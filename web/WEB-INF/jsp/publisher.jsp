<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>LIST OF PUBLISHERS</h1>
<c:forEach var="publishers" items="${requestScope.publishers}">
    <li>
        <a href="${pageContext.request.contextPath}/books?publisherId=${publishers.id}"> ${publishers.name} </a>
    </li>
</c:forEach>
</body>
</html>