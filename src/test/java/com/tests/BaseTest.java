package com.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	protected WebDriver driver;
	@BeforeTest
	public void setUp() throws MalformedURLException{
		/*User has to provide the below
		 * BROWSER=> Chrome, Firfox etc
		 *  HUB_HOST => localhost / 10.0.1.3 / host name etc
		 */
		
		String host = "localhost";
		DesiredCapabilities DC = DesiredCapabilities.chrome(); //THESE ARE DEFAULT VALUE OF HOST AND BROWSER
		
		if(System.getProperty("BROWSER") != null &&      									//VALUE OF BROWSER IF PROVIDED BY USER
				System.getProperty("BROWSER").equalsIgnoreCase("Firefox")) {
			DC = DesiredCapabilities.firefox();
		}	
		
		if(System.getProperty("HUB_HOST")!=null) {										//VALUE OF HUB IF PROVIDED BY USER
			host=System.getProperty("HUB_HOST");
		}		
		
		String completeUrl = "http://"+ host + ":4444/wd/hub";
		
		this.driver = new RemoteWebDriver(new URL(completeUrl), DC);
		
		  /*System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver 3"); 
		  this.driver = new ChromeDriver();
		  driver.manage().window().maximize();*/
	  }
	
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}

}
