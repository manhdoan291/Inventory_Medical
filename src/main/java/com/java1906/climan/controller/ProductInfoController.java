package com.java1906.climan.controller;

import com.java1906.climan.data.model.CategoryValue;
import com.java1906.climan.data.model.ProductInfo;
import com.java1906.climan.data.repo.CategoryValueRepository;
import com.java1906.climan.interceptor.HasRole;
import com.java1906.climan.services.IProducInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
class ProductInfoController {

    @Autowired
    private IProducInfoService productInfoService;

    @Autowired
    private CategoryValueRepository categoryDetailRepository;

    //Get all product
    @GetMapping("/product")
    @HasRole({"STAFF", "ADMIN", "DOCTOR"})
    public ResponseEntity<Iterable<ProductInfo>> showProductList() {
        Iterable<ProductInfo> productList = productInfoService.finAllProduct();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    // Create product
    @PostMapping("/product")
    @HasRole({"STAFF", "ADMIN", "DOCTOR"})
    public ResponseEntity<ProductInfo> createProduct(@RequestBody ProductInfo productInfo) {

        ProductInfo prductInfo = productInfoService.save(productInfo);
        return new ResponseEntity<ProductInfo>(prductInfo, HttpStatus.CREATED);
    }

    // Update product
    @PutMapping("/product")
    @HasRole({"STAFF", "ADMIN", "DOCTOR"})
    public ResponseEntity<ProductInfo> updateProduct(
            @RequestBody ProductInfo product) {
        ProductInfo productInfo1 = productInfoService.update(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    // Delete product
    @DeleteMapping("/product")
    @HasRole({"STAFF", "ADMIN", "DOCTOR"})
    public ResponseEntity<String> deleteProduct(@RequestParam Integer id) {
        String message = productInfoService.delete(id);
        return new ResponseEntity<String>(message, HttpStatus.OK);
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
