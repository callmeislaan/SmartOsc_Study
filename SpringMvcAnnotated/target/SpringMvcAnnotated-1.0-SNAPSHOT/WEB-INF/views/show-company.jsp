<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 6/11/2020
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show company</title>
</head>
<body>
<h1>Company</h1>
<table>
    <tr>
        <td>id: </td>
        <td>${company.id}</td>
    </tr>
    <tr>
        <td>name: </td>
        <td>${company.name}</td>
    </tr>
    <tr>
        <td>dob: </td>
        <td><spring:bind path="company.dob">
            ${status.value}
        </spring:bind></td>
    </tr>
</table>
</body>
</html>
