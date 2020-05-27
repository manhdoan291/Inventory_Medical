package com.java1906.climan.services.impl;


import com.java1906.climan.data.model.ProductInfo;
import com.java1906.climan.data.repo.ProductRepository;
import com.java1906.climan.exception.LogicException;
import com.java1906.climan.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductInfo get(long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<ProductInfo> getAll() {
        return (List<ProductInfo>) productRepository.findAll();
    }

    @Override
    public ProductInfo save(ProductInfo product) {
        return productRepository.save(product);

    }

    @Override
    public ProductInfo update(ProductInfo product, long id) throws Exception {
        Optional<ProductInfo> optionalUpdatingProduct = productRepository.findById(id);
        if (!optionalUpdatingProduct.isPresent()) {
            throw new LogicException("Product khong ton tai", HttpStatus.NOT_FOUND);
        }
        ProductInfo updatingProduct = optionalUpdatingProduct.get();
        if (null != product.getName())
            updatingProduct.setName(product.getName());
        if (null != product.getDescription())
            updatingProduct.setDescription(product.getDescription());
        if (null != product.getActiveFlag())
            updatingProduct.setActiveFlag(product.getActiveFlag());
        if (null != product.getImg_url())
            updatingProduct.setImg_url(product.getImg_url());
        return productRepository.save(updatingProduct);
    }

    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }

}
