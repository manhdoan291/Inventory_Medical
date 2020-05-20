package com.java1906.climan.data.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String description;
	
	@NotNull
	private String img_url;
	
	@NotNull
	private Boolean active_flag;
	
	@NotNull
	private Date create_date;

	@NotNull
	private Date update_date;

	@ManyToOne
	@JoinColumn(name = "invoice_id")
	private Invoice invoice;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Boolean getActive_flag() {
		return active_flag;
	}

	public void setActive_flag(Boolean active_flag) {
		this.active_flag = active_flag;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public Product(@NotNull String name, @NotNull String description, @NotNull String img_url, @NotNull Boolean active_flag,
				   @NotNull Date create_date, @NotNull Date update_date) {
		super();
		this.name = name;
		this.description = description;
		this.img_url = img_url;
		this.active_flag = active_flag;
		this.create_date = create_date;
		this.update_date = update_date;
	}

	public Product() {
	}

}
