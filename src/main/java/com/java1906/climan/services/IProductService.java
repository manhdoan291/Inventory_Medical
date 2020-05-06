package com.java1906.climan.services;


import com.java1906.climan.data.model.Product;

import java.util.List;

public interface IProductService {
	public Product get(long id);
	public List<Product> getAll();
	public void post(Product product);
	public Product put(Product product, long id);
	public void delete(long id);
}
