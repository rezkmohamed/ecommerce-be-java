package com.scai.ecommerce.utils;

import java.util.ArrayList;
import java.util.List;

import com.scai.ecommerce.dto.ProfileDTO;
import com.scai.ecommerce.entity.Profile;

public class ProfileUtils {
	public static ProfileDTO profileEntityToDTO(Profile profile) {
		ProfileDTO profileDTO = new ProfileDTO(profile.getIdProfile(), profile.getEmail(), profile.isVendor());
		
		return profileDTO;
	}
	
	public static List<ProfileDTO> profileEntityToDTO(List<Profile> profiles){
		List<ProfileDTO> ris = new ArrayList<>();
		
		for(Profile p : profiles) {
			ris.add(profileEntityToDTO(p));
		}
		
		return ris;
	}
	
	public static Profile profileDTOToEntity(ProfileDTO profileDTO) {
		Profile profile = new Profile(profileDTO.getEmail(), profileDTO.getPassword(), profileDTO.getIsVendor());

		return profile;
	}
}
