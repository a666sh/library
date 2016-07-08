<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书类型列表</title>
</head>
<body>
	<ul class="nav nav-tabs">
		<li role="presentation" class="active"><a href="book_listType.action">图书类型列表</a></li>
		<li role="presentation"><a
			href="book_addTypeInput.do">添加图书类型</a></li>
	</ul>
	<br />
	<br />
	<br />
	<table align="center" class="table table-bordered table-hover">
		<tr>
			<td>图书类型标识</td>
			<td>图书类型名称</td>
			<td>图书类型操作</td>
		</tr>
		<s:iterator value="#bts">
			<tr>
				<td>${id }</td>
				<td>${name }</td>
				<td><a class="btn btn-default" onclick="firm(${id})">删除</a>&nbsp;
					<a class="btn btn-info" href="book_updateTypeInput.do?tid=${id }">修改</a>
				</td>
			</tr>
		</s:iterator>
	</table>
	<script type="text/javascript">
	function firm(obj) {
	    if (confirm("你确定删除吗？")) { 
	        window.location.href="book_deleteType.do?tid="+obj;
	    }  
	    else {  
	    }  
}  
</script>
</body>
</html>