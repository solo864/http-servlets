<%--
  Created by IntelliJ IDEA.
  User: iamus
  Date: 24.06.2022
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/registration" method="post">
    USERNAME
    <label for="username">
        <input type="text" name="username" id="username">
    </label>
    <br>
    PASSWORD
    <label for="pw">
        <input type="password" name="password" id="pw">
    </label>
    <br>
    BIRTHDAY
    <label for="birthDay">
        <input type="date" name="birthday" id="birthDay">
    </label>
    <br>
    ROLE
    <select name="role" id="role">
        <option value="ADMIN">ADMIN</option>
        <option value="USER">USER</option>
    </select>
    <br>
    <input type="radio" name="gender" value="male"> MALE
    <input type="radio" name="gender" value="female"> FEMALE

    <button type="submit"> SEND </button>
</form>
</body>
</html>
