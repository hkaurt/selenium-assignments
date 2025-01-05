package assignment23dec2024;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//DRY principle- Do not repeat code

public class HrmBaseTest {

	public WebDriver driver; // instance var - declare at class level to use in other methods

	@BeforeMethod
	public void init() {

		String browser = "Chrome";

		// cross browser testing
		switch (browser.toLowerCase()) {

		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("invalid browser");
			break;

		}

		// implicitly wait must be added right after the driver initialization,
		// it will wait until given element is found or for mentioned time whichever is
		// earliest
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}
}
