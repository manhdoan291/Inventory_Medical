package com.java1906.climan.data.repo;


import com.java1906.climan.data.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
}
