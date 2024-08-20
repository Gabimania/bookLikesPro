package Servlets;

import com.gabimania.booklikespro.Controller.BookController;
import com.gabimania.booklikespro.Model.Book;
import com.gabimania.booklikespro.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.GET;

import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "deleteBookServlet", value ="/deleteBook")
public class DeleteBookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        BookController bookController = new BookController();
        //bookController.setUserlogged((User) request.getSession().getAttribute("userLogged"));
        User userLogged = (User) request.getSession().getAttribute("userLogged");
        bookController.setUserlogged(userLogged);
        int idBook = Integer.parseInt(request.getParameter("idBook"));
        Book book = bookController.getBookById(idBook);
        deleteImage(book.getBook_image());
        bookController.deleteBookById(idBook);
        response.getWriter().write(createBookDiv(bookController, userLogged));

    }

    private String createBookDiv(BookController bookController, User userLogged) {
        List<Book> bookList = bookController.getAllBookUserAdded(userLogged);
        StringBuilder divContent = new StringBuilder();
        if (!bookList.isEmpty()) {
            for (Book bookbyUser : bookList) {
                divContent.append("<div class=\"card\">")
                        .append("<img src=\"assets/img/")
                        .append(bookbyUser.getBook_image()).append("\" class=\"card-img-top\" alt=\"")
                        .append(bookbyUser.getTitle()).append(" img\">")
                        .append("<div class=\"card-body\">")
                        .append("<h5 class=\"card-title\">").append(bookbyUser.getTitle()).append("</h5>")
                        .append("<p class=\"card-text\">Author: ").append(bookbyUser.getAuthor()).append("</p>")
                        .append("<p class=\"card-text\">Description: ").append(bookbyUser.getDescription()).append("</p>");

                divContent.append("</p>")
                        .append("<p>")
                        .append("<i onclick=\"showEditForm(").append(bookbyUser.getIdbook())
                        .append(")\" class=\"fa-solid fa-file-pen\"></i>")
                        .append("<i onclick=\"deleteBook(").append(bookbyUser.getIdbook())
                        .append(")\" class=\"fa-solid fa-trash\"></i>")
                        .append("</p>")
                        .append("</div>")
                        .append("</div>")
                        .append("<div id=\"modalContainer").append(bookbyUser.getIdbook()).append("\" class=\"modal-container\">")
                        .append("<div id=\"editForm\" class=\"modal-content\">")
                        .append("<form method=\"post\" action=\"editBook\">")
                        .append("<input type=\"hidden\" name=\"id\" value=\"").append(bookbyUser.getIdUser()).append("\">")
                        .append("<input type=\"text\" name=\"title\" value=\"").append(bookbyUser.getTitle()).append("\">")
                        .append("<input type=\"text\" name=\"author\" value=\"").append(bookbyUser.getAuthor()).append("\">")
                        .append("<input type=\"text\" name=\"description\" value=\"").append(bookbyUser.getDescription()).append("\">")
                        .append("<input onclick=\"hideEditForm(").append(bookbyUser.getIdbook()).append(")\" type=\"submit\" value=\"Save\">")
                        .append("</form>")
                        .append("</div>")
                        .append("</div>");
            }
        } else {
            divContent.append("<p>No books created</p>");
        }
        return divContent.toString();
    }

    private void deleteImage(String fileName) {
        String serverPath = System.getProperty("user.dir") + "/../webapps/BookLikesPro_war/assets/imag";
        String localPath = System.getProperty("user.home") + "/IdeaProjects/BookLikesPro/src/main/webapp/assets/imag";
        File fileToDeleteServer = new File(serverPath, fileName);
        File fileToDeleteLocal = new File(localPath, fileName);
        fileToDeleteLocal.delete();
        fileToDeleteServer.delete();
    }
}



