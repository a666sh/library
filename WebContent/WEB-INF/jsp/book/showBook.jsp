<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书详情</title>
</head>
<body>
<ul class="nav nav-tabs">
		<li role="presentation"><a href="book_listBook.action">图书列表</a></li>
		<li role="presentation"><a href="book_addBookInput.do">图书入库</a></li>
		<li role="presentation"><a href="book_listType.do">图书类型管理</a></li>
	</ul><br/>
<table align="center" class="table table-bordered table-hover" width="900">
	<tr>
		<th>图书标识</th><th>ISBN</th><th>图书名称</th><th>图书作者</th><th>出版社</th><th>价格</th><th>图书类型</th><th>图书数量</th><th>图书状态</th><th>操作</th>
	</tr>
			<tr>
		<td>${id }</td><td>${isbn }</td><td><a href="book_showBook.do?id=${id }">${name }</a></td><td>${author }</td><td>${publisher }</td><td>${price }</td><td>${booktype.name }</td><td>${bookNo }</td>
		<s:if test="status==0"><td>可借阅</td></s:if>
		<s:if test="status==1"><td>库存不足</td></s:if>
		<s:if test="status==2"><td>已下架</td></s:if>
		<td>
		<a href="book_deleteBook.do?id=${id }">删除</a>&nbsp;
		<a href="book_updateBookInput.do?id=${id }">修改</a>
		</td>
	</tr>
</table>
<label><span>图书已借出数量：${count}本</span></label>
<br/>
<label><span>图书剩余数量：${bookNo-count}本</span></label>
</body>
</html>