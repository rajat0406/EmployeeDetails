package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.constraints.Positive;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserMapper;
import com.example.demo.exception.CustomException;
import com.example.demo.model.DepartmentModel;
import com.example.demo.model.UserModel;
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
		List<String> department = Arrays.asList("Sales", "Export", "IT", "Marketing", "Financial", "Human Resources",
				"Buying", "R&D", "Quality", "Administration", "Prooduction", "Logistics", "PR", "Security");
		
		return department;
	}

	public DepartmentModel saveDepartmentWithUser(DepartmentModel model) {		
		logger.info("saveUser method called . UserDTO = " + model);
		 
		
		if(model.getDepartment()==null && model.getEmployee()==null && model.getDepartment().length()==0 && !model.getEmployee().isEmpty()) {
			throw new CustomException(String.format("%s Object Received","Null"));
		}
		
		return departmentRepo.save(model);
		
	}

	public DepartmentModel findUserByDeptId(@Positive(message = "Id must be greater than 0") Long deptId) {
		Optional<DepartmentModel> optional = departmentRepo.findById(deptId);
		if (optional.isPresent()) {
			return optional.get();

		}
		throw new CustomException(String.format("%s	 does not exist", "user"));
	}

	@Override
	public void deleteUserByDeptId(Long userId) {
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
		logger.info("deleteUserById method called. userId=" + userId);
		departmentRepo.deleteById(userId);
	}

	@Override
	public DepartmentDTO findUserFewDetailsByDeptId(Long userId) {

		Optional<DepartmentModel> optional = departmentRepo.findById(userId);
		if (optional.isPresent()) {
			DepartmentModel model = optional.get();

			List<UserDto> uDto = model.getEmployee().stream().map(UserMapper::toDtoForDept)
					.collect(Collectors.toList());
			return new DepartmentDTO().setDepartment(model.getDepartment()).setEmployee(uDto);
		}

		throw new CustomException(String.format("%s does not exist", "user"));

	}

	@Override
	public UserModel getDepartmentDetails(String depName, String mobileNumber) {
		List<DepartmentModel> model = departmentRepo.findByDepartment(depName);
		List<UserModel> u = new ArrayList<>();
		model.forEach((value) -> {
			value.getEmployee().forEach(x -> {
				if (x.getMobileNumber().equals(mobileNumber)) {
					u.add(x);
				}
			});
		});

		if (u.size()>0&&u.get(0) != null)
			return u.get(0);

		throw new CustomException(String.format("%s does not exist", "user"));

	}

	@Override
	public List<DepartmentModel> getUserWithDepartment() {
		return departmentRepo.findAll().stream().collect(Collectors.toList());

	}

	@Override
	public List<DepartmentModel> getUserFromDepartment(String departmentName) {

		List<DepartmentModel> model = departmentRepo.findByDepartment(departmentName);
//		System.out.println("+++++++++++++++++++------------"+model);

		return model;
	}

}
