package Servlets;
import java.io.*;
import com.gabimania.booklikespro.Controller.BookController;
import com.gabimania.booklikespro.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.rmi.ServerException;

@WebServlet(name="addBookServlet",value="/addBook" )
public class AddBookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException{
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException{
        BookController bookController = new BookController();
       // bookController.setUserlogged((User)).request.getSession().getAtribute("userlogged");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String author = request.getParameter("author");
        Part image = null;
        try {
             image = request.getPart("book_image");
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
        String book_image = getImageName(image);
        String path = request.getServletContext().getRealPath("/assets/img/") + File.separator + book_image;
        image.write(path);
        if(bookController.addBook(title,description,author,book_image)){
            response.sendRedirect("index.jsp");
        }



    }
    private String getImageName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("book_image")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return "";
    }


    }

