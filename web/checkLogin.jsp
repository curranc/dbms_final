<%@ page import="com.daoimpl.PersonDaoImpl" %>
<%@ page import="com.entities.Person" %>


<%--
  Created by IntelliJ IDEA.
  User: Christian
  Date: 11/23/2015
  Time: 12:08 PM
  To change this template use File | Settings | File Templates.

  This page is the user's account. From here, they can:
  Delete the account.
  View or modify their balance.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Checking Login...</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    PersonDaoImpl pdi = new PersonDaoImpl();
    Person person = pdi.selectByUsername(username);

    if(username != null){
        if(password.equals(person.getPassword())){
            session.setAttribute("username", username);
            response.sendRedirect("homepage.jsp");
        }
    }
    else{
        response.sendRedirect("error2.jsp");
    }
%>
</body>
</html>