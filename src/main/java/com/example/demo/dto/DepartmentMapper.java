package com.example.demo.dto;

import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import com.example.demo.model.DepartmentModel;

public class DepartmentMapper {
	
	static Logger logger = Logger.getLogger(UserMapper.class);
	
	private DepartmentMapper() {
	}
	
	public static DepartmentModel toModel(DepartmentDTO dto) {
		logger.info("toModel method called="+ dto);
		
		return new DepartmentModel()
				.setDepartmentId(dto.getDepartmentId())
				.setDepartment(dto.getDepartment())
				.setEmployee(dto.getEmployee().stream().map(UserMapper::toModel).collect(Collectors.toList()))
				.setUserStatus(dto.getUserStatus());		
	}
	
	

		public static DepartmentDTO toDto(DepartmentModel model) {
		logger.info("toDto method called=" + model);
		
		return new DepartmentDTO()
				.setDepartmentId(model.getDepartmentId())
				.setDepartment(model.getDepartment())
				.setEmployee(model.getEmployee().stream().map(UserMapper::toDto).collect(Collectors.toList()))
				.setUserStatus(model.getUserStatus());		
		
	}
	

}
