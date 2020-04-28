package com.java1906.demointerceptor.dao;


import com.java1906.demointerceptor.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductDao extends CrudRepository<Product, Long> {
	
}
