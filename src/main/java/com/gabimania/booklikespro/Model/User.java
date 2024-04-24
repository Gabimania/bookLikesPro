package com.gabimania.booklikespro.Model;

import java.time.LocalDateTime;

public class User extends BaseModel{
    private int iduser;
    private String username;
    private String email;
    private String password;

    private LocalDateTime date_registration;

    public User() {
    }

    public User(int iduser, String username, String email, String password, LocalDateTime date_registration) {
        this.iduser = iduser;
        this.username = username;
        this.email = email;
        this.password = password;
        this.date_registration = date_registration;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDate_registration() {
        return date_registration;
    }

    public void setDate_registration(LocalDateTime date_registration) {
        this.date_registration = date_registration;
    }

    @Override
    protected String getNameTable() {
        return "user";
    }

    @Override
    public String toString() {
        return "User{" +
                "iduser=" + iduser +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", date_registration=" + date_registration +
                '}';
    }
}
