package com.java1906.demointerceptor.controller;


import com.java1906.demointerceptor.models.Product;
import com.java1906.demointerceptor.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
	
	@Autowired
	IProductService bicycleService;
	
	@GetMapping("/bicycles")
	public List<Product> getAllBicycles(){
		return bicycleService.getAll();
	}
	
	@GetMapping("/bicycle/{id}")
	public Product getOne(@PathVariable(value = "id") long id) {
		return bicycleService.get(id);
	}
	
	@PostMapping("/bicycle")
	public void add(Product product) {
		bicycleService.post(product);
	}
	
	@PutMapping("/bicycle/{id}")
	public void update(Product product, @PathVariable(value = "id") long id) {
		bicycleService.put(product, id);
	}
	
	@DeleteMapping("/bicycle/{id}")
	public void update(@PathVariable(value = "id") long id) {
		bicycleService.delete(id);
	}
}
