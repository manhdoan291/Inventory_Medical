package com.java1906.climan.controller;

import com.java1906.climan.data.model.Category;
import com.java1906.climan.data.model.Customer;
import com.java1906.climan.interceptor.HasRole;
import com.java1906.climan.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    //get all customer
    @GetMapping("/customer")
    @CrossOrigin(origins = "http://locahost:4200")
    @HasRole({"STAFF","ADMIN"})
    public ResponseEntity<List<Customer>> showCustomerList(){
        return new ResponseEntity<List<Customer>>(customerService.getAll(), HttpStatus.OK);
    }
    //get customer by  id
    @GetMapping("/customer/{customerId}")
    @HasRole({"STAFF","ADMIN"})
    public ResponseEntity<Object> getCustomerById(@PathVariable("customerId") int customerId) {
        return new ResponseEntity<>(customerService.findById(customerId),HttpStatus.OK);
}
    // Create customer
    @PostMapping("/customer")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

        return new ResponseEntity<Customer>(customerService.save(customer),HttpStatus.CREATED);
    }
    // Update customer
    @PutMapping("/customer/{customerId}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") Integer customerId,
                                                   @RequestBody Customer customer) throws Exception {
        return new ResponseEntity<Customer>(customerService.update(customerId,customer),HttpStatus.NOT_FOUND);
    }
    // Delete category
    @DeleteMapping("/customer/{customerId}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<String> deleteCategory(@PathVariable("customerId") Integer customerId) {
        customerService.delete(customerId);
        return new ResponseEntity<String>("delete_ok",HttpStatus.OK);
    }
}
