<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 6/7/2020
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Request param index</title>
</head>
<body>
<form action="/request-param/employee-info" method="post">
    <input type="text" name="name"/>
    <input type="submit" value="submit"/>
</form>
</body>
</html>
