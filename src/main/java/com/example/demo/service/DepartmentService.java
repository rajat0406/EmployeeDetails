package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.dto.DepartmentDTO;
import com.example.demo.model.DepartmentModel;

@Service
public interface DepartmentService {
	
	public List<String> saveDepartment();

	//public List<DepartmentDTO> saveDepartmentWithUser(DepartmentModel dpModel);

	public DepartmentModel findUserByDeptId( Long userId);
	
	public DepartmentDTO findUserFewDetailsByDeptId(Long userId);
	
	public void deleteUserByDeptId(Long userId);

	public List<DepartmentModel> saveDepartmentWithUser(DepartmentModel dpModel);
	
	public DepartmentModel getDepartmentDetails(Long depId, Long id);

	public List<DepartmentModel> getUserWithDepartment();
	
	public List<DepartmentModel> getUserFromDepartment(String DepartmentName);

}
