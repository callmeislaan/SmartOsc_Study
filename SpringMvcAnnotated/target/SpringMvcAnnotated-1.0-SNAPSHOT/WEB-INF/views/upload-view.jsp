<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 6/5/2020
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<form action="multipart" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" value="up load"/>
</form>
</body>
</html>
