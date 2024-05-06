package Servlets;

import com.gabimania.booklikespro.Controller.BookController;
import com.gabimania.booklikespro.Model.BaseModel;
import com.gabimania.booklikespro.Model.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name="indexservlet", value="")
public class IndexServlet {

   public void  doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       Connection connection = BaseModel.getConnection();
       BookController bookController = new BookController();
       List<Book> bookList= bookController.getAllBooks();
       request.setAttribute("bookList", bookList);
       request.getRequestDispatcher("index.jsp").forward(request, response);
   }
}
