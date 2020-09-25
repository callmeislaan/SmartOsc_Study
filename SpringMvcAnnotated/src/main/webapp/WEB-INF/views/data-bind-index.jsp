<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 6/8/2020
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Data bind index</title>
</head>
<body>
<%--<form action="/databind/getMode" method="post">--%>
<%--    <input type="text" name="mode"/>--%>
<%--&lt;%&ndash;    <input type="datetime-local" name="date"/>&ndash;%&gt;--%>
<%--    <input type="submit" value="get mode"/>--%>
<%--</form>--%>

<h1>input company</h1>

<form:form action="/databind/doBinder" method="post" modelAttribute="company">
    <table>
        <tr>
            <td>ID:</td>
            <td><form:input path="id"/></td>
            <td><form:errors path="id" cssStyle="color: red;"/> </td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name" cssStyle="color: red;"/> </td>
        </tr>
        <tr>
            <td>Dob:</td>
            <td><form:input path="dob" type="datetime-local"/></td>
            <td><form:errors path="dob" cssStyle="color: red;"/> </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="submit"/>
            </td>
        </tr>
    </table>

</form:form>

</body>
</html>
