<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>读者添加</title>
</head>
<body>
	<ul class="nav nav-tabs">
		<li role="presentation"><a href="reader_findReader.do">读者列表</a></li>
		<li role="presentation" class="active"><a
			href="reader_addInput.do">添加读者</a></li>
		<li role="presentation"><a href="personType_list.do">读者类型管理</a></li>
	</ul>
	<br />
	<div class="row">
		<div class="col-sm-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<span><small>添加读者</small></span>
					</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal center" action="reader_add.do"
						method="post">
						<div class="form-group">
							<label for="username" class="col-sm-3 control-label"> 用户名</label>
							<div class="col-sm-6">
								<input name="username" type="text" value="${username }"
									class="form-control" id="username" placeholder="输入用户名">
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
							<label for="realName" class="col-sm-3 control-label">
								真实姓名</label>
							<div class="col-sm-6">
								<input name="realName" type="text" value="${realName }"
									class="form-control" id="realName" placeholder="输入用户真实姓名">
							</div>
						</div>
						<div class="form-group">
							<label for="sex" class="col-sm-3 control-label"> 性别</label>
							<div class="col-sm-6">
								<label class="btn btn-info active"> <input type="radio"
									name="sex" id="option1" value="男" autocomplete="off" checked>
									男
								</label><label class="btn btn-danger"> <input type="radio"
									name="sex" value="女" id="option2" autocomplete="off"> 女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label for="tid" class="col-sm-3 control-label">读者类型</label>
							<div class="col-sm-6">
								<select name="tid" class="form-control">
									<option value="0">请选择相应的读者类型</option>
									<s:iterator value="#ps">
										<s:if test="id==type.id">
											<option value="${id }" selected="selected">${name }</option>
										</s:if>
										<s:else>
											<option value="${id }">${name }</option>
										</s:else>
									</s:iterator>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-7">
								<button type="submit" class="btn btn-default">确认添加</button>
							</div>
						</div>
					</form>
				</div>
			</div>
</body>
</html>