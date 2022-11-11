package com.userprofile.profile.repository;

import org.springframework.data.repository.CrudRepository;

import com.userprofile.profile.entity.UserImages;

public interface IUserImagesRepository extends CrudRepository<UserImages, Integer> {

}
