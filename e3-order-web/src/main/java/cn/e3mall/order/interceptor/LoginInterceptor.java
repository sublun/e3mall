package cn.e3mall.order.interceptor;

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
 * 用户登录拦截器
 * <p>Title: LoginInterceptor</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Value("${TOKEN_KEY}")
	private String TOKEN_KEY;
	@Value("${SSO_URL}")
	private String SSO_URL;
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 执行handler之前执行
		//1、判断用户是否登录
		//2、从cookie中取token
		String token = CookieUtils.getCookieValue(request, TOKEN_KEY);
		//3、如果取不到token，跳转到sso的登录页面,拦截
		if (StringUtils.isBlank(token)) {
			//跳转到sso系统的登录页面，把请求的url传递给登录页面
			response.sendRedirect(SSO_URL + "/page/login?redirectUrl=" + request.getRequestURL());
			return false;
		}
		//4、取到token调用sso服务，根据token查询用户信息
		E3Result result = userService.getUserByToken(token);
		//5、判断是否取到用户信息
		if (result.getStatus() != 200) {
			//跳转到sso系统的登录页面，把请求的url传递给登录页面
			//6、取不到，跳转到sso的登录页面，拦截
			response.sendRedirect(SSO_URL + "/page/login?redirectUrl=" + request.getRequestURL());
			return false;
		}
		//7、取到用户信息放行
		TbUser user = (TbUser) result.getData();
		request.setAttribute("user", user);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		// 执行handler之后，返回ModelAndView之前

	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
			throws Exception {
		//返回ModelAndView之后

	}

}
