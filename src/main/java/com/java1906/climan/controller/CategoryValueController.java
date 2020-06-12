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
            return new ResponseEntity <List<CategoryValue>>(categoryValueService.findAll(),HttpStatus.OK);

    }
//GET ById
    @GetMapping("/{id}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<Object> getCategoryValueById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(categoryValueService.findById(id),HttpStatus.OK);
    }


//    // Create categoryvalue
    @PostMapping("category/{categoryId}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<CategoryValue> createCategoryValue(@PathVariable(value = "categoryId") Integer categoryId, @RequestBody CategoryValue categoryValue)   {
        return new ResponseEntity<>(categoryValueService.save(categoryId,categoryValue),HttpStatus.OK);
    }

    // Update category value
    @PutMapping("/{categoryValueId}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<CategoryValue> updateCategoryDetail(@PathVariable("categoryValueId") Integer categoryValueId,
                                                              @RequestBody CategoryValue categoryValue) {
        return new ResponseEntity<CategoryValue>(categoryValueService.update(categoryValueId,categoryValue), HttpStatus.OK);
    }

    // Delete category value
    @DeleteMapping("/{categoryValueId}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<String> deleteCategoryDetail(@PathVariable("categoryValueId") Integer categoryValueId) {
        categoryValueService.delete(categoryValueId);
        return new ResponseEntity<String>("Delete Ok",HttpStatus.OK);
    }
}
