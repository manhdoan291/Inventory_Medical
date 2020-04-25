package com.java1906.demointerceptor.product;

import javax.persistence.Entity;

	
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Product {
	private Long id;
	private String name;
	private String brand;
	private String madein;
	private float price;
	private String createdate;
	private String updatedate;
	public Product() {	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getMadein() {
		return madein;
	}
	public void setMadein(String madein) {
		this.madein = madein;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCreatedate(){return createdate;}
	public void setCreatedate(String createdate){this.createdate = createdate;}
	public String getUpdatedate(){return updatedate;}
	public void setUpdatedate(String updatedate){this.updatedate=updatedate;}

}
