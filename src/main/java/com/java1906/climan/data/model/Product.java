package com.java1906.climan.data.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "product_info")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	private String name;
	
	@NotNull
	private String description;
	
	@NotNull
	private String img_url;
	
	@NotNull
	private String active_flag;
	
	@NotNull
	private String create_date;
	
	@NotNull
	private String update_date;
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

	public String getActive_flag() {
		return active_flag;
	}

	public void setActive_flag(String active_flag) {
		this.active_flag = active_flag;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public Product(@NotEmpty String name, @NotNull String description, @NotNull String img_url, @NotNull String active_flag,
				   @NotNull String create_date, @NotNull String update_date) {
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
