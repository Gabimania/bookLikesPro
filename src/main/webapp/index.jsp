<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book likes Pro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h1><%= "Book likes pro" %>
</h1>
<br/>
<div class="container">
    <a href="login.jsp"><button> Login</button></a>
    <a href="register.jsp"><button> Register</button></a>
</div>
<div class="card" style="width: 18rem;">
    <c:forEach var="book" items="${bookList}" >
        <img src="assets/img/${book.getBook_image()}" class="card-img-top" alt="book-image">
        <div class="card-body">
            <h5 class="card-title"><c:out value="${book.getTitle()}"/></h5>
            <p class="card-text"><c:out value="${book.getDescription()}"/></p>
            <a href="#" class="btn btn-primary">Go somewhere</a>
        </div>
    </c:forEach>
</div>

</body>
</html>