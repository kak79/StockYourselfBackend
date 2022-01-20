package com.revature.stockYourself.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.stockYourself.StockYourselfApplication;
import com.revature.stockYourself.data.UserRepository;

@SpringBootTest(classes=StockYourselfApplication.class)
public class UserServiceTest {
	
	@MockBean
	private UserRepository userRepo;
	@Autowired
	private UserService userServ;
	

}
