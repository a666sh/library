<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>系统登录</title>
<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<link href="signin.css" rel="stylesheet">
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>
<!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="jumbotron">
<div>
  <h1>欢迎使用</h1>
  <h3>图书管理系统</h3>
</div>
<div class="col-md-6 col-md-offset-7" style="margin-top: -130px ">
	<form class="form-horizontal" action="login.do">
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
			<div class="col-sm-6">
				<input name="username" type="text" class="form-control"
					id="inputEmail3" placeholder="请输入用户名">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
			<div class="col-sm-6">
				<input name="password" type="password" class="form-control"
					id="inputPassword3" placeholder="请输入密码">
			</div>
		</div>
		<div class="form-group"></div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">登陆</button>
			</div>
		</div>
	</form>
	</div>
</div>
</body>
</html>
