package com.revature.stockYourself.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.stockYourself.StockYourselfApplication;
import com.revature.stockYourself.beans.User;
import com.revature.stockYourself.exceptions.IncorrectCredentialsException;
import com.revature.stockYourself.exceptions.UsernameAlreadyExistsException;
import com.revature.stockYourself.services.UserService;

@SpringBootTest(classes=StockYourselfApplication.class)
public class UsersControllerTest {
	
	@MockBean
	private UserService userServ;
	
	@Autowired
	private UsersController usersCtrl;
	
	private static MockMvc mockMvc;
	
	private ObjectMapper objMapper = new ObjectMapper();
	
	@BeforeAll
	public static void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(UsersController.class).build();
	}
	
	@Test
	public void checkLoginUserExists() throws Exception {
		when(userServ.getUserById(1)).thenReturn(new User());
		
		mockMvc.perform(get("/users/{userId}/auth", 1))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andReturn();
	}
	
	@Test
	public void checkLoginUnauthorized() throws Exception {
		when(userServ.getUserById(0)).thenReturn(null);
		
		mockMvc.perform(get("/users/{userId}/auth", 0))
			.andExpect(status().isUnauthorized())
			.andReturn();
	}
	
	@Test
	public void getUserByIdUserExists() throws Exception {
		when(userServ.getUserById(1)).thenReturn(new User());
		
		mockMvc.perform(get("/users/{userId}", 1))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andReturn();
	}
	
	@Test
	public void getUserByIdUserDoesNotExist() throws Exception {
		when(userServ.getUserById(0)).thenReturn(null);
		
		mockMvc.perform(get("/users/{userId}", 0))
			.andExpect(status().isNotFound())
			.andReturn();
	}
	
	@Test
	public void logInCorrectly() throws Exception {
		when(userServ.logIn("test", "test")).thenReturn(new User());
		
		String jsonCredentials = "{"
				+ "\"username\":\"test\","
				+ "\"password\":\"test\""
				+ "}";
		mockMvc
			.perform(post("/users/auth").content(jsonCredentials).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string("0"))
			.andReturn();
	}
	
	@Test
	public void logInIncorrectCredentials() throws Exception {
		Map<String, String> credentials = new HashMap<>();
		credentials.put("username", "test");
		credentials.put("password", "test");
		
		when(userServ.logIn(credentials.get("username"), credentials.get("password")))
			.thenThrow(IncorrectCredentialsException.class);
		
		String jsonCredentials = objMapper.writeValueAsString(credentials);
		
		mockMvc
			.perform(post("/users/auth").content(jsonCredentials).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound())
			.andReturn();
	}
	
//	@Test
//	public void registerSuccessfully() throws Exception {
//		User newUser = new User();
//		
//		when(userServ.register(newUser)).thenReturn(newUser);
//		Map<String,Integer> idMap = new HashMap<>();
//		idMap.put("generatedId", 0);
//		
//		String jsonUser = objMapper.writeValueAsString(newUser);
//		String jsonIdMap = objMapper.writeValueAsString(idMap);
//		mockMvc.perform(post("/users").content(jsonUser).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isCreated())
//				.andExpect(content().json(jsonIdMap))
//				.andReturn();
//	}
	
//	@Test
//	public void registerUsernameAlreadyExists() throws Exception {
//		User newUser = new User();
//		
//		when(userServ.register(newUser)).thenThrow(UsernameAlreadyExistsException.class);
//		
//		String jsonUser = objMapper.writeValueAsString(newUser);
//		mockMvc.perform(post("/users").content(jsonUser).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isConflict())
//				.andReturn();
//	}

}
