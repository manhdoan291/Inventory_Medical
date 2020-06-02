package com.java1906.climan.controller;

import com.java1906.climan.data.model.Category;
import com.java1906.climan.data.model.CategoryValue;
import com.java1906.climan.interceptor.HasRole;
import com.java1906.climan.services.ICategoryService;
import com.java1906.climan.services.ICategoryValueService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RequestMapping("/categoryValue")
@RestController
public class CategoryValueController {
    @Autowired
    private ICategoryValueService categoryValueService;

    @Autowired
    private ICategoryService categoryService;

    //Get all category
    @GetMapping("")
    @CrossOrigin(origins = "http://localhost:4200")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity <List<CategoryValue>> showCategoryValueList() {
        List<CategoryValue> categoryValueList = (List<CategoryValue>) categoryValueService.findAll();
        if (categoryValueList.isEmpty()) {
            return new ResponseEntity <List<CategoryValue>>(categoryValueList,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CategoryValue>>(categoryValueList,HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<CategoryValue>> listAllCategoryValueByCategory(@PathVariable Integer categoryid) {
        Optional<CategoryValue> categoryValues = categoryValueService.findByCategory(categoryid);
        if (categoryValues.isPresent()) {
            return new ResponseEntity<List<CategoryValue>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CategoryValue>>(HttpStatus.OK);
    }


//    // Create categoryvalue
    @PostMapping("category/{categoryId}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<Optional<CategoryValue>> createCategoryValue(@PathVariable(value = "categoryId") Integer categoryId, @RequestBody CategoryValue categoryValue)   {
        Optional<Category> category = categoryService.findById(categoryId);
//        Category category = categoryValue.getCategory();
        categoryValue.setCategory(category.get());
            categoryValueService.save(categoryValue);
    return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Update category detail
    @PutMapping("/{id}/{category_id}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<CategoryValue> updateCategoryDetail(@PathVariable("id") Integer id, @PathVariable("category_id") Integer category_id,
                                                              @RequestBody CategoryValue categoryValue) {
        Optional<Category> category = categoryService.findById(category_id);
        Optional<CategoryValue> categoryValue1 = categoryValueService.findById(id);
        if (!categoryValue1.isPresent()) {
            return new ResponseEntity<CategoryValue>(HttpStatus.NOT_FOUND);
        }
        categoryValue1.get().setName(categoryValue.getName());
        categoryValue1.get().setActiveFlag(categoryValue.getActiveFlag());
        categoryValue1.get().setDescription(categoryValue.getDescription());
        categoryValue1.get().setCategory(category.get());
        categoryValue1.get().setUpdateDate(categoryValue.getUpdateDate());
        categoryValueService.save(categoryValue1.get());
        return new ResponseEntity<CategoryValue>(categoryValue, HttpStatus.OK);
    }

    // Delete category value
    @DeleteMapping("/{id}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<String> deleteCategoryDetail(@PathVariable("id") Integer id) {
        Optional<CategoryValue> categoryValue = categoryValueService.findById(id);
        if (!categoryValue.isPresent()) {
            return new ResponseEntity<String>("Lỗi",HttpStatus.NOT_FOUND);
        }
        categoryValueService.delete(id);
        return new ResponseEntity<String>("Delete Ok",HttpStatus.OK);
    }
}
