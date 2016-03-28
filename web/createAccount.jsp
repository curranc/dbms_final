<%@ page import="com.daoimpl.PersonDaoImpl" %>
<%@ page import="com.entities.Person" %>
<%@ page import="com.util.privateLib" %><%--
  Created by IntelliJ IDEA.
  User: Christian
  Date: 11/27/2015
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account Creation</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String confirmPassword = request.getParameter("confirmPassword");

    PersonDaoImpl pdi = new PersonDaoImpl();
    privateLib.writeString(username + " " + password + " " + confirmPassword);
    if ((username != null && password != null)) {

        Person person = new Person(username, password);
        if(pdi.selectByUsername(username) == null) {
            pdi.insert(person);
            if (password.equals(confirmPassword)) {
                response.sendRedirect("createAccountConfirm.jsp");

            }
            else {
                response.sendRedirect("error.jsp");
            }
        }

    }




%>
</body>
</html>
