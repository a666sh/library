<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发现错误</title>
</head>
<body>
<div class="panel panel-danger">
  <div class="panel-heading">
    <h3 class="panel-title">错误信息</h3>
  </div>
  <div class="panel-body">
    <p class="text-danger">${exception.message }</p>
    <a  id="backHis" href="#">请返回上一页</a>
  </div>
  <script type="text/javascript">
  		var a=document.getElementById("backHis");
  		a.onclick=toHistory;
  		function toHistory() {
  			window.history.back();
  		}
  </script>
</div>
</body>
</html>