package com.java1906.climan.controller;

import com.java1906.climan.data.model.Category;
import com.java1906.climan.data.model.Supplier;
import com.java1906.climan.interceptor.HasRole;
import com.java1906.climan.services.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierController {
    @Autowired
    private ISupplierService supplierService;
    //Get all suppleir
    @GetMapping("/supplier")
    @CrossOrigin(origins = "http://localhost:4200")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<List<Supplier>> showSupplierList() {
        return new ResponseEntity<>(supplierService.getAll(), HttpStatus.OK);
    }
    //Get supplier by id
    @GetMapping("/supplier/{supplierId}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<Object> getCategoryById(@PathVariable("supplierId") int supplierId) {
        return new ResponseEntity<>(supplierService.findById(supplierId),HttpStatus.OK);
    }
    // Create supplier
    @PostMapping("/supplier")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {

        return new ResponseEntity<Supplier>(supplierService.save(supplier),HttpStatus.CREATED);
    }
    // Update supplier
    @PutMapping("/supplier/{supplierId}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<Supplier> updateSupplier(@PathVariable("supplierId") Integer supplierId,
                                                   @RequestBody Supplier supplier) throws Exception {
        return new ResponseEntity<Supplier>(supplierService.update(supplierId,supplier),HttpStatus.NOT_FOUND);
    }
    // Delete category
    @DeleteMapping("/supplier/{supplierId}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<String> deleteCategory(@PathVariable("supplierId") Integer supplierId) {
        supplierService.delete(supplierId);
        return new ResponseEntity<String>("delete_ok",HttpStatus.OK);
    }
}
