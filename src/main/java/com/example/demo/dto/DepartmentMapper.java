package com.example.demo.dto;

import org.jboss.logging.Logger;

import com.example.demo.model.DepartmentModel;
import com.example.demo.model.UserModel;

public class DepartmentMapper {
	
	static Logger logger = Logger.getLogger(UserMapper.class);
	
	private DepartmentMapper() {
	}
	
	public static DepartmentModel toModel(DepartmentDTO dto) {
		logger.info("toModel method called="+ dto);
		
		return new DepartmentModel()
				.setDepartmentId(dto.getDepartmentId())
				.setDepartment(dto.getDepartment());
	}
	
	
	public static DepartmentDTO toDto(DepartmentModel model) {
		logger.info("toDto method called=" + model);
		
		return new DepartmentDTO()
				.setDepartmentId(model.getDepartmentId())
				.setDepartment(model.getDepartment());				
		
	}
	
	

}
