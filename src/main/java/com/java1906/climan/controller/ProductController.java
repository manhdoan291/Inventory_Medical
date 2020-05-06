package com.java1906.climan.controller;

import com.java1906.climan.data.model.Product;
import com.java1906.climan.interceptor.HasRole;
import com.java1906.climan.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
	
	@Autowired
	private IProductService productService;

	//Get all product
	@GetMapping("/product/list")
	@HasRole({"USER", "ADMIN"})
	public ResponseEntity<List<Product>> showProductList() {
		List<Product> productList = (List<Product>) productService.getAll();
		if (productList.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}

	//Get product by id
	@GetMapping("/product/{id}")
	@HasRole({"USER", "ADMIN"})
	public ResponseEntity<Object> getProductById(@PathVariable("id") Long id) {
		System.out.println("Fetching product with id " + id);
		Product product = productService.get(id);
		if (product  == null){
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(product ,HttpStatus.OK);
	}

	// Create product
	@PostMapping("/product/save")
	@HasRole({"USER", "ADMIN"})
	public ResponseEntity<String> createProduct(@RequestBody Product product ) {
		if(product == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		productService.post(product);
		return new ResponseEntity<>("created!", HttpStatus.CREATED);
	}

	// Update product
	@PutMapping("/product/update/{id}")
	@HasRole({"USER", "ADMIN"})
	public ResponseEntity<String> updateProduct(@PathVariable("id") Long id,
												 @RequestBody Product product){
		System.out.println("Updating product " + id);
		Product currentProduct = productService.put(product, id);
		if (currentProduct == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		productService.post(product);
		return new ResponseEntity<>("Updated!", HttpStatus.OK);
	}

	// Delete product
	@DeleteMapping("/product/delete/{id}")
	@HasRole({"USER", "ADMIN"})
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
		Product product = productService.get(id);
		if(product == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		productService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
