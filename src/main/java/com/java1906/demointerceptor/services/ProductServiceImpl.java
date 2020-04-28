package com.java1906.demointerceptor.services;

import com.java1906.demointerceptor.dao.IProductDao;
import com.java1906.demointerceptor.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDao bicycleDao;

	@Override
	public Product get(long id) {
		return bicycleDao.findById(id).get();
	}

	@Override
	public List<Product> getAll() {
		return (List<Product>) bicycleDao.findAll();
	}

	@Override
	public void post(Product product) {
		bicycleDao.save(product);

	}

	@Override
	public void put(Product product, long id) {
		bicycleDao.findById(id).ifPresent((x)->{
			product.setId(id);
			bicycleDao.save(product);
		});
	}

	@Override
	public void delete(long id) {
		bicycleDao.deleteById(id);
	}

}
