package com.userprofile.profile.serviceImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.userprofile.profile.dto.UserProfileDto;
import com.userprofile.profile.entity.UserImages;
import com.userprofile.profile.entity.UserProfile;
import com.userprofile.profile.repository.IUserImagesRepository;
import com.userprofile.profile.repository.IUserProfileRepository;
import com.userprofile.profile.service.UserProfileService;

@Service
public class UserServiceImpl implements UserProfileService {

	@Autowired
	IUserProfileRepository iUserRegistraionRepository;

	@Autowired
	IUserImagesRepository iUserImagesRepository;

	@Override
	public void registerNewUser(UserProfileDto user) {

		UserProfile userProfile = new UserProfile();
		userProfile.setuName(user.getName());
		userProfile.setuPassword(user.getPassword());
		userProfile.setuGender(user.getGender());
		iUserRegistraionRepository.save(userProfile);
	}

	@Override
	public void uploadImage(String imgValue, Integer userId) throws IOException, UnirestException {

		UserImages images = new UserImages();
		images.setImgUrls(imgValue);
		iUserImagesRepository.save(images);

		Unirest.setTimeouts(0, 0);
		Unirest.post("https://api.imgur.com/3/upload/").header("Authorization", "Client-ID 5f7f9947b5c92ed")
				.field("image", imgValue).asString();

	}

	@Override
	public String fetchImage(String imageHash) {
		Unirest.setTimeouts(0, 0);

		return Unirest.get("https://api.imgur.com/3/image/" + imageHash)
				.header("Authorization", "Client-ID 5f7f9947b5c92ed").getUrl();
	}

	@Override
	public void deleteImage(String imageHash) throws UnirestException {
		Unirest.setTimeouts(0, 0);
		Unirest.delete("https://api.imgur.com/3/image/" + imageHash)
				.header("Authorization", "Client-ID 5f7f9947b5c92ed").asString();

	}

	@Override
	public UserProfile fetchUserInfo(Integer userId) {

		return iUserRegistraionRepository.findById(userId).get();

	}

}
