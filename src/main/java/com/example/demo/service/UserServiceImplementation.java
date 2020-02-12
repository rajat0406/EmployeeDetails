package com.example.demo.service;

import java.util.List;
import java.util.Optional;
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
	
	@Override
	public UserDto updateUser(UserDto userDto, Long userId) {

		logger.info("updateUser method called . UserDTO = " + userDto + " | userId = " + userId);
		
		try {
			if ((userDto.getUserStatus() == 1
					|| userDto.getUserStatus() == 2)
					&& userDto.getUserStatus() != 5) {

				Optional<UserModel> optional = userRepo.findById(userId);

				UserModel orginaluserModel = null;
				if (optional.isPresent())
					orginaluserModel = optional.get();
				else
					throw new CustomException(String.format("%s Does Not Exists", "User"));

				if (userDto.getName() == null)
					userDto.setName(orginaluserModel.getName());

				if (userDto.getCity() == null)
					userDto.setCity(orginaluserModel.getCity());

				if (userDto.getMobileNumber() == null)
					userDto.setMobileNumber(orginaluserModel.getMobileNumber());


				UserModel userModel = UserMapper.toModel(userDto);
				userModel.setRegisterNo(userId);

				logger.info("In updateUser method . Repository.save() called . UserDTO = " + userDto + " | userId = "
						+ userId);

				return UserMapper.toDto(userRepo.save(userModel));
			}
			throw CustomException.throwException("Not a valid status");
		} catch (Exception ex) {
			logger.error(ex);
			throw ex;
		}

	}

	
	
	

}
