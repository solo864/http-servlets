<%@ page import="service.FlightService" %>
<%@ page import="dto.FlightDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: iamus
  Date: 24.06.2022
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flights</title>
</head>
<body>
<h1>List of flights</h1>

<ul>
<%

%>
    <p>LIST SIZE ${sessionScope.flights.size()}</p>
    <p>FLIGHT LIST: ${sessionScope.flights}</p>
    <p>FLIGHT MAP: ${requestScope.flightsMap}</p>
    <p>COOKIE: ${cookie["JSESSIONID"].value}</p>
    <p>HEADER: ${header["cookie"]}</p>
    <p>param id: ${param.id}</p>
    <p>param size: ${param.size}</p>

</ul>
</body>
</html>
