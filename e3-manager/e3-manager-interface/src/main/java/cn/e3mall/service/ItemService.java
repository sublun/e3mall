package cn.e3mall.service;

import java.util.List;

import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemImage;

public interface ItemService {

	//根据商品id取商品信息
	TbItem getItemById(long itemId);
	//根据商品id取商品图片
	List<TbItemImage> getGoodsImages(long itemId);
	
}
