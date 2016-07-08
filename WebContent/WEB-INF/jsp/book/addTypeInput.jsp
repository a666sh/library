<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加图书类型</title>
</head>
<body>
<ul class="nav nav-tabs">
		<li role="presentation"><a href="book_listType.action">图书类型列表</a></li>
		<li role="presentation" class="active"><a href="book_addTypeInput.do">添加图书类型</a></li>
	</ul>
<br/>
		<div class="row">
		<div class="col-sm-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<span><small>添加图书类型</small></span>
					</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal center" action="book_addType.do" method="post">
						<div class="form-group">
							<label for="isbn" class="col-sm-3 control-label"> 图书类型:</label>
							<div class="col-sm-6">
								<input name="type" type="text" value="${type }"
									class="form-control" id="isbn" placeholder="图书类型名称">
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