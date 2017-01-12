package cn.e3mall.search.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.RangeFacet;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.util.NamedList;
import org.apache.solr.common.util.SimpleOrderedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * 查询索引库使用的Dao
 * <p>Title: SearchDao</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */

import cn.e3mall.common.pojo.SearchItem;
import cn.e3mall.common.pojo.SearchResult;
import cn.e3mall.search.pojo.PriceRange;
@Repository
public class SearchDao {
	
	@Autowired
	private SolrServer solrServer;

	public SearchResult search(SolrQuery query) throws Exception{
		System.out.println(query);
		//根据Query对象查询索引库
		QueryResponse response = solrServer.query(query);
		//取查询结果
		SolrDocumentList solrDocumentList = response.getResults();
		//取查询结果总记录数
		long recordCount = solrDocumentList.getNumFound();
		SearchResult result = new SearchResult();
		result.setRecordCount(recordCount);
		//取商品列表，需要取高亮信息
		List<SearchItem> items = new ArrayList<>();
		for (SolrDocument solrDocument : solrDocumentList) {
			SearchItem searchItem = new SearchItem();
			searchItem.setId((String) solrDocument.get("id"));
			searchItem.setCategory_name((String) solrDocument.get("goods_category_name"));
			searchItem.setImg_url((String) solrDocument.get("goods_img_url"));
			searchItem.setSell_price((double) solrDocument.get("goods_sell_price"));
			searchItem.setAd_word((String) solrDocument.get("goods_ad_word"));
			//取高亮后的结果
			String goodsName = "";
			if (query.getHighlight()) {
				Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
				List<String> list = highlighting.get(solrDocument.get("id")).get("goods_name");
				if (list != null && list.size() > 0) {
					goodsName = list.get(0);
				} else {
					goodsName = (String) solrDocument.get("goods_name");
				}
			} else {
				//如果没有开启高亮则直接取商品名称
				goodsName = (String) solrDocument.get("goods_name");
			}
			searchItem.setItem_name(goodsName);
			//添加到商品列表
			items.add(searchItem);
		}
		//添加到返回结果
		result.setItemList(items);
		//取分类统计则取分类统计结果
		getFacet(response, result);
		//返回结果
		return result;
	}
	
	private void getFacet(QueryResponse queryResponse, SearchResult result) {
		List<Map> categoryList = new ArrayList<>();
		//类别过滤
		List<FacetField> fields = queryResponse.getFacetFields();
		for (FacetField facetField : fields) {
			System.out.println(facetField.getName() + ":");
			List<Count> values = facetField.getValues();
			for (Count count : values) {
				Map fieldMap = new HashMap<>();
				fieldMap.put("name", count.getName());
				fieldMap.put("count", count.getCount());
				categoryList.add(fieldMap);
			}
		}
		result.setCategoryList(categoryList);
		//价格区间
		List<Map> priceRange = new ArrayList<>();
		List<RangeFacet> facetRanges = queryResponse.getFacetRanges();
		for (RangeFacet rangeFacet : facetRanges) {
			System.out.println(rangeFacet.getName() + ":");
			List counts = rangeFacet.getCounts();
			//区间下限
			int max = 0;
			//区间步长
			/*NamedList namedList = queryResponse.getResponseHeader();
			Iterator iterator = namedList.iterator();
			while(iterator.hasNext()) {
				Object next = iterator.next();
				System.out.println(next);
			}
			NamedList object2 = (NamedList) namedList.get("params");
			Iterator iterator2 = object2.iterator();
			while(iterator2.hasNext()) {
				Object next = iterator2.next();
				System.out.println(next);
			}
			Object gap = object2.get("f.price.facet.range.gap");*/
			NamedList params = (NamedList) queryResponse.getResponseHeader().get("params");
			Object gap = params.get("f.price.facet.range.gap");
			int step = Integer.parseInt(gap.toString());
			//queryResponse.getResponseHeader().get("facet.range.gap");
			//因为当前的区间只有价格，只取价格的区间列表。
			for (Object object : counts) {
				org.apache.solr.client.solrj.response.RangeFacet.Count count 
				= (org.apache.solr.client.solrj.response.RangeFacet.Count) object;
				//区间上限
				int start = (int) Float.parseFloat(count.getValue());
				//计算区间下限
				max = start + step;
				Map range = new HashMap<>();
				range.put("name", (int) Float.parseFloat(count.getValue()) + "-" + max);
				range.put("value", (int) Float.parseFloat(count.getValue()) + "-" + max);
				range.put("count", count.getCount());
				System.out.println((int) Float.parseFloat(count.getValue()) + "-" + max + ":" + count.getCount());
				priceRange.add(range);
			}
			System.out.println(max + "以上:" + rangeFacet.getAfter());
			//取最后的区间
			Map range = new HashMap<>();
			range.put("name", max + "以上");
			range.put("value", max + "-*");
			range.put("count", rangeFacet.getAfter());
			priceRange.add(range);
		}
		//将价格范围添加到结果
		result.setPriceRange(priceRange);
	}
	
	/**
	 * 根据查询条件查询价格区间
	 * <p>Title: getPriceRange</p>
	 * <p>Description: </p>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public PriceRange getPriceRange(String queryString) throws Exception {
		SolrQuery query = new SolrQuery(queryString);
		//根据查询条件降序排列
		query.setSort("goods_sell_price", ORDER.desc);
		//取最高价格
		query.setStart(0);
		query.setRows(1);
		query.set("df", "goods_name");
		//执行查询
		QueryResponse response = solrServer.query(query);
		SolrDocumentList solrDocumentList = response.getResults();
		if (solrDocumentList.size() != 1) {
			return new PriceRange();
		}
		//取最高价格商品
		SolrDocument solrDocument = solrDocumentList.get(0);
		double maxPrice = (double) solrDocument.get("goods_sell_price");
		PriceRange priceRange = new PriceRange();
		priceRange.setMin(0);
		//设置区间最大值
		if (maxPrice < 10) {
			priceRange.setMax((int) maxPrice);
		} else if (maxPrice < 100) {
			maxPrice = Math.round(maxPrice / 10) * 10;
			priceRange.setMax((int)maxPrice);
		} else if (maxPrice < 1000) {
			maxPrice = Math.round(maxPrice / 100) * 100;
			priceRange.setMax((int)maxPrice);
		} else {
			maxPrice = Math.round(maxPrice / 1000) * 1000;
			priceRange.setMax((int)maxPrice);
		}
		// 设置区间步长
		// 区间数量7个，计算区间大小
		float gap = (int) (maxPrice / 7);
		if (gap < 10) {
			priceRange.setGap(10);
		} else if (gap < 100) {
			gap = Math.round(gap / 10) * 10;
			priceRange.setGap((int) gap);
		} else if (gap < 1000) {
			gap = Math.round(gap / 100) * 100;
			priceRange.setGap((int) gap);
		} else {
			gap = Math.round(gap / 1000) * 1000;
			priceRange.setGap((int) gap);
		}
		
		return priceRange;
		
	}
}
