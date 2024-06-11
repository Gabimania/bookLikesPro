package Servlets;

import com.gabimania.booklikespro.Controller.BookController;
import com.gabimania.booklikespro.Model.BaseModel;
import com.gabimania.booklikespro.Model.Book;
import com.gabimania.booklikespro.Model.FavoriteBook;
import com.gabimania.booklikespro.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name="userServlet" , value="/user")
public class UserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        BookController bookController = new BookController();
        User user = ((User) request.getSession().getAttribute("userLogged"));
        bookController.setUserlogged(user);
        List<Book> bookList = bookController.getAllBooks();
        request.setAttribute("bookList", bookList);
        List<FavoriteBook> favoriteBooks = bookController.getFavoriteBooks();
        FavoriteBook favoriteBook = new FavoriteBook();
        request.setAttribute("favoriteBook", favoriteBook);
        request.setAttribute("favoriteBooks", favoriteBooks);
        request.setAttribute("user", user);
        request.setAttribute("bookController", bookController);
        request.getRequestDispatcher("user.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{

    }
}
