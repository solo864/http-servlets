<%--
  Created by IntelliJ IDEA.
  User: iamus
  Date: 24.06.2022
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Title</title>
</head>
<body>
<form action="/registration" method="post">
  <label for="name"> Name:
    <input type="text" name="name" id="name">
  </label><br>
  <label for="birthDay"> Birth Day:
    <input type="date" name="birthDay" id="birthDay">
  </label><br>
  <label for="emailId"> Email:
    <input type="text" name="email" id="emailId">
  </label><br>
  <label for="passwordId"> Password:
    <input type="password" name="password" id="passwordId">
  </label><br>
  <select name="role" id="role">
    <c:forEach var="role" items="${requestScope.roles}">
      <option value="${role}">${role}</option>
    </c:forEach>
  </select><br>
  <c:forEach var="gender" items="${requestScope.genders}">
    <input type="radio" name="gender" value=${gender}> ${gender}
    <br>

  </c:forEach>
  <button type="submit">Send</button>


</form>

</body>
</html>
