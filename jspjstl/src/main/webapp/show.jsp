<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>JSP & JSTL</title>
  </head>
  <body>
    <fmt:setLocale value="${param.lang}" />
    <fmt:bundle basename="message">
      <fmt:message key="label.greeting" />
      <br />
      <fmt:message key="label.firstname" />: ${param.firstname}
      <br />
      <fmt:message key="label.lastname" />: ${param.lastname}
      <br />
      <fmt:message key="label.gender" />: ${param.gender}
      <br />
      <fmt:message key="label.dob" />: ${param.dob}
      <br />
    </fmt:bundle>
  </body>
</html>
