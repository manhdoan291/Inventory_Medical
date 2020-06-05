package com.java1906.climan.data.model;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class InvoiceIssue implements Serializable {

    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public InvoiceIssue() {
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
