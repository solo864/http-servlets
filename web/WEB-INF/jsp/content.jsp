<%--
  Created by IntelliJ IDEA.
  User: iamus
  Date: 23.06.2022
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp" %>
<div>
    <span>
        Content.Русский
    </span>
    <p>Size: ${sessionScope.publishers.size()}</p>
    <p>INFO: ${sessionScope.publishers}</p>
    <p>INFO: ${requestScope.flights}</p>
    <p>MAP: ${sessionScope.publishersMap}</p>
    <p>ID: ${sessionScope.publishers.get(1).id}</p>
    <p>PARAM: ${param.get("heyeveryone")}</p>
    <p>PARAM ${param.get("test")} HEEY</p>
    <p>JSESSION id: ${cookie["JSESSIONID"].value}, unique id</p>
    <p>HEADER : ${header["Cookie"]}</p>
    <p>Empty list: ${empty flights}</p>
</div>
<%@include file="footer.jsp" %>

</body>
</html>
