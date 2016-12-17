package cn.e3mall.cart.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.e3mall.cart.service.CartService;
import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.jedis.JedisClient;
import cn.e3mall.mapper.TbGoodsMapper;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbGoods;
import cn.e3mall.pojo.TbItem;

/**
 * 购车管理Service
 * <p>Title: CartServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private JedisClient jedisClient;
	@Autowired
	private TbGoodsMapper goodsMapper;
	
	@Value("${REDIS_CART_KEY}")
	private String REDIS_CART_KEY;
	@Value("${REDIS_CART_SORT_KEY}")
	private String REDIS_CART_SORT_KEY;
	
	/**
	 * 向购车中添加商品
	 * <p>Title: addCart</p>
	 * <p>Description: </p>
	 * @param userId
	 * @param itemId
	 * @param num
	 * @return
	 * @see cn.e3mall.cart.service.CartService#addCart(long, long, int)
	 */
	@Override
	public E3Result addCart(long userId, long itemId, int num) {
		//判断此商品是否在购物车在存在
		Boolean isExists = jedisClient.hexists(REDIS_CART_KEY + ":" + userId , itemId + "");
		//如果存在购物车数量相加
		if (isExists) {
			String json = jedisClient.hget(REDIS_CART_KEY + ":" + userId, itemId + "");
			TbGoods item = JsonUtils.jsonToPojo(json, TbGoods.class);
			//数量相加
			item.setNum(item.getNum() + num);
			//更新redis
			addCartRedis(userId, item);
			return E3Result.ok();
		}
		//如果不存在添加新商品
		//根据商品id取商品信息
		TbItem item = goodsMapper.selectByPrimaryKey(itemId);
		//更新商品数量
		item.setNum(num);
		//将商品添加到redis
		addCartRedis(userId, item);
		return E3Result.ok();
	}
	
	/**
	 * 将购物车添加到redis并且更新商品排序
	 * <p>Title: addCart</p>
	 * <p>Description: </p>
	 * @param userId
	 * @param item
	 */
	private void addCartRedis(long userId, TbItem item) {
		//将商品添加到redis
		jedisClient.hset(REDIS_CART_KEY + ":" + userId, item.getId().toString(), JsonUtils.objectToJson(item));
		//设置排序
		jedisClient.zadd(REDIS_CART_SORT_KEY + ":" + userId, System.currentTimeMillis(), item.getId().toString());
	}
	
	/**
	 * 将cookie中的购物车列表和redis中的购物车合并
	 * <p>Title: mergeCartItem</p>
	 * <p>Description: </p>
	 * @param userId
	 * @param itemList
	 * @return
	 * @see cn.e3mall.cart.service.CartService#mergeCartItem(long, java.util.List)
	 */
	@Override
	public E3Result mergeCartItem(long userId, List<TbItem> itemList) {
		//将cookie中的购物车列表和redis中的购物车合并
		for (TbItem tbItem : itemList) {
			addCart(userId, tbItem.getId(), tbItem.getNum());
		}
		return E3Result.ok();
	}
	
	/**
	 * 更新购车商品数量
	 * <p>Title: updateItemNum</p>
	 * <p>Description: </p>
	 * @param userId
	 * @param itemId
	 * @param num
	 * @return
	 * @see cn.e3mall.cart.service.CartService#updateItemNum(long, long, int)
	 */
	@Override
	public E3Result updateItemNum(long userId, long itemId, int num) {
		String json = jedisClient.hget(REDIS_CART_KEY + ":" + userId, itemId + "");
		TbItem item = JsonUtils.jsonToPojo(json, TbItem.class);
		//数量相加
		item.setNum(num);
		//更新redis
		jedisClient.hset(REDIS_CART_KEY + ":" + userId, itemId + "", JsonUtils.objectToJson(item));
		return E3Result.ok();
	}
	
	/**
	 * 取购物车商品列表，列表应该是有序的，根据商品添加的时间进行倒序排列。
	 * 新添加的商品应该在最上面。
	 * <p>Title: getCartList</p>
	 * <p>Description: </p>
	 * @param userId
	 * @return
	 * @see cn.e3mall.cart.service.CartService#getCartList(long)
	 */
	@Override
	public List<TbItem> getCartList(long userId) {
		//取商品id列表
		Set<String> idSet = jedisClient.zrevrange(REDIS_CART_SORT_KEY + ":" + userId, 0, -1);
		List<TbItem> cartList = new ArrayList<>();
		for (String id : idSet) {
			//从Hash中取商品信息
			String json = jedisClient.hget(REDIS_CART_KEY + ":" + userId, id);
			TbItem item = JsonUtils.jsonToPojo(json, TbItem.class);
			cartList.add(item);
		}
		return cartList;
	}
	
	/**
	 * 删除购物车商品
	 * <p>Title: deleteCartItem</p>
	 * <p>Description: </p>
	 * @param userId
	 * @param itemid
	 * @return
	 * @see cn.e3mall.cart.service.CartService#deleteCartItem(long, long)
	 */
	@Override
	public E3Result deleteCartItem(long userId, long itemid) {
		//删除购物车商品
		jedisClient.hdel(REDIS_CART_KEY + ":" + userId, itemid + "");
		jedisClient.zrem(REDIS_CART_SORT_KEY + ":" + userId, itemid + "");
		return E3Result.ok();
	}
	
	

}
