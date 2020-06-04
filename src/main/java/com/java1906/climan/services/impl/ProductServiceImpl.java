package com.java1906.climan.services.impl;


import com.java1906.climan.data.model.CategoryValue;
import com.java1906.climan.data.model.ProductInfo;
import com.java1906.climan.data.repo.CategoryValueRepository;
import com.java1906.climan.data.repo.ProductInfoRepository;
import com.java1906.climan.services.IProducInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class ProductServiceImpl implements IProducInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Autowired
    private CategoryValueRepository categoryValueRepository;

    @Override
    public Iterable<ProductInfo> finAllProduct() {
        return productInfoRepository.findAll();
    }

    @Override
    public Optional<ProductInfo> findById(int id) {
        return productInfoRepository.findById(id);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
      return  productInfoRepository.save(productInfo);
    }

    @Override
    public ProductInfo update(ProductInfo productInfo) {
        ProductInfo pInfo = productInfoRepository.getOne(productInfo.getId());
        if(null !=pInfo){
            pInfo =productInfo;
            return  productInfoRepository.save(pInfo);
        }else{
            return null;
        }
    }

    @Override
    public String delete(int id) {
        productInfoRepository.deleteById(id);
        return "ProductInfo" +id +"deleted successfully!";
    }


}
