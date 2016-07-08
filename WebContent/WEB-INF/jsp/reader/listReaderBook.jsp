<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>借阅管理</title>
</head>
<body>
	<ul class="nav nav-tabs">
		<li role="presentation"><a href="reader_addReaderBookInput.do">借书办理</a></li>
		<li role="presentation"><a
			href="reader_receiveReaderBookInput.do">还书办理</a></li>
		<li role="presentation"><a href="reader_payInput.do">赔偿办理</a></li>
	</ul>
	<br />
	<br />
	<br />
	<table class="table table-bordered table-hover" align="center"
		width="1100">
		<tr>
			<th>借阅单号</th>
			<th>借书用户</th>
			<th>书籍名称</th>
			<th>借书日期</th>
			<th>应还日期</th>
			<th>实还日期</th>
			<th>借阅状态</th>
			<th>赔付状态</th>
			<th>赔付金额</th>
			<th>信息操作</th>
		</tr>
		<s:iterator value="#pagers.datas">
			<tr>
				<td>${id }</td>
				<td><a href="reader_show.action?id=${reader.id }">${reader.realName}</a></td>
				<td><a href="book_showBook.do?id=${book.id }">${book.name }</a></td>
				<td><s:date name="startDate" format="yyyy-MM-dd HH:mm:ss" /></td>
				<td><s:date name="endDate" format="yyyy-MM-dd" /></td>
				<td><s:if test="reaDate!=null">
						<s:date name="reaDate" format="yyyy-MM-dd HH:mm:ss" />
					</s:if> <s:else>
			尚未还书
		</s:else></td>
				<td><s:if test="status==0">
				正在借阅
			</s:if> <s:if test="status==1">
				正常归还
			</s:if> <s:if test="status==2">
				需要赔付
			</s:if> <s:if test="status==3">
				已经赔付
			</s:if> <s:if test="status==4">
				已经赔付
			</s:if></td>
				<td><s:if test="fineType==0">不用赔偿</s:if> <s:if
						test="fineType==1">超时赔偿</s:if> <s:if test="fineType==2">损坏书籍赔偿</s:if>
				</td>
				<td>${payMoney }</td>
				<td><a class="btn btn-danger"
					href="reader_deleteReaderBook.action?id=${id }">删除</a>&nbsp;</td>
			</tr>
		</s:iterator>
	</table>
	<jsp:include page="/inc/pager.jsp">
		<jsp:param value="reader_listReaderBook.action" name="url" />
		<jsp:param value="${pagers.totalRecord }" name="items" />
	</jsp:include>
</body>
</html>