<%@ include file="../layout/taglib.jsp" %>
<!-- <h1>Hello From Spring</h1> -->
<!-- <h2>I welcome you here</h2> -->
<h1>Latest News From Java World</h1>

				<table class="table table-bordered table-hover table-striped">
					<thead style="margin-left: 100px">
						<tr>
							<th>Published date</th>
							<th>Title</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${items}" var="item">
							<tr>
								<td><c:out value="${item.publishedDate}" />
								<br/>
								<c:out value="${item.blog.name}" />
								</td>
								<td>
								<strong>
								<a href="<c:out value="${item.link}" />" target="_blank">
								<c:out value="${item.title}" />
								</a>
								</strong>
								<br/>
								${item.description}
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

