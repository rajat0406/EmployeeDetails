package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;

public interface Userservice {
	
	public UserDto saveUser(UserDto userDto);

	public List<UserDto> getUser();
}
