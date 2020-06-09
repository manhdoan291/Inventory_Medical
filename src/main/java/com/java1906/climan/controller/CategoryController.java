package com.java1906.climan.controller;

import com.java1906.climan.data.model.Category;
import com.java1906.climan.interceptor.HasRole;
import com.java1906.climan.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    //Get all category
    @GetMapping("/category")
    @CrossOrigin(origins = "http://localhost:4200")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<List<Category>> showCategoryList() {
         return new ResponseEntity<>(categoryService.getAll(),HttpStatus.OK);

    }

    //Get category by id
    @GetMapping("/category/{categoryId}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<Object> getCategoryById(@PathVariable("categoryId") int categoryId) {
    return new ResponseEntity<>(categoryService.findById(categoryId),HttpStatus.OK);
    }

    // Create category
    @PostMapping("/category")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {

        return new ResponseEntity<Category>(categoryService.save(category),HttpStatus.CREATED);
    }
    // Update category
    @PutMapping("/category/{categoryId}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<Category> updateCategory(@PathVariable("categoryId") Integer categoryId,
                                                 @RequestBody Category category) throws Exception {
            return new ResponseEntity<Category>(categoryService.update(categoryId,category),HttpStatus.NOT_FOUND);
    }

    // Delete category
    @DeleteMapping("/category/{categoryId}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<String> deleteCategory(@PathVariable("categoryId") Integer categoryId) {
        categoryService.delete(categoryId);
        return new ResponseEntity<String>("delete_ok",HttpStatus.OK);
    }
}
