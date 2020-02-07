package com.example.demo.dto;

import java.util.List;

public class DepartmentDTO {
	
	private Long departmentId;
	
	private String department;

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
	
	@Override
	public String toString() {
		return "UserModel [departmentId=" + departmentId + ", departmentName=" + department
				+"]";
	}

}
