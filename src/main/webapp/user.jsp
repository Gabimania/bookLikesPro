<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book likes Pro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="assets/js/user.js"></script>
    <script src="assets/js/books.js"></script>
</head>
<body>
<h1>Welcome to your profile</h1>
<h2><%= "Book likes pro" %>
</h2>
<a href="addBook.jsp">Add Book</a>
<br/>
<input type="text" id="searchInput" placeholder="Search...">
<div id="bookContainer">
<div class="card" style="width: 18rem;">

    <c:forEach var="book" items="${bookList}" >
            <%-- <a href="idBook=${book.getIdbook()}"> --%>


        <img src="./assets/img/${book.getBook_image()}" class="card-img-top" alt="{$book.getTitle()}">
        <div class="card-body">
            <h5 class="card-title"><c:out value="${book.getTitle()}"/></h5>
            <p class="card-text"><c:out value="${book.getDescription()}"/></p>
            <p class="card-author"><c:out value="${book.getAuthor()}"/></p>
            <p class="card-text">Uploaded by: ${bookController.getUserById(book.getIdUser()).getUsername()}</p>
            <p id="likesManager${book.getIdbook()}">
                ${book.getLikes()}
                <c:set var="liked" value="false"/>
                    <c:forEach items="${favoriteBooks}" var="favorBook">
                        <c:if test="${favorBook.iduser== user.iduser && favorBook.idbook == book.idbook}">
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
    </c:forEach>
</div>
</div>

</body>
</html>