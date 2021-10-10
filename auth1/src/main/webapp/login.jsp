<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Registration</title>
</head>
<body>

	<h1>Login Page</h1>

	<form action="login" method="post">
		<label for="loginId">Login Id:</label>
		<input type="text" name="loginId" id="loginId">
		<br><br>
		<label for="password">Password:</label>
		<input type="password" name="password" id="password">
		<br><br>
		<input type="submit" name="submit" value="Login">
	</form>
</body>
</html>
