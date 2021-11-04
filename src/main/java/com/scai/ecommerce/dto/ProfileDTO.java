package com.scai.ecommerce.dto;

import java.util.List;


public class ProfileDTO {
	private String idProfile;
	private String email;
	private boolean isVendor;
	private List<ProductDTO> products;
	private String password;
	
	public ProfileDTO() {}	

	public ProfileDTO(String email, boolean isVendor) {
		super();
		this.email = email;
		this.isVendor = isVendor;
	}

	public ProfileDTO(String idProfile, String email, boolean isVendor) {
		super();
		this.idProfile = idProfile;
		this.email = email;
		this.isVendor = isVendor;
	}

	public String getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(String idProfile) {
		this.idProfile = idProfile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getIsVendor() {
		return isVendor;
	}

	public void setIsVendor(boolean isVendor) {
		this.isVendor = isVendor;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ProfileDTO [idProfile=" + idProfile + ", email=" + email + ", isVendor=" + isVendor + ", products="
				+ products + ", password=" + password + "]";
	}
}
