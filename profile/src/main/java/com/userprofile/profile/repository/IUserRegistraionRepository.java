package com.userprofile.profile.repository;

import org.springframework.data.repository.CrudRepository;

import com.userprofile.profile.entity.UserProfile;

public interface IUserRegistraionRepository extends CrudRepository<UserProfile, Integer>{

}
