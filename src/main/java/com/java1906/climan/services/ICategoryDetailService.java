package com.java1906.climan.services;


import com.java1906.climan.data.model.CategoryDetail;

import java.util.List;

public interface ICategoryDetailService {

    public CategoryDetail get(Integer id);

    public List<CategoryDetail> getAll();

    public CategoryDetail save(CategoryDetail categoryDetail);

    public CategoryDetail update(CategoryDetail categoryDetail, Integer id) throws Exception;

    public void delete(Integer id);
}
