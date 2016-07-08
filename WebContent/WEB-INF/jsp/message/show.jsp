<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>意见建议</title>
</head>
<body>
<div class="row">
<div class="col-sm-10">
<table class="table table-bordered table-hover">
	<tr><th>留言标题</th><td>${m.title }</td></tr>
	<tr><th colspan="2">留言内容</th></tr>
	<tr><td colspan="2">${m.content }</td></tr>
</table>
</div>
</div>
</body>
</html>