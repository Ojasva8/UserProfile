package com.userprofile.profile.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserProfile {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer uId;

	@Column
	private String uName;

	@Column
	private String uPassword;

	@Column
	private String uGender;

	@OneToMany(mappedBy = "uId")
	List<UserImages> images;

	public List<UserImages> getImages() {
		return images;
	}

	public void setImages(List<UserImages> images) {
		this.images = images;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuGender() {
		return uGender;
	}

	public void setuGender(String uGender) {
		this.uGender = uGender;
	}

}
