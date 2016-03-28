<%@ page import="com.entities.Person" %>
<%@ page import="com.daoimpl.PersonDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: Christian
  Date: 11/27/2015
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bank Account</title>
</head>
<body>
    <%
        String username = session.getAttribute("username").toString();
        PersonDaoImpl pdi = new PersonDaoImpl();
        Person person = pdi.selectByUsername(username);
    %>
    <h1>Welcome, <%out.print(username);%>!</h1>
    <h2>You currently have $<%out.print(person.getBalance());%>. </h2>
    <form action="index.jsp" method="post">
        <br/><input type="submit" value="Logout">

    </form>
    <form action="depositBalance.jsp" method="post">
        <br/><input type="text" name="value">
        <br/><input type="submit" value="Deposit">
    </form>
    <form action="withdrawBalance.jsp" method="post">
        <br/><input type="text" name="value">
        <br/><input type="submit" value="Withdraw">
    </form>

</body>
</html>
