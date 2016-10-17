package cn.e3mall.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.e3mall.common.pojo.SearchResult;
import cn.e3mall.search.service.SearchService;

/**
 * 商品搜索服务Controller
 * <p>Title: SearchController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class SearchController {
	
	@Value("${ITEM_ROWS}")
	private Integer ITEM_ROWS;

	@Autowired
	private SearchService searchService;
	
	@RequestMapping("/search")
	public String search(@RequestParam("keyword")String queryString, 
			@RequestParam(defaultValue="1")Integer page, Model model) throws Exception{
		//解决get乱码问题
		queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
		SearchResult searchResult = searchService.query(queryString, page, ITEM_ROWS);
		//向页面传递参数
		model.addAttribute("query", queryString);
		model.addAttribute("totalPages", searchResult.getTotalPage());
		model.addAttribute("itemList", searchResult.getItemList());
		model.addAttribute("recourdCount", searchResult.getRecordCount());
		model.addAttribute("page", page);
		//异常测试
		//int a = 1/0;
		//返回逻辑视图
		return "search";
	}
	
	@RequestMapping("/error")
	public String showError() {
		return "error/exception";
	}
}
