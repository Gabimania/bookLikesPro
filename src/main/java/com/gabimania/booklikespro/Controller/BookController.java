package com.gabimania.booklikespro.Controller;

import com.gabimania.booklikespro.Model.Book;
import com.gabimania.booklikespro.Model.User;

import java.util.List;

public class BookController {
    private User userlogged;

    public BookController() {
    }

    public boolean newUser(String username, String email, String password) {
        User user=new User(username, email, password);
        return user.insert("(username, email, password ) values(?,?,?)", user.getUsername(), user.getEmail(), user.getPassword() );
    }

    public boolean login(String email, String password){
        this.userlogged = User.login(email, password);
        return userlogged!= null;
    }

    public List<Book> getAllBooks() {
        return Book.getBooks();

    }

    public User getUserlogged() {
        return userlogged;
    }

    public void setUserlogged(User user) {
        this.userlogged = user;
    }

    public boolean addBook(String title, String description, String author, String book_image){
        return new Book().insert("(title,description, author,book_image, iduser) values(?,?,?,?,?)", title, description, author, book_image, userlogged.getIduser());

    }
}
