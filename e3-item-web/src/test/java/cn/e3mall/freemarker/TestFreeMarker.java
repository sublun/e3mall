package cn.e3mall.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class TestFreeMarker {

	@Test
	public void testFreeMarker() throws Exception {
		//创建一个Freemarker的Configuration对象
		Configuration configuration = new Configuration(Configuration.getVersion());
		//配置模板文件所在的路径
		configuration.setDirectoryForTemplateLoading(new File("D:/workspaces-itcast/JavaEE27/taotao-item-web/src/main/webapp/WEB-INF/ftl"));
		//指定模板的字符集
		configuration.setDefaultEncoding("utf-8");
		//使用Configuration对象加载一个模板创建一个模板对象
		Template template = configuration.getTemplate("student.ftl");
		//创建一个数据集，可以是pojo也可以是map，推荐使用map
		Map data = new HashMap<>();
		data.put("hello", "hello freemarker");
		data.put("title", "学生信息展示");
		data.put("student", new Student(1, "张三", "男", "北京", 10));
		List<Student> stuList = new ArrayList<>();
		stuList.add(new Student(1, "小明1", "男", "北七家", 30));
		stuList.add(new Student(2, "小明2", "男", "北七家", 31));
		stuList.add(new Student(3, "小明3", "男", "北七家", 32));
		stuList.add(new Student(4, "小明4", "男", "北七家", 33));
		stuList.add(new Student(5, "小明5", "男", "北七家", 34));
		stuList.add(new Student(6, "小明6", "男", "北七家", 35));
		stuList.add(new Student(7, "小明7", "男", "北七家", 36));
		data.put("stuList", stuList);
		data.put("date", new Date());
		data.put("mytest", "我的测试");
		//创建一个Writer对象，指定文件数输出的路径及文件名。
		Writer out = new FileWriter(new File("D:/temp/javaee27/out/student.html"));
		//使用模板对象的process方法生成文件。
		template.process(data, out);
		//关闭流
		out.close();
	}
}
