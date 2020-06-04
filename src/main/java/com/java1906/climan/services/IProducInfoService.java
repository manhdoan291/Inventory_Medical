package com.java1906.climan.services;


import com.java1906.climan.data.model.ProductInfo;

import java.util.Optional;

public interface IProducInfoService {
    Iterable<ProductInfo> finAllProduct();

    Optional<ProductInfo> findById(int id);

    public ProductInfo save(ProductInfo product);

    public ProductInfo update(ProductInfo product);

    String delete(int id);


}
