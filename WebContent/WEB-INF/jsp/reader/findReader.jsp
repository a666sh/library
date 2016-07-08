<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>读者管理</title>
</head>
<body>
	<ul class="nav nav-tabs">
		<li role="presentation" class="active"><a href="reader_findReader.do">读者列表</a></li>
		<li role="presentation"><a
			href="reader_addInput.do">添加读者</a></li>
		<li role="presentation"><a
			href="personType_list.do">读者类型管理</a></li>
	</ul>
	<br />
	<br />
	<table class="table table-bordered table-hover" align="center"
		width="900">
		<tr>
			<th>读者标识</th>
			<th>用户名</th>
			<th>读者密码</th>
			<th>真实姓名</th>
			<th>读者性别</th>
			<th>读者类型</th>
			<th>读者注册日期</th>
			<th>读者操作</th>
		</tr>
		<s:iterator value="#readers.datas">
			<tr>
				<td>${id }</td>
				<td><a href="reader_show.action?id=${id }">${username}</a></td>
				<td>${password }</td>
				<td>${realName }</td>
				<td>${sex }</td>
				<td>${type.name }</td>
				<td><s:date name="createDate" /></td>
				<td><a class="btn btn-danger"
					href="reader_delete.action?id=${id }">删除</a>&nbsp; <a
					class="btn btn-default" href="reader_updateInput.action?id=${id }">更新</a>
				</td>
			</tr>
		</s:iterator>
	</table>
	<jsp:include page="/inc/pager.jsp">
		<jsp:param value="reader_findReader.action" name="url" />
		<jsp:param value="${readers.totalRecord }" name="items" />
	</jsp:include>
</body>
</html>