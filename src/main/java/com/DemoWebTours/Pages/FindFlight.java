package com.DemoWebTours.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlight {
	
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath="//*[contains(text(),'Flights')]")
	WebElement FlightsLink;
	
	@FindBy(name="passCount")
	WebElement passCount;

	@FindBy(name="findFlights")
	WebElement ContinueBtn;
	
	@FindBy(name="reserveFlights")
	WebElement ReserveFlight;
	
	
	public FindFlight(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SelectPAX(String noOfPassenger) { //
		FlightsLink.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		new Select(passCount).selectByVisibleText(noOfPassenger);
		//new Select(passCount).selectByVisibleText("2");
	}
	
	public void ContinueForFlightSelection() {
		ContinueBtn.click();
		ReserveFlight.click();
	}
	
	
	
}
