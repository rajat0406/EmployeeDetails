package com.example.demo.model;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="employee")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="registerNo", unique=true, nullable = false)
	private Long registerNo;
	
	@Column(name = "name" , unique = false, nullable = false)
	private String name;

	@Column(name = "city",unique = false, nullable = false)
	private String city;

	@Column(name = "mobileNumber", unique = true,nullable = false)
	@Pattern(regexp = "(^[0-9]{10}$)", message = "Not a valid contact number.It must be ten digit.")
	private String mobileNumber;

//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@Column(name="department", unique = true, nullable = false)
//	@JoinTable(name="department", joinColumns = @JoinColumn(name = "registerNo"), inverseJoinColumns = @JoinColumn(name = "departmentId"))
//	private List<DepartmentModel> department ;
//	
//
//	public List<DepartmentModel> getDepartment() {
//		return (List<DepartmentModel>) department;
//	}
//
//	public UserModel setDepartment(List<DepartmentModel> department) {
//		this.department = department;
//		return this;
//	}

	public Long getRegisterNo(){
		return registerNo;
	}

	public UserModel setRegisterNo(Long registerNo) {
		this.registerNo = registerNo;
		return this;
	}

	public String getName() {
		return name;
	}

	public UserModel setName(String name) {
		this.name = name;
		return this;
	}

	public String getCity() {
		return city;
	}

	public UserModel setCity(String city) {
		this.city = city;
		return this;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public UserModel setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
		return this;
	}
	
	@Override
	public String toString() {
		//System.out.println("Hello Application");
		return "UserModel [registerNo=" + registerNo + ", name=" + name + ", city=" + city
				+ ", mobileNumber=" + mobileNumber + "]";
	}
	

}
