<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>借书办理</title>
</head>
<body>
	<ul class="nav nav-tabs">
		<li role="presentation" class="active"><a href="reader_addReaderBookInput.do">借书办理</a></li>
		<li role="presentation"><a
			href="reader_receiveReaderBookInput.do">还书办理</a></li>
		<li role="presentation"><a
			href="reader_payInput.do">赔偿办理</a></li>
	</ul>
	<br />
	<br />
	<br />
	<div class="row">
		<div class="col-sm-6 col-md-offset-3">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">
						<span><small>借书办理</small></span>
					</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal center"
						action="reader_addReaderBookShow.do#addReaderBookShow"
						method="post">
						<div class="form-group">
							<label for="id" class="col-sm-4 control-label"> 请输入读者编号:</label>
							<div class="col-sm-6">
								<input name="id" type="number" "
										class="form-control"
									id="id" placeholder="读者编号">
							</div>
						</div>
						<div class="form-group">
							<label for="bid" class="col-sm-4 control-label"> 请输入图书编号:</label>
							<div class="col-sm-6">
								<input name="bid" type="number" class="form-control" id="bid"
									placeholder="图书编号">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-7">
								<button type="submit" class="btn btn-default">借书办理</button>
							</div>
						</div>
					</form>
				</div>
			</div>
</body>
</html>