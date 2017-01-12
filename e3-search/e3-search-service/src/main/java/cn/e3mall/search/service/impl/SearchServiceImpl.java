package cn.e3mall.search.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrQuery.SortClause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.SearchInfo;
import cn.e3mall.common.pojo.SearchResult;
import cn.e3mall.common.utils.StringUtil;
import cn.e3mall.search.dao.SearchDao;
import cn.e3mall.search.pojo.PriceRange;
import cn.e3mall.search.service.SearchService;

/**
 * 搜索服务实现类
 * <p>Title: SearchServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchDao searchDao;
	
	@Override
	public SearchResult query(SearchInfo searchInfo) throws Exception{
		//创建查询对象
		SolrQuery query = new SolrQuery();
		//设置查询条件
		query.setQuery(searchInfo.getQueryString());
		//开启分类统计
		query.setFacet(true);
		//根据分类过滤
		if (StringUtils.isNotBlank(searchInfo.getCategory())) {
			query.addFilterQuery("goods_category_name:" + searchInfo.getCategory());
		} else {
			//设置商品分类统计
			query.addFacetField("goods_category_name");
		}
		//根据价格区间过滤
		if (StringUtils.isNotBlank(searchInfo.getPrice())) {
			String[] strings = searchInfo.getPrice().split("-");
			query.addFilterQuery("goods_sell_price:["+ strings[0] +" TO "+ strings[1] +"]");
		} else {
			//价格区间统计
			PriceRange priceRange = searchDao.getPriceRange(searchInfo.getQueryString());
			query.addNumericRangeFacet("price", priceRange.getMin(), priceRange.getMax(), priceRange.getGap());
			query.set("facet.range.other", "after");
		}
		//分页条件
		int page = 1;
		if (searchInfo.getPage() != null) {
			page = searchInfo.getPage();
		}
		query.setStart((page - 1) * searchInfo.getRows());
		query.setRows(searchInfo.getRows());
		query.set("df", "goods_name");
		
		//排序设置
		if (StringUtils.isNotBlank(searchInfo.getSort())) {
			String sort = searchInfo.getSort();
			String[] split = sort.split("-");
			String sortField = "";
			if ("sellnum".equals(split[0])) {
				sortField = "goods_sell_num";
			} else if ("price".equals(split[0])) {
				sortField = "goods_sell_price";
			}
			query.setSort(sortField, "asc".equals(split[1])?ORDER.asc:ORDER.desc);
		}
		
		//设置高亮
		query.setHighlight(true);
		query.addHighlightField("goods_name");
		query.setHighlightSimplePre("<font style=\"color:red\">");
		query.setHighlightSimplePost("</font>");
		//调用dao执行查询
		SearchResult searchResult = searchDao.search(query);
		//计算查询结果总页数
		long recordCount = searchResult.getRecordCount();
		long pageCount = recordCount/searchInfo.getRows();
		if (recordCount % searchInfo.getRows() > 0) {
			pageCount ++;
		}
		searchResult.setTotalPage(pageCount);
		//返回结果
		return searchResult;
	}

}
