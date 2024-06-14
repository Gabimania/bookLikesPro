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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.ServerException;

@WebServlet(name="addBookServlet",value="/addBook" )
public class AddBookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException{
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        BookController bookController = new BookController();
        bookController.setUserlogged((User) request.getSession().getAttribute("userLogged"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String author = request.getParameter("author");
        Part imagePart = request.getPart("book_image");
        String imageName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
        saveImageInServer(imagePart, imageName);
        bookController.addBook(title, description,author, imageName);
        response.sendRedirect("user");

    }
    private void saveImageInServer(Part filePart, String fileName) throws IOException {
        // Especifica la ubicación de almacenamiento en Tomcat
        String tomcatUploadPath = System.getProperty("user.dir") + "/../webapps/BookLikesPro_war/assets/img";

        // Especifica la ubicación de almacenamiento en el repositorio local del proyecto
        String localRepoPath = System.getProperty("user.home") + "/IdeaProjects/BookLikesPro/src/main/webapp/assets/img";

        // Lee el contenido del archivo
        InputStream fileContent = filePart.getInputStream();

        // Escribe el contenido en un archivo en Tomcat
        OutputStream tomcatOutputStream = new FileOutputStream(new File(tomcatUploadPath, fileName));
        int read = 0;
        byte[] bytes = new byte[1024];
        while ((read = fileContent.read(bytes)) != -1) {
            tomcatOutputStream.write(bytes, 0, read);
        }
        tomcatOutputStream.close();
        fileContent.close(); // Cerrar el InputStream

        // Crear una copia de la imagen en el repositorio local del proyecto
        InputStream fileContentCopy = filePart.getInputStream();
        OutputStream localRepoOutputStream = new FileOutputStream(new File(localRepoPath, fileName));
        while ((read = fileContentCopy.read(bytes)) != -1) {
            localRepoOutputStream.write(bytes, 0, read);
        }
        localRepoOutputStream.close();
        fileContentCopy.close(); // Cerrar el InputStream
    }

    }

