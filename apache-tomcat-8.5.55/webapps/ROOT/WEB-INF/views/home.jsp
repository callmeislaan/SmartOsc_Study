<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 6/4/2020
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="label.home"/> </title>
</head>
<body>
<h1><sping:message code="label.home"/></h1>
<ul>
    <li><a href="?lang=vi">Vietnamese</a></li>
    <li><a href="?lang=en">English</a></li>
</ul>
</body>
</html>
