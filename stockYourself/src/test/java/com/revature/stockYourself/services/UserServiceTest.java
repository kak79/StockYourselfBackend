package com.revature.stockYourself.services;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.stockYourself.StockYourselfApplication;
import com.revature.stockYourself.beans.User;
import com.revature.stockYourself.data.UserRepository;
import com.revature.stockYourself.exceptions.IncorrectCredentialsException;
import com.revature.stockYourself.exceptions.UsernameAlreadyExistsException;

@SpringBootTest(classes=StockYourselfApplication.class)
public class UserServiceTest {
	
	@MockBean
	private UserRepository userRepo;
	@Autowired
	private UserService userServ;
	
	@Test
	public void logInSuccessfully() throws IncorrectCredentialsException {
		// input setup
		String username="qwertyuiop";
		String password="pass";
		
		// set up the mocking
		User mockUser = new User();
		mockUser.setUsername(username);
		mockUser.setPasswrd(password);
		when(userRepo.findByUsername(username)).thenReturn(mockUser);
		
		// call the method we're testing
		User actualUser = userServ.logIn(username, password);
		
		// assert the expected behavior/output
		assertEquals(mockUser,actualUser);
	}
	
	@Test
	public void logInIncorrectPassword() {
		String username="qwertyuiop";
		String password="12345";
		
		User mockUser = new User();
		mockUser.setUsername(username);
		mockUser.setPasswrd("pass");
		when(userRepo.findByUsername(username)).thenReturn(mockUser);
		
		assertThrows(IncorrectCredentialsException.class, () -> {
			userServ.logIn(username, password);
		});
	}
	
	@Test
	public void logInUsernameDoesNotExist() {
		String username="asdfghjkl";
		String password="pass";
		
		when(userRepo.findByUsername(username)).thenReturn(null);
		
		assertThrows(IncorrectCredentialsException.class, () -> {
			userServ.logIn(username, password);
		});
	}
	
//	@Test
//	public void registerPersonSuccessfully() throws UsernameAlreadyExistsException {
//		User person = new User();
//		person.setUserId(10);
//		
//		when(userRepo.save(person)).thenReturn(person);
//		
//		User actualUser = userServ.register(person);
//		assertEquals(10, actualUser.getUserId());
//	}
	
//	@Test
//	public void registerPersonSomethingWrong() throws UsernameAlreadyExistsException {
//		User user = new User();
//		when(userRepo.save(user)).thenThrow(new RuntimeException());
//		User actualUser = userServ.register(user);
//		assertNull(actualUser);
//	}
//	
//	@Test
//	public void registerPersonUsernameAlreadyExists() {
//		User user = new User();
//		when(userRepo.save(user)).thenThrow(new RuntimeException("unique constraint violation"));
//
//		assertThrows(UsernameAlreadyExistsException.class, () -> {
//			userServ.register(user);
//		});
//	}
	
}
