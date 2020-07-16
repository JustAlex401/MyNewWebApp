<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/19/2020
  Time: 4:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello User</title>
</head>
<body>
<%--<c:forEach var="user" items="${dao}">--%>
<%--    <ul>--%>
<%--        <li>--%>
<%--            <c:out value="${user.id}"></c:out>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <c:out value="${user.login}"></c:out>--%>
<%--        </li>--%>
<%--    </ul>--%>
<%--</c:forEach>--%>
    <form method="get" action="<c:url value='/registration'/> ">
        <input type="submit" name="registration" value="registration">
    </form>
    <form method="get" action="<c:url value='/login'/> ">
        <input type="submit" name="login" value="login">
    </form>

</body>
</html>
