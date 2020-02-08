package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Positive;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DepartmentModel;
import com.example.demo.repository.DepartmentRepository;


@Service
public class DepartmentServiceImplementation implements DepartmentService {
	
	Logger logger = Logger.getLogger(DepartmentServiceImplementation.class);
	
	@Autowired
	public DepartmentRepository departmentRepo;

	@Override
	public List<String> saveDepartment() {
		
//		String[] department = { "Sales" , "Export" , "IT", "Marketing" , "Financial" , 
//				"Human Resources", "Buying" , "R&D", "Quality" , "Administration", 
//				"Production" , "Logistics" , "PR" , "Security"};
		List<String> department = Arrays.asList("Sales" , "Export" , "IT", "Marketing" , "Financial" , 
				"Human Resources", "Buying" , "R&D", "Quality" , "Administration", 
				"Production" , "Logistics" , "PR" , "Security");
		
		return department;
	}

	public List<DepartmentModel> saveDepartmentWithUser(DepartmentModel dpDTO) {
		// TODO Auto-generated method stub
		departmentRepo.save(dpDTO);
		
		return null;
	}

	public DepartmentModel findUserByDeptId(@Positive(message = "Id must be greater than 0") Long deptId) {
		Optional<DepartmentModel> optional = departmentRepo.findById(deptId);	
		if (optional.isPresent()){
			return optional.get();
			
		}
		return null;

	}

	@Override
	public void deleteUserByDeptId(Long userId) {
		// TODO Auto-generated method stub
//		try {
//			logger.info("deleteUserById method called. userId="+userId);
//			Optional<DepartmentModel> optional = departmentRepo.findById(userId);
//			
//			DepartmentModel dpModel = optional.get();
//			if(dpModel != null) {
//		}
//		catch(Exception e) {
//			logger.error(e);;
//		}
		logger.info("deleteUserById method called. userId="+userId);
		departmentRepo.deleteById(userId);
	}


}
