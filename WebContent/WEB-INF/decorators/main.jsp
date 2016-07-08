<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Administrator" />
<!-- Date: 2016-06-10 -->
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet">
<!--[if lt IE 9]>
	<script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
<title><decorator:title default="欢迎使用图书馆管理系统" /></title>
<decorator:head />
</head>
<body>
	<div class="container">
		<!-- Static navbar -->
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">欢迎图书管理系统</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<s:if test="#session.loginAdmin!=null||#session.loginReader!=null">
							<li class="dropdown"><a href="book_listBook.action"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false">图书管理 <span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="book_listBook.action">图书列表</a></li>
									<li><a href="book_addBookInput.do">图书入库</a></li>
									<li><a href="book_listType.do">图书类型管理</a></li>
								</ul></li>
							<li><a class="top" href="reader_findReader.do">读者管理</a></li>
							<li><a class="top" href="reader_listReaderBook.do">借阅管理</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">联系我们 <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="message_addInput.do">意见建议</a></li>
									<li><a href="message_list.do">查看留言</a></li>
									<li><a href="<%=request.getContextPath()%>/about.jsp">关于</a></li>
									<!-- //TODO -->
								</ul></li>
							<li><a class="top" href=admin_list.do>权限管理</a></li>
						</s:if>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<s:if test="#session.loginReader!=null&&#session.loginAdmin==null">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false" href="reader_showSelf.do?">个人信息</a>
								<ul class="dropdown-menu">
									<li><a href="reader_showSelf.action">${loginReader.username }的信息</a></li>
									<li><a href="reader_updateSelfInput.do">修改个人信息</a></li>
								</ul></li>
							<li><a href="logOut.do">退出登录</a></li>
						</s:if>
						<s:if test="#session.loginAdmin!=null&&#session.loginReader==null">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false" href=admin_showSelf.do?>个人信息<span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="admin_showSelf.action">${loginAdmin.username }的信息</a></li>
									<li><a href="admin_updateSelfInput.do">修改个人信息</a></li>
								</ul></li>
							<li><a href="logOut.do">退出登录</a></li>
						</s:if>
						<s:if test="#session.loginAdmin==null&&#session.loginReader==null">
							<li><a href="loginInput.do">登陆系统</a></li>
						</s:if>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</nav>
		<decorator:body />
	</div>
	<div align="center"
		style="width: 100%; border-top: 1px solid; float: left; margin-top: 10px;">
		CopyRight@2016-2017<br /> 图书馆管理系统
	</div>
</body>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</html>