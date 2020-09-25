<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 6/2/2020
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>--%>
<html>
<head>
    <title>Input</title>
</head>
<body>
<h1>input</h1>
<h1><spring:message code="name"/> </h1>
<a href="?lang=en">English</a>
<a href="?lang=vi">Viet Nam</a>
<form action="show-input" method="post">
    <label>id
        <input type="text" name="id"/>
    </label>
    <label>name
        <input type="text" name="name"/>
    </label>
    <input type="submit" value="submit"/>
</form>

</body>
</html>
