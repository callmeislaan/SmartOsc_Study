<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 6/4/2020
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form:form method="post" action="/register" modelAttribute="person">
    Name: <form:input path="name"/>
    <input type="submit" value="register"/>
</form:form>
</body>
</html>
