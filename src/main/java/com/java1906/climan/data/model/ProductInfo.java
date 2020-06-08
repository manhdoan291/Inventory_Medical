package com.java1906.climan.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "product_info")
public class ProductInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id;
    private String name;
    private String description;
    private String img_url;
    private Integer activeFlag;
    private Date createDate;
    private Date updateDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "productInfo_categoryValue",
            joinColumns = {@JoinColumn(name = "ProductInfo_id")},
            inverseJoinColumns = {@JoinColumn(name = "categoryValue_id")})
    private List<CategoryValue> categoryValues;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "productInfo_invoiceEnter", joinColumns = { @JoinColumn(name = "ProductInfo_id") }, inverseJoinColumns = {
            @JoinColumn(name = "invoiceEnter_id") })
    private List<Invoice_Enter> invoiceEnters;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "productInfo_invoiceExport", joinColumns = { @JoinColumn(name = "ProductInfo_id") }, inverseJoinColumns = {
            @JoinColumn(name = "invoiceExport_id") })
    private List<Invoice_Export> invoiceExports;

    public ProductInfo() {
    }

public ProductInfo(String name,String description,String img_url,int activeFlag, Date createDate,Date updateDate,List<CategoryValue> categoryValues){
            this.name =name;
            this.description =description;
            this.img_url =img_url;
            this.activeFlag =activeFlag;
            this.createDate =createDate;
            this.updateDate =updateDate;
            this.categoryValues =categoryValues;

}

    public List<Invoice_Enter> getInvoiceEnters() {
        return invoiceEnters;
    }

    public void setInvoiceEnters(List<Invoice_Enter> invoiceEnters) {
        this.invoiceEnters = invoiceEnters;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public Integer getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Integer activeFlag) {
        this.activeFlag = activeFlag;
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

    public List<CategoryValue> getCategoryValues() {
        return categoryValues;
    }

    public void setCategoryValues(List<CategoryValue> categoryValues) {
        this.categoryValues = categoryValues;
    }

}
