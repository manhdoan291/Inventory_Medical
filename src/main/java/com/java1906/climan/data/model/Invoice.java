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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice")
    private List<InvoiceValue> invoiceValue ;

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
}