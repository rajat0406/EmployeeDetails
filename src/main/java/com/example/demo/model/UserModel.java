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
	
	
	@Column(name = "userStatus", columnDefinition = "int default 1", nullable = false)
	private int userStatus;

//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinTable(name="employee_info", joinColumns = @JoinColumn(name = "registerId"), inverseJoinColumns = @JoinColumn(name = "Id"))
//	private List<DepartmentModel> department ;
	
//
//	public List<DepartmentModel> getDepartment() {
//		return (List<DepartmentModel>) department;
//	}		userModel.setUserStatus(1);
//
//	public UserModel setDepartment(List<DepartmentModel> department) {
//		this.department = department;
//		return this;
//	}

//	public List<DepartmentModel> getDepartment() {
//		return department;
//	}
//
//	public UserModel setDepartment(List<DepartmentModel> department) {
//		this.department = department;
//		return this;
//	}

	public int getUserStatus() {
		return userStatus;
	}

	public UserModel setUserStatus(int userStatus) {
		this.userStatus = userStatus;
		return this;
	}

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
