package cn.e3mall.solrj;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class TestSolrJ {

	@Test
	public void addDocument() throws Exception {
		//1、使用SolrJ连接到solr服务，使用SolrServer对象。HttpSolrServer、CloudSolrServer
		//参数solr服务的url地址
		SolrServer solrServer = new HttpSolrServer("http://192.168.25.154:8080/solr/collection1");
		//2、创建一个文档对象SolrInputDocument
		SolrInputDocument document = new SolrInputDocument();
		//3、向文档对象中添加域，域必须先定义后使用，每个文档中必须有id域。
		document.addField("id", "test002");
		document.addField("item_title", "测试商品title-002");
		document.addField("item_sell_point", "测试商品卖点2");
		document.addField("item_price", 1100);
		//4、把文档对象写入索引库。
		solrServer.add(document);
		//5、提交
		solrServer.commit();
	}
	@Test
	public void testDeleteDocumnetById() throws Exception {
		//1、创建一个SolrServer对象。
		SolrServer solrServer = new HttpSolrServer("http://192.168.25.154:8080/solr/collection1");
		//2、使用SolrServer的删除方法删除文档
		solrServer.deleteById("test001");
		//3、提交
		solrServer.commit();
	}
	
	@Test
	public void testDeleteDocumentByQuery() throws Exception {
		SolrServer solrServer = new HttpSolrServer("http://192.168.25.154:8080/solr/collection1");
		solrServer.deleteByQuery("*:*");
		solrServer.commit();
	}
	
	@Test
	public void testQueryDocument() throws Exception {
		//1、创建一个SolrServer对象
		SolrServer solrServer = new HttpSolrServer("http://192.168.25.154:8080/solr/collection1");
		//2、创建一个SolrQuery对象。
		SolrQuery query = new SolrQuery();
		//3、设置查询条件，可以参考solr后台
		//query.set("q", "商品");
		query.setQuery("商品");
		query.addFilterQuery("item_price:[0 TO 2000]");
		query.setStart(0);
		query.setRows(3);
		query.set("df","item_keywords");
		query.setHighlight(true);
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<em>");
		query.setHighlightSimplePost("</em>");
		//4、执行查询
		QueryResponse response = solrServer.query(query);
		//5、取查询结果
		SolrDocumentList solrDocumentList = response.getResults();
		System.out.println("查询结果总记录数：" + solrDocumentList.getNumFound());
		//6、遍历查询结果
		for (SolrDocument solrDocument : solrDocumentList) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("item_title"));
			System.out.println(solrDocument.get("item_sell_point"));
			System.out.println(solrDocument.get("item_price"));
		}
	}
}
