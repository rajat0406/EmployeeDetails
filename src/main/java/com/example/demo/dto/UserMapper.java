package com.example.demo.dto;

import org.jboss.logging.Logger;

import com.example.demo.model.UserModel;



public class UserMapper {
	static Logger logger = Logger.getLogger(UserMapper.class);
	
	private UserMapper() {
	}
	
	public static UserModel toModel(UserDto dto) {
		logger.info("toModel method called="+ dto);
		
		return new UserModel()
				.setCity(dto.getCity())
				.setMobileNumber(dto.getMobileNumber())
				.setName(dto.getName())
				.setRegisterNo(dto.getRegisterNo());
	}
	
	
	public static UserDto toDto(UserModel model) {
		logger.info("toDto method called=" + model);
		
		return new UserDto() 
			.setCity(model.getCity())
			.setMobileNumber(model.getMobileNumber())
			.setName(model.getName())
			.setRegisterNo(model.getRegisterNo());		
		
	}
	public static UserDto toDtoForDept(UserModel model) {
		logger.info("toDto method called=" + model);
		
		return new UserDto() 
			.setMobileNumber(model.getMobileNumber())
			.setName(model.getName());
		
	}
	
	

}
