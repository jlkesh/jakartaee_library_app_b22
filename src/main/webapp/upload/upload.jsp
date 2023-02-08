<%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 08/02/23
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Uploads Page</title>
    <jsp:include page="/fragments/css.jsp"/>
</head>
<body>

<div class="col-8 offset-2 m-2">
    <form method="post" enctype="multipart/form-data">
        <label for="file" class="form-label">Upload File</label>
        <input type="file" id="file" name="file" class="form-control">
        <button type="submit" class="btn btn-primary">Upload</button>
    </form>
</div>

<jsp:include page="/fragments/js.jsp"/>
</body>
</html>
