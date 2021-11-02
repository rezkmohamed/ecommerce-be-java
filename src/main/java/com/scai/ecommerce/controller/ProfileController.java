package com.scai.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.scai.ecommerce.dto.ProfileDTO;
import com.scai.ecommerce.service.ProfileService;
import com.scai.ecommerce.utils.RequestUtils;

@RestController("/profiles")
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	@Autowired
	private RequestUtils requestUtils;
	
	@GetMapping("/{idProfile}")
	public ResponseEntity<ProfileDTO> findProfileById(@PathVariable String idProfile){
		/**
		 * FIXME
		 */
		return null;
	}
	
}
