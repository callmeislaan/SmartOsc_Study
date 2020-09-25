<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 6/8/2020
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Request body index</title>
</head>
<body>
<h1>Request body</h1>
<form action="/request-body/plus" method="post">
    <input type="text" name="id"/>
    <input type="text" name="name"/>
    <input type="text" name="contactNumber"/>
    <input type="submit" value="plus"/>
</form>
</body>
</html>
