package cn.e3mall.search.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.RangeFacet;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
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
@Repository
public class SearchDao {
	
	@Autowired
	private SolrServer solrServer;

	public SearchResult search(SolrQuery query) throws Exception{
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
			searchItem.setGoods_name(goodsName);
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
			float max = 0;
			//因为当前的区间只有价格，只取价格的区间列表。
			for (Object object : counts) {
				org.apache.solr.client.solrj.response.RangeFacet.Count count 
				= (org.apache.solr.client.solrj.response.RangeFacet.Count) object;
				max = (Float.parseFloat(count.getValue()) + 200);
				Map range = new HashMap<>();
				range.put("begin", count.getValue());
				range.put("end", count.getCount());
				System.out.println(count.getValue() + "-" + max + ":" + count.getCount());
				priceRange.add(range);
			}
			System.out.println(max + "以上:" + rangeFacet.getAfter());
			//取最后的区间
			Map range = new HashMap<>();
			range.put("begin", max);
			range.put("end", "*");
			priceRange.add(range);
		}
		//将价格范围添加到结果
		result.setPriceRange(priceRange);
	}
}
