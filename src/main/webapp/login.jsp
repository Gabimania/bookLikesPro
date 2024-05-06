<%--
  Created by IntelliJ IDEA.
  User: Alumno Tarde
  Date: 25/04/2024
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome to our web</h1>
<form method="post" action="login">
    <input type="email" placeholder="Email" name="email" required>
    <input type="password" placeholder="Password" name="password" required>
    <input type="submit" value="Sing in">
</form>
</body>
</html>
