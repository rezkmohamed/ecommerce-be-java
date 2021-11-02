package com.scai.ecommerce.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scai.ecommerce.dto.ProfileDTO;
import com.scai.ecommerce.dto.UserDTO;
import com.scai.ecommerce.service.ProfileService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController("")
public class AuhtController {
	@Autowired
	private ProfileService profileService;
	@Value("${signingKey}")
	private String signingKey;
	
	
	@PostMapping("/login")
	public ResponseEntity<ProfileDTO> login(@RequestBody UserDTO user){
		ProfileDTO profileToLogin = profileService.findProfileByEmailAndPassword(user.getEmail(), user.getPassword());
		
		if(profileToLogin != null) {
			HttpHeaders headers = new HttpHeaders();
        	HashMap<String, Object> addedValues = new HashMap<String, Object>();
        	
        	String token = Jwts.builder()
        			.addClaims(addedValues)
        			.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 4 * 120 * 60 * 1000))
					.signWith(SignatureAlgorithm.HS512, this.signingKey).compact();
        	headers.add("Authentication","Bearer " + token);
			
			return ResponseEntity.ok().headers(headers).build();        	
		}
				
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Boolean> register(@RequestBody ProfileDTO profileToRegister){
		if(profileService.saveProfile(profileToRegister) != null) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
	}
	
}
