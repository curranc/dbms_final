<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>OOPFinal</title>
</head>
<body>
<h1>Account Login</h1>
    <%
        session.setAttribute("username", null);
    %>
    <h2>Please Login</h2>
    <form action="checkLogin.jsp" method="post">
        <br/>Username:<input type="text" name="username">
        <br/>Password:<input type="password" name="password">
        <br/><input type="submit" value="Submit">

    </form>
    <form action="createLogin.jsp" method = post>
        <br/><input type="submit" value = "Signup">
    </form>

</body>
</html>