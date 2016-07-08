<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>读者个人信息</title>
</head>
<body>
<br/><br/><br/>
<div class="col-xs-6 col-md-offset-3">
<table class="table table-responsive table-bordered table-condensed table-hover" align="center" width="400">
	<tr><th colspan="2" class="text-center">个人信息</th></tr>
	<tr><td>读者编号</td><td width="250">${id }</td></tr>
	<tr><td>读者名</td><td>${username }</td></tr>
	<tr><td>真实姓名</td><td>${realName }</td></tr>
	<tr><td>性别</td><td>${sex }</td></tr>
	<tr><td>注册日期</td><td><s:date name="createDate" format="yyyy-MM-dd"/></td></tr>
	<tr><td>读者类型</td><td>${type.name }</td></tr>
	<tr><td>最大可借数量</td><td>${type.maxNo }</td></tr>
	<tr><td>当前已借数量</td><td>${curNo }</td></tr>
	<tr align="center"><td><a class="btn btn-info" onclick="opeanReaderBook()">查看借阅记录<a/></td>
	<td><a href="reader_showSelf.action#hellohello" class="btn btn-warning" onclick="overReaderBook()">隐藏借阅记录<a/></td>
	</tr>
</table>
</div>
<div id="hellohello" style="display: none;">
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
		</tr>
		<s:iterator value="#rbs">
			<tr>
				<td>${id }</td>
				<td>${reader.realName}</td>
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
			</tr>
		</s:iterator>
	</table>
</div>
<script type="text/javascript">
function opeanReaderBook() {
	var a=document.getElementById("hellohello");
	a.style.display="block";
}
function overReaderBook() {
	var a=document.getElementById("hellohello");
	a.style.display="none";
}
</script>
</body>
</html>