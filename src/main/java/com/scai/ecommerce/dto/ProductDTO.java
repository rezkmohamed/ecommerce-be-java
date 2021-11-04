package com.scai.ecommerce.dto;

public class ProductDTO {
	private String idProduct;
	private String name;
	private String category;
	private String img;
	private float price;
	private int quantity;
	private ProfileDTO profile;
	private String idProfile;
	
	
	public ProductDTO() {}

	public ProductDTO(String idProduct, String name, String category, String img, float price) {
		super();
		this.idProduct = idProduct;
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

	public ProfileDTO getProfile() {
		return profile;
	}

	public void setProfile(ProfileDTO profile) {
		this.profile = profile;
	}
	
	public String getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(String idprofile) {
		this.idProfile = idprofile;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductDTO [idProduct=" + idProduct + ", name=" + name + ", category=" + category + ", img=" + img
				+ ", price=" + price + ", quantity=" + quantity + ", profile=" + profile + ", idProfile=" + idProfile
				+ "]";
	}
}
