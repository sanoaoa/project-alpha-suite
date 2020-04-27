package com.DemoWebTours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//import junit.framework.Assert;

public class BookingConfirmationPage {
private WebDriver driver;

@FindBy(xpath="//*[contains(text(),'itinerary has been booked!')]")
WebElement ConfirmationMesge;

@FindBy(xpath="//*[contains(text(),'Confirmation #')]")
WebElement BookingOrderNo;

@FindBy(xpath="(//*[contains(text(),'$')])[1]")
WebElement Tax;

@FindBy(xpath="(//*[contains(text(),'$')])[2]")
WebElement Total;
		
public 	BookingConfirmationPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}	

public void ConfirmationPageValidation() {
	Assert.assertEquals("Your itinerary has been booked!", ConfirmationMesge.getText());
	
}

public String getBookingOrderNumber() {
	String OrderNumber = BookingOrderNo.getText().split("#")[1];
	System.out.println("Order Number # "+OrderNumber);
	return OrderNumber;	
}

public String getFinalPrice() {
	String TotalAmount = Total.getText();
	System.out.println("Total Amount payable is "+TotalAmount);
	return TotalAmount;	
}



}
