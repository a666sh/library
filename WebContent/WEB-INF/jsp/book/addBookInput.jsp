<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书入库</title>
</head>
<body>
	<ul class="nav nav-tabs">
		<li role="presentation"><a href="book_listBook.action">图书列表</a></li>
		<li role="presentation" class="active"><a href="book_addBookInput.do">图书入库</a></li>
		<li role="presentation"><a href="book_listType.do">图书类型管理</a></li>
	</ul>
	<br />
	<div class="row">
		<div class="col-sm-7">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<span><small>图书入库</small></span>
					</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal center" action="book_addBook.do">
						<div class="form-group">
							<label for="isbn" class="col-sm-2 control-label">ISBN</label>
							<div class="col-sm-7">
								<input name="isbn" type="text" value="${isbn }"
									class="form-control" id="isbn" placeholder="ISBN">
							</div>
						</div>
						<div class="form-group">
							<label for="bookName" class="col-sm-2 control-label">图书名</label>
							<div class="col-sm-7">
								<input name="name" type="text" value="${name }"
									class="form-control" id="bookName" placeholder="图书名">
							</div>
						</div>
						<div class="form-group">
							<label for="author" class="col-sm-2 control-label">作者</label>
							<div class="col-sm-7">
								<input name="author" type="text" value="${author }"
									class="form-control" id="author" placeholder="作者">
							</div>
						</div>
						<div class="form-group">
							<label for="publisher" class="col-sm-2 control-label">出版社</label>
							<div class="col-sm-7">
								<input name="publisher" type="text" value="${publisher }"
									class="form-control" id="publisher" placeholder="出版社名">
							</div>
						</div>
						<div class="form-group">
							<label for="price" class="col-sm-2 control-label">价格</label>
							<div class="col-sm-7">
								<input name="price" type="float" value="${price }"
									class="form-control" id="price" placeholder="输入图书价格">
							</div>
						</div>
						<div class="form-group">
							<label for="tid" class="col-sm-2 control-label">图书类型</label>
							<div class="col-sm-7">
								<select name="tid" class="form-control">
									<option value="0">请选择相应的图书类型</option>
									<s:iterator value="#bts">
										<s:if test="id==booktype.id">
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
							<label for="bookNo" class="col-sm-2 control-label">图书数量</label>
							<div class="col-sm-7">
								<input name="bookNo" type="number" value="${bookNo }"
									class="form-control" id="bookNo" placeholder="图书数量">
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
		</div>
	</div>
</body>
</html>