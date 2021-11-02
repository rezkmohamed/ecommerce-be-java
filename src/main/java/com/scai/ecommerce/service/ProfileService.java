package com.scai.ecommerce.service;

import com.scai.ecommerce.dto.ProfileDTO;

public interface ProfileService {
	public ProfileDTO findProfile(String idProfile);
	
	public ProfileDTO findProfileByEmailAndPassword(String email, String password);
	
	public ProfileDTO findProfileByEmail(String email);
	
	public String saveProfile(ProfileDTO profile);
}
