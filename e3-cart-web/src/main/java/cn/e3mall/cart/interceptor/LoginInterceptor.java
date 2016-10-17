package cn.e3mall.cart.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.utils.CookieUtils;
import cn.e3mall.pojo.TbUser;
import cn.e3mall.sso.service.UserService;

/**
 * 判断用户是否登录拦截器
 * <p>Title: LoginInterceptor</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	private UserService userService;
	@Value("${TOKEN_KEY}")
	private String TOKEN_KEY;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//判断用户是否登录
		String token = CookieUtils.getCookieValue(request, TOKEN_KEY);
		//如果cookie中有token查询用户登录状态
		if (StringUtils.isNotBlank(token)) {
			E3Result result = userService.getUserByToken(token);
			if (result.getStatus() == 200) {
				//取用户信息
				TbUser user = (TbUser) result.getData();
				//将用户信息保存到request
				request.setAttribute("user", user);
			}
		}
		//用户不登陆也可以使用购物车
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
			throws Exception {

	}



}
