<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/19/2020
  Time: 7:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello, User</title>
</head>
<body>
<h1>Hello, User</h1>

<form method="get" action="<c:url value='/'/> ">
    <input type="submit" name="Start menu" value="Start menu">
</form>

</body>
</html>
