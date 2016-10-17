package cn.e3mall.search.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.SearchResult;
import cn.e3mall.search.dao.SearchDao;
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
	public SearchResult query(String queryString, Integer page, Integer rows) throws Exception{
		//创建查询对象
		SolrQuery query = new SolrQuery();
		//设置查询条件
		query.setQuery(queryString);
		if (page == null) {
			page = 1;
		}
		query.setStart((page - 1) * rows);
		query.setRows(rows);
		query.set("df", "item_title");
		//设置高亮
		query.setHighlight(true);
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<font style=\"color:red\">");
		query.setHighlightSimplePost("</font>");
		//调用dao执行查询
		SearchResult searchResult = searchDao.search(query);
		//计算查询结果总页数
		long recordCount = searchResult.getRecordCount();
		long pageCount = recordCount/rows;
		if (recordCount % rows > 0) {
			pageCount ++;
		}
		searchResult.setTotalPage(pageCount);
		//返回结果
		return searchResult;
	}

}
