package com.java1906.climan.data.repo;

import com.java1906.climan.data.model.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvocieRepository extends CrudRepository<Invoice, Integer> {
}
