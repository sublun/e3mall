package cn.e3mall.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Success {

	@RequestMapping("/success")
	public String showSuccess() {
		return "success";
	}
}
