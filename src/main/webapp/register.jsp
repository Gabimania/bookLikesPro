<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="assets/css/register.css">
</head>
<body>
<div class="container">
    <form action="register" method="post">
        <h2>Register</h2>
        <input type="text" placeholder="Username" name="username" required>
        <input type="email" placeholder="Email" name="email" required>
        <input type="password" placeholder="Password" name="password" required>
        <input type="password" placeholder="Repeat the Password" name="repassword" required>
        <input type="submit" value="Register">
    </form>
</div>
</body>
</html>
