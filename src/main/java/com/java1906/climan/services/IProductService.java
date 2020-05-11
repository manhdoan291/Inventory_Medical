package com.java1906.climan.services;


import com.java1906.climan.data.model.Product;
import com.java1906.climan.exception.LogicException;

import java.util.List;

public interface IProductService {
	public Product get(long id);
	public List<Product> getAll();
	public Product save(Product product);
	public Product update(Product product, long id) throws Exception;
	public void delete(long id);
}
