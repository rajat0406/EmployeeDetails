package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.dto.DepartmentDTO;
import com.example.demo.model.DepartmentModel;
import com.example.demo.model.UserModel;

@Service
public interface DepartmentService {
	
	public List<String> saveDepartment();

	//public List<DepartmentDTO> saveDepartmentWithUser(DepartmentModel dpModel);

	public DepartmentModel findUserByDeptId( Long userId);
	
	public DepartmentDTO findUserFewDetailsByDeptId(Long userId);
	
	public void deleteUserByDeptId(Long userId);

	public DepartmentModel saveDepartmentWithUser(DepartmentModel dpModel);
	
	public UserModel getDepartmentDetails(String depName, String mobileNumber);

	public List<DepartmentModel> getUserWithDepartment();
	
	public List<DepartmentModel> getUserFromDepartment(String DepartmentName);
	
	public DepartmentDTO updateDepartment(DepartmentDTO depDTO,Long depId);

}
