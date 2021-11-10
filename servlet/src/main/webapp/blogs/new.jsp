<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Write New Blog - AudaciousTux</title>
    <link rel="stylesheet" href="/css/index.css" />
  </head>

  <body>
    <%@include file="../WEB-INF/components/page-header.jsp" %>
    <form action="./new" method="POST" accept-charset="utf-8">
      <input type="text" name="title" placeholder="title" required/><br />
      <textarea name="body" rows="8" cols="40" placeholder="body" required></textarea></br>
      <button type="submit">Publish</button>
    </form>

    <script src="//unpkg.com/alpinejs" defer></script>
  </body>
</html>
