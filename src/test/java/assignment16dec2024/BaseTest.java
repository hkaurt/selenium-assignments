package assignment16dec2024;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {

	WebDriver driver; // declare it as class level ( default access) to use it throughout the package

	@BeforeMethod
	public void init() {

		// open web browser(chrome)
		driver = new ChromeDriver();// constructor of class ChromeDriver creates object of ref var driver of type WebDriver Interface

		driver.manage().window().maximize(); // maximise browser window

		// open url-https://the-internet.herokuapp.com/
		driver.navigate().to("https://the-internet.herokuapp.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

	}

	@AfterMethod
	public void tearDown() {

		driver.quit(); // will close all instances of browser

	}
}
