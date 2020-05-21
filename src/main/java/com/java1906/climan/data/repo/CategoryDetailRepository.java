package com.java1906.climan.data.repo;

import com.java1906.climan.data.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDetailRepository extends CrudRepository<Category, Integer> {
    
}
