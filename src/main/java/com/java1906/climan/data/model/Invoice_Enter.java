package com.java1906.climan.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table
public class Invoice_Enter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int invoiceEnter;
    private String name;
    private String description;
    private int type;
    private String lotNumber;
    private Date createDate;
    private Date updateDate;
    private double priceEnter;
    private int numberEnter;
    private double totalMoneyEnter;

    @ManyToOne
    @JoinColumn(name ="supplier_id")
    @JsonIgnore
    private Supplier supplier;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "productInfo_invoiceEnter", joinColumns = { @JoinColumn(name = "ProductInfo_id") }, inverseJoinColumns = {
            @JoinColumn(name = "invoiceEnter_id") })
    private List<ProductInfo> productInfos;


    public Invoice_Enter() {
    }

    public List<ProductInfo> getProductInfos() {
        return productInfos;
    }

    public void setProductInfos(List<ProductInfo> productInfos) {
        this.productInfos = productInfos;
    }

    public int getInvoiceEnter() {
        return invoiceEnter;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public void setInvoiceEnter(int invoiceEnter) {
        this.invoiceEnter = invoiceEnter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public double getPriceEnter() {
        return priceEnter;
    }

    public void setPriceEnter(double priceEnter) {
        this.priceEnter = priceEnter;
    }

    public int getNumberEnter() {
        return numberEnter;
    }

    public void setNumberEnter(int numberEnter) {
        this.numberEnter = numberEnter;
    }

    public double getTotalMoneyEnter() {
        return totalMoneyEnter;
    }

    public void setTotalMoneyEnter(double totalMoneyEnter) {
        this.totalMoneyEnter = totalMoneyEnter;
    }
}
