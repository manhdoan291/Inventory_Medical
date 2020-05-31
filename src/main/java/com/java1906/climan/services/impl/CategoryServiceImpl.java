package com.java1906.climan.services.impl;

import com.java1906.climan.data.model.Category;
import com.java1906.climan.data.repo.CategoryRepository;
import com.java1906.climan.exception.LogicException;
import com.java1906.climan.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    public List<Category> getAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void update(Category category) throws Exception {
categoryRepository.save(category);
    }
    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
