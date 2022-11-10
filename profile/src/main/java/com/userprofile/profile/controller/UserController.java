package com.userprofile.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userprofile.profile.dto.UserProfileDto;
import com.userprofile.profile.service.UserRegistrationService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRegistrationService registrationService;
	
	@RequestMapping(value = "getHome", method = RequestMethod.GET)
	public String home() {
		return "Home";
	}
 	
	@PostMapping(path = "/register-user")
	public ResponseEntity<String> register(@RequestBody UserProfileDto userDetails){
		
		
		registrationService.registerNewUser(userDetails);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
