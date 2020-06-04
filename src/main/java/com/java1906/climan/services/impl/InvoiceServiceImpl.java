package com.java1906.climan.services.impl;

import com.java1906.climan.data.model.Invoice;
import com.java1906.climan.data.repo.InvoiceRepository;
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
private InvoiceRepository invoiceRepository;
    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> finAllInvoice() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        Invoice inv = invoiceRepository.getOne(invoice.getId());
        if(null != inv){
            inv =invoice;
            return invoiceRepository.save(inv);
        }
        return null;
    }

    @Override
    public String deleteInvoice(int invoiceId) {
        invoiceRepository.deleteById(invoiceId);
        return "Invoice with id:"+ invoiceId +"delete successfully!";
    }
}
