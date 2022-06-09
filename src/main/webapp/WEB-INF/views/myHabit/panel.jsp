<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 09.06.2022
  Time: 11:44
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
<table border="2">
    <thead>
    <th>Name</th>
    <th>Description</th>
    <th>Type</th>
    <th>Categories</th>
    <th>Resolution</th>
    <th>Actual Streak</th>
    <th>Max Streak</th>
    <th>Action</th>
    </thead>
    <tbody>
        <tr>
            <td><c:out value="${myHabit.name}"/></td>
            <td><c:out value="${myHabit.description}"/></td>
            <td><c:out value="${myHabit.typeName}"/></td>
            <td>
                <c:forEach items="${myHabit.categoriesNames}" var="categoryName">
                    <c:out value="${categoryName}, "/>
                </c:forEach>
            </td>
            <td><c:out value="${myHabit.resolution}"/></td>
            <td><c:out value="${myHabit.actualStreak}"/></td>
            <td><c:out value="${myHabit.maxStreak}"/></td>
            <td>
                <a href="<c:out value="/myHabit/streak/${myHabit.myHabitId}"/>">Streak</a>
            </td>

        </tr>
    </tbody>
</table>
<a href="<c:out value="/habitualday"/>">Homepage</a>
</body>
</html>
