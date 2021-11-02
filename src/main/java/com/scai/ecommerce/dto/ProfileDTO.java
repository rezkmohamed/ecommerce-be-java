package com.scai.ecommerce.dto;

import java.util.List;

public class ProfileDTO {
	private String idProfile;
	private String email;
	private boolean isVendor;
	private List<ProductDTO> products;
	
	public ProfileDTO() {}

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

	public boolean isVendor() {
		return isVendor;
	}

	public void setVendor(boolean isVendor) {
		this.isVendor = isVendor;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ProfileDTO [idProfile=" + idProfile + ", email=" + email + ", isVendor=" + isVendor + ", products="
				+ products + "]";
	}
}
