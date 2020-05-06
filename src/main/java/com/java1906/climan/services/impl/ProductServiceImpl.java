package com.java1906.climan.services.impl;


import com.java1906.climan.data.model.Product;
import com.java1906.climan.data.repo.ProductRepository;
import com.java1906.climan.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product get(long id) {
		return productRepository.findById(id).get();
	}

	@Override
	public List<Product> getAll() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public void post(Product product) {
		productRepository.save(product);

	}

	@Override
	public Product put(Product product, long id) {
		productRepository.findById(id).ifPresent((x)->{
			product.setId(id);
			productRepository.save(product);
		});
        return product;
    }

	@Override
	public void delete(long id) {
		productRepository.deleteById(id);
	}

}
