package com.gabimania.booklikespro.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User extends BaseModel{
    private int iduser;
    private String username;
    private String email;
    private String password;

    private LocalDateTime date_registration;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
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

    public static List<User> getUsers(){
        List<User> userList = new ArrayList<>();
        List<Object> objectList = new User().readAll("select * from user");
        return getUserList(userList, objectList);
    }


    private static List<User> getUserList(List<User> userList, List<Object> objectList) {
        for(Object object : objectList){
            Object[] objects= (Object[]) object;
            User user = new User();
            user.setIduser((int)objects[0]);
            user.setUsername((String) objects[1]);
            user.setEmail((String)objects[2]);
            user.setPassword((String) objects[3]);
            user.setDate_registration((LocalDateTime) objects[4]);
            userList.add(user);
        }
        return userList;
    }

    public static User login( String password, String email){
        List<User> userList = User.getUsers();
        for (User user: userList){
            if(user.password.equals(password)&& user.email.equals(email)){
                return user;
            }
        }
        return null;
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
