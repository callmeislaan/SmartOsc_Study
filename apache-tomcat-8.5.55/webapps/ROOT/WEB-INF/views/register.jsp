<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 6/4/2020
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>register</h1>
<table>
    <form:form modelAttribute="account" action="register" method="post">
        <tr>
            <td>name</td>
            <td>
                <from:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>password</td>
            <td>
                <from:input path="password"/>
            </td>
        </tr>
        <tr>
            <td>full name</td>
            <td>
                <from:input path="accountInfo.fullName"/>
            </td>
        </tr>
        <tr>
            <td>gender</td>
            <td>
                <from:select path="accountInfo.gender">

                </from:select>
            </td>
        </tr>
        <tr>
            <td>address</td>
            <td>
                <from:input path="accountInfo.address"/>
            </td>
        </tr>
        <tr>
            <td>email</td>
            <td>
                <from:input path="accountInfo.email"/>
            </td>
        </tr>
        <tr>
            <td>phone</td>
            <td>
                <from:input path="accountInfo.phone"/>
            </td>
        </tr>
        <tr>
            <td>introduce</td>
            <td>
                <from:input path="accountInfo.introduce"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="register"/>
            </td>
        </tr>
    </form:form>
</table>
</body>
</html>
