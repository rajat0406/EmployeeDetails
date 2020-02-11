package com.example.demo.controllerUnitTest;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.demo.controller.DepartmentController;
import com.example.demo.model.DepartmentModel;
import com.example.demo.model.UserModel;
import com.example.demo.service.DepartmentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DepartmentController.class)
public class DepartmentControllerUnitTest {
	
	@Autowired
	public MockMvc mvc;
	
	@MockBean
	public DepartmentService departmentService;
	
	@Test
	@DisplayName("saveDepartmentWithUser Unit Test")
	public void saveDepartmentWithUserUnitTest() {
		
		UserModel userModel = new UserModel();
		userModel.setName("Chaudhary");
		userModel.setCity("Noida");
		userModel.setMobileNumber("1234567891");
		
		userModel.setRegisterNo(1l);
		
		List<UserModel> userModels = new ArrayList<>();
		userModels.add(userModel);
		DepartmentModel departmentModel = new DepartmentModel();
		departmentModel.setDepartment("CustomerSupportDepartMent");
		departmentModel.setEmployee(userModels);	
		
		try {
			
			when(departmentService.saveDepartmentWithUser(departmentModel)).thenReturn(departmentModel);
			
			MvcResult obj = mvc.perform(post("/department/addDepartmentWithUser")
										.contentType(MediaType.APPLICATION_JSON)
										.content(new ObjectMapper().writeValueAsString(departmentModel)))
									    .andExpect(status().isOk())
									    .andReturn();
			
			JSONObject jsonObj = new JSONObject(obj.getResponse().getContentAsString());
			
			assertEquals(1 , jsonObj.get("status"));	
			
		}
		catch(Exception e) {
			System.out.println("The Exception is -------------- " + e);
		}
	}
	

}
