package com.java1906.climan.data.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int customerId;
    private String name;
    private String address;
    private String numberPhone;
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private  List<Invoice_Export> invoiceExports ;

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public List<Invoice_Export> getInvoiceExports() {
        return invoiceExports;
    }

    public void setInvoiceExports(List<Invoice_Export> invoiceExports) {
        this.invoiceExports = invoiceExports;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
