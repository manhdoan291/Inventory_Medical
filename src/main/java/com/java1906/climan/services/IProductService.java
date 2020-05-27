package com.java1906.climan.services;


import com.java1906.climan.data.model.ProductInfo;

import java.util.List;

public interface IProductService {
    public ProductInfo get(long id);

    public List<ProductInfo> getAll();

    public ProductInfo save(ProductInfo product);

    public ProductInfo update(ProductInfo product, long id) throws Exception;

    public void delete(long id);
}
