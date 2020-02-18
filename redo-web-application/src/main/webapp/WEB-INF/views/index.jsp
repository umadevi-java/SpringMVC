<%@ include file="common/header.jspf" %>
<%@ include file="common/navbar.jspf" %>
<form action="/login" method="post">
<h3 style="color:red">${errorMessage}</h3>
Name: <Input name="name" type="text">
Password:<Input name="password" type="password">
<button type="submit" value="submit">Submit</button>
</form>
<%@ include file="common/footer.jspf" %>