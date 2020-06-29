package com.java1906.climan.data.model;

import java.sql.Date;

public class Invoice {
    private Integer id;
    private int type; // kieu hoa don
    private double inTotal;       // tong gia nhap
    private double outTotal;    // tong gia xuat
    private int activeFlag;
    private Date createdDate;
    private Date updatedDate;
}
