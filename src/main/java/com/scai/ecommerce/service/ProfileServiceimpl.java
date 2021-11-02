package com.scai.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scai.ecommerce.dto.ProfileDTO;
import com.scai.ecommerce.entity.Profile;
import com.scai.ecommerce.repo.ProfileRepo;
import com.scai.ecommerce.utils.ProfileUtils;

@Service
public class ProfileServiceimpl implements ProfileService {
	@Autowired
	private ProfileRepo profileRepo;
	

	@Override
	@Transactional
	public ProfileDTO findProfile(String idProfile) {
		Profile profileSearched = profileRepo.findProfile(idProfile);
		
		return ProfileUtils.profileEntityToDTO(profileSearched);
	}

	@Override
	@Transactional
	public ProfileDTO findProfileByEmailAndPassword(String email, String password) {
		Profile profileSearched = profileRepo.findProfileByEmailAndPassword(email, password);
		
		return ProfileUtils.profileEntityToDTO(profileSearched);
	}

	@Override
	@Transactional
	public ProfileDTO findProfileByEmail(String email) {
		Profile profileSearched = profileRepo.findProfileByEmail(email);
		
		return ProfileUtils.profileEntityToDTO(profileSearched);
	}

	@Override
	@Transactional
	public String saveProfile(ProfileDTO profile) {
		Profile checkProfile = profileRepo.findProfileByEmail(profile.getEmail());
		if(checkProfile != null) {
			return null;
		}
		Profile profileToSave = ProfileUtils.profileDTOToEntity(profile);
		
		return profileRepo.saveProfile(profileToSave);
	}

}
