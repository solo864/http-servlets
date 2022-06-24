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
    List<FlightDto> flightDto = FlightService.getInstance().findAll();
    for (FlightDto dto : flightDto) {
        out.write("<li>%s</li>".formatted(dto.getDescription()));
    }
%>
</ul>
</body>
</html>
