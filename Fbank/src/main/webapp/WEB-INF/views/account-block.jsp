<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 5/28/2020
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="label.blocked"/> </title>
</head>
<body>
<h1><spring:message code="label.blocked"/></h1>
<div><spring:message code="label.time_remaining"/> : ${remainingTime}</div>
</body>
</html>
