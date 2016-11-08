package cn.e3mall.service;

import java.util.List;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.pojo.TbGoods;
import cn.e3mall.pojo.TbGoodsImage;

public interface ItemService {

	//根据商品id取商品信息
	TbGoods getItemById(long goodsId);
	//根据商品id取商品图片
	List<TbGoodsImage> getGoodsImages(long goodsId);
	
}
