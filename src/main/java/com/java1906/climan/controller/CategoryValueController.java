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
    public ResponseEntity<List<CategoryValue>> showCategoryList() {
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
        return new ResponseEntity<List<CategoryValue>>(categoryValueList,HttpStatus.OK);
    }

    //Get category by id
    @GetMapping("/{id}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<Object> getCategoryValueById(@PathVariable("id") Integer id) {
        System.out.println("Fetching category value with id " + id);
        Optional<CategoryValue> categoryValue = categoryValueService.findById(id);
        if (categoryValue == null) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(categoryValue, HttpStatus.OK);
    }

    // Create category
    @PostMapping("/")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<String> createCategoryValue(@RequestBody CategoryValue categoryValue) {
        List<Category> categories =new ArrayList<>();
        if (categoryValue == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // lấy đc id của thg cha: category
        // set id vừa lấy, vào category_id của categoryDetail.

        categoryValueService.save(categoryValue);
        return new ResponseEntity<>("created!", HttpStatus.CREATED);
    }

    // Update category detail
    @PutMapping("/categoryDetail/{id}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<String> updateCategoryDetail(@PathVariable("id") Integer id,
                                                       @RequestBody CategoryValue categoryDetail) {
        System.out.println("Updating Category Detail " + id);
        Optional<CategoryValue> currentCategoryDetail = categoryValueService.findById(id);
        if (currentCategoryDetail == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryValueService.save(categoryDetail);
        return new ResponseEntity<>("Updated!", HttpStatus.OK);
    }

    // Delete category detail
    @DeleteMapping("/categoryDetail/{id}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<CategoryValue> deleteCategoryDetail(@PathVariable("id") Integer id) {
        Optional<CategoryValue> categoryDetail = categoryValueService.findById(id);
        if (categoryDetail == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryValueService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
