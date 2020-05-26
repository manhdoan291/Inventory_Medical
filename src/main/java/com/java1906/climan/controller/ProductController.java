package com.java1906.climan.controller;

import com.java1906.climan.data.model.Product;
import com.java1906.climan.data.repo.CategoryDetailRepository;
import com.java1906.climan.interceptor.HasRole;
import com.java1906.climan.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private CategoryDetailRepository categoryDetailRepository;

    //Get all product
    @GetMapping("/product")
    @HasRole({"STAFF", "ADMIN", "DOCTOR"})
    public ResponseEntity<List<Product>> showProductList() {
        List<Product> productList = productService.getAll();
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    //Get product by id
    @GetMapping("/product/{id}")
    @HasRole({"STAFF", "ADMIN", "DOCTOR"})
    public ResponseEntity<Object> getProductById(@PathVariable("id") Long id) {
        System.out.println("Fetching product with id " + id);
        Product product = productService.get(id);
        if (product == null) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(product, HttpStatus.OK);
    }

    // Create product
    @PostMapping("/product")
    @HasRole({"STAFF", "ADMIN", "DOCTOR"})
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        productService.save(product);
        return new ResponseEntity<>("created!", HttpStatus.CREATED);


    }

    // Update product
    @PutMapping("/product/{id}")
    @HasRole({"STAFF", "ADMIN", "DOCTOR"})
    public ResponseEntity<String> updateProduct(@PathVariable("id") Long id,
                                                @RequestBody Product product) {
        System.out.println("Updating product " + id);
        Product currentProduct = productService.get(id);
        if (currentProduct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.save(product);
        return new ResponseEntity<>("Updated!", HttpStatus.OK);
    }

    // Delete product
    @DeleteMapping("/product/{id}")
    @HasRole({"STAFF", "ADMIN", "DOCTOR"})
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
        Product product = productService.get(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @HasRole({"STAFF", "ADMIN", "DOCTOR"})
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        File convertFile = new File("./uploadfolder/image/" + file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
    }
}
