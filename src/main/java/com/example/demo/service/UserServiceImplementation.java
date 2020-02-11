package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserMapper;
import com.example.demo.exception.CustomException;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImplementation implements Userservice {
	 Logger logger = Logger.getLogger(UserServiceImplementation.class);
	
@Autowired 
UserRepository userRepo;

	@Override
	public UserDto saveUser(UserDto userDto) {
		logger.info("this is the saveUserMethod");
		
		if(userDto == null) {
			throw new CustomException(String.format("%s object entered","empty"));
		}
		else {
		
		return UserMapper.toDto(userRepo.save(UserMapper.toModel((userDto))));
		}
	}

	@Override
	public List<UserDto> getUser() {	
		return userRepo.findAll().stream().map(UserMapper::toDto).collect(Collectors.toList());
		
	}

	@Override
	public UserModel findByMobileNumber(String mobile) {
	UserModel model = userRepo.findByMobileNumber(mobile);
	return model;
		
	}
	
	
	

}
