package servlet;


import dao.BookDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/delete")
public class BookDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp中文输出乱码
        resp.setContentType("text/html;charset=UTF-8");
        //根据bookid删除图书
        resp.setContentType("text/html;charset=UTF-8");
        BookDao dao=new BookDao();
        int bookid= Integer.parseInt(req.getParameter("bookid"));
        PrintWriter out=resp.getWriter();
        if(dao.delete(bookid)){
            resp.getWriter().println("删除成功！");
            out.println("<input type=\"button\" onclick=\"window.location.href=\'button.jsp\' \" value=\"返回\">  ");
        }
        else{
            resp.getWriter().println("删除失败");
            out.println("<input type=\"button\" onclick=\"window.location.href=\'button.jsp\' \" value=\"返回\">  ");
        }

    }
}
