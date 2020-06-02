package com.java1906.climan.services.impl;


import com.java1906.climan.data.model.ProductInfo;
import com.java1906.climan.data.repo.ProductInfoRepository;
import com.java1906.climan.exception.LogicException;
import com.java1906.climan.services.IProducInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProductServiceImpl implements IProducInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Override
    public Iterable<ProductInfo> finAllProduct() {
        return productInfoRepository.findAll();
    }

    @Override
    public Optional<ProductInfo> findById(int id) {
        return productInfoRepository.findById(id);
    }

    @Override
    public void save(ProductInfo productInfo) {
        productInfoRepository.save(productInfo);
    }

    @Override
    public void update(ProductInfo product) {
    }

    @Override
    public void delete(int id) {
        productInfoRepository.deleteById(id);
    }

}
