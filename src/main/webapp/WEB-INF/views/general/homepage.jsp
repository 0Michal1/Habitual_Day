<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 26.05.2022
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Habitual Day</title>
</head>
<body>
<a href="<c:out value="/register"/>">Register</a></br>
<a href="<c:out value="/login"/>">Login</a></br>
<a href="<c:out value="/habits/list"/>">List of Habits</a></br>
<a href="<c:out value="/habits/create"/>">Create New Habit</a></br>
<a href="<c:out value="/myHabit/create"/>">Create My New Habit</a></br>
<a href="<c:out value="/myHabit/list"/>">My Habits</a></br>
<a href="<c:out value="/logout"/>">Logout</a></br>
</body>
</html>
