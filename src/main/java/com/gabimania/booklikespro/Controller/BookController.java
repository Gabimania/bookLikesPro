package com.gabimania.booklikespro.Controller;

import com.gabimania.booklikespro.Model.Book;
import com.gabimania.booklikespro.Model.FavoriteBook;
import com.gabimania.booklikespro.Model.User;

import java.util.List;

public class BookController {
    private User userlogged;

    public BookController() {
    }

    public User getUserlogged() {
        return userlogged;
    }

    public void setUserlogged(User user) {
        this.userlogged = user;
    }

    public boolean newUser(String username, String email, String password) {
        User user = new User(username, email, password);
        return user.insert("(username, email, password ) values(?,?,?)", user.getUsername(), user.getEmail(), user.getPassword());
    }

    public boolean login(String email, String password) {
        this.userlogged = User.login(email, password);
        return userlogged != null;
    }

    public List<Book> getAllBooks() {
        return Book.getBooks();
    }

    public List <Book> getAllBooksByUser(){
        return Book.getBooksByUser(userlogged);
    }

    public List <Book> getAllBookUserAdded(User userlogged){
        return Book.getBooksByUserAdded(userlogged);
    }


    public boolean addBook(String title, String description, String author, String book_image) {
        return new Book().insert("(title,description, author,book_image, iduser) values(?,?,?,?,?)", title, description, author, book_image, userlogged.getIduser());

    }

    public boolean newLike(int idBook) {
        return new FavoriteBook().insert("(idbook, iduser) values(?,?)", idBook,userlogged.getIduser());
    }

    public boolean deleteLikebyId(int idBook) {
        return new FavoriteBook().delete("idbook = ? and iduser=?", idBook, userlogged.getIduser());

    }

    public Long getAllFavoriteBooksById(int idBook){
        return new FavoriteBook().getAllFavoritesBookById(idBook);
    }

    public boolean isFavoriteBookByUser(int idBook){
        return new FavoriteBook().favoriteBookByUser(idBook, userlogged.getIduser());
    }

    public List<FavoriteBook> getFavoriteBooks(){
        return new FavoriteBook().getFavoriteBooks();
    }

    public User getUserById(int idUser){
        return new User().getUserById(idUser);
    }

    public boolean editTitleBook(int id, String title) {
        return new Book().update("title = ? where idbook = ?", title, id);
    }

    public boolean editAuthorBook(int id, String author) {
        return new Book().update("author = ? where idbook = ?", author, id);
    }

    public boolean editDescriptionBook(int id, String description) {
        return new Book().update("description = ? where idbook = ?", description, id);
    }

    public boolean deleteBookById(int idBook){
        return new Book().delete("idbook= ?", idBook);
    }

    public Book getBookById(int idBook){
        return new Book().getBookById(idBook);
    }
}

