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
    public Category get(Integer id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public List<Category> getAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category, Integer id) throws Exception {
        Optional<Category> optionalUpdatingCategory = categoryRepository.findById(id);
        if (!optionalUpdatingCategory.isPresent()) {
            throw new LogicException("Category khong ton tai", HttpStatus.NOT_FOUND);
        }
        Category updatingCategory = optionalUpdatingCategory.get();
        if (null != category.getName())
            updatingCategory.setName(category.getName());
        if (null != category.getDescription())
            updatingCategory.setDescription(category.getDescription());
        return categoryRepository.save(updatingCategory);
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
