package com.java1906.climan.services.impl;

import com.java1906.climan.data.model.CategoryDetail;
import com.java1906.climan.data.repo.CategoryDetailRepository;
import com.java1906.climan.exception.LogicException;
import com.java1906.climan.services.ICategoryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryDetailServiceImpl implements ICategoryDetailService {
    @Autowired
    private CategoryDetailRepository categoryDetailRepository;

    @Override
    public CategoryDetail get(Integer id) {
        return categoryDetailRepository.findById(id).get();
    }

    @Override
    public List<CategoryDetail> getAll() {
        return (List<CategoryDetail>) categoryDetailRepository.findAll();
    }

    @Override
    public CategoryDetail save(CategoryDetail categoryDetail) {


        return categoryDetailRepository.save(categoryDetail);
    }

    @Override
    public CategoryDetail update(CategoryDetail categoryDetail, Integer id) throws Exception {
        Optional<CategoryDetail> optionalUpdatingCategoryDetail= categoryDetailRepository.findById(id);
        if (!optionalUpdatingCategoryDetail.isPresent()) {
            throw new LogicException("Category Detail khong ton tai", HttpStatus.NOT_FOUND);
        }
        CategoryDetail updatingCategoryDetail = optionalUpdatingCategoryDetail.get();
        if ( null!=categoryDetail.getName() )
        {
            updatingCategoryDetail.setName(categoryDetail.getName());
        }
        if ( null!=categoryDetail.getDescription())
        {
            updatingCategoryDetail.setDescription(categoryDetail.getDescription());
        }
        if ( null!=categoryDetail.getCategory())
        {
            updatingCategoryDetail.setCategory(categoryDetail.getCategory());
        }
        return categoryDetailRepository.save(updatingCategoryDetail);
        
    }

    @Override
    public void delete(Integer id) {
        categoryDetailRepository.deleteById(id);
    }
}
