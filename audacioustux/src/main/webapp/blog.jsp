<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <h1>${blog.getTitle()}</h1>
    <br />
    <p>${blog.getBody()}</p>
    <br />

    <c:if test="${account != null}">
      Write a new Comment:
      <form action="/comments/new" method="POST" accept-charset="utf-8">
        <input type="text" value="${blog.getId()}" name="blog_id" id="blog_id" hidden />
        <input type="text" name="body" id="body" />
        <button type="submit">Submit</button>
      </form>
    </c:if>
    <br />
    Comments: <br />
    <c:forEach var="comment" items="${comments}">${comment.getBody()} by ${comment.getAccount().getUsername()}<br /> </c:forEach>
    <script src="//unpkg.com/alpinejs" defer></script>
  </body>
</html>
