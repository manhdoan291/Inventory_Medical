package com.java1906.climan.data.model;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;


public class InvoiceReceipt implements Serializable {
    @@OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @OneToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public InvoiceReceipt() {
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
