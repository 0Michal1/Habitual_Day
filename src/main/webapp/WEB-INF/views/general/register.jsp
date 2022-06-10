<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 10.06.2022
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form:form action="/register" method="post" modelAttribute="registerModel">
    <table border="2">
    <thead>
    <th>Nagłówek</th>
    <th>Wartość</th>
    </thead>
    <tbody>
    <tr>
    <td>Username</td>
    <td><form:input path="username"/>
    <form:errors path="username"/></td>

    </tr>
    <tr>
    <td>Email</td>
    <td><form:input path="email"/>
    <form:errors path="email"/></td>

    </tr>
    <tr>
    <td>Password</td>
    <td><form:input path="password"/>
    <form:errors path="password"/></td>

    </tr>
    </tbody>
    </table>
    <input type="submit"/>
</form:form>
</body>
</html>
