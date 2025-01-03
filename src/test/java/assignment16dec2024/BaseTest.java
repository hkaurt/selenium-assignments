package assignment16dec2024;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {

	public WebDriver driver; // declare it as class level ( default access) to use it throughout the package

	@BeforeMethod
	public void init() {

		// open web browser
		driver = new ChromeDriver();// constructor of class ChromeDriver creates object of ref var driver of type WebDriver Interface
		
		//window handles
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //should be right after driver initiatiation and will be auto applied on each findElement until it finds the element or timeout- do not use for 5 sec time , will save time if element is found before 5 sec
		driver.manage().window().maximize(); // maximise browser window
		
		// open url-https://the-internet.herokuapp.com/
		driver.navigate().to("https://the-internet.herokuapp.com/");  //driver.get("url");

	}

	@AfterMethod
	public void tearDown() {

		driver.quit(); // avoid driver.close as it does not kill the browser instance especially if browser closing / opening is repeated in following methods and throws error

	}
}
