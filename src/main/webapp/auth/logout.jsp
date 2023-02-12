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
    <title>Logout Page</title>
    <jsp:include page="/fragments/css.jsp"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8 offset-2">
            <form method="post" action="/auth/logout">
                <div class="alert alert-danger">
                    <h1><span class="text-capitalize">USERNAME</span> Are you sure to sign out ?</h1>
                </div>
                <button type="submit" class="btn btn-danger">Logout</button>
                <a href="/book" class="btn btn-warning">Home</a>
            </form>
        </div>
    </div>
</div>

<jsp:include page="/fragments/js.jsp"/>
</body>
</html>
