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
    <%@include file="../WEB-INF/components/page-header.jsp" %> ${blog.getTitle()} by ${blog.getAccount().getUsername()} <br />
    ${blog.getBody()}
    <script src="//unpkg.com/alpinejs" defer></script>
  </body>
</html>
