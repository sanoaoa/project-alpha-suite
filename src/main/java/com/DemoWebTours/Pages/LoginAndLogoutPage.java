package com.DemoWebTours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAndLogoutPage {
	private WebDriver driver;

	@FindBy(linkText="SIGN-ON")
	WebElement SignIn;
	
	@FindBy(name="userName")
	WebElement userID;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(name="login")
	WebElement SignInBtn;
	
	@FindBy(linkText="SIGN-OFF")
	WebElement SignOut;
	
	public 	LoginAndLogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}		
	
	public void logIN(String UID, String Pass) {
		SignIn.click();
		userID.sendKeys(UID);
		Password.sendKeys(Pass);
		SignIn.click();
	}
	
	public void Logout() {
		SignOut.click();
	}
	
	
	

}
