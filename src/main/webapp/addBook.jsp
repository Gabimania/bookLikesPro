<%--
  Created by IntelliJ IDEA.
  User: gabri
  Date: 07/05/2024
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="addBook" enctype="multipart/form-data">
    <input type="text" name="title" placeholder="Title">
    <input type="text" name="description" placeholder="Description">
    <input type="text" name="author" placeholder="Author">
    <input type="file" name="book_image" accept="image/*">
    <input type="submit" value="Add">
</form>
</body>
</html>
