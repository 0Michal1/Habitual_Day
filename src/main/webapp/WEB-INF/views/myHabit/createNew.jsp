<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 11.06.2022
  Time: 09:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/myHabit/create" method="post" modelAttribute="createMyHabitModel">
    <table border="2">
        <thead>
        <th>Nagłówek</th>
        <th>Wartość</th>
        </thead>
        <tbody>
        <tr>
            <td>Habit Name</td>
            <td><form:select path="habitId" itemValue="id" itemLabel="name"
                items="${habitsList}"/></td>
        </tr>
        <tr>
            <td>Your Resolution</td>
            <td><form:input path="resolution"/>
                <form:errors path="resolution"/></td>
        </tr>
        </tbody>
    </table>
    <input type="submit"/>
</form:form>
</body>
</html>
