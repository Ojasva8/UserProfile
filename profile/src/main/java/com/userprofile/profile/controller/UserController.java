package com.userprofile.profile.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.userprofile.profile.dto.UserProfileDto;
import com.userprofile.profile.entity.UserProfile;
import com.userprofile.profile.service.UserProfileService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserProfileService registrationService;

	@RequestMapping(value = "getHome", method = RequestMethod.GET)
	public String home() {
		return "Home";
	}

	@PostMapping(path = "/register-user")
	public ResponseEntity<String> register(@RequestBody UserProfileDto userDetails) {

		registrationService.registerNewUser(userDetails);

		return new ResponseEntity<>("Successfull Registered", HttpStatus.CREATED);
	}

	@PostMapping(path = "/upload-img")
	public ResponseEntity<String> uploadImages(@RequestParam String imgPath, @RequestParam Integer userId)
			throws IOException, UnirestException {

		registrationService.uploadImage(imgPath, userId);
		return new ResponseEntity<>("Successfully Uploaded Image", HttpStatus.CREATED);
	}

	@GetMapping(path = "/view-img")
	public ResponseEntity<String> viewImages(String imgHash) {

		return new ResponseEntity<>(registrationService.fetchImage(imgHash), HttpStatus.OK);
	}

	@DeleteMapping(path = "/delete-img")
	public ResponseEntity<String> deleteImage(String imgHash) throws UnirestException {

		registrationService.deleteImage(imgHash);

		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

	@GetMapping(path = "/view-img")
	public ResponseEntity<UserProfile> viewUserInfo(@RequestParam Integer userId) {

		return new ResponseEntity<>(registrationService.fetchUserInfo(userId), HttpStatus.OK);
	}

}
