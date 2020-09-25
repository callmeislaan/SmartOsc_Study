<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 6/15/2020
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Person info</title>
</head>
<body>
<h1>Person info</h1>
<table>
    <tr>
        <td>${person.id}</td>
        <td>${person.firstName}</td>
        <td>${person.lastName}</td>
        <td>${person.age}</td>
        <td>${person.salary}</td>
        <td>
            <fmt:formatDate pattern="dd/MM/yy" value="${person.dob}" />
<%--            ${person.dob}--%>
        </td>
        <td>${person.status}</td>
    </tr>
</table>
</body>
</html>
