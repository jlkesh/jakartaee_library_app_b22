<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 12/02/23
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
    <jsp:include page="/fragments/css.jsp"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8 offset-2">
            <form method="post">
                <div class="mb-3">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" class="form-control" name="username" id="username">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <div class="mb-3">
                    <label for="confirmPassword" class="form-label">Confirm Password</label>
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword">
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" name="email" id="email">
                </div>

                <button type="submit" class="btn btn-success">Register</button>
                <a href="<c:url value="/auth/login"/>" class="btn btn-primary">Login</a>
            </form>
        </div>
    </div>
</div>

<jsp:include page="/fragments/js.jsp"/>
</body>
</html>
