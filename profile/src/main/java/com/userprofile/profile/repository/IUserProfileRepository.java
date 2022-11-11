package com.userprofile.profile.repository;

import org.springframework.data.repository.CrudRepository;

import com.userprofile.profile.entity.UserProfile;

public interface IUserProfileRepository extends CrudRepository<UserProfile, Integer>{

}
