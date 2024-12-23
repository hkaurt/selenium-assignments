package assignment21dec2024;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import assignment18dec2024.BaseTest;

public class JavascriptEx extends BaseTest {

	@Test
	public void loginTest() {

		// open url
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// enter username and password
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		// driver.findElement(By.xpath("//button[@type='submit']")).click();

		// using JavascriptExecutor its an interface: below is typecasting of driver to JavascriptExecutor ref var to executescript
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// WebElement usernameText=driver.findElement(By.name("username"));
		// js.executeScript("arguments[0].value='Admin';",usernameText);

		// WebElement pwdText=driver.findElement(By.name("password"));
		// js.executeScript("arguments[0].value='admin123';",pwdText);

		// click on login button using JavascriptExecutor
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		js.executeScript("arguments[0].click();", loginBtn);

		// find url of landing page or homepage
		String url = js.executeScript("return document.URL").toString();
		System.out.println(url);

		// verify the actual url with expected url
		Assert.assertEquals(url, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

		// reload landing page
		js.executeScript("location.reload();");
		// driver.navigate().refresh();

		// Use JavaScriptExecutor to scroll the element into view
		WebElement webEle = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[7]/div/div[1]/div/p"));
		js.executeScript("arguments[0].scrollIntoView(true);", webEle);
		
		//js.executeScript("window.scrollBy(0,1000);");  //vertical scroll
		
		Assert.assertEquals(webEle.getText(), "Employee Distribution by Location");

	}
}
