<%--
  Created by IntelliJ IDEA.
  User: iamus
  Date: 24.06.2022
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>LIST OF PUBLISHERS</h1>
<ul>
    <p> Publishers size: ${requestScope.publishers} </p>
    <p>Publishers list${requestScope.publishers}</p>
    <p> Publishers map ${sessionScope.publishersMap}</p>
    <p>${empty sessionScope.publishersMap}</p>
    <p>${header["cookie"]}</p>
    <p>JSESSIONID ${cookie["JSESSIONID"].value}</p>
</ul>
</body>
</html>
