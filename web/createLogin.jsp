<%--
  Created by IntelliJ IDEA.
  User: Christian
  Date: 11/27/2015
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create An Account</title>
</head>
<body>
<h1>Create an Account</h1>
    <h2></h2>
    <form action="createAccount.jsp" method="post">
        <br/>Username        :<input type="text" name="username">
        <br/>Password        :<input type="password" name="password">
        <br/>Confirm Password:<input type="password" name="confirmPassword">
        <br/><input type="submit" value="Submit">

    </form>


</body>
</html>
