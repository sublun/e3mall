package cn.e3mall.search.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器
 * <p>Title: GlobalExceptionResolver</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {

	private static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionResolver.class);
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception e) {
		LOGGER.debug("debug测试。hahahahah。。。。");
		LOGGER.debug("handler类型：" + handler.getClass().getName());
		LOGGER.info("已经进入全局异常处理器");
		//写日志文件
		LOGGER.error(e.getMessage(),e);
		//控制台打印
		e.printStackTrace();
		//发邮件
		//java mail工具包。是一个邮件客户端。
		//发短信
		//展示错误页面
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error/exception");
		modelAndView.addObject("message", "您的网络有问题请稍后重试。。。。");
		return modelAndView;
	}

}
