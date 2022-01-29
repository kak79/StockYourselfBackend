package com.revature.stockYourself.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy(id="home")
	private WebElement homeBtn;
	@FindBy(id="stocks")
	private WebElement stocksBtn;
	@FindBy(id="posts")
	private WebElement postsBtn;
	@FindBy(id="portfolios")
	private WebElement portfoliosBtn;
	@FindBy(id="login")
	private WebElement logInBtn;
	@FindBy(id="submitLogin")
	private WebElement submitLogin;
	@FindBy(id="Logout")
	private WebElement logOutBtn;
	@FindBy(id="inputUserName")
	private WebElement inputUserName;
	@FindBy(id="inputPassword")
	private WebElement inputPassword;
	
	public LoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
	
	public void navigateTo() {
        driver.get("http://localhost:4200");
    }
	
	public void loginToPage() {
		homeBtn.click();
		logInBtn.click();
		inputUserName.sendKeys("bdixon");
		inputPassword.sendKeys("pass");
		submitLogin.click();
	}
	
	public void verifyLoggedIn() {
		navigateTo();
		homeBtn.click();
	}
	
	public void logOut() {
		homeBtn.click();
		logOutBtn.click();
	}
	

}
