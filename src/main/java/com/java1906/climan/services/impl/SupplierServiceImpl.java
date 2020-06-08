package com.java1906.climan.services.impl;

import com.java1906.climan.controller.ResourceNotFoundException;
import com.java1906.climan.data.model.Category;
import com.java1906.climan.data.model.Supplier;
import com.java1906.climan.data.repo.SupplierRepository;
import com.java1906.climan.services.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class SupplierServiceImpl implements ISupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Optional<Supplier> findById(Integer id) {
        if(!supplierRepository.existsById(id)){
            try{
                throw new ResourceNotFoundException("Supplier with"+id+"not found");
            }catch(ResourceNotFoundException e){
                e.printStackTrace();
            }

        }
        return supplierRepository.findById(id);
    }

    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier update(int supplierId, Supplier supplier) throws Exception {
        if (!supplierRepository.existsById(supplierId)) {
            try {
                throw new ResourceNotFoundException("Supplier with id " + supplierId + " not found");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        Optional<Supplier> supplierOne =supplierRepository.findById(supplierId);

        if (!supplierOne.isPresent()) {
            try {
                throw new ResourceNotFoundException("Supplier with id " + supplierId + " not found");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        Supplier supplier1 = supplierOne.get();
        return supplierRepository.save(supplier1);
    }

    @Override
    public void delete(Integer supplierId) {
        if (!supplierRepository.existsById(supplierId)) {
            try {
                throw new ResourceNotFoundException("Supplier with id " + supplierId + " not found");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        supplierRepository.deleteById(supplierId);
    }
}
