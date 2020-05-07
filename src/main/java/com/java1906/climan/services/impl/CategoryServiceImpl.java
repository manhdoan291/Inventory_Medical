package com.java1906.climan.services.impl;

import com.java1906.climan.data.model.Category;
import com.java1906.climan.data.repo.CategoryRepository;
import com.java1906.climan.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category get(Integer id) {
       return categoryRepository.findById(id).get();
    }

    @Override
    public List<Category> getAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public void post(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void put(Category category, Integer id) {
        categoryRepository.findById(id);
        categoryRepository.save(category);
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
