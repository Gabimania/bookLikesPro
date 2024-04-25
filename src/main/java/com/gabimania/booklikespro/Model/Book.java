package com.gabimania.booklikespro.Model;

import java.time.LocalDateTime;

public class Book extends BaseModel{

    private int idbook;
    private String title;
    private String description;
    private String author;
    private String book_image;

    private LocalDateTime creation_date;

    private int iduser;

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

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
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