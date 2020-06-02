package com.java1906.climan.services;


import com.java1906.climan.data.model.ProductInfo;

import java.util.List;
import java.util.Optional;

public interface IProducInfoService {
    public Iterable<ProductInfo> finAllProduct();
    Optional<ProductInfo> findById(int id);
    void  save(ProductInfo product);
    void  update(ProductInfo product);
     void delete(int id);
}
