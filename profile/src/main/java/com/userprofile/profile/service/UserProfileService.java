package com.userprofile.profile.service;

import java.io.IOException;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.userprofile.profile.dto.UserProfileDto;
import com.userprofile.profile.entity.UserProfile;

public interface UserProfileService {

	void registerNewUser(UserProfileDto user);

	void uploadImage(String imgValue, Integer userId) throws IOException, UnirestException;

	String fetchImage(String imgHash);

	void deleteImage(String imageHash) throws UnirestException;

	UserProfile fetchUserInfo(Integer userId);

}
