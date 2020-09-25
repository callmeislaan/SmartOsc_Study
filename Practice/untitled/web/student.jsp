<%@ page import="com.practice.entity.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 9/24/2020
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
<h1>Student list</h1>
<table>
<%List<Student> students = (List<Student>) request.getAttribute("students");
    for (int i=0; i<students.size(); i++) {
%>
<tr>
    <td><%System.out.println(students.get(i).getId());%></td>
</tr>
<%
    }%>

</table>
</body>
</html>