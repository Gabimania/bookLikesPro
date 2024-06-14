package Servlets;

import com.gabimania.booklikespro.Controller.BookController;
import com.gabimania.booklikespro.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.http.HttpRequest;

@WebServlet(name="likesServlet", value="/likes")
public class LikesServlets extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BookController bookController = new BookController();
        bookController.setUserlogged((User) request.getSession().getAttribute("userLogged"));
        int idBook = Integer.parseInt(request.getParameter("idBook"));
        if(!bookController.isFavoriteBookByUser(idBook)){
            bookController.newLike(idBook);
            response.getWriter().write(createRedLikeManagerHtml(bookController, idBook));
        }else{
            bookController.deleteLike(idBook);
            response.getWriter().write(createBlackLikeManagerHtml(bookController,idBook));
        }
    }


    private String createBlackLikeManagerHtml(BookController bookController, int idBook) {
        return bookController.getAllFavoriteBooksById(idBook) +
                "<i onclick=\"manageLikes(" + idBook + ")\" class=\"fa-solid fa-heart\"></i>";
    }

    private String createRedLikeManagerHtml(BookController bookController, int idBook) {
        return bookController.getAllFavoriteBooksById(idBook) +
                "<i onclick=\"manageLikes(" + idBook + ")\" class=\"fa-solid fa-heart\" style=\"color: red\"></i>";
    }





}
