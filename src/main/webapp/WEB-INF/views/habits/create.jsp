<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 19.05.2022
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Habit</title>
</head>
<body>
<form:form action="/habits/create" method="post" modelAttribute="createHabitModel">
    <table border="2">
        <thead>
        <th>Nagłówek</th>
        <th>Wartość</th>
        </thead>
        <tbody>
        <tr>
            <td>Name</td>
            <td><form:input path="name"/>
                <form:errors path="name"/></td>

        </tr>
        <tr>
            <td>Description</td>
            <td><form:input path="description"/>
                <form:errors path="description"/></td>

        </tr>
        <tr>
            <td>Type</td>
            <td> <form:select path="type.id" itemValue="id" itemLabel="name"
                              items="${types}"/>
                <form:errors path="type"/></td>

        </tr>
        <tr>
            <td>Category</td>
            <td><form:select path="categories" itemValue="id" itemLabel="name" multiple="true"
                             items="${categories}"/>
                <form:errors path="categories"/></td>
        </tr>
        <tr>
            <td>Add Category</td>
            <td><form:input path="categoryName"/>
                <form:errors path="categoryName"/></td>

        </tr>
        </tbody>
    </table>
    <input type="submit"/>
</form:form>
</body>
</html>
