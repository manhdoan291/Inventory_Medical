package com.java1906.climan.services;
import com.java1906.climan.data.model.Supplier;

import java.util.List;
import java.util.Optional;

public interface ISupplierService {
    List<Supplier> getAll();

    Optional<Supplier> findById(Integer id);

    Supplier  save(Supplier supplier);

    Supplier update(int supplierId , Supplier supplier) throws Exception;

    void delete(Integer supplierId);
}
