package com.example.vp_a4.bootstrap;

import com.example.vp_a4.model.Category;
import com.example.vp_a4.model.User;
import jakarta.annotation.PostConstruct;
import lombok.Getter;

import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;


@Component
@Getter
public class DataHolder {

    public static List<Category> categories = new ArrayList<>();
    public static List<User> users = new ArrayList<>();


    @PostConstruct
    public void init() {
        categories.add(new Category("Movies", "Movies category"));
        categories.add(new Category("Books", "Books category"));
        categories.add(new Category("Software", "Software category"));

        users.add(new User("kostadin.mishev","km","Kostadin","Mishev"));
        users.add(new User("riste.stojanov","rs","Riste","Stojanov"));

    }
}
