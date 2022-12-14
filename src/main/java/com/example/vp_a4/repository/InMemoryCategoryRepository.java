package com.example.vp_a4.repository;

import com.example.vp_a4.bootstrap.DataHolder;
import com.example.vp_a4.model.Category;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryCategoryRepository {

    public List<Category> findAll() {
        return DataHolder.categories;
    }

    public Category save(Category c) {
        if (c==null || c.getName().isEmpty()) {
            return null;
        }
        DataHolder.categories.removeIf(r->r.getName().equals(c.getName()));
        DataHolder.categories.add(c);
        return c;
    }

    public Optional<Category> findByName(String name) {
        return DataHolder.categories.stream().filter(r->r.getName().equals(name)).findFirst();
    }

    public List<Category> search(String text) {
        return DataHolder.categories.stream().filter(r->r.getName().contains(text) || r.getDescription().contains(text)).collect(Collectors.toList());
    }

    public void delete(String name) {
        DataHolder.categories.removeIf(r->r.getName().equals(name));
    }
}
