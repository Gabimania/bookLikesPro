package com.gabimania.booklikespro.Controller;

import com.gabimania.booklikespro.Model.Book;
import com.gabimania.booklikespro.Model.User;

public class BookController {
    private User userloged;
    public boolean newUser(String username, String email, String password) {
        User user=new User(username, email, password);
        return user.insert("(username, email, password ) values(?,?,?)", user.getUsername(), user.getEmail(), user.getPassword() );
    }

    public boolean login(String email, String password){
        this.userloged = User.login(email, password);
        return userloged!= null;
    }
}
