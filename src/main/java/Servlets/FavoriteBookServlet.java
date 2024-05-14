package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name="favoriteBookServlet", value="/favoriteBook")
public class FavoriteBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {}

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {}


}
