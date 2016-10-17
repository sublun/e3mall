package cn.e3mall.solrj;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class TestSolrCloud {

	@Test
	public void testAddDocument() throws Exception {
		//和服务端建立连接CloudSolrServer,参数zkHost
		CloudSolrServer cloudSolrServer = new CloudSolrServer("192.168.25.154:2181,192.168.25.154:2182,192.168.25.154:2183");
		//指定默认的Collection
		cloudSolrServer.setDefaultCollection("collection2");
		//创建文档对象
		SolrInputDocument document = new SolrInputDocument();
		//向文档对象中添加域
		document.addField("id", "test003");
		document.addField("item_title", "测试商品标题");
		document.addField("item_price", 100);
		//把文档对象写入索引库
		cloudSolrServer.add(document);
		//提交
		cloudSolrServer.commit();
	}
	
	@Test
	public void testQuerySolrCloud() throws Exception {
		//和服务端建立连接CloudSolrServer,参数zkHost
		CloudSolrServer cloudSolrServer = new CloudSolrServer("192.168.25.154:2181,192.168.25.154:2182,192.168.25.154:2183");
		//指定默认的Collection
		cloudSolrServer.setDefaultCollection("collection2");
		//创建查询对象
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		//执行查询
		QueryResponse queryResponse = cloudSolrServer.query(query);
		//取查询结果
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		System.out.println("查询结果总记录数：" + solrDocumentList.getNumFound());
		for (SolrDocument solrDocument : solrDocumentList) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("item_title"));
			System.out.println(solrDocument.get("item_price"));
		}
	}
}
