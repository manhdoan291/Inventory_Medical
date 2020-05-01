package com.java1906.demointerceptor.controller;

import com.java1906.demointerceptor.data.model.Category;
import com.java1906.demointerceptor.data.repo.CategoryRepository;
import com.java1906.demointerceptor.interceptor.HasRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    //Get all category
    @GetMapping("/category/list")
    @HasRole({"USER", "ADMIN"})
    public ResponseEntity<List<Category>> showCategoryList() {
        List<Category> categoryList = (List<Category>) categoryRepository.findAll();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    //Get category by id
    @GetMapping("/category/{id}")
    @HasRole({"USER", "ADMIN"})
    public ResponseEntity<Object> getCategoryById(@PathVariable("id") Integer id) {
        System.out.println("Fetching category with id " + id);
        Optional<Category> category = categoryRepository.findById(id);
        if (category == null){
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(category,HttpStatus.OK);
    }

    // Create category
    @PostMapping("/category/save")
    @HasRole({"USER", "ADMIN"})
    public ResponseEntity<String> createCategory(@RequestBody Category category ) {
        if(category == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        categoryRepository.save(category);
        return new ResponseEntity<>("created!", HttpStatus.CREATED);
    }

    // Update category
    @PutMapping("/category/update/{id}")
    @HasRole({"USER", "ADMIN"})
    public ResponseEntity<String> updateCategory(@PathVariable("id") Integer id,
                                                   @RequestBody Category category){
        System.out.println("Updating Category " + id);
        Optional<Category> currentCategory = categoryRepository.findById(id);
        if (currentCategory == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryRepository.save(category);
        return new ResponseEntity<>("Updated!", HttpStatus.OK);
    }

    // Delete category
    @DeleteMapping("/category/delete/{id}")
    @HasRole({"USER", "ADMIN"})
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
