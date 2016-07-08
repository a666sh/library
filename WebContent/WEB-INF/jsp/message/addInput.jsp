<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>意见建议</title>
</head>
<body>
<div class="row">
<div class="col-sm-10">
<form id="formData" class="form-horizontal" action="message_add.do" method="post">
  <div class="form-group">
    <label for="title" class="col-sm-2 control-label">留言标题</label>
    <div class="col-sm-5">
      <input type="text" name="title" class="form-control" id="title" placeholder="请输入您的留言标题">
    </div>
  </div>
  <div class="form-group">
    <label for="content" class="col-sm-2 control-label">留言内容</label>
    <div class="col-sm-10">
  	<textarea class="form-control" name="content" id="content" name="content" rows="5" placeholder="请输入您的留言内容"></textarea>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-info" id="gogogo">提交建议</button>
    </div>
  </div>
</form>
</div>
</div>
</body>
</html>