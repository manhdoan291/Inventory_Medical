package com.java1906.climan.services.impl;

import com.java1906.climan.controller.ResourceNotFoundException;
import com.java1906.climan.data.model.Category;
import com.java1906.climan.data.repo.CategoryRepository;
import com.java1906.climan.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
        if (!categoryRepository.existsById(id)) {
            try {
                throw new ResourceNotFoundException("Category with"+ id+ "not found");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(int categoryId, Category category){
        if (!categoryRepository.existsById(categoryId)) {
            try {
                throw new ResourceNotFoundException("Author with id " + categoryId + " not found");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        Optional<Category> categoryOne =categoryRepository.findById(categoryId);

        if (!categoryOne.isPresent()) {
            try {
                throw new ResourceNotFoundException("Author with id " + categoryId + " not found");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        Category category1 = categoryOne.get();
        category1.setName(category.getName());
        category1.setDescription(category.getDescription());
        category1.setCreateDate(category1.getCreateDate());
        category1.setUpdateDate(new Date());
        return categoryRepository.save(category1);
    }
    @Override
    public void delete(Integer categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            try {
                throw new ResourceNotFoundException("Author with id " + categoryId + " not found");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        categoryRepository.deleteById(categoryId);
    }
}
