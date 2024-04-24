package Servlets;

import java.io.*;

import com.gabimania.booklikespro.Controller.BookController;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "registerServlet", value = "/register")
public class RegisterServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("register.jsp").forward(request,response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BookController bookController = new BookController();
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        String repassword= request.getParameter("repassword");
        String email = request.getParameter("email");
        if (password.equals(repassword)){
            if (bookController.newUser(username,password,email))
                response.sendRedirect("login.jsp");
            else {
                request.setAttribute("errorMessage","There was an error. Please try again later");
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }
        } else {
            request.setAttribute("errorMessage","Check introduced passwords and try again");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
    }
}