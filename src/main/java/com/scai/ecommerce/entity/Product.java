package com.scai.ecommerce.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="id_product")
	private String idProduct;
	
	@Column(name="name")
	private String name;
	
	@Column(name="category")
	private String category;
	
	@Column(name="img")
	private String img;
	
	@Column(name="price")
	private float price;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, 
	           CascadeType.REFRESH, CascadeType.DETACH},
			   fetch=FetchType.LAZY)
	@JoinColumn(name="id_profile")
	private Profile profile;
	
	public Product() {}

	public Product(String name, String category, String img, float price) {
		super();
		this.name = name;
		this.category = category;
		this.img = img;
		this.price = price;
	}

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", name=" + name + ", category=" + category + ", img=" + img
				+ ", price=" + price + "]";
	}
}
