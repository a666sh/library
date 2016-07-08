<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书馆类型信息列表</title>
</head>
<body>
	<ul class="nav nav-tabs">
		<li role="presentation" class="active"><a href="personType_list.do">读者类型列表</a></li>
		<li role="presentation"><a href="personType_addInput.do">添加读者类型</a></li>
	</ul>
<br/><br/><br/>
<table class="table table-hover">
<tr><th>ID</th><th>类型名称</th><th>最大可借阅数</th><th>可借阅时间</th><th>操作</th></tr>
<s:iterator value="#personTypes">
	<tr><td>${id }</td><td>${name }</td><td>${maxNo }</td><td>${date }</td><td><a class="btn btn-info" href="personType_updateInput.do?id=${id }">更新</a><a class="btn btn-danger" href="personType_delete.do?id=${id }">删除</a></td></tr>
</s:iterator>
</table>
</body>
</html>