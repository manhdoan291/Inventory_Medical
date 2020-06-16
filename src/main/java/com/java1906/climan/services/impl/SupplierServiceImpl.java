package com.java1906.climan.services.impl;

import com.java1906.climan.data.model.Supplier;
import com.java1906.climan.data.repo.SupplierRepository;
import com.java1906.climan.services.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SupplierServiceImpl implements ISupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Optional<Supplier> findById(int supplierId) {
        return supplierRepository.findById(supplierId);
    }
}
