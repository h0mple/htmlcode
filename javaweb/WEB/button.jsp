<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>BookService</title>
</head>
<body>
<h1>Welcome BookService</h1>

<input type="button" onclick="window.location.href='query.jsp'" value="查询">
<input type="button" onclick="window.location.href='add.jsp'" value="增加">
<input type="button" onclick="window.location.href='update.jsp'" value="修改">
<input type="button" onclick="window.location.href='delete.jsp'" value="删除">
<form action="queryall" method="get">
    <button type="submit">显示所有书</button >
</form>
</body>
</html>