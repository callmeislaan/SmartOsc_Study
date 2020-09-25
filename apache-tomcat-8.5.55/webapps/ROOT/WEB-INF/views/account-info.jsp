<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 6/4/2020
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account Information</title>
</head>
<body>
    <table>
        <tr>
            <td>name ${account.name}</td>
        </tr>
        <tr>
            <td>name ${account.accountInfo.fullName}</td>
        </tr>
        <tr>
            <td>name ${account.accountInfo.address}</td>
        </tr>
        <tr>
            <td>name ${account.accountInfo.gender}</td>
        </tr>
        <tr>
            <td>name ${account.accountInfo.email}</td>
        </tr>
        <tr>
            <td>name ${account.accountInfo.phone}</td>
        </tr>
    </table>
</body>
</html>
