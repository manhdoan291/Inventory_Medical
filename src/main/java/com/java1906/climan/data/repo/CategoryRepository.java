package com.java1906.climan.data.repo;

import com.java1906.climan.data.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
