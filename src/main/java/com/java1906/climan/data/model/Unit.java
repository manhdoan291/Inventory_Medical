package com.java1906.climan.data.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "unit")
    private List<InvoiceValue> invoiceValue;

    public Unit() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<InvoiceValue> getInvoiceValue() {
        return invoiceValue;
    }

    public void setInvoiceValue(List<InvoiceValue> invoiceValue) {
        this.invoiceValue = invoiceValue;
    }
}