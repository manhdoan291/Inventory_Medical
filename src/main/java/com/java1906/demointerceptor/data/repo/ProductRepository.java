package com.java1906.demointerceptor.data.repo;


import com.java1906.demointerceptor.data.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
}
