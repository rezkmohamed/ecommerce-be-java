package com.scai.ecommerce.repo;

import com.scai.ecommerce.entity.Profile;

public interface ProfileRepo {
	public Profile findProfile(String idProfile);
	
	public Profile findprofileByEmailAndPassword(String email, String password);
	
	public Profile findProfileByEmail(String email);
	
	public String saveProfile(Profile profile);
}
