package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.mapper.TbGoodsImageMapper;
import cn.e3mall.mapper.TbGoodsMapper;
import cn.e3mall.pojo.TbGoods;
import cn.e3mall.pojo.TbGoodsImage;
import cn.e3mall.pojo.TbGoodsImageExample;
import cn.e3mall.pojo.TbGoodsImageExample.Criteria;
import cn.e3mall.service.ItemService;

/**
 * 商品服务实现类
 * <p>
 * Title: ItemServiceImpl
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.itcast.cn
 * </p>
 * 
 * @version 1.0
 */
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbGoodsMapper goodsMapper;
	@Autowired
	private TbGoodsImageMapper goodsImageMapper;
	
	/**
	 * 根据商品id取商品信息
	 * <p>Title: getItemById</p>
	 * <p>Description: </p>
	 * @param itemId
	 * @return
	 * @see cn.e3mall.service.ItemService#getItemById(long)
	 */
	@Override
	public TbGoods getItemById(long goodsId) {
		//根据商品id取商品信息
		TbGoods goods = goodsMapper.selectByPrimaryKey(goodsId);
		return goods;
	}

	/**
	 * 根据商品id取商品图片
	 * <p>Title: getGoodsImages</p>
	 * <p>Description: </p>
	 * @param goodsId
	 * @return
	 * @see cn.e3mall.service.ItemService#getGoodsImages(long)
	 */
	@Override
	public List<TbGoodsImage> getGoodsImages(long goodsId) {
		//根据商品id取商品图片
		TbGoodsImageExample example = new TbGoodsImageExample();
		//设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andGoodsIdEqualTo(goodsId);
		//设置排序条件
		example.setOrderByClause("SORT");
		//执行查询
		List<TbGoodsImage> imageList = goodsImageMapper.selectByExample(example);
		return imageList;
	}

	

}
