package Servlets;

import com.gabimania.booklikespro.Controller.BookController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "editBookServlet", value ="/editBook")
public class EditBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BookController bookController = new BookController();
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String description = request.getParameter("description");
        bookController.editTitleBook(id,title);
        bookController.editAuthorBook(id,author);
        bookController.editDescriptionBook(id,description);
        response.sendRedirect("userBook");
    }
}