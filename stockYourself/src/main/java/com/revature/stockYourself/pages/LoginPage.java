package com.revature.stockYourself.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy(id="home")
	private WebElement homeBtn;
	@FindBy(id="login")
	private WebElement logInBtn;
	@FindBy(id="submitLogin")
	private WebElement submitLogin;
	@FindBy(id="Logout")
	private WebElement logOutBtn;
	
	
	
	
	public void navigateTo() {
        driver.get("http://localhost:4200");
    }
	
	
	
	

}
