
<%@ include file="common/header.jspf" %>
<%@ include file="common/navbar.jspf" %>
<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>  Item</th>
					<th>  Target Date</th>
					<th>  Status</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${todos}" var="todo">
				<tr>
						<td>  ${todo.desc}</td>
						<td><fmt:formatDate pattern="MM/dd/yyy"  value="${todo.targ_date}"/>
						 ${todo.done}</td>
							<td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
						<td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
				</tr>
				</c:forEach>
			</tbody>

		</table>

<div>
<a class="btn btn-success" href="/add-todo">ADD</a>
</div>
</div>
<%@ include file="common/footer.jspf" %>
