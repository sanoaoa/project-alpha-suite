package com.DemoWebTours.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegestrationPage {

	private WebDriver driver;
	
	@FindBy(linkText="REGISTER")
	private WebElement Registerlink;
	
	@FindBy(name="firstName")
	WebElement FirstName;
	
	@FindBy(name="lastName")
	WebElement LastName;
	
	@FindBy(name="email")
	WebElement UID;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(name="register")
	WebElement SubmitBtn;
	
public 	RegestrationPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
public void Registration1(String firtName, String lastName) {
	Registerlink.click();
	
	FirstName.sendKeys(firtName);
	LastName.sendKeys(lastName);
	
}

public void Registration2(String UserID, String Pass) {
	
	UID.sendKeys(UserID);
	password.sendKeys(Pass);
	confirmPassword.sendKeys(Pass);
	SubmitBtn.click();
	
}
	
	
	
}
