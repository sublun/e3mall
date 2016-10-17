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
			document.addField("item_title", searchItem.getTitle());
			document.addField("item_sell_point", searchItem.getSell_point());
			document.addField("item_price", searchItem.getPrice());
			//向索引库中只添加一张图片
			String image = searchItem.getImage();
			if (StringUtils.isNotBlank(image)) {
				String[] images = image.split(",");
				image = images[0];
			}
			document.addField("item_image", image);
			document.addField("item_category_name", searchItem.getCategory_name());
			document.addField("item_desc", searchItem.getItem_des());
			//写入索引库
			solrServer.add(document);
		}
		//提交
		solrServer.commit();
		return E3Result.ok();
	}

}
