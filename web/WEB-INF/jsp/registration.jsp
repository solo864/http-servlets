<%--
  Created by IntelliJ IDEA.
  User: iamus
  Date: 26.06.2022
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sign up  </title>
</head>
<body>

<form action="/registration" method="post" enctype="multipart/form-data">
    NAME
    <label for="name">
        <input type="text" name="name" id="name">
    </label><br>
    EMAIL
    <label for="email">
        <input type="text" name="email" id="email">
    </label><br>
    PASSWORD
    <label for="pw">
        <input type="password" name="password" id="pw">
    </label><br>
    BIRTHDAY
    <label for="birthday">
        <input type="date" name="birthday" id="birthday">
    </label><br>

    <button type="submit">SEND</button>


</form>


</body>
</html>
