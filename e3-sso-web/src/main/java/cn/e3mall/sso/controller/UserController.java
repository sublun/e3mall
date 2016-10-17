package cn.e3mall.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.utils.CookieUtils;
import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.pojo.TbUser;
import cn.e3mall.sso.service.UserService;

/**
 * 用户管理Controller
 * <p>Title: UserController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
//@RestController相当于@Controller+@ResponseBody
@RestController
public class UserController {
	
	@Value("${TOKEN_KEY}")
	private String TOKEN_KEY;
	
	@Autowired
	private UserService userService;

	@RequestMapping("/user/check/{param}/{type}")
	public E3Result checkUserData(@PathVariable String param, @PathVariable Integer type) {
		E3Result result = userService.checkUserData(param, type);
		return result;
	}
	
	@RequestMapping(value="/user/register", method=RequestMethod.POST)
	public E3Result addUser(TbUser user) {
		E3Result result = userService.addUser(user);
		return result;
	}
	
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public E3Result userLogin(String username, String password,
			HttpServletRequest request, HttpServletResponse response) {
		E3Result e3Result = userService.userLogin(username, password);
		//判断是否登录成功
		if (e3Result.getStatus() == 200) {
			//如果登录成功，应该吧token写入cookie
			String token = e3Result.getData().toString();
			CookieUtils.setCookie(request, response, TOKEN_KEY, token);
		}
		return e3Result;
		
	}
	
	/*@RequestMapping(value="/user/token/{token}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getUserByToken(@PathVariable String token, String callback) {
		E3Result result = userService.getUserByToken(token);
		//判断是否为jsonp请求
		if (StringUtils.isNotBlank(callback)) {
			//支持jsonp
			String res = callback + "(" + JsonUtils.objectToJson(result) + ");";
			return res;
		}
		return JsonUtils.objectToJson(result);
	}*/
	//第二种方法
	@RequestMapping(value="/user/token/{token}")
	public Object getUserByToken(@PathVariable String token, String callback) {
		E3Result result = userService.getUserByToken(token);
		//判断是否为jsonp请求
		if (StringUtils.isNotBlank(callback)) {
			//支持jsonp
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
			//设置callback方法
			mappingJacksonValue.setJsonpFunction(callback);
			//返回
			return mappingJacksonValue;
		}
		return result;
	}
	
}
