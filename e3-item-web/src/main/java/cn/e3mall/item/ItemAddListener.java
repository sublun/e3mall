package cn.e3mall.item;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.activemq.filter.function.inListFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import cn.e3mall.item.pojo.Item;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.service.ItemService;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class ItemAddListener implements MessageListener {
	
	@Autowired
	private ItemService itemService;
	@Autowired
	private FreeMarkerConfig freeMarkerConfig;
	@Value("${HTML_OUT_PATH}")
	private String HTML_OUT_PATH;

	@Override
	public void onMessage(Message message) {
		try {
			Thread.sleep(100);
			//从消息中取商品id
			TextMessage textMessage = (TextMessage) message;
			String text = textMessage.getText();
			Long itemId = Long.parseLong(text);
			//根据商品id查询商品基本信息和商品描述
			TbItem tbItem = itemService.getItemById(itemId);
			Item item = new Item(tbItem);
			TbItemDesc tbItemDesc = itemService.getItemDescById(itemId);
			//加载模板文件
			Configuration configuration = freeMarkerConfig.getConfiguration();
			Template template = configuration.getTemplate("item.ftl");
			//创建对应的数据集
			Map model = new HashMap<>();
			model.put("item", item);
			model.put("itemDesc", tbItemDesc);
			//生成静态页面的文件名
			Writer out = new FileWriter(new File(HTML_OUT_PATH + itemId + ".html"));
			//生成静态页面
			template.process(model, out);
			//关闭流
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
