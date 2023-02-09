<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <jsp:include page="/fragments/css.jsp"/>
</head>
<body>
<%
    response.sendRedirect("/book");
%>
<jsp:include page="/fragments/js.jsp"/>
</body>
</html>