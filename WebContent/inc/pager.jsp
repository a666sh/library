<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<pg:pager maxPageItems="15" items="${param.items }" export="curPage=pageNumber" url="${param.url }">
<c:forEach items="${param.params }" var="p">
	<pg:param name="${p }"/>
</c:forEach>
<pg:first>
<nav>
<ul class="pagination">
	<li><a href="${pageUrl }">首页</a></li>
</pg:first>
<pg:prev>
	<li><a href="${pageUrl }">上一页</a></li>
</pg:prev>
<pg:pages>

<c:if test="${curPage eq pageNumber }">
<li class="active"><a href="#">${pageNumber } <span class="sr-only">(current)</span></a></li>
</c:if>
<c:if test="${curPage ne pageNumber }">
	<li><a href="${pageUrl }">${pageNumber }</a></li>
</c:if>
</pg:pages>
<pg:next>
	<li><a href="${pageUrl }">下一页</a></li>
</pg:next>
<pg:last>
	<li><a href="${pageUrl }">尾页</a></li>
</pg:last>
<pg:last>
<li><span style="color:#000">共<strong>${param.items }</strong>记录,共<strong>${pageNumber }</strong>页,
</pg:last>
当前第<strong>${curPage }</strong>页</span></li>
</ul>
	</nav>
</pg:pager>