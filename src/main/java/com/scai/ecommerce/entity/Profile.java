package com.scai.ecommerce.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="profile")
public class Profile {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="id_profile")
	private String idProfile;
	
	@Column(name="email")
	private String email;

	@Column(name="password")
	private String password;
	
	@Column(name="isvendor")
	private boolean isVendor;
	
	@OneToMany(fetch=FetchType.LAZY,
			   mappedBy="profile",
			   cascade= CascadeType.ALL)
	private List<Product> products;
	
	public Profile() {}

	public Profile(String email, String password, boolean isVendor) {
		super();
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isVendor() {
		return isVendor;
	}

	public void setVendor(boolean isVendor) {
		this.isVendor = isVendor;
	}

	@Override
	public String toString() {
		return "Profile [idProfile=" + idProfile + ", email=" + email + ", password=" + password + ", isVendor="
				+ isVendor + "]";
	}
}
