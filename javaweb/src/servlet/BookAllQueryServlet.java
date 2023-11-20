package servlet;

import dao.BookDao;
import entity.Book;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/queryall")
public class BookAllQueryServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //输出所有student查询结果
        /*BookDao bdao = new BookDao();
        ArrayList<Book> books = bdao.queryAll();
        for(Book book : books){
            System.out.println(book);//输出到控制台
            resp.getWriter().println("<h3>"+book+"</h3>");
        }
*/
        BookDao bdao = new BookDao();
        ArrayList<Book> books = bdao.queryAll();
        PrintWriter out=resp.getWriter();
        for(Book book : books){
            //输出到控制台
            resp.getWriter().println("<h3>"+book+"</h3>");
            System.out.println(book);

        }
        out.println("<input type=\"button\" onclick=\"window.location.href=\'button.jsp\' \" value=\"返回\">  ");



    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
        //post操作与get操作执行相同的代码
    }
}
