<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 5/28/2020
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1><spring:message code="label.login"/> </h1>
<table>
    <form action="/login" method="post">
        <label><spring:message code="label.name"/>
            <input type="text" name="name">
        </label>
        <label><spring:message code="label.password"/>
            <input type="text" name="password">
        </label>
        <button type="submit"><spring:message code="label.login"/></button>
    </form>
</table>

<form action="/register" method="get">
    <input type="submit" value="register">
</form>

</body>
</html>
