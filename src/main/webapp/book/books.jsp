<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 09/02/23
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
    <jsp:include page="/fragments/css.jsp"/>
</head>
<body>
<div class="container">
    <div class="row">
        <a href="/book/add" class="btn btn-success">Add</a>
        <div class="books_list">
            <c:forEach items="${books}" var="book">
                <div class="card">
                    <img src="/download?filename=${book.getCoverGeneratedFileName()}" class="card-img-top" alt="${book.getCoverOriginalFileName()}" loading="lazy" />
                    <div class="card-body">
                        <h5 class="card-title">${book.getTitle()} by <span class="book_title">${book.getAuthor()}</span></h5>
                        <p class="card-text">${book.getDescription()}</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">An item</li>
                        <li class="list-group-item">A second item</li>
                        <li class="list-group-item">A third item</li>
                    </ul>
                    <div class="card-body">
                        <a href="#" class="card-link">Card link</a>
                        <a href="#" class="card-link">Another link</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<jsp:include page="/fragments/js.jsp"/>
</body>
</html>
