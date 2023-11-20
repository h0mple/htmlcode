<%@ page import="entity.Book" %>
<%@ page import="java.util.List" %><%--
        Created by IntelliJ IDEA.
        User: A5pg
        Date: 2023/11/23
        Time: 12:24
        To change this template use File | Settings | File Templates.
        --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>show</title>
  <style type="text/css">
    table.gridtable{
      font-family: Verdana,Arial,sans-serif;
      font-size: 11px;
      color: #333333;
      border-width: 1px;
      border-color: #666666;
      border-collapse: collapse;
    }
    table.gridtable th{
      border-width: 1px;
      padding: 8px;
      border-style: solid;
      border-color: #666666;
      background-color: #dedede;
    }
    table.gridtable td{
      border-width: 1px;
      padding: 8px;
      border-style: solid;
      border-color: #666666;
      background-color: #ffffff;
    }
  </style>
</head>
<body>

<h1 align="center">书籍信息</h1>
<%
  Book book= (Book) request.getAttribute("books");
%>
<table class="gridtable" align="center" width="500px" >
  <tr>
    <th>图书编号</th>
    <th>书名</th>
    <th>作者</th>
    <th>出版社</th>
    <th>价格</th>
    <th>操作</th>
  </tr>
  <tr align="center">
    <td><%=book.getbookid()%></td>
    <td><%=book.gettitle()%></td>
    <td><%=book.getauthor()%></td>
    <td><%=book.getpublisher()%></td>
    <td><%=book.getprice()%></td>
    <td>
      <a href="update.jsp">修改</a>
      <a href="delete.jsp">删除</a>
      <a href="button.jsp">返回</a>
    </td>
  </tr>
</table>
</body>
</html>
