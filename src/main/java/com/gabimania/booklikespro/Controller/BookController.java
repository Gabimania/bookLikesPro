package com.gabimania.booklikespro.Controller;

import com.gabimania.booklikespro.Model.User;

public class BookController {
    public boolean newUser(String username, String password, String email) {
        return new User().insert("(username, password, email ) values(?,?,?)" );
    }
}
