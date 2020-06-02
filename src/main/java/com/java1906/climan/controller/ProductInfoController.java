package com.java1906.climan.controller;

import com.java1906.climan.data.model.Category;
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
    public ResponseEntity<String> createProduct(@RequestBody ProductInfo productInfo) {
        productInfoService.save(productInfo);
        return new ResponseEntity<>("created!", HttpStatus.CREATED);
    }
    // Update product
    @PutMapping("/product/{id}")
    @HasRole({"STAFF", "ADMIN", "DOCTOR"})
    public ResponseEntity<ProductInfo> updateProduct(@PathVariable("id") Integer id,
                                                     @RequestBody ProductInfo product) {
        Optional<ProductInfo> productInfo1 = productInfoService.findById(id);
        if (!productInfo1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        productInfo1.get().setId(id);
//        productInfo1.get().setId(id);
//        return new ResponseEntity<>("Updated!", HttpStatus.OK);
        return null;
    }

    // Delete product
    @DeleteMapping("/product/{id}")
    @HasRole({"STAFF", "ADMIN", "DOCTOR"})
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id) {
        Optional<ProductInfo> productInfo = productInfoService.findById(id);
        if (!productInfo.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productInfoService.delete(id);
        return new ResponseEntity<String>("delete_ok",HttpStatus.OK);
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
