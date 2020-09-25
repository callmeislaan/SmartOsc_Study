<%@ page import="com.fintech.model.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fintech.model.Persons" %><%--
  Created by IntelliJ IDEA.
  User: phuoc
  Date: 6/1/2020
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<%--%>
<%--    List<Person> persons = (List<Person>) request.getAttribute("persons");--%>
<%--%>--%>
<html>
<head>
    <title>home</title>
</head>
<body>
<h1>Persons </h1>
<table>
    <p:forEach items="${persons}" var="person">
        <tr>
            <td>
                    ${person.id}
            </td>
            <td>
                    ${person.name}
            </td>
            <td>
                    ${person.dateOfBirth}
            </td>
        </tr>
    </p:forEach>

</table>

<form action="/makeError" method="post">
    <input type="submit" value="submit">
</form>
</body>
</html>
