package cn.e3mall.portal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.content.service.ContentService;
import cn.e3mall.pojo.TbContent;
import cn.e3mall.portal.pojo.Ad1Node;

/**
 * 首页处理Controller
 * <p>Title: IndexController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class IndexController {
	
	@Autowired
	private ContentService contentService;
	
	@Value("${INDEX_AD1_CID}")
	private Long INDEX_AD1_CID;
	@Value("${AD1_WIDTH}")
	private Integer AD1_WIDTH;
	@Value("${AD1_WIDTH_B}")
	private Integer AD1_WIDTH_B;
	@Value("${AD1_HEIGHT}")
	private Integer AD1_HEIGHT;
	@Value("${AD1_HEIGHT_B}")
	private Integer AD1_HEIGHT_B;

	@RequestMapping("/index")
	public String showIndex(Model model) {
		//取首页大广告位内容
		List<TbContent> ad1List = contentService.getContentList(INDEX_AD1_CID);
		//转换成AD1Node列表
		/*List<Ad1Node> ad1Nodes = new ArrayList<>();
		for (TbContent tbContent : ad1List) {
			Ad1Node node = new Ad1Node();
			node.setAlt(tbContent.getTitle());
			node.setHref(tbContent.getUrl());
			node.setSrc(tbContent.getPic());
			node.setSrcB(tbContent.getPic2());
			node.setWidth(AD1_WIDTH);
			node.setWidthB(AD1_WIDTH_B);
			node.setHeight(AD1_HEIGHT);
			node.setHeightB(AD1_HEIGHT_B);
			//添加到列表
			ad1Nodes.add(node);
		}
		model.addAttribute("ad1", JsonUtils.objectToJson(ad1Nodes));*/
		model.addAttribute("ad1List", ad1List);
		return "index";
	}
}
