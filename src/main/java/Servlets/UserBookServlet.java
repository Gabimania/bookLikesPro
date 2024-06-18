package Servlets;

import com.gabimania.booklikespro.Controller.BookController;
import com.gabimania.booklikespro.Model.Book;
import com.gabimania.booklikespro.Model.FavoriteBook;
import com.gabimania.booklikespro.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name="userBookServlet" , value="/userBook")
public class UserBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        BookController bookController = new BookController();
        User userLogged = (User) request.getSession().getAttribute("userLogged");
        bookController.setUserlogged(userLogged);
        request.setAttribute("userLogged",userLogged);
        List<Book> bookUserList = bookController.getAllBooksByUser();
        request.setAttribute("bookUserList", bookUserList);
        List<FavoriteBook> favoriteBooks = bookController.getFavoriteBooks();
        FavoriteBook favoriteBook = new FavoriteBook();
        request.setAttribute("favoriteBook", favoriteBook);
        request.setAttribute("favoriteBooks", favoriteBooks);
        request.getRequestDispatcher("userBooks.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

    }
}
