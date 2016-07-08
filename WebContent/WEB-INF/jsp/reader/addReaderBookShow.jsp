<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>借书信息</title>
</head>
<body>
	<ul class="nav nav-tabs">
		<li role="presentation"><a
			href="reader_addReaderBookInput.do">借书办理</a></li>
		<li role="presentation"><a
			href="reader_receiveReaderBookInput.do">还书办理</a></li>
		<li role="presentation"><a href="reader_payInput.do">赔偿办理</a></li>
	</ul>
	<br />
	<br />
	<br />
	<div class="col-xs-6 col-md-offset-3">
		<form action="reader_addReaderBook.do" method="post">
			<s:hidden name="id" value="%{id}" />
			<input type="hidden" name="bid" value="${b.id }" />
			<table class="table table-bordered table-hover" align="center"
				width="500">
				<tr>
					<th colspan="2" class="text-center" align="center">读者信息</th>
				</tr>
				<tr>
					<td>读者编号</td>
					<td>${id }</td>
				</tr>
				<tr>
					<td>读者名</td>
					<td><a href="reader_show.do?id=${id }">${username }</a></td>
				</tr>
				<tr>
					<td>真实姓名</td>
					<td>${realName }</td>
				</tr>
				<tr>
					<td>性别</td>
					<td>${sex }</td>
				</tr>
				<tr>
					<td>读者身份</td>
					<td>${type.name }</td>
				</tr>
				<tr id="addReaderBookShow">
					<th class="text-center" colspan="2" align="center">书籍信息</th>
				</tr>
				<tr>
					<td>书籍编号</td>
					<td>${b.id }</td>
				</tr>
				<tr>
					<td>书籍名称</td>
					<td>${b.name }</td>
				</tr>
				<tr>
					<td>ISBN</td>
					<td>${b.isbn }</td>
				</tr>
				<tr>
					<td>作者</td>
					<td>${b.author }</td>
				</tr>
				<tr>
					<td>出版社</td>
					<td>${b.publisher }</td>
				</tr>
				<tr>
					<td>价格</td>
					<td>${b.price }</td>
				</tr>
				<tr>
					<td>价格</td>
					<td>${b.booktype.name }</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						class="btn btn-info" value="确认办理" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>