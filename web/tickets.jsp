<%@ page import="entity.TicketEntity" %>
<%@ page import="service.TicketService" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: iamus
  Date: 23.06.2022
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> ПРОДАННЫЕ БИЛЕТЫ </h1>
<ul>
<%
Long flightId = Long.valueOf(request.getParameter("flightId"));
List<TicketEntity> tickets = TicketService.getInstance().findAllByFlightId(flightId);
    for (TicketEntity ticket : tickets) {
        out.write(String.format("<li>%s</li>", ticket.getSeatNo()));
    }
%>
</ul>
</body>
</html>

