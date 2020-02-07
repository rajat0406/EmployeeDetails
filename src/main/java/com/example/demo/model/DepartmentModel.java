package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="department")
public class DepartmentModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="departmentId", unique=true, nullable = false)
	private Long departmentId;
	
	@Column(name="department", unique=false, nullable = false)
	private String department;
		
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="employee_info", joinColumns = @JoinColumn(name = "departmentId"), inverseJoinColumns = @JoinColumn(name = "registerId"))
	@Column(name="employee", unique=false, nullable = false)
	private List<UserModel> employee;
	
	
	public String getDepartment() {
		return department;
	}
	public DepartmentModel setDepartment(String department) {
		this.department = department;
		return this;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public DepartmentModel setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
		return this;
	}
	public List<UserModel> getEmployee() {
		return employee;
	}
	public DepartmentModel setEmployee(List<UserModel> employee) {
		this.employee = employee;
		return this;
	}
	
	@Override
	public String toString() {
		return "UserModel [departmentId=" + departmentId + ", departmentName=" + department + ", employee=" + employee
				+"]";
	}
	

}