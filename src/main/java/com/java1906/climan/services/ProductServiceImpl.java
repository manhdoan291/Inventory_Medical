package com.java1906.climan.services;


import com.java1906.climan.data.model.Product;
import com.java1906.climan.data.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
	public void put(Product product, long id) {
		productRepository.findById(id).ifPresent((x)->{
			product.setId(id);
			productRepository.save(product);
		});
	}

	@Override
	public void delete(long id) {
		productRepository.deleteById(id);
	}

}
