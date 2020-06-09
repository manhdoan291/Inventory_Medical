package com.java1906.climan.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class InvoiceReceipt {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "invoice_id")

    private Invoice invoice;

    @ManyToOne
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
