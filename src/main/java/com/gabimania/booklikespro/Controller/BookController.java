package com.gabimania.booklikespro.Controller;

import com.gabimania.booklikespro.Model.User;

public class BookController {
    public boolean newUser(String username, String email, String password) {
        return new User().insert("(username, email, password ) values(?,?,?)", username, email, password );
    }
}
