package com.java1906.climan.services;

import com.java1906.climan.data.model.Invoice;

import java.util.List;
import java.util.Optional;

public interface IInvoiceService {
        public Invoice saveInvoice(Invoice invoice);
        public List<Invoice> finAllInvoice();
        public Invoice updateInvoice(Invoice invoice);
        public String deleteInvoice(int invoiceId);
}
