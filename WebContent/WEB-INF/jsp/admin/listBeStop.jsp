<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员列表</title>
</head>
<body>
<ul class="nav nav-tabs">
  <li role="presentation" class="active"><a href="admin_list.do">管理员列表</a></li>
  <li role="presentation"><a href="admin_addInput.do">添加管理员</a></li>
</ul>
<br/><br/><br/>
<table class="table table-bordered table-hover" align="center" width="1000">
	<tr><th>管理员标识</th><th>用户名</th><th>读者密码</th><th>真实姓名</th><th>联系地址</th><th>联系电话</th><th>管理员权限</th><th>管理员身份</th><th>管理员操作</th></tr>
	<s:iterator value="#as.datas">
	<tr>
		<td>${id }</td>
		<td><a href="admin_show.action?id=${id }">${username}</a></td>
		<td>${password }</td>
		<td>${relname }</td>
		<td>${address }</td>
		<td>${tel }</td>
		<td>
		<s:if test="status==0">所有权限</s:if>
		<s:if test="status==1">书籍入库权限</s:if>
		<s:if test="status==2">借阅管理权限</s:if>
		<s:if test="status==5">已停用</s:if>
		</td>
		<td>${type.name }</td>
		<td><s:if test="status==5"><a class="btn btn-info" href="admin_delete.action?id=${id }">启用管理员</a></s:if><s:else><a class="btn btn-danger" href="admin_delete.action?id=${id }">停用管理员</a></s:else>&nbsp;
			<a class="btn btn-default" href="admin_updateInput.action?id=${id }">更新信息</a>
		</td>
	</tr>
</s:iterator>
</table>
<jsp:include page="/inc/pager.jsp">
	<jsp:param value="admin_list.action" name="url"/>
	<jsp:param value="${as.totalRecord }" name="items"/>
</jsp:include>
</body>
</html>