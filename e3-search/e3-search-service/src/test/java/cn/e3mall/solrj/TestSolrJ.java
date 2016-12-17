package cn.e3mall.solrj;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.RangeFacet;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.springframework.stereotype.Controller;

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
	@Test
	public void testFacetQuery() throws Exception {
//		facet.interval=price&facet.interval.set=[0,10]&&facet.interval.set=(10,100]&&facet.interval.set=(100,*]
//		facet.range=price&facet.range.start=0&facet.range.end=600&facet.range.gap=200&facet.interval=price&facet.interval.set=[0,10]&facet.interval.set=(10,100]&facet.interval.set=(100,300]
		SolrServer solrServer = new HttpSolrServer("http://192.168.25.181:8983/solr/collection1");
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		query.setFacet(true);
		query.addFacetField("manu_id_s");
		query.addNumericRangeFacet("price", 0, 600, 200);
		query.set("facet.range.other", "after");
		QueryResponse queryResponse = solrServer.query(query);
		//类别过滤
		List<FacetField> fields = queryResponse.getFacetFields();
		for (FacetField facetField : fields) {
			System.out.println(facetField.getName() + ":");
			List<Count> values = facetField.getValues();
			for (Count count : values) {
				System.out.println(count.getName() + ":" + count.getCount());
			}
		}
		System.out.println("==================================");
		//价格区间
		List<RangeFacet> facetRanges = queryResponse.getFacetRanges();
		for (RangeFacet rangeFacet : facetRanges) {
			System.out.println(rangeFacet.getName() + ":");
			List counts = rangeFacet.getCounts();
			float max = 0;
			for (Object object : counts) {
				org.apache.solr.client.solrj.response.RangeFacet.Count count 
				= (org.apache.solr.client.solrj.response.RangeFacet.Count) object;
				max = (Float.parseFloat(count.getValue()) + 200);
				System.out.println(count.getValue() + "-" + max + ":" + count.getCount());
			}
			System.out.println(max + "以上:" + rangeFacet.getAfter());
		}
	}
}
