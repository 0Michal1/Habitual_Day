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
<a href="<c:out value="/create-habit"/>">Create New Habit</a>
<a href="<c:out value="/login"/>">Login</a>
<a href="<c:out value="/register"/>">Register</a>
<a href="<c:out value="/myhabits"/>">My Habits</a>
<a href="<c:out value="/habits/list"/>">List of Habits</a>


</body>
</html>
