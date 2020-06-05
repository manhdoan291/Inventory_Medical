package com.java1906.climan.data.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Invoice_Enter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Integer id;
    private String name;
    private int type;
    private String lotNumber;
    private Date dateOfManufacture;
    private Date expiryDate;
    private Date createDate;
    private Date updateDate;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "invoiceEnters")
    private  List<InvoiceEnter_Detail> invoiceEnterDetails ;


    public List<InvoiceEnter_Detail> getInvoiceEnterDetails() {
        return invoiceEnterDetails;
    }

    public void setInvoiceEnterDetails(List<InvoiceEnter_Detail> invoiceEnterDetails) {
        this.invoiceEnterDetails = invoiceEnterDetails;
    }

    public Invoice_Enter() {
    }


    public Supplier getSupplier() {
        return supplier;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
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
