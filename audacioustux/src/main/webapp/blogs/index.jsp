<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page import="com.audacioustux.model.Accounts" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blogs - AudaciousTux</title>
    <link rel="stylesheet" href="/css/index.css" />
  </head>

  <body>
    <%@include file="../WEB-INF/components/page-header.jsp" %>
    <c:forEach var="blog" items="${blogs}"> <a href="/blog/${blog.getId()}">${blog.getTitle()}</a> <br /> </c:forEach>

    <c:if test="${Accounts.is_superuser(account)}">
      <a href="/blogs/new">Write a new blog</a>
    </c:if>
    <script src="//unpkg.com/alpinejs" defer></script>
  </body>
</html>
