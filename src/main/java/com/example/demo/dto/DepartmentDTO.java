package com.example.demo.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class DepartmentDTO {
	
	private Long departmentId;
	
	private String department;
	
	private List<UserDto> employee;
	
	@ApiModelProperty(notes = "status of the user. 1-Active | 2-Inactive | 5-SoftDelete")
	private int userStatus;
	
	public int getUserStatus() {
		return userStatus;
	}

	public DepartmentDTO setUserStatus(int userStatus) {
		this.userStatus = userStatus;
		return this;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public DepartmentDTO setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
		return this;
	}

	public String getDepartment() {
		return department;
	}

	public DepartmentDTO setDepartment(String department) {
		this.department = department;
		return this;
	}

	public List<UserDto> getEmployee() {
		return employee;
	}

	public DepartmentDTO setEmployee(List<UserDto> employee) {
		this.employee = employee;
		return this;
	}
	
	public String toString() {
		
		return "DepartmentDTO [departmentId=" + departmentId + ", departmentName=" + department + ", employee=" + employee
				+"]";
	}
	

}
