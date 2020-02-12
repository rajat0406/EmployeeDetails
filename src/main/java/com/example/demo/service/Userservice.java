package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.UserModel;

@Service
public interface Userservice {
	
	public UserDto saveUser(UserDto userDto);

	public List<UserDto> getUser();
	
	public UserModel findByMobileNumber(String mobile);
	
	public UserDto updateUser(UserDto userDto, Long userId);
}
