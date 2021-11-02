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
}
