package com.gabimania.booklikespro.Controller;

import com.gabimania.booklikespro.Model.Book;
import com.gabimania.booklikespro.Model.User;

public class BookController {
    public boolean newUser(String username, String email, String password) {
        User user=new User(username, email, password);
        return user.insert("(username, email, password ) values(?,?,?)", user.getUsername(), user.getEmail(), user.getPassword() );
    }
}
