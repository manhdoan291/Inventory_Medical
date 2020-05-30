package com.java1906.climan.services;


import com.java1906.climan.data.model.CategoryValue;

import java.util.List;
import java.util.Optional;

public interface ICategoryValueService {

    Iterable<CategoryValue> findAll();
    Optional<CategoryValue> findById(Integer id);
    void save(CategoryValue categoryValue);
    void delete(Integer id);
    List<CategoryValue> findAllByCategory(Integer id);
    List<CategoryValue> findAllByNameContatining(String name); // phần này tìm kiếm

}
