package com.java1906.climan.controller;

import com.java1906.climan.data.model.Category;
import com.java1906.climan.data.model.CategoryValue;
import com.java1906.climan.interceptor.HasRole;
import com.java1906.climan.services.ICategoryService;
import com.java1906.climan.services.ICategoryValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoryValue")
public class CategoryValueController {
    @Autowired
    private ICategoryValueService categoryValueService;

    @Autowired
    private ICategoryService   categoryService;

    //Get all category
    @GetMapping("")
    @CrossOrigin(origins = "http://localhost:4200")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<List<CategoryValue>> showCategoryValueList() {
        List<CategoryValue> categoryValueList = (List<CategoryValue>) categoryValueService.findAll();
        if (categoryValueList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryValueList, HttpStatus.OK);
    }

    //trả cho  sever list của  category
    @GetMapping("/category/{id}")
    public ResponseEntity<List<CategoryValue>> listCategoryValueByCategory(@PathVariable Integer id){
        List<CategoryValue> categoryValueList = categoryValueService.findAllByCategory(id);
        if(categoryValueList.isEmpty()){
            return new ResponseEntity<List<CategoryValue>>(categoryValueList,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CategoryValue>>(categoryValueList,HttpStatus.OK);
    }


    // Create categoryvalue
    @PostMapping("/{id}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<String> createCategoryValue(@PathVariable("id") Integer id ,@RequestBody CategoryValue categoryValue) {
        Optional<CategoryValue> categoryValue1 = categoryValueService.findById(id);
        if (!categoryValue1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryValueService.save(categoryValue);
        return new ResponseEntity<>("created!", HttpStatus.CREATED);
    }

    // Update category detail
    @PutMapping("/{id}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<CategoryValue> updateCategoryDetail(@PathVariable("id") Integer id,
                                                       @RequestBody CategoryValue categoryValue) {
        System.out.println("Updating Category Value " + id);
        Optional<CategoryValue> categoryValue1 = categoryValueService.findById(id);
        if (!categoryValue1.isPresent()) {
            return new ResponseEntity<CategoryValue>(HttpStatus.NOT_FOUND);
        }
        categoryValueService.save(categoryValue);
        return new ResponseEntity<CategoryValue>(categoryValue, HttpStatus.OK);
    }

    // Delete category value
    @DeleteMapping("/categoryDetail/{id}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<CategoryValue> deleteCategoryDetail(@PathVariable("id") Integer id) {
        Optional<CategoryValue> categoryValue = categoryValueService.findById(id);
        if (!categoryValue.isPresent()) {
            return new ResponseEntity<CategoryValue>(HttpStatus.NOT_FOUND);
        }
        categoryValueService.delete(id);
        return new ResponseEntity<CategoryValue>(HttpStatus.NO_CONTENT);
    }
}
