<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人信息</title>
</head>
<body>
	<br />
	<br />
	<br />
	<div class="row">
		<div class="col-sm-6 col-md-offset-3">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">
						<span><small>修改个人信息</small></span>
					</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal center" action="admin_updateSelf.do"
						method="post">
						<div class="form-group">
							<label for="username" class="col-sm-3 control-label"> 用户名</label>
							<div class="col-sm-6">
								<label name="username" class="form-control" id="username"
									placeholder="输入用户名">${username }</label>
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-sm-3 control-label">
								用户密码</label>
							<div class="col-sm-6">
								<input name="password" type="password" value="${password }"
									class="form-control" id="password" placeholder="输入用户密码">
							</div>
						</div>
						<div class="form-group">
							<label for="relname" class="col-sm-3 control-label"> 真实姓名</label>
							<div class="col-sm-6">
								<input name="relname" type="text" value="${relname }"
									class="form-control" id="relname" placeholder="输入用户真实姓名">
							</div>
						</div>
						<div class="form-group">
							<label for="address" class="col-sm-3 control-label"> 联系地址</label>
							<div class="col-sm-6">
								<input name="address" type="text" value="${address }"
									class="form-control" id="address" placeholder="输入您的联系地址">
							</div>
						</div>
						<div class="form-group">
							<label for="tel" class="col-sm-3 control-label"> 联系电话</label>
							<div class="col-sm-6">
								<input name="tel" type="text" value="${tel }"
									class="form-control" id="tel" placeholder="请输入您的联系电话">
							</div>
						</div>
						<div class="form-group">
							<label for="type.name" class="col-sm-3 control-label"> 管理员身份</label>
							<div class="col-sm-6">
								<label name="type.name" value="${relname }"
									class="form-control" id="type.name" placeholder="输入用户真实姓名">${type.name }</label>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-7">
								<button type="submit" class="btn btn-default">确认修改</button>
							</div>
						</div>
					</form>
				</div>
			</div>
</body>
</html>