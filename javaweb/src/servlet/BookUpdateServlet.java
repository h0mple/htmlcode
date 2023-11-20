package servlet;


import dao.BookDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/update")
public class BookUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //根据bookid来确定修改哪本书
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        BookDao dao=new BookDao();
        int bookid= Integer.parseInt(req.getParameter("bookid"));
        String title=req.getParameter("title");
        String author=req.getParameter("author");
        String publisher=req.getParameter("publisher");
        Double price=Double.parseDouble(req.getParameter("price"));
        PrintWriter out=resp.getWriter();
        if(dao.update(bookid,title,author,publisher,price)){
            resp.getWriter().println("更新成功！");
            out.println("<input type=\"button\" onclick=\"window.location.href=\'button.jsp\' \" value=\"返回\">  ");
        }
        else{
            resp.getWriter().println("更新失败！");
            out.println("<input type=\"button\" onclick=\"window.location.href=\'button.jsp\' \" value=\"返回\">  ");
        }

    }
}
