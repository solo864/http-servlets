<%--
  Created by IntelliJ IDEA.
  User: iamus
  Date: 24.06.2022
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>LIST OF BOOKS</h1>
<ul>
<c:forEach var="books" items="${requestScope.books}">
    <li>
            ${books}
    </li>
</c:forEach>
</ul>
</body>
</html>
