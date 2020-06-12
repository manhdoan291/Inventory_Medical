package com.java1906.climan.services;

import com.java1906.climan.data.model.CategoryValue;
import com.java1906.climan.data.model.InvoiceItem;

import java.util.List;
import java.util.Optional;

public interface IInvoiceItemService {
    List<InvoiceItem> findAll();
    Optional<InvoiceItem> findById(Integer invoiceItemId);
    InvoiceItem save( Integer invoiceId,InvoiceItem invoiceItem, Integer productInfoId);
    InvoiceItem update(Integer invoiceId, InvoiceItem invoiceItem);
    void delete(Integer invoiceItemId);

}
