package com.example.demo.controller;

import javax.validation.constraints.Positive;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.model.DepartmentModel;
import com.example.demo.service.DepartmentService;
import com.example.demo.utils.ResponseModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/department")
@Api(value="department")
public class DepartmentController {
	Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	public DepartmentService departmentService;
	
	@GetMapping("/addDepartment")
	public ResponseEntity<ResponseModel> saveDepartment() {
		return new ResponseEntity<>(new ResponseModel()
				.setStatus(1)
				.setMessage("Succesfully Fetched")
				.setObject(departmentService.saveDepartment())
				,HttpStatus.OK);
	}
	@PostMapping("/addDepartmentWithUser")
	public ResponseEntity<ResponseModel> saveDepartmentWithUser(@RequestBody DepartmentModel departmentModel) {
		return new ResponseEntity<>(new ResponseModel()
				.setStatus(1)
				.setMessage("Succesfully Saved")
				.setObject(departmentService.saveDepartmentWithUser(departmentModel))
				,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<ResponseModel> getUserWithDepartment(){
		return new ResponseEntity<>(new ResponseModel()
				.setStatus(1)
				.setMessage("Succesfully Saved")
				.setObject(departmentService.getUserWithDepartment())
				,HttpStatus.OK);
		
	}
	
	@GetMapping("/getUserOfSameDepartment/{departmentName}")
	public ResponseEntity<ResponseModel> getUserFromDepartment(@PathVariable("departmentName") String DepartmentName){
		return new ResponseEntity<>(new ResponseModel()
				.setStatus(1)
				.setMessage("Succesfully Fetched")
				.setObject(departmentService.getUserFromDepartment(DepartmentName))
				,HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Find The user by userId ")
	@GetMapping("/id/{id}")
	public ResponseEntity<ResponseModel> findUserByDeptId(@PathVariable("id") @Positive(message = "Id must be greater than 0")  Long userId){
		return new ResponseEntity<>(new ResponseModel()
				.setStatus(1)
				.setMessage("Succesfully Fetched")
				.setObject(departmentService.findUserByDeptId(userId))
				,HttpStatus.OK);	
	}
	
	@ApiOperation(value = "Find The user by userId ")
	@GetMapping("/fewValues/{id}")
	public ResponseEntity<ResponseModel> findUserFewDetailsByDeptId(@PathVariable("id") @Positive(message = "Id must be greater than 0")  Long userId){
		return new ResponseEntity<>(new ResponseModel()
				.setStatus(1)
				.setMessage("Succesfully Fetched")
				.setObject(departmentService.findUserFewDetailsByDeptId(userId))
				,HttpStatus.OK);	
	}
	
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<ResponseModel> deleteUserByDeptId(@PathVariable("id") @Positive(message = "Id must be greater than 0")  Long userId){
		departmentService.deleteUserByDeptId(userId);
		return new ResponseEntity<>(new ResponseModel()
				.setStatus(1)
				.setMessage("Successfully Deleted")		
				,HttpStatus.OK);
		
	}
	
	@PostMapping("/empInfo")
	public ResponseEntity<ResponseModel> getDepartmentDetails(@RequestParam String depName,@RequestParam String mobileNumber) {
		return new ResponseEntity<>(new ResponseModel()
				.setStatus(1)
				.setMessage("Succesfully Fetched")
				.setObject(departmentService.getDepartmentDetails(depName, mobileNumber))
				,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseModel> updateDepartment(@PathVariable("id") @Positive(message = "id must be greater than 0")  Long depId,@RequestBody DepartmentDTO depDTO){
		return new ResponseEntity<>(new ResponseModel()
				.setStatus(1)
				.setMessage("Succesfully Updated")
				.setObject(departmentService.updateDepartment(depDTO, depId))
				,HttpStatus.OK);	
	}	

}
