<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改图书类型信息</title>
</head>
<body>
	<ul class="nav nav-tabs">
		<li role="presentation" ><a href="personType_list.do">读者类型列表</a></li>
		<li role="presentation"><a href="personType_addInput.do">添加读者类型</a></li>
	</ul>
<br/><br/><br/>
	<div class="row">
		<div class="col-sm-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<span><small>修改读者类型</small></span>
					</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal center" action="personType_update.do"
						method="post">
						<input type="hidden" name="id" value="${id }" />
						<div class="form-group">
							<label for="name" class="col-sm-4 control-label"> 读者类型:</label>
							<div class="col-sm-6">
								<input name="name" type="text" value="${name }"
									class="form-control" id="name" placeholder="读者类型名称">
							</div>
						</div>
						<div class="form-group">
							<label for="date" class="col-sm-4 control-label">
								每本书可借阅时间(天):</label>
							<div class="col-sm-6">
								<input name="date" type="number" value="${date }"
									class="form-control" id="date" placeholder="可借阅天数">
							</div>
						</div>
						<div class="form-group">
							<label for="maxNo" class="col-sm-4 control-label"> 可借阅最大数量(本):</label>
							<div class="col-sm-6">
								<input name="maxNo" type="number" value="${maxNo }"
									class="form-control" id="maxNo" placeholder="最大借阅数">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-7">
								<button type="submit" class="btn btn-default">确认修改</button>
							</div>
						</div>
					</form>
				</div>
			</div>
</body>
</html>