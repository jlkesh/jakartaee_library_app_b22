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
    <title>Login Page</title>
    <jsp:include page="/fragments/css.jsp"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8 offset-2">
            <form method="post" action="/auth/login?next=${next}">
                <div class="mb-3">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" class="form-control" name="username" id="username">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <button type="submit" class="btn btn-success">Login</button>
                <a href="/auth/register" class="btn btn-primary">Register</a>
            </form>
        </div>
    </div>
</div>

<jsp:include page="/fragments/js.jsp"/>
</body>
</html>
