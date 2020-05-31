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
        List<Category> categoryList = (List<Category>) categoryService.getAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    //Get category by id
    @GetMapping("/category/{id}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<Object> getCategoryById(@PathVariable("id") int id) {
        System.out.println("Fetching category with id " + id);
        Optional<Category> category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(category, HttpStatus.OK);
    }

    // Create category
    @PostMapping("/category")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<String> createCategory(@RequestBody Category category , UriComponentsBuilder uriComponentsBuilder) {
        categoryService.save(category);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/categories/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<String>(headers,HttpStatus.CREATED);
    }

    // Update category
    @PutMapping("/category/{id}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Integer id,
                                                 @RequestBody Category category) {
        System.out.println("Updating Category " + id);
        Optional<Category> categorys = categoryService.findById(id);
        if (!categorys.isPresent()) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        categorys.get().setName(category.getName());
        categorys.get().setDescription(category.getDescription());
        categorys.get().setCreateDate(category.getCreateDate());
        categorys.get().setUpdateDate(category.getUpdateDate());
        categoryService.save(category);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    // Delete category
    @DeleteMapping("/category/{id}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") Integer id) {
        Optional<Category> category = categoryService.findById(id);
        if (!category.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
