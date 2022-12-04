package com.example.vp_a4.service.impl;


import com.example.vp_a4.model.User;
import com.example.vp_a4.model.exceptions.InvalidArgumentsException;
import com.example.vp_a4.model.exceptions.InvalidUserCredentialsException;
import com.example.vp_a4.model.exceptions.PasswordsDoNotMatchException;
import com.example.vp_a4.repository.InMemoryUserRepository;
import com.example.vp_a4.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final InMemoryUserRepository userRepository;

    public AuthServiceImpl(InMemoryUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        if (!password.equals(repeatPassword)) {
            throw new PasswordsDoNotMatchException();
        }
        User user = new User(username,password,name,surname);
        return userRepository.saveOrUpdate(user);
    }
}
