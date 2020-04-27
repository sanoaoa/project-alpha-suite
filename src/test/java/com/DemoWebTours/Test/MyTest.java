package com.DemoWebTours.Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.DemoWebTours.Pages.BookingConfirmationPage;
import com.DemoWebTours.Pages.FindFlight;
import com.DemoWebTours.Pages.FlightSummeryPage;
import com.DemoWebTours.Pages.LoginAndLogoutPage;
import com.DemoWebTours.Pages.RegestrationPage;
import com.beust.jcommander.Parameter;
import com.tests.BaseTest;

//import junit.framework.Assert;

public class MyTest extends BaseTest{

	//private WebDriver driver;	
	private String NoOfPax;
	private String expectedPrice;

  @BeforeTest
  @Parameters({"NoOfPax","expectedPrice"})
  public void setupParameters(String NoOfPax, String expectedPrice) {
	  this.NoOfPax=NoOfPax;
	  this.expectedPrice = expectedPrice;
  }
	
  @Test
	public void LaunchAppURL() throws InterruptedException {
		System.out.println("Inside LaunchApp Test");
		driver.get("http://www.newtours.demoaut.com/");
		Thread.sleep(2000);
	}
	
  @Test (dependsOnMethods="LaunchAppURL")
  public void RegistrationTest() throws InterruptedException {
	  System.out.println("RegistrationTest");
  RegestrationPage registration = new RegestrationPage(driver);
  registration.Registration1("Selenium", "Docker");
  registration.Registration2("Selenium", "Docker");
  Thread.sleep(3000);
  }

  /*
  @Test//(dependsOnMethods="RegistrationTest")
  public void RegistrationTest() throws InterruptedException {
	  LoginAndLogoutPage login =  new LoginAndLogoutPage(driver);
	  login.logIN("Selenium", "Docker");
	  Thread.sleep(3000);
  }*/

  @Test(dependsOnMethods="RegistrationTest")
  public void SelectFlights() throws InterruptedException {
	  System.out.println("Select Flight");
	  	  FindFlight findfl  = new FindFlight(driver);
	  	  findfl.SelectPAX(NoOfPax); //
	  	  findfl.ContinueForFlightSelection();
	  	Thread.sleep(3000);
  }

  @Test(dependsOnMethods = "SelectFlights")
  public void FlightSummeryTest() throws InterruptedException {
	  System.out.println("Flight Summery Test");
	  FlightSummeryPage FlightSummery = new FlightSummeryPage(driver);
	  FlightSummery.CalculateTheAmount();
	  FlightSummery.ContinuePurchse();
	  Thread.sleep(3000);
  }
  
  @Test(dependsOnMethods="FlightSummeryTest")
  public void ConfPage() throws InterruptedException {
	  System.out.println("Conf Page");
	  BookingConfirmationPage confPage = new BookingConfirmationPage(driver);
	  confPage.ConfirmationPageValidation();
	  confPage.getBookingOrderNumber();
	  String actualPrice = confPage.getFinalPrice();
	  Assert.assertEquals(expectedPrice, actualPrice);
	  Thread.sleep(3000);
  }
  
  @Test(dependsOnMethods="ConfPage")
  public void LogOut() throws InterruptedException {
	  System.out.println("log out");
	  LoginAndLogoutPage login =  new LoginAndLogoutPage(driver);
	  login.Logout();
	  Thread.sleep(3000);
  }
  
  

}
