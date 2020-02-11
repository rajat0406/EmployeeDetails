package com.example.demo.controller;

import javax.validation.constraints.Positive;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.service.Userservice;
import com.example.demo.utils.ResponseModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/user")
@Api(value="employee")
public class UserController {
	Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private Userservice userService;
	
	@PostMapping("/add")
	public ResponseEntity<ResponseModel> saveUser(@RequestBody UserDto userDto) {
		return new ResponseEntity<>(new ResponseModel()
				.setStatus(1)
				.setMessage("Succesfully Saved")
				.setObject(userService.saveUser(userDto))
				,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<ResponseModel> getUser(){
		return new ResponseEntity<>(new ResponseModel()
				.setStatus(1)
				.setMessage("Succesfully Saved")
				.setObject(userService.getUser())
				,HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Find The user by mobile ")
	@GetMapping("/mobile/{mobile}")
	public ResponseEntity<ResponseModel> findByMobileNumber(@PathVariable("mobile") @Positive(message = "Id must be greater than 0")  String mobile){
		return new ResponseEntity<>(new ResponseModel()
				.setStatus(1)
				.setMessage("Succesfully Saved")
				.setObject(userService.findByMobileNumber(mobile))
				,HttpStatus.OK);
		
	}
}
