package com.java1906.climan.data.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Integer id;
    private String name;
    private String lotNumber;
    private Date dateOfManufacture;
    private Date expiryDate;
    private Integer quantity;
    private String unit;
    private Double price;
    private Date createDate;
    private Date updateDate;
    @ManyToOne
    @JoinColumn(name = "history_id")
    private History history;

    @ManyToMany
    @JoinTable(name = "productInfo_Invoice",
            joinColumns = @JoinColumn(name = "Invoice_id"),
            inverseJoinColumns = @JoinColumn(name = "productInfo_id"))
    private Set<ProductInfo> productInfos;


    public Set<ProductInfo> getProductInfos() {
        return productInfos;
    }

    public void setProductInfos(Set<ProductInfo> productInfos) {
        this.productInfos = productInfos;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
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

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(Date dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createTime) {
        this.createDate = createTime;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateTime) {
        this.updateDate = updateTime;
    }
}
