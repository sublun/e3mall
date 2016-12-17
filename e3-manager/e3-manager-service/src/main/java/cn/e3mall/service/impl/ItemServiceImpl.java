package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.mapper.TbItemImageMapper;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemImage;
import cn.e3mall.pojo.TbItemImageExample;
import cn.e3mall.pojo.TbItemImageExample.Criteria;
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
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemImageMapper itemImageMapper;
	
	/**
	 * 根据商品id取商品信息
	 * <p>Title: getItemById</p>
	 * <p>Description: </p>
	 * @param itemId
	 * @return
	 * @see cn.e3mall.service.ItemService#getItemById(long)
	 */
	@Override
	public TbItem getItemById(long itemId) {
		//根据商品id取商品信息
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		return item;
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
	public List<TbItemImage> getGoodsImages(long itemId) {
		//根据商品id取商品图片
		TbItemImageExample example = new TbItemImageExample();
		//设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(itemId);
		//设置排序条件
		example.setOrderByClause("SORT");
		//执行查询
		List<TbItemImage> imageList = itemImageMapper.selectByExample(example);
		return imageList;
	}

	

}
