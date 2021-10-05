<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Registration</title>
</head>
<body>

	<h1>Registration Page</h1>

	<form action="registration" method="post">
		<label for="loginId">Login Id:</label>
		<input type="text" name="loginId" id="loginId">
		<br><br>
		<label for="password">Password:</label>
		<input type="password" name="password" id="password">
		<br><br>
		<input type="submit" name="submit" value="Register">
	</form>

	<!-- <c:if test="${fn:contains(message, 'success')}">
		<b>Registration Successful.</b>
	</c:if> -->

	<c:if test="${fn:contains(param.message, 'success')}">
		<b>Registration Successful With param.</b>
	</c:if>

</body>
</html>
