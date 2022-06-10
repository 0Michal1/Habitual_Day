<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 26.05.2022
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Habits List</title>
</head>
<body>
<table border="2">
    <thead>
    <th>Name</th>
    <th>Description</th>
    <th>Type</th>
    <th>Categories</th>
    <th>Popularity</th>
    <th>Action</th>
    </thead>
    <tbody>
    <c:forEach items="${habits}" var="habit">
        <tr>
            <td><c:out value="${habit.name}"/></td>
            <td><c:out value="${habit.description}"/></td>
            <td><c:out value="${habit.type.name}"/></td>
            <td>
        <c:forEach items="${habit.categories}" var="category">
                <c:out value="${category.name}, "/>
        </c:forEach>
            </td>

            <td><c:out value="${habit.userCounter}"/></td>
            <td>
                <a href="<c:out value="/myHabit/create/${habit.id}"/>">Create My Habit</a>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<c:out value="/habitualday"/>">Homepage</a>
</body>
</html>
