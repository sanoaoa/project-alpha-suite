package com.DemoWebTours.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//import junit.framework.Assert;

public class FlightSummeryPage {

	private WebDriver driver;
	
	@FindBy(xpath="(//*[@class=\"data_center\"])[1]")
	WebElement Flight1Price;
	
	@FindBy(xpath="(//*[@class=\"data_center\"])[3]")
	WebElement Flight2Price;
	
	
	@FindBy(xpath="(//*[@class=\"data_left\"])[6]")
	WebElement NoOFPax;

	@FindBy(xpath="(//*[@class=\"data_left\"])[8]")
	WebElement Tax;
	
	@FindBy(xpath="(//*[@class=\"data_left\"])[10]")
	WebElement TotalAmnt;
	
	@FindBy(name="buyFlights")
	WebElement ContinuePurchaseBtn;
	
	public 	FlightSummeryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	
	public void CalculateTheAmount(){
		
		
		int Pax = Integer.parseInt(NoOFPax.getText());
		int tax = Integer.parseInt(Tax.getText().substring(1));
		int Total = Integer.parseInt(TotalAmnt.getText().substring(1));
		
		int FlightCost = Integer.parseInt(Flight1Price.getText())+Integer.parseInt(Flight2Price.getText());
		int TotalAmount = FlightCost*Pax+tax;
		
		Assert.assertEquals(Total, TotalAmount);
		
	}
	
	public void ContinuePurchse() {
		ContinuePurchaseBtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
}
