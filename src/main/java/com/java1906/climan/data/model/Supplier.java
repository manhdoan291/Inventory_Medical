package com.java1906.climan.data.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int supplierId;
    private String supplierName;
    private String supplierAddress;
    private String numberPhone;
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier")
        private List<Invoice_Enter> invoiceEnters;

    public Supplier() {
    }

    public List<Invoice_Enter> getInvoiceEnters() {
        return invoiceEnters;
    }

    public void setInvoiceEnters(List<Invoice_Enter> invoiceEnters) {
        this.invoiceEnters = invoiceEnters;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
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
