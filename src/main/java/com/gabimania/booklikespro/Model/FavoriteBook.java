package com.gabimania.booklikespro.Model;

import java.time.LocalDateTime;

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

    @Override
    protected String getNameTable() {
        return null;
    }
}
