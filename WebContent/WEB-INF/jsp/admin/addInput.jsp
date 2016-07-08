<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加管理员</title>
</head>
<body>
<ul class="nav nav-tabs">
  <li role="presentation" ><a href="admin_list.do">管理员列表</a></li>
  <li role="presentation" class="active"><a href="admin_addInput.do">添加管理员</a></li>
</ul>
<br/><br/><br/>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<span><small>添加管理员</small></span>
					</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal center" action=admin_add.do>
						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-9">
								<input name="username" type="text" value="${username }"
									class="form-control" id="username" placeholder="请输入用户名">
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-sm-2 control-label">图书名</label>
							<div class="col-sm-9">
								<input name="password" type="password" value="${password }"
									class="form-control" id="password" placeholder="输入用户密码">
							</div>
						</div>
						<div class="form-group">
							<label for="relname" class="col-sm-2 control-label">真实姓名</label>
							<div class="col-sm-9">
								<input name="relname" type="text" value="${relname }"
									class="form-control" id="relname" placeholder="请输入真实姓名">
							</div>
						</div>
						<div class="form-group">
							<label for="address" class="col-sm-2 control-label">联系地址</label>
							<div class="col-sm-9">
								<input name="address" type="text" value="${address }"
									class="form-control" id="address" placeholder="请输入联系地址">
							</div>
						</div>
						<div class="form-group">
							<label for="tel" class="col-sm-2 control-label">联系电话</label>
							<div class="col-sm-9">
								<input name="tel" type="number" value="${tel }"
									class="form-control" id="price" placeholder="请输入联系电话">
							</div>
						</div>
						<div class="form-group">
							<label for="status" class="col-sm-2 control-label">权限级别</label>
							<div class="col-sm-9">
								<select name="status" class="form-control">
									<option value="0">所有权限</option>
									<option value="1">入库权限</option>
									<option value="2">借阅管理权限</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="tid" class="col-sm-2 control-label">图书类型</label>
							<div class="col-sm-9">
								<select name="tid" class="form-control">
									<option value="0">请选择相应的用户身份</option>
									<s:iterator value="#ts">
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
						<div class="row">
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-2">
									<button type="submit" class="btn btn-success">确认添加</button>
								</div>
								<div class="col-sm-offset-1 col-sm-2">
									<button type="reset" class="btn btn-info">重置</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>