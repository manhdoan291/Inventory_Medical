package com.java1906.climan.data.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Integer id;
    private Integer quantityInStock;
    private Integer quantityImportInStock;
    private Integer quantityExportInStock;
    private Integer quatityEndingInStock;
    private Date exportDate;
    private Date importDate;
    private Double intoMoney;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "history")
    private  List<Invoice> invoices ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Integer getQuantityImportInStock() {
        return quantityImportInStock;
    }

    public void setQuantityImportInStock(Integer quantityImportInStock) {
        this.quantityImportInStock = quantityImportInStock;
    }

    public Integer getQuantityExportInStock() {
        return quantityExportInStock;
    }

    public void setQuantityExportInStock(Integer quantityExportInStock) {
        this.quantityExportInStock = quantityExportInStock;
    }

    public Integer getQuatityEndingInStock() {
        return quatityEndingInStock;
    }

    public void setQuatityEndingInStock(Integer quatityEndingInStock) {
        this.quatityEndingInStock = quatityEndingInStock;
    }

    public Date getExportDate() {
        return exportDate;
    }

    public void setExportDate(Date exportDate) {
        this.exportDate = exportDate;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public Double getIntoMoney() {
        return intoMoney;
    }

    public void setIntoMoney(Double intoMoney) {
        this.intoMoney = intoMoney;
    }
}
