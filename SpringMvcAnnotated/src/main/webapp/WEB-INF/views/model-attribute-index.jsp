<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 6/7/2020
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Model attribute index</title>
</head>
<body>
<form:form modelAttribute="employee" action="/model-attribute/employee-info" method="post">
    ID: <form:input path="id"/><br/>
    Name: <form:input path="name"/><br/>
    Contact Number: <form:input path="contactNumber"/><br/>
    <input type="submit" value="show information"/>
</form:form>
</body>
</html>
