package com.java1906.climan.data.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int type; // kieu hoa don
    private double inTotal;       // tong gia nhap
    private double outTotal;    // tong gia xuat
    private int activeFlag;
    private Date createdDate;
    private Date updatedDate;

    @OneToMany(fetch = FetchType.LAZY)
    private List<InvoiceItem> invoiceItems;

    @OneToMany(fetch = FetchType.LAZY)
    private  List<InvoiceExport> invoiceExports;

    @OneToMany(fetch = FetchType.LAZY)
    private  List<InvoiceImport> invoiceImports;

    public Invoice() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getInTotal() {
        return inTotal;
    }

    public void setInTotal(double inTotal) {
        this.inTotal = inTotal;
    }

    public double getOutTotal() {
        return outTotal;
    }

    public void setOutTotal(double outTotal) {
        this.outTotal = outTotal;
    }

    public int getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(int activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    public List<InvoiceExport> getInvoiceExports() {
        return invoiceExports;
    }

    public void setInvoiceExports(List<InvoiceExport> invoiceExports) {
        this.invoiceExports = invoiceExports;
    }

    public List<InvoiceImport> getInvoiceImports() {
        return invoiceImports;
    }

    public void setInvoiceImports(List<InvoiceImport> invoiceImports) {
        this.invoiceImports = invoiceImports;
    }
}
