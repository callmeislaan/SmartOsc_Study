<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 6/15/2020
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>home</title>
</head>
<body>
<h1>Home</h1>
<form:form modelAttribute="person" method="post" action="/add-person">
    <table>
        <tr>
            <td>First name</td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td>Last name</td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><form:input path="age"/></td>
        </tr>
        <tr>
            <td>Salary</td>
            <td><form:input path="salary"/></td>
        </tr>
        <tr>
            <td>Date of birth</td>
            <td><form:input path="dob" type="date"/></td>
        </tr>
        <tr>
            <td>Status</td>
            <td>
                <form:select path="status" items="${status.}"/>
            </td>
        </tr>
        <tr>
            <td>
                <button type="submit">Save</button>
            </td>
            <td>
                <button type="reset">Reset</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
