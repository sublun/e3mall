package cn.e3mall.item.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

/**
 * 页面静态化Controller
 * <p>Title: HtmlGenController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class HtmlGenController {
	
	@Autowired
	private FreeMarkerConfig freeMarkerConfig;

	@RequestMapping("/genHtml")
	@ResponseBody
	public String genHtml() throws Exception {
		Configuration configuration = freeMarkerConfig.getConfiguration();
		Template template = configuration.getTemplate("hello.ftl");
		Map data = new HashMap<>();
		data.put("hello", "genHtml hello");
		Writer out = new FileWriter(new File("D:/temp/javaee27/out/hello2.html"));
		template.process(data, out);
		out.close();
		return "OK";
	}
}
