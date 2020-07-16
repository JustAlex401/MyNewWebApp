<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/19/2020
  Time: 7:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h1>Login</h1>
<hr>
<form method="post" action="<c:url value='/login'/>">
    <input type="text" name="login">
    <input type="text" name="password">
    <input type="submit" name="OK" value="OK">
</form>
</body>
</html>
