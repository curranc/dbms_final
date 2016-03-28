<%@ page import="com.entities.Person" %>
<%@ page import="com.daoimpl.PersonDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: Christian
  Date: 11/28/2015
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Processing...</title>
</head>
<body>
    <%
        PersonDaoImpl pdi = new PersonDaoImpl();
        double value = Double.parseDouble(request.getParameter("value"));
        Person person = pdi.selectByUsername(session.getAttribute("username").toString());
        pdi.depositBalance(person, value);
        response.sendRedirect("homepage.jsp");
    %>
</body>
</html>
