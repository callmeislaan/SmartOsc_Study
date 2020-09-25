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
<h1>Login</h1>
<table>
    <form action="/login" method="post">
        <label>
            <input type="text" name="name">
        </label>
        <label>
            <input type="text" name="password">
        </label>
        <button type="submit">submit</button>
    </form>
</table>
</body>
</html>
