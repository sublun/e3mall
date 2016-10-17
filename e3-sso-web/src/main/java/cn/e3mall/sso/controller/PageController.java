package cn.e3mall.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面展示Controller
 * <p>Title: PageController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class PageController {

	@RequestMapping("/page/login")
	public String showLogin(String redirectUrl, Model model) {
		model.addAttribute("redirect", redirectUrl);
		return "login";
	}
	@RequestMapping("/page/register")
	public String showRegister() {
		return "register";
	}
}
