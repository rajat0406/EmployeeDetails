package com.example.demo.service;

import java.util.List;

import javax.validation.constraints.Positive;

import org.springframework.stereotype.Service;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.model.DepartmentModel;
@Service
public interface DepartmentService {
	
	public List<String> saveDepartment();

	public List<DepartmentModel> saveDepartmentWithUser(DepartmentModel dpModel);

	DepartmentModel findUserByDeptId( Long userId);

}
