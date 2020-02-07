package com.example.demo.dto;

import io.swagger.annotations.ApiModelProperty;

public class UserDto {
	
	private String name;
	
	private Long registerNo;

	private String city;

	private String mobileNumber;
	

	public String getName() {
		return name;
	}
	
	@ApiModelProperty(notes = "status of the user. 1-Active | 2-Inactive | 5-SoftDelete")
	private int userStatus;

	public int getUserStatus() {
		return userStatus;
	}

	public UserDto setUserStatus(int userStatus) {
		this.userStatus = userStatus;
		return this;
	}

	public UserDto setName(String name) {
		this.name = name;
		return this;
	}

	public String getCity() {
		return city;
	}

	public UserDto setCity(String city) {
		this.city = city;
		return this;
	}
	

	public String getMobileNumber() {
		return mobileNumber;
	}

	public UserDto setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
		return this;
	}
	
	public Long getRegisterNo() {
		return registerNo;
	}

	public UserDto setRegisterNo(Long registerNo) {
		this.registerNo = registerNo;
		return this;
	}
	
	@Override
	public String toString() {
		return "UserDTO [" + ", name=" + name + ", city=" + city + ", mobileNumber=" + mobileNumber
				 + "registerNo="+ registerNo + "]";
	}



}
