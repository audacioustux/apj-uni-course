<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page import="com.audacioustux.model.Accounts" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>AudaciousTux - Tanjim Hossain</title>
    <link rel="stylesheet" href="/css/index.css" />
  </head>

    <c:forEach var="account" items="${Accounts.getAll()}">
    ${account.getUsername()} ${account.getEmail()} <a
        href="/accounts/delete?account_id=${account.getId()}">delete</a> <br /> </c:forEach>


    <%@include file="WEB-INF/components/page-header.jsp" %>
    <script src="//unpkg.com/alpinejs" defer></script>
  </body>
</html>
