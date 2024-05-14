package com.gabimania.booklikespro.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FavoriteBook extends BaseModel{
    private int iduser;
    private int idbook;
    private LocalDateTime creationDate;

    public FavoriteBook() {
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdbook() {
        return idbook;
    }

    public void setIdbook(int idbook) {
        this.idbook = idbook;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<FavoriteBook> getFavoriteBooks(){
        List<FavoriteBook> favoriteBooks = new ArrayList<>();
        List<Object>objectList = new FavoriteBook().readAll("select * from favorite_book");
        for (Object object : objectList){
            Object[] objects = (Object[]) object;
            FavoriteBook favoriteBook = new FavoriteBook();
            favoriteBook.setIdbook((int)objects[0]);
            favoriteBook.setIduser((int) objects[1]);
            favoriteBook.setCreationDate((LocalDateTime)objects[2]);
            favoriteBooks.add(favoriteBook);
        }
        return favoriteBooks;
    }


    public int getAllFavoritesBookById(int idBook){
        List<Object> objectList = new FavoriteBook().readAll("select count(iduser) from favorite_book where idbook= " + idBook + " group by idbook");
        int likes = 0;
        for(Object object: objectList){
            likes += (int) object;
        }
        return likes;
    }

    public boolean favoriteBookByUser(int idBook, int idUser ){
        List<FavoriteBook> favoriteBooks = getFavoriteBooks();
        if(favoriteBooks.stream().anyMatch(favorite-> favorite.getIdbook() == idBook && favorite.getIduser() == idUser)){
            return true;
        }
        return false;
    }

    @Override
    protected String getNameTable() {
      return  "favorite_book";
    }
}
