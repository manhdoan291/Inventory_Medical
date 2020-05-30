package com.java1906.climan.services;

import com.java1906.climan.data.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    public List<Category> getAll();
    Optional<Category> findById(Integer id);
    public Category save(Category category);
  //  public Category update(Category category, Integer id) throws Exception;
    public void delete(Integer id);

}
