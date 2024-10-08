package com.gabimania.booklikespro.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Book extends BaseModel{



    private int idbook;
    private String title;
    private String description;
    private String author;
    private String book_image;

    private LocalDateTime creation_date;

    private int iduser;

    private Long likeCount;

    public Book(int idbook, String title, String description, String author, String book_image, LocalDateTime creation_date, int iduser) {
        this.idbook = idbook;
        this.title = title;
        this.description = description;
        this.author = author;
        this.book_image = book_image;
        this.creation_date = creation_date;
        this.iduser = iduser;
    }

    public Book() {
    }

    public int getIdbook() {
        return idbook;
    }

    public void setIdbook(int idbook) {
        this.idbook = idbook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBook_image() {
        return book_image;
    }

    public void setBook_image(String book_image) {
        this.book_image = book_image;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }

    public int getIdUser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIduser() {
        return iduser;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public static List<Book> getBooks(){
        List<Book>bookList = new ArrayList<>();
        List<Object>objectList= new Book().readAll("select book.idbook, \n" +
                "       book.title, \n" +
                "       book.description, \n" +
                "       book.author, \n" +
                "       book.book_image, \n" +
                "       book.creation_date, \n" +
                "       book.iduser, \n" +
                "       count(favorite_book.idbook) as likeCount\n" +
                "from book \n" +
                "left join favorite_book on book.idbook = favorite_book.idbook\n" +
                "group by book.idbook;");
        return getBookList(bookList,objectList);
    }

    public static List<Book> getBooksByUser(User user){
        List<Book>bookList = new ArrayList<>();
        List<Object> objectList = new Book().readAll( "SELECT b.idbook, b.title, b.description, b.author, b.book_image, b.creation_date, b.iduser, COUNT(f.idbook) AS likeCount " +
                "FROM book AS b " +
                "right JOIN favorite_book AS f ON b.idbook = f.idbook " +
                "WHERE f.iduser = '" + user.getIduser() + "' " +
                "GROUP BY b.iduser, b.title, b.description, b.author, b.book_image, b.creation_date, b.idbook");

        return getBookList(bookList,objectList);
    }


    public static List<Book> getBooksByUserAdded(User user){
        List<Book>bookList = new ArrayList<>();
        List<Object> objectList = new Book().readAll( "SELECT b.idbook, b.title, b.description, b.author, b.book_image, b.creation_date, b.iduser " +
                "FROM book AS b " +
                "WHERE b.iduser = '" + user.getIduser() + "'");

        return getBookListUserAdded(bookList,objectList);
    }

    public Book getBookById(int idBook){
        List<Book> bookList = new ArrayList<>();
        List<Object> objectList = new Book().readAll("SELECT b.idbook, b.title, b.description, b.author, b.book_image, b.creation_date, b.iduser " +
                "FROM book AS b " +
                "WHERE b.idbook = '" + idBook + "'");
        return getBookListUserAdded(bookList, objectList).get(0);
    }



    private static List<Book> getBookList(List<Book> bookList, List<Object> objectList) {
        for(Object object: objectList){
            Object[]objects= (Object[]) object;
            Book book = new Book();
            book.setIdbook((int)objects[0]);
            book.setTitle((String) objects[1]);
            book.setDescription((String)objects[2]);
            book.setAuthor((String)objects[3]);
            book.setBook_image((String)objects[4]);
            book.setCreation_date((LocalDateTime) objects[5]);
            int idUser = (int)objects[6];
            book.setIduser(idUser);
            book.setLikeCount((Long) objects[7]);
            bookList.add(book);
        }
        return bookList;
    }

    private static List<Book> getBookListUserAdded(List<Book> bookList, List<Object>objectList){
        for(Object object: objectList) {
            Object[] objects = (Object[]) object;
            Book book = new Book();
            book.setIdbook((int) objects[0]);
            book.setTitle((String) objects[1]);
            book.setDescription((String) objects[2]);
            book.setAuthor((String) objects[3]);
            book.setBook_image((String) objects[4]);
            book.setCreation_date((LocalDateTime) objects[5]);
            int idUser = (int) objects[6];
            book.setIduser(idUser);
            bookList.add(book);
        }
        return bookList;
    }

    @Override
    protected String getNameTable() {
        return "book";
    }

    @Override
    public String toString() {
        return "Book{" +
                "idbook=" + idbook +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", book_image='" + book_image + '\'' +
                ", creation_date=" + creation_date +
                ", iduser=" + iduser +
                '}';
    }
}
