package com.java1906.climan.services;


import com.java1906.climan.data.model.CategoryValue;

import java.util.List;

public interface ICategoryValueService {

    public CategoryValue get(Integer id);

    public List<CategoryValue> getAll();

    public CategoryValue save(CategoryValue categoryDetail);

    public CategoryValue update(CategoryValue categoryDetail, Integer id) throws Exception;

    public void delete(Integer id);
}
