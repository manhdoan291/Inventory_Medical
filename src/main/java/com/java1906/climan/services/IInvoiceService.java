package com.java1906.climan.services;



import com.java1906.climan.data.model.Invoice_Enter;

import java.util.List;
import java.util.Optional;

public interface IInvoiceService {
        List<Invoice_Enter> finAllInvoice();

        Optional<Invoice_Enter> findById(int invoiceId);

        Invoice_Enter save(int productInfoId, Invoice_Enter invoice);

         Invoice_Enter update(int invoiceId, Invoice_Enter invoice);

        void delete(int invoiceId);
//    void save(ProductInfo productInfo);
}
