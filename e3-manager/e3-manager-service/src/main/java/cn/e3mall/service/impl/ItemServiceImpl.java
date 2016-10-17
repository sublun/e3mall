package cn.e3mall.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.utils.IDUtils;
import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.jedis.JedisClient;
import cn.e3mall.mapper.TbItemDescMapper;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.pojo.TbItemExample;
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
	private TbItemDescMapper itemDescMapper;
	@Autowired
	private JmsTemplate jmsTemplate;
	@Resource(name = "topicDestination")
	private Destination destination;
	@Autowired
	private JedisClient jedisClient;

	@Value("${ITEM_INFO}")
	private String ITEM_INFO;
	@Value("${ITEM_EXPIRE}")
	private Integer ITEM_EXPIRE;

	@Override
	public TbItem getItemById(long itemId) {
		// 查询缓存
		try {
			String json = jedisClient.get(ITEM_INFO + ":" + itemId + ":base");
			if (StringUtils.isNotBlank(json)) {
				TbItem tbItem = JsonUtils.jsonToPojo(json, TbItem.class);
				return tbItem;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 缓存中没有查询数据库
		TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
		// 添加到缓存
		try {
			jedisClient.set(ITEM_INFO + ":" + itemId + ":base", JsonUtils.objectToJson(tbItem));
			// 设置缓存的过期时间
			jedisClient.expire(ITEM_INFO + ":" + itemId + ":base", ITEM_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tbItem;
	}

	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		// 查询商品列表并分页
		PageHelper.startPage(page, rows);
		// 查询商品列表
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		// 取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		// 取总记录数
		result.setTotal((int) pageInfo.getTotal());
		// 商品列表
		result.setRows(list);
		return result;
	}

	@Override
	public E3Result addItem(TbItem item, String desc) {
		// 生成主键
		final long itemId = IDUtils.genItemId();
		// 补全item的属性
		item.setId(itemId);
		// 1-正常，2-下架，3-删除
		item.setStatus((byte) 1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		// 向商品表插入数据
		itemMapper.insert(item);
		// 向商品描述表插入数据
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		// 插入数据
		itemDescMapper.insert(itemDesc);
		// 发送商品添加消息
		jmsTemplate.send(destination, new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage(itemId + "");
				return textMessage;
			}
		});
		return E3Result.ok();
	}

	@Override
	public TbItemDesc getItemDescById(long itemId) {
		// 查询缓存
		try {
			String json = jedisClient.get(ITEM_INFO + ":" + itemId + ":desc");
			if (StringUtils.isNotBlank(json)) {
				TbItemDesc tbItemDesc = JsonUtils.jsonToPojo(json, TbItemDesc.class);
				return tbItemDesc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		TbItemDesc tbItemDesc = itemDescMapper.selectByPrimaryKey(itemId);
		// 添加到缓存
		try {
			jedisClient.set(ITEM_INFO + ":" + itemId + ":desc", JsonUtils.objectToJson(tbItemDesc));
			// 设置缓存的过期时间
			jedisClient.expire(ITEM_INFO + ":" + itemId + ":desc", ITEM_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tbItemDesc;
	}

}
