package com.java1906.climan.services;

import com.java1906.climan.data.model.Category;

import java.util.List;

public interface ICategoryService {
    public Category get(Integer id);

    public List<Category> getAll();

    public Category save(Category category);

    public Category update(Category category, Integer id) throws Exception;

    public void delete(Integer id);
}
