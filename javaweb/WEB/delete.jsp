<%--
  Created by IntelliJ IDEA.
  User: A5pg
  Date: 2023/11/22
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete</title>
</head>
<body>
<h1>请输入要删除的图书编号</h1>
<form action="delete" method="post">
    图书编号<input type="text" name="bookid">
    <input type="submit" value="删除">
    <a href="button.jsp">返回</a>
</form>
</body>
</html>
