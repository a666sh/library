<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员[${loginAdmin.username }]的信息</title>
</head>
<body>
<br/><br/><br/>
<div class="col-xs-6 col-md-offset-3">
<table class="table table-responsive table-bordered table-condensed table-hover" align="center" width="400">
	<tr><th colspan="2"  class="text-center">个人信息查看</th></tr>
	<tr><td>用户标识</td><td width="250">${id }</td></tr>
	<tr><td>用户名称</td><td>${username }</td></tr>
	<tr><td>真实姓名</td><td>${relname }</td></tr>
	<tr><td>用户地址</td><td>${address }</td></tr>
	<tr><td>联系电话</td><td>${tel }</td></tr>
	<tr><td>管理员身份</td><td>${type.name }</td></tr>
</table>
</div>
</body>
</html>