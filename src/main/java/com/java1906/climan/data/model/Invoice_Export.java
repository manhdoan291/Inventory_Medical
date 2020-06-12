package com.java1906.climan.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table
public class Invoice_Export {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int invoiceExport;
    private String name;
    private String description;
    private int type;
    private String lotNumber;
    private Date createDate;
    private Date updateDate;
    private double priceExport;
    private int numberExport;
    private double totalMoneyExport;

    @ManyToOne
    @JoinColumn(name ="customer_id")
    @JsonIgnore
    private Customer customer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "productInfo_invoiceExport", joinColumns = { @JoinColumn(name = "ProductInfo_id") }, inverseJoinColumns = {
            @JoinColumn(name = "invoiceExport_id") })
    private List<ProductInfo> productInfos;


    public Invoice_Export() {
    }

    public List<ProductInfo> getProductInfos() {
        return productInfos;
    }

    public void setProductInfos(List<ProductInfo> productInfos) {
        this.productInfos = productInfos;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getInvoiceExport() {
        return invoiceExport;
    }

    public void setInvoiceExport(int invoiceExport) {
        this.invoiceExport = invoiceExport;
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

    public double getPriceExport() {
        return priceExport;
    }

    public void setPriceExport(double priceExport) {
        this.priceExport = priceExport;
    }

    public int getNumberExport() {
        return numberExport;
    }

    public void setNumberExport(int numberExport) {
        this.numberExport = numberExport;
    }

    public double getTotalMoneyExport() {
        return totalMoneyExport;
    }

    public void setTotalMoneyExport(double totalMoneyExport) {
        this.totalMoneyExport = totalMoneyExport;
    }
}
