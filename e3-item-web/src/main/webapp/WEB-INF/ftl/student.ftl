<html>
	<head>
		<title>${title}</title>
		<link rel="stylesheet" type="text/css" href="${url!}/css/pshow.css" media="all" />
	</head>
	<body>
		展示学生信息:<br>
		学号：${student.id}
		姓名：${student.name}
		性别：${student.sex}
		家庭住址：${student.address}
		年龄：${student.age}
	</body>
	学生列表信息：<br>
	<table border="1">
		<tr>
			<td>序号</td><td>学号</td><td>姓名</td><td>性别</td><td>家庭住址</td><td>年龄</td>
		</tr>
		<#list stuList as stu>
		<#if stu_index%2==0>
		<tr bgcolor="red">
		<#else>
		<tr bgcolor="blue">
		</#if>
			<td>${stu_index}</td><td>${stu.id}</td><td>${stu.name}</td><td>${stu.sex}</td><td>${stu.address}</td><td>${stu.age}</td>
		</tr>
		</#list>
	</table>
	<br>
	展示日期类型：<br>
	当前日期：${date?date}<br>
	当前日期格式自定义：${date?string("yyyy/MM/dd HH:mm:ss")}<br>
	null值测试：${mytest!}<br>
	null值的if处理：
	<#if mytest??>
		mytest的值不为null
	<#else>
		mytest的值为null
	</#if>
	<br>
	include测试：<#include "hello.ftl">
</html>