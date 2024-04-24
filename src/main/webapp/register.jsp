<%--
  Created by IntelliJ IDEA.
  User: Alumno Tarde
  Date: 23/04/2024
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="register" method="post">
    <input type="text" placeholder="Username" name="username" required>
    <input type="email" placeholder="Email" name="email" required>
    <input type="password" placeholder="Password" name="password" required>
    <input type="password" placeholder="Repeat the Password" name="repassword" required>
    <input type="submit" value="Register">
</form>
</body>
</html>
