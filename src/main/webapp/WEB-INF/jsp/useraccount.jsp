
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp" %>
<head>
<script type="text/javascript" src="/js/try.js"></script>
</head>
<h1>${user.name}</h1>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  New Blog
</button>

<!-- Modal -->
<form:form commandName="blog" cssClass="form-horizontal">
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Add Blog</h4>
      </div>
      <div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label"> Name: </label>
						<div class="col-sm-10">
							<form:input path="name" cssClass="form-control" />
							<form:errors path="name"/>
						</div>
					</div>
					<div class="form-group">
						<label for="url" class="col-sm-2 control-label"> URL: </label>
						<div class="col-sm-10">
							<form:input path="url" cssClass="form-control" />
							<form:errors path="url"/>
						</div>
					</div>
				</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" value="Save" class="btn btn-primary" />
        
      </div>
    </div>
  </div>
</div>
</form:form>
<br/>

<br/>



<div>

  <!-- Nav tabs -->
	<ul class="nav nav-tabs" role="tablist">
		<c:forEach items="${user.blogs}" var="blog">
			<li role="presentation"><a href="#blog_${blog.id}"
				aria-controls="home" role="tab" data-toggle="tab">${blog.name}</a></li>
		</c:forEach>
	</ul>

	<!-- Tab panes -->
	<div class="tab-content">
		<c:forEach items="${user.blogs}" var="blog">
			<div role="tabpanel" class="tab-pane" id="blog_${blog.id}">
				<h1>${blog.name}</h1>
				<p>${blog.url}</p>
				<a href="/blog/remove/${blog.id}.html" class="btn btn-danger triggerRemove">Remove</a>
				<br/>
				<table class="table table-bordered table-hover table-striped">
					<thead style="margin-left: 100px">
						<tr>
							<th>Published date</th>
							<th>Title</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${blog.items}" var="item">
							<tr>
								<td><c:out value="${item.publishedDate}" /></td>
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

			</div>

		</c:forEach>
	</div>

</div>

<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove Blog</h4>
      </div>
      <div class="modal-body">
        Really Remove?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>