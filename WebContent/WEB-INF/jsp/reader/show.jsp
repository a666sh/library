<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>读者[${username }]个人信息</title>
</head>
<body>
<br/><br/><br/>
<div class="col-xs-6 col-md-offset-3">
<table class="table table-responsive table-bordered table-condensed table-hover" align="center" width="400">
	<tr><th class="text-center" colspan="2">正在查看[${realName }]的信息</th></tr>
	<tr><td>读者编号</td><td width="250">${id }</td></tr>
	<tr><td>读者名</td><td>${username }</td></tr>
	<tr><td>真实姓名</td><td>${realName }</td></tr>
	<tr><td>性别</td><td>${sex }</td></tr>
	<tr><td>注册日期</td><td><s:date name="createDate" format="yyyy-MM-dd"/></td></tr>
	<tr><td>读者类型</td><td>${type.name }</td></tr>
	<tr><td>最大可借数量</td><td>${type.maxNo }</td></tr>
	<tr><td>当前已借数量</td><td>${curNo }</td></tr>
	</table>
</div>
</body>
</html>