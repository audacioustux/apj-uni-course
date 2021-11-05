<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>JSP & JSTL</title>
  </head>
  <body>
    <form action="/show.jsp" method="get" accept-charset="utf-8">
      <label for="firstname">First Name:</label>
      <input id="firstname" type="text" name="firstname" /><br />

      <label for="lastname">Last Name:</label>
      <input id="lastname" type="text" name="lastname" /><br />

      <fieldset>
        <legend>Gender:</legend>
        <input type="radio" id="male" name="gender" value="male" />
        <label for="male">Male</label>
        <input type="radio" id="female" name="gender" value="female" />
        <label for="female">Female</label><br />
      </fieldset>

      <label for="dob">Date of Birth:</label>
      <input type="date" name="dob" id="dob" /><br />

      <label for="lang">Choose Preferred Language:</label>
      <select name="lang" id="lang">
        <option value="en_US">English</option>
        <option value="bn_BN">Bangla</option>
      </select>
      <button type="submit">Submit</button>
    </form>
  </body>
</html>
