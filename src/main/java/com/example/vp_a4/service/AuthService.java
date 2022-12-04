package com.example.vp_a4.service;

import com.example.vp_a4.model.User;

public interface AuthService {

    User login(String username, String password);
    User register(String username, String password, String repeatPassword, String name, String surname);

}
