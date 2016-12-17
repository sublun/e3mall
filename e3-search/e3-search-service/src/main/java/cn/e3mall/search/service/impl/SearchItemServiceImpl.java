package cn.e3mall.search.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.SearchItem;
import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.search.mapper.SearchItemMapper;
import cn.e3mall.search.service.SearchItemService;

/**
 * 索引库维护Service
 * <p>Title: SearchItemServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Service
public class SearchItemServiceImpl implements SearchItemService {

	@Autowired
	private SearchItemMapper searchItemMapper;
	@Autowired
	private SolrServer solrServer;
	
	@Override
	public E3Result importItemToIndex() throws Exception{
		//查询所有商品数据
		List<SearchItem> itemList = searchItemMapper.getSearchItemList();
		//把商品数据添加到索引库
		for (SearchItem searchItem : itemList) {
			//创建一个文档对象
			SolrInputDocument document = new SolrInputDocument();
			//向文档中添加域
			document.addField("id", searchItem.getId());
			document.addField("goods_name", searchItem.getGoods_name());
			document.addField("goods_ad_word", searchItem.getAd_word());
			document.addField("goods_sell_price", searchItem.getSell_price());
			document.addField("goods_img_url", searchItem.getImg_url());
			document.addField("goods_brand_name", searchItem.getBrand_name());
			document.addField("goods_category_name", searchItem.getCategory_name());
			document.addField("goods_sell_num", searchItem.getSell_num());
			//写入索引库
			solrServer.add(document);
		}
		//提交
		solrServer.commit();
		return E3Result.ok();
	}

}
