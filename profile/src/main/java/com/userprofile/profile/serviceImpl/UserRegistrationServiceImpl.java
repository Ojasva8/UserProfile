package com.userprofile.profile.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userprofile.profile.dto.UserProfileDto;
import com.userprofile.profile.entity.UserProfile;
import com.userprofile.profile.repository.IUserRegistraionRepository;
import com.userprofile.profile.service.UserRegistrationService;


@Service
public class UserRegistrationServiceImpl implements UserRegistrationService{

	@Autowired
	IUserRegistraionRepository iUserRegistraionRepository;
	
	
	@Override
	public void registerNewUser(UserProfileDto user) {
		
		UserProfile userProfile = new UserProfile();
		userProfile.setuName(user.getName());
		userProfile.setuPassword(user.getPassword());
		userProfile.setuGender(user.getGender());
		iUserRegistraionRepository.save(userProfile);
	}

}
