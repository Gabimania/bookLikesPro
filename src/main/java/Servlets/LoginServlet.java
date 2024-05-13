package Servlets;

import com.gabimania.booklikespro.Controller.BookController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="loginservlet", value="/login")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session= request.getSession();
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BookController bookController = new BookController();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (bookController.login(password, email)) {
            HttpSession session= request.getSession();
            session.setAttribute("userLogged", bookController.getUserlogged());
            response.sendRedirect("user.jsp");
        } else {
            request.setAttribute("errorMessage", "There was an error. Please try again later");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}



