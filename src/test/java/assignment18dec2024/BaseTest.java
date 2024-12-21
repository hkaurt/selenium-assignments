package assignment18dec2024;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	WebDriver driver; // declare it as class level ( default access) to use it throughout the package

	@BeforeMethod
	public void init() {

		// open web browser
		//driver = new ChromeDriver();// constructor of class ChromeDriver creates object of ref var driver of type WebDriver Interface

		//cross-browser testing
		String browser="Chrome";
		
		switch(browser.toUpperCase()) {
		
		case "CHROME": driver= new ChromeDriver(); break;
		case "EDGE": driver= new ChromeDriver(); break;
		case "FIREFOX": driver= new ChromeDriver(); break;
		case "SAFARI": driver= new ChromeDriver(); break;
		default : System.out.println("driver not found"); break;
	
		}
		
		//window handles
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //should be right after driver initiatiation and will be auto applied on each findElement until it finds the element or timeout- do not use for 5 sec time , will save time if element is found before 5 sec
		driver.manage().window().maximize(); // maximise browser window

	}

	@AfterMethod
	public void tearDown() {

		driver.quit(); // avoid driver.close as it does not kill the browser instance especially if browser closing / opening is repeated in following methods and throws error

	}
}
