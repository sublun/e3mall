package cn.e3mall.sso.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.jedis.JedisClient;
import cn.e3mall.mapper.TbUserMapper;
import cn.e3mall.pojo.TbUser;
import cn.e3mall.pojo.TbUserExample;
import cn.e3mall.pojo.TbUserExample.Criteria;
import cn.e3mall.sso.service.UserService;

/**
 * 用户管理Service
 * <p>Title: UserServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper userMapper;
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${USER_TOKEN}")
	private String USER_TOKEN;
	@Value("${SESSION_EXPIRE}")
	private Integer SESSION_EXPIRE;
	
	@Override
	public E3Result checkUserData(String data, int type) {
		//检查数据的有效性
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		//设置查询条件
		//1、2、3分别代表username、phone、email
		if (type == 1) {
			//对用户名进行校验
			criteria.andUsernameEqualTo(data);
		} else if (type == 2) {
			//对手机号进行校验
			criteria.andPhoneEqualTo(data);
		} else if (type == 3) {
			//对email进行校验
			criteria.andEmailEqualTo(data);
		} else {
			return E3Result.build(400, "参数类型错误");
		}
		//执行查询
		List<TbUser> list = userMapper.selectByExample(example);
		//判断结果
		if (list == null || list.size() ==0 ) {
			return E3Result.ok(true);
		}
		return E3Result.ok(false);
	}

	@Override
	public E3Result addUser(TbUser user) {
		//对数据进行有效性校验
		//对用户名进行校验
		if (StringUtils.isBlank(user.getUsername())){
			return E3Result.build(400, "用户名不能为空");
		}
		E3Result e3Result = checkUserData(user.getUsername(),1);
		if (!(boolean)e3Result.getData()) {
			return E3Result.build(400, "用户名重复");
		}
		//密码进行校验
		if (StringUtils.isBlank(user.getPassword())) {
			return E3Result.build(400, "密码不能为空");
		}
		//对手机号进行校验
		if (StringUtils.isNotBlank(user.getPhone())) {
			E3Result result = checkUserData(user.getPhone(),2);
			if (!(boolean)result.getData()) {
				return E3Result.build(400, "手机号重复");
			}
		}
		//对email进行校验
		if (StringUtils.isNotBlank(user.getEmail())) {
			E3Result result = checkUserData(user.getEmail(),3);
			if (!(boolean)result.getData()) {
				return E3Result.build(400, "email重复");
			}
		}
		//对TBUser的属性进行补全
		user.setCreated(new Date());
		user.setUpdated(new Date());
		//对密码进行md5加密
		String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(md5Pass);
		//把数据插入到数据库中
		userMapper.insert(user);
		//返回成功
		return E3Result.ok();
	}

	@Override
	public E3Result userLogin(String username, String password) {
		//1、根据用户名查询用户表
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TbUser> list = userMapper.selectByExample(example);
		if (list == null || list.isEmpty()) {
			//2、如果查询不到用户，返回登录失败
			return E3Result.build(400, "用户名不存在");
		}
		TbUser user = list.get(0);
		//3、查询到用户信息，判断密码是否正确
		if (!user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
			//4、如果密码不正确返回登录失败
			return E3Result.build(400, "密码不正确");
		}
		//5、密码正确，要把用户信息写入Session，使用redis模拟Session，
		//key使用uuid生成（token），value就是用户对象转换为json
		String token = UUID.randomUUID().toString();
		user.setPassword(null);
		jedisClient.set(USER_TOKEN + ":" + token, JsonUtils.objectToJson(user));
		//6、设置Session的过期时间
		jedisClient.expire(USER_TOKEN + ":" + token, SESSION_EXPIRE);
		//7、返回E3Result，包装token
		return E3Result.ok(token);
	}

	@Override
	public E3Result getUserByToken(String token) {
		//到redis中根据token查询用户信息
		String json = jedisClient.get(USER_TOKEN + ":" + token);
		//如果取不到数据，返回查询失败
		if (StringUtils.isBlank(json)) {
			return E3Result.build(400, "登录已经过期，请重新登录");
		}
		//取到数据，把json转换成TbUser对象
		TbUser user = JsonUtils.jsonToPojo(json, TbUser.class);
		//重置Session的过期时间
		jedisClient.expire(USER_TOKEN + ":" + token, SESSION_EXPIRE);
		//返回结果
		return E3Result.ok(user);
	}
	
	

}
