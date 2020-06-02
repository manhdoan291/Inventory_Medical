package com.java1906.climan.services.impl;

import com.java1906.climan.data.model.CategoryValue;
import com.java1906.climan.data.repo.CategoryValueRepository;
import com.java1906.climan.services.ICategoryValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryValueServiceImpl implements ICategoryValueService {
    @Autowired
    private CategoryValueRepository categoryValueRepository;


    @Override
    public List<CategoryValue> findAll() {
        return categoryValueRepository.findAll();
    }

    @Override
    public Optional<CategoryValue> findById(Integer id) {
        return categoryValueRepository.findById(id);
    }



    @Override
    public void save(CategoryValue categoryValue) {
         categoryValueRepository.save(categoryValue);
    }

    @Override
    public void delete(Integer id) {
        categoryValueRepository.deleteById(id);
    }

    @Override
    public Optional<CategoryValue> findByCategory(Integer categoryId) {
        return categoryValueRepository.findByCategory_id(categoryId);
    }

    @Override
    public List<CategoryValue> findAllByNameContatining(String name) {
        return null;
    }
}
