package cn.e3mall.content.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.content.service.ContentService;
import cn.e3mall.jedis.JedisClient;
import cn.e3mall.mapper.TbContentMapper;
import cn.e3mall.pojo.TbContent;
import cn.e3mall.pojo.TbContentExample;
import cn.e3mall.pojo.TbContentExample.Criteria;
import sun.tools.jar.resources.jar;

/**
 * 内容管理服务
 * <p>Title: ContentServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${CONTENT_KEY}")
	private String CONTENT_KEY;
	
	@Override
	public E3Result addContent(TbContent content) {
		//补全content的属性
		content.setCreated(new Date());
		content.setUpdated(new Date());
		//把content插入到数据库
		contentMapper.insert(content);
		//添加内容删除缓存数据
		jedisClient.hdel(CONTENT_KEY, content.getCategoryId() + "");
		//返回结果
		return E3Result.ok();
	}

	@Override
	public List<TbContent> getContentList(Long cid) {
		//先查询缓存
		//添加缓存不能影响正常业务逻辑
		try {
			String result = jedisClient.hget(CONTENT_KEY, cid + "");
			//判断是否查询到数据
			if (StringUtils.isNotBlank(result)) {
				//把json转换成java对象
				List<TbContent> list = JsonUtils.jsonToList(result, TbContent.class);
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//缓存中没有查询数据库
		//根据cid查询内容列表
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		//执行查询
		List<TbContent> list = contentMapper.selectByExampleWithBLOBs(example);
		//把结果添加到缓存
		try {
			jedisClient.hset(CONTENT_KEY, cid+"", JsonUtils.objectToJson(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
