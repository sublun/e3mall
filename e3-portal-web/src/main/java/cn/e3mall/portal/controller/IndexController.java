package cn.e3mall.portal.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.e3mall.common.utils.StringUtil;
import cn.e3mall.content.service.ContentService;
import cn.e3mall.pojo.TbContent;
import cn.e3mall.pojo.TbGoods;
import cn.e3mall.pojo.TbGoodsImage;
import cn.e3mall.service.ItemService;

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
	@Autowired
	private ItemService itemService;
	
	@Value("${INDEX_SILDER_CODE}")
	private String INDEX_SILDER_CODE;
	@Value("${GOOD_DETAIL_URL}")
	private String GOOD_DETAIL_URL;
	@Value("${INDEX_FLOOR1_CODE}")
	private String INDEX_FLOOR1_CODE;


	@RequestMapping("/index")
	public String showIndex(Model model) {
		//取首页大广告位内容
		List<TbContent> ad1List = getContentList(INDEX_SILDER_CODE);
		//取一楼内容
		List<TbContent> floor1List = getContentList(INDEX_FLOOR1_CODE);
		//将结果传递给jsp页面
		model.addAttribute("ad1List", ad1List);
		model.addAttribute("floor1List", floor1List);
		
		return "index";
	}
	
	/**
	 * 根据code取内容列表。如果内容指定为商品id则将商品信息展示到页面。
	 * <p>Title: getContentList</p>
	 * <p>Description: </p>
	 * @param spaceCode
	 * @return
	 */
	private List<TbContent> getContentList(String spaceCode) {
		//更加spaceCode查询内容列表
		List<TbContent> contentList = contentService.getContentList(spaceCode);
		//如果内容对应的是商品需要
		for (TbContent tbContent : contentList) {
			//如果内容没有对应的url，则判断是否有商品信息，将商品id转换成url
			if (StringUtils.isEmpty(tbContent.getUrl()) && tbContent.getGoodsId() != null) {
				//根据商品信息取商品id
				TbGoods goods = itemService.getItemById(tbContent.getGoodsId());
				//如果内容信息中没有图片则取商品图片
				if (StringUtils.isEmpty(tbContent.getPic())) {
					List<TbGoodsImage> images = itemService.getGoodsImages(tbContent.getGoodsId());
					if (images != null && images.size() > 0) {
						//取一张商品图片
						tbContent.setPic(images.get(0).getImgUrl());
					}
				}
				//如果没有内容标题则使用商品名称
				if (StringUtils.isEmpty(tbContent.getTitle())) {
					//取商品标题
					String goodsName = goods.getGoodsName();
					//限制商品标题过长，最多显示15个汉字
					goodsName = StringUtil.cutString(goodsName, 15);
					tbContent.setTitle(goodsName);
					//将完整标题保存
					tbContent.setTitleDesc(goods.getGoodsName());
				}
				//如果没有商品价格则使用商品价格
				if (StringUtils.isEmpty(tbContent.getSubTitle())) {
					tbContent.setSubTitle(goods.getSellPrice().toString());
				}
				//url跳转到商品详情页面
				tbContent.setUrl(GOOD_DETAIL_URL + goods.getGoodsId() + ".html");
			}
		}
		return contentList;
	}
	
}
