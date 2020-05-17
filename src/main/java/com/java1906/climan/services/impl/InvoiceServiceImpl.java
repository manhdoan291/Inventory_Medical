package com.java1906.climan.services.impl;

import com.java1906.climan.data.model.Invoice;
import com.java1906.climan.data.repo.InvocieRepository;
import com.java1906.climan.services.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class InvoiceServiceImpl implements IInvoiceService {
    @Autowired
    private InvocieRepository invocieRepository;

    @Override
    public Optional<Invoice> get(Integer id) {
        return invocieRepository.findById(id);
    }

    @Override
    public List<Invoice> getAll() {
        return (List<Invoice>) invocieRepository.findAll();
    }
}
