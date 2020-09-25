<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 6/3/2020
  Time: 6:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>

<form action="/getPerson" method="get">
    <div>
        <label>ID:
            <input type="text" name="id"/>
        </label>
    </div>
    <input type="submit" value="submit"/>
</form>

<form action="/register" method="get">
    <input type="submit" value="go register">
</form>

</body>
</html>
