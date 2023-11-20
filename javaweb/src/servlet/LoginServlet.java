

/**
 * Servlet implementation class LoginServlet
 */

package servlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getMethod().equals("GET")) {
            // 处理GET请求的逻辑
            handleGetRequest(request, response);
        } else if (request.getMethod().equals("POST")) {
            // 处理POST请求的逻辑
            handlePostRequest(request, response);
        }
    }

    private void handleGetRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理GET请求的逻辑
        // 例如，显示登录表单页面
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    private void handlePostRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理POST请求的逻辑
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 在这里进行用户名和密码的验证
        if (isValidUser(username, password)) {
            // 登录成功
            request.getSession().setAttribute("username", username);
            response.sendRedirect("button.jsp"); // 重定向到仪表盘页面
        } else {
            // 登录失败
            request.setAttribute("errorMessage", "用户名或密码错误");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
        }
    }

    private boolean isValidUser(String username, String password) {
        // 在这里编写验证用户名和密码的逻辑，可以与数据库或其他存储进行交互
        // 返回true表示验证成功，返回false表示验证失败
        // 这里只是一个示例，实际上应该进行更强大的验证和加密
        return username.equals("root") && password.equals("030114lyh");
    }
}