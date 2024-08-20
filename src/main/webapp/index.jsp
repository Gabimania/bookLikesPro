<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Likes Pro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="assets/css/index.css">
</head>
<body>
<div class="container text-center mt-5">
    <h1>Book Likes Pro</h1>
    <div class="btn-group mt-3">
        <a href="login.jsp" class="btn btn-outline-primary">Login</a>
        <a href="register.jsp" class="btn btn-outline-secondary">Register</a>
    </div>
</div>

<div class="container mt-5">
    <div class="row justify-content-center">
        <c:forEach var="book" items="${bookList}">
            <div class="col-md-4 mb-4">
                <div class="card h-100">
                    <img src="./assets/img/${book.getBook_image()}" class="card-img-top" alt="book-image">
                    <div class="card-body d-flex flex-column">
                        <h5 class="card-title"><c:out value="${book.getTitle()}"/></h5>
                        <p class="card-text flex-grow-1"><c:out value="${book.getDescription()}"/></p>
                        <a href="login.jsp" class="btn btn-primary mt-auto">Check this book</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
