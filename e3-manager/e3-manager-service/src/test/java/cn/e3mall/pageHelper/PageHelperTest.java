package cn.e3mall.pageHelper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;

public class PageHelperTest {

	@Test
	public void testPagehelper() {
		//1、在mybatis的配置文件中配置插件
		//2、在执行查询之前设置分页信息。使用PageHelper的startPage方法。
		PageHelper.startPage(1, 30);
		//3、执行查询
		//初始化spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		//4、取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		//取总记录数
		System.out.println("查询总记录数：" + pageInfo.getTotal());
		System.out.println("查询总页数：" + pageInfo.getPages());
		System.out.println("查询总记录数：" + pageInfo.getPageNum());
		System.out.println("list中的记录数：" + list.size());
		
	}
}
