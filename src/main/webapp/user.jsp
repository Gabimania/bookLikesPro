<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book likes Pro</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" crossorigin="anonymous"/>
    <link rel="stylesheet" href="assets/css/user.css">
    <script src="assets/js/user.js"></script>
    <script src="assets/js/books.js"></script>
</head>
<body>
<h1>Welcome to your profile</h1>
<h2>Book likes pro</h2>

<div class="container-buttons">
    <a href="addBook.jsp"><button>Add Book</button></a>
    <a href="userBook"><button>User Books</button></a>
</div>

<input type="text" id="searchInput" placeholder="Search...">

<div id="bookContainer">
    <c:forEach var="book" items="${bookList}">
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">Title: <c:out value="${book.getTitle()}"/></h5>
                <img src="./assets/img/${book.getBook_image()}" class="card-img-top" alt="${book.getTitle()}">
                <p class="card-text">Description: <c:out value="${book.getDescription()}"/></p>
                <p class="card-author">Author: <c:out value="${book.getAuthor()}"/></p>
                <p class="card-text">Uploaded by: ${bookController.getUserById(book.getIdUser()).getUsername()}</p>
                <p id="likesManager${book.getIdbook()}">
                        ${book.getLikeCount()}
                    <c:set var="liked" value="false"/>
                    <c:forEach items="${favoriteBooks}" var="favorBook">
                        <c:if test="${favorBook.iduser == user.iduser && favorBook.idbook == book.idbook}">
                            <c:set var="liked" value="true"/>
                        </c:if>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${liked eq true}">
                            <i onclick="manageLikes(${book.idbook})" class="fa-solid fa-heart" style="color: red"></i>
                        </c:when>
                        <c:otherwise>
                            <i onclick="manageLikes(${book.idbook})" class="fa-solid fa-heart"></i>
                        </c:otherwise>
                    </c:choose>
                </p>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
