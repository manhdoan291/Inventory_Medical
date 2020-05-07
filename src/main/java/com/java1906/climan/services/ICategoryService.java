package com.java1906.climan.services;

import com.java1906.climan.data.model.Category;

import java.util.List;

public interface ICategoryService {
    public Category get(Integer id);
    public List<Category> getAll();
    public void post(Category category);
    public void put(Category category, Integer id) throws Exception;
    public void delete(Integer id);
}
