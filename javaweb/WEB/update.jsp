<%@ page import="entity.Book" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<%
    Book book= (Book) request.getAttribute("books");
%>
<body>
<form action="update" method="post">
    图书编号  <input type="text" name="bookid">
    书名<input type="text" name="title">
    作者<input type="text" name="author">
    出版社<input type="text" name="publisher">
    价格<input type="text" name="price">
    <input type="submit" value="修改" >
    <a href="button.jsp">返回</a>
</form>
</body>
</html>
