package com.java1906.climan.services;

import com.java1906.climan.data.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> getAll();

    Optional<Category> findById(Integer id);

    Category save(Category category);

    void update(Category category) throws Exception;

    void delete(Integer id);


}
