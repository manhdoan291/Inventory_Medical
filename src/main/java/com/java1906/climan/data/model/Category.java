package com.java1906.climan.data.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private Date createDate;
    private Date updateDate;

    // @OneToMany(mappedBy = "category")
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CategoryValue> categoryValueList;


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

    public List<CategoryValue> getCategoryValueList() {
        return categoryValueList;
    }

    public void setCategoryValueList(List<CategoryValue> categoryValueList) {
        this.categoryValueList = categoryValueList;
    }
}
