package com.example.demo.dto;

import java.util.List;

public class DepartmentDTO {
	
	private Long departmentId;
	
	private String department;
	
	private List<UserDto> employee;
	
	

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
