package com.java1906.climan.services.impl;

import com.java1906.climan.data.model.CategoryValue;
import com.java1906.climan.data.repo.CategoryValueRepository;
import com.java1906.climan.exception.LogicException;
import com.java1906.climan.services.ICategoryValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryValueServiceImpl implements ICategoryValueService {
    @Autowired
    private CategoryValueRepository categoryDetailRepository;

    @Override
    public CategoryValue get(Integer id) {
        return categoryDetailRepository.findById(id).get();
    }

    @Override
    public List<CategoryValue> getAll() {
        return (List<CategoryValue>) categoryDetailRepository.findAll();
    }

    @Override
    public CategoryValue save(CategoryValue categoryDetail) {


        return categoryDetailRepository.save(categoryDetail);
    }

    @Override
    public CategoryValue update(CategoryValue categoryDetail, Integer id) throws Exception {
        Optional<CategoryValue> optionalUpdatingCategoryDetail = categoryDetailRepository.findById(id);
        if (!optionalUpdatingCategoryDetail.isPresent()) {
            throw new LogicException("Category Detail khong ton tai", HttpStatus.NOT_FOUND);
        }
        CategoryValue updatingCategoryDetail = optionalUpdatingCategoryDetail.get();
        if (null != categoryDetail.getName()) {
            updatingCategoryDetail.setName(categoryDetail.getName());
        }
        if (null != categoryDetail.getDescription()) {
            updatingCategoryDetail.setDescription(categoryDetail.getDescription());
        }

        return categoryDetailRepository.save(updatingCategoryDetail);

    }

    @Override
    public void delete(Integer id) {
        categoryDetailRepository.deleteById(id);
    }
}
