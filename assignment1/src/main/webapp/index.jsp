<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.domain.User,java.util.*" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>JSTL Core</title>
</head>
<body>

	<h1>JSTL Core Tag</h1>

	<c:set var="counter" value="10"/>

	The value is: <c:out value="${counter}"/>

	<br>

	The value is: ${counter}

	<br>

	<%
		List<User> users = new ArrayList<>();
		users.add(new User(1, "Rahim", "rahim@Student.aiub.edu", false));
		users.add(new User(2, "Jobbar", "jobbar@Student.aiub.edu", true));
		users.add(new User(3, "Rafiq", "rafiq@Student.aiub.edu", false));

		pageContext.setAttribute("allUsers", users);
	%>

	<hr>
	<br>

	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Is Vip</th>
				<th>Remarks</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${allUsers}">
			<tr>
				<td>${user.getId()}</td>
				<td>${user.getName()}</td>
				<td>${user.etEmail()}</td>
				<td>${user.getIsVip()}</td> 
				<td>
					<c:if test="${ user.getIsVip()}">
						He can avail 30% discount
					</c:if>

					<c:if test="${not user.getIsVip()}">
						He can avail 5% discount
					</c:if>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>


	<br>

	<%
		String[] fruits = {"apple", "mango", "banana"};
		pageContext.setAttribute("allFruits", fruits);
	%>


	<hr>

	<ul>
		<c:forEach var="fruit" items="${allFruits}">
			<li>${fruit}</li>	
		</c:forEach>
	</ul>
</body>
</html>
