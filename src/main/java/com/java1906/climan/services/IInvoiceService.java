package com.java1906.climan.services;

import com.java1906.climan.data.model.Invoice;

import java.util.List;
import java.util.Optional;

public interface IInvoiceService {
    public Optional<Invoice> get(Integer id);
    public List<Invoice> getAll();
}
