package com.java1906.demointerceptor.data.repo;

import com.java1906.demointerceptor.data.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, String> {
    public Optional<Category> findCategoryById(int id);
    public List<Optional<Category>> findAllBy();
    public Optional<Category> save(Category category);
    public Optional<Category> edit(Category category);
    public Optional<Category> deleteById(int id);
}
