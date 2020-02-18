<%@ include file="common/header.jspf" %>
<%@ include file="common/navbar.jspf" %>

	<div class="container">
		<form:form  method="post" commandName="todo">
			<form:hidden path="id"/>
			<form:hidden path="user"/>
			<fieldset class="form-group">
				<form:label path="desc">Description</form:label>
				<form:input path="desc" type="text" class="form-control" required="required"/>
				<form:errors path="desc" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="targ_date">target Date</form:label>
				<form:input path="targ_date" type="text" class="form-control" required="required"/>
				<form:errors path="targ_date" cssClass="text-warning" />
			</fieldset>
			<button type="submit" class="btn btn-success">Submit</button>
		</form:form>
	</div>
	<%@ include file="common/footer.jspf" %>

	