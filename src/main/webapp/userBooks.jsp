<%--
  Created by IntelliJ IDEA.
  User: gabri
  Date: 18/06/2024
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Books</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>

    <script src="assets/js/books.js"></script>


</head>
<body>
<h1>Your books <c:out value="${sessionScope.userLogged.getUsername()}"/></h1>
<div id="bookContainer">
    <c:forEach var="userBook" items="${bookUserList}">
        <div class="card"  style="width: 18rem;">
            <div class="card-body">
                <img src="./assets/img/${userBook.getBook_image()}" class="card-img-top" alt="{$book.getTitle()}">
                <h5 class="card-title">Title: <c:out value="${userBook.getTitle()}"/></h5>
                <p class="card-text">Description: <c:out value="${userBook.getDescription()}"/></p>
                <p class="card-author">Author: <c:out value="${userBook.getAuthor()}"/></p>
                <p id="likesManager${userBook.getIdbook()}">
                        ${userBook.getLikeCount()}
                    <c:set var="liked" value="false"/>
                    <c:forEach items="${favoriteBooks}" var="favorBook">
                        <c:if test="${favorBook.iduser== userBook.iduser && favorBook.idbook == userBook.idbook}">
                            <c:set var="liked" value="true"/>
                        </c:if>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${liked eq true}">
                            <i onclick="manageLikes(${userBook.idbook})" class="fa-solid fa-heart" style="color: red"></i>
                        </c:when>
                        <c:otherwise>
                            <i onclick="manageLikes(${userBook.idbook})" class="fa-solid fa-heart"></i>
                        </c:otherwise>
                    </c:choose>

                </p>
            </div>
    </c:forEach>
</div>
</div>

</body>
</html>
