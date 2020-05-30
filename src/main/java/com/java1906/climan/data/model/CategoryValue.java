package com.java1906.climan.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "category_value")
public class CategoryValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private Integer activeFlag;
    private Date createDate;
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name ="category_id")
    private Category category;

    @ManyToMany
    @JoinTable(name = "productInfo_categoryValue",
            joinColumns = @JoinColumn(name = "categoryValue_id"),
            inverseJoinColumns = @JoinColumn(name = "productInfo_id"))
    private List<ProductInfo> productInfos;

    public CategoryValue() {
    }

    public CategoryValue(String name, String description, Integer activeFlag, Date createDate, Date updateDate, Category category, List<ProductInfo> productInfos) {
        this.name = name;
        this.description = description;
        this.activeFlag = activeFlag;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.category = category;
        this.productInfos = productInfos;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
    public List<ProductInfo> getProductInfos() {
        return productInfos;
    }

    public void setProductInfos(List<ProductInfo> productInfos) {
        this.productInfos = productInfos;
    }

}
