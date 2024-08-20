<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>
    <link rel="stylesheet" href="assets/css/addBook.css">
</head>
<body>
<div class="container">
    <div class="home-button">
        <a href="user"><button>Home</button></a>
    </div>
    <h1>Add a New Book</h1>
    <form method="post" action="addBook" enctype="multipart/form-data">
        <input type="text" name="title" placeholder="Title" required>
        <input type="text" name="description" placeholder="Description" required>
        <input type="text" name="author" placeholder="Author" required>
        <input type="file" name="book_image" accept="image/*" required>
        <input type="submit" value="Add">
    </form>
</div>
</body>
</html>
