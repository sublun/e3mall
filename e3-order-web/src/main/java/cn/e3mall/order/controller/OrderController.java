package cn.e3mall.order.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.utils.CookieUtils;
import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.order.pojo.Item;
import cn.e3mall.order.pojo.OrderInfo;
import cn.e3mall.order.service.OrderService;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbUser;

/**
 * 订单处理Controller
 * <p>Title: OrderController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class OrderController {
	
	@Value("${CART_KEY}")
	private String CART_KEY;
	@Autowired
	private OrderService orderService;

	@RequestMapping("/order/order-cart")
	public String showOrderCart(HttpServletRequest request) {
		//根据用户id查询收货地址列表，目前使用静态数据
		TbUser user = (TbUser) request.getAttribute("user");
		//System.out.println(user.getUsername());
		//支付方式列表，静态数据
		//从cookie中取购物车列表
		List<TbItem> cartList = getCartList(request);
		List<Item> itemList = new ArrayList<>();
		for (TbItem tbItem : cartList) {
			Item item = new Item(tbItem);
			itemList.add(item);
		}
		//把商品列表传递给jsp
		request.setAttribute("cartList", itemList);
		//返回逻辑视图
		return "order-cart";
	}
	
	private List<TbItem> getCartList(HttpServletRequest request) {
		//使用CookieUtil工具类
		String json = CookieUtils.getCookieValue(request, CART_KEY, true);
		if (StringUtils.isBlank(json)) {
			return new ArrayList<>();
		}
		//如果cookie中有购物车列表
		List<TbItem> list = JsonUtils.jsonToList(json, TbItem.class);
		return list;
	}
	
	@RequestMapping(value="/order/create", method=RequestMethod.POST)
	public String createOrder(HttpServletRequest request, OrderInfo orderInfo, Model model) {
		//取用户信息
		TbUser user = (TbUser) request.getAttribute("user");
		orderInfo.setUserId(user.getUserId());
		orderInfo.setBuyerNick(user.getUsername());
		//业务处理
		E3Result e3Result = orderService.createOrder(orderInfo);
		//向页面传递数据
		model.addAttribute("orderId", e3Result.getData());
		model.addAttribute("payment", orderInfo.getPayment());
		//设置为当前时间三天之后的日期。
		DateTime dateTime = new DateTime();
		dateTime = dateTime.plusDays(3);
		model.addAttribute("date", dateTime.toString("yyyy-MM-dd"));
		return "success";
	}
}
