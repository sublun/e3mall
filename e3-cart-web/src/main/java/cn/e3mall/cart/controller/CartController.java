package cn.e3mall.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.cart.pojo.Item;
import cn.e3mall.cart.service.CartService;
import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.utils.CookieUtils;
import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbUser;
import cn.e3mall.service.ItemService;

/**
 * 购物车管理Controller
 * <p>Title: CartController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class CartController {
	
	@Value("${CART_KEY}")
	private String CART_KEY;
	@Value("${CART_EXPIRE}")
	private Integer CART_EXPIRE;
	@Autowired
	private ItemService itemService;
	@Autowired
	private CartService cartService;

	//添加购车处理
	@RequestMapping("/cart/add/{itemId}")
	public String addCart(@PathVariable Long itemId,
			@RequestParam(defaultValue="1")Integer num,
			HttpServletRequest request, HttpServletResponse response) {
		//取用户信息，判断用户是否登录
		Object user = request.getAttribute("user");
		//用户已经登录则使用购物车服务
		if (user != null) {
			cartService.addCart(((TbUser)user).getId(), itemId, num);
			return "cartSuccess";
		}
		//用户未登录状态使用cookie保存购物车信息
		//1、取商品id和商品数量
		//2、从cookie中取购物车列表
		List<TbItem> cartList = getCartList(request);
		//3、判断购物车列表中是否有此商品数据
		boolean flag = false;
		for (TbItem tbItem : cartList) {
			if (tbItem.getId() == itemId.longValue()) {
				//4、如果有数量相加
				tbItem.setNum(tbItem.getNum() + num);
				flag = true;
			}
		}		
		//5、如果没有根据商品id查询商品信息
		if (!flag) {
			TbItem tbItem = itemService.getItemById(itemId);
			//6、把商品信息添加到购物车，数量就是num的值
			tbItem.setNum(num);
			cartList.add(tbItem);
		}
		//7、把购物车列表添加到cookie
		CookieUtils.setCookie(request, response, CART_KEY, JsonUtils.objectToJson(cartList),
				CART_EXPIRE, true);
		//8、返回添加成功页面
		return "cartSuccess";
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
	
	@RequestMapping("/cart/cart")
	public String showCartList(HttpServletRequest request, HttpServletResponse response) {
		//从cookie中取购物车列表
		List<TbItem> cartList = getCartList(request);
		//取用户信息，判断用户是否登录
		TbUser user = (TbUser)request.getAttribute("user");
		//用户已经登录则使用购物车服务
		if (user != null) {
			//判断cookie中是否有购物车信息
			if (!cartList.isEmpty()) {
				//将购物车同步到服务端
				cartService.mergeCartItem(((TbUser)user).getId(), cartList);
				//将cookie中的购物车信息删除
				CookieUtils.setCookie(request, response, CART_KEY, "", 0);
			}
			//从服务端取购物车商品列表
			cartList = cartService.getCartList(((TbUser)user).getId());
			
		}
		//把商品列表传递给页面
		List<Item> itemList = new ArrayList<>();
		for (TbItem tbItem : cartList) {
			Item item = new Item(tbItem);
			itemList.add(item);
		}
		request.setAttribute("cartList", itemList);
		//返回逻辑视图
		return "cart";
	}
	
	@RequestMapping("/cart/update/num/{itemId}/{num}")
	@ResponseBody
	public E3Result updateCartItem(@PathVariable Long itemId, @PathVariable Integer num,
			HttpServletRequest request, HttpServletResponse response) {
		//取用户信息，判断用户是否登录
		Object user = request.getAttribute("user");
		//用户已经登录则使用购物车服务
		if (user != null) {
			E3Result result = cartService.updateItemNum(((TbUser)user).getId(), itemId, num);
			return result;
		}
		//从cookie中取购物车列表
		List<TbItem> cartList = getCartList(request);
		//查询到对应的商品
		for (TbItem tbItem : cartList) {
			if (tbItem.getId().longValue() == itemId) {
				//更新商品数量
				tbItem.setNum(num);
				break;
			}
		}
		//把购车列表写入cookie
		CookieUtils.setCookie(request, response, CART_KEY, JsonUtils.objectToJson(cartList),
				CART_EXPIRE, true);
		//返回E3Result
		return E3Result.ok();
	}
	
	@RequestMapping("/cart/delete/{itemId}")
	public String deleteCartItem(@PathVariable Long itemId, 
			HttpServletResponse response,HttpServletRequest request) {
		//取用户信息，判断用户是否登录
		Object user = request.getAttribute("user");
		//用户已经登录则使用购物车服务
		if (user != null) {
			E3Result result = cartService.deleteCartItem(((TbUser)user).getId(), itemId);
			return "redirect:/cart/cart.html";
		}
		//从cookie中取购物车列表
		List<TbItem> cartList = getCartList(request);
		//找到对应的商品
		for (TbItem tbItem : cartList) {
			if (tbItem.getId().longValue() == itemId) {
				//删除对应的商品
				cartList.remove(tbItem);
				break;
			}
		}
		//写入cookie
		CookieUtils.setCookie(request, response, CART_KEY, JsonUtils.objectToJson(cartList),
				CART_EXPIRE, true);
		//返回购物车列表页面
		return "redirect:/cart/cart.html";
	}

}