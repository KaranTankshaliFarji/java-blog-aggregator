<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp" %>
<body>
<table class="table table-bordered table-hover table-striped">
<thead>
	<tr>
	<th>user name</th>
	<th>operations</th>
	</tr>
</thead>
<tbody>
	<c:forEach items = "${users}" var="user">
	<tr>
		<td>
		<a href="/users/${user.id}.html">
			<c:out value="${user.name}"/>
		</a>
		</td>
		<td>
		<a href="/users/remove/${user.id}.html" class="btn btn-danger">Remove
		
		</a>
		</td>
	</tr>
	</c:forEach>
</tbody>
</table>
</body>