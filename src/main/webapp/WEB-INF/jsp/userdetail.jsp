<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp" %>
<h1>${user.name}</h1>
<br>
<h1>${user.id}</h1>
<br>
<c:forEach items="${user.blogs}" var="blog">
	<h1>${blog.name}</h1>
	<p>${blog.url}</p>
	
	<table class="table-bordered table-hover table-striped" >
	<thead style="margin-left:100px">
		<tr>
			<th>Title</th>
			<th>Link</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${blog.items}" var="item">
		<tr>
			<td>${item.title}</td>
			<td>${item.link}</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	
</c:forEach>
