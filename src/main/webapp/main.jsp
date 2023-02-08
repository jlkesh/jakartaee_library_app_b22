<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <jsp:include page="/fragments/css.jsp"/>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-10 offset-1">
            <input type="text" class="form-control" placeholder="Search..."/>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Page Count</th>
                    <th>Publisher</th>
                    <th>Published At</th>
                    <th>Rank</th>
                    <th>Category</th>
                    <th>Downloads Count</th>
                    <th>View Count</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>


<jsp:include page="/fragments/js.jsp"/>
</body>
</html>