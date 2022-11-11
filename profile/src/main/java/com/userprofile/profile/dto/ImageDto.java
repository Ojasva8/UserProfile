package com.userprofile.profile.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ImageDto {

	private Integer uId;
	private String uPassword;
	private List<MultipartFile> images;

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}

}
