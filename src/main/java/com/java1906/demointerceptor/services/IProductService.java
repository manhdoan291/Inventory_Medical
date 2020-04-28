package com.java1906.demointerceptor.services;


import com.java1906.demointerceptor.models.Product;

import java.util.List;

public interface IProductService {
	public Product get(long id);
	public List<Product> getAll();
	public void post(Product product);
	public void put(Product product, long id);
	public void delete(long id);
}
