package assignment18dec2024;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleAlerts extends BaseTest { // inherited from other package class

	@Test
	public void handleJsALert() {
		// open url
		driver.get("https://the-internet.herokuapp.com/");

		// click on JavaScript Alerts link
		driver.findElement(By.linkText("JavaScript Alerts")).click();

		// click on "Click for JS Alert" button
		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/button")).click();

		Alert jsAlert = driver.switchTo().alert(); // Alert is an interface
		jsAlert.accept();
		String jsAlertMsg = driver.findElement(By.xpath("//*[@id='result']")).getText();
		Assert.assertEquals(jsAlertMsg, "You successfully clicked an alert");

		// click on "Click for JS Confirm" button
		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button")).click();
		jsAlert.dismiss();
		String jsCancelMsg = driver.findElement(By.xpath("//*[@id='result']")).getText();
		Assert.assertEquals(jsCancelMsg, "You clicked: Cancel");

		// click on "Click for JS prompt" button   
		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button")).click();
		jsAlert.sendKeys("HEY!!");   // locate text box in alert and enter keys
		jsAlert.accept();   // click on ok in alert
		String jsPromptMsg = driver.findElement(By.xpath("//*[@id='result']")).getText();
		Assert.assertEquals(jsPromptMsg, "You entered: HEY!!");
	}

	@Test
	public void handleAlertDemo() {
		// open url
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");

		//click on "Double click me to see Alert"
		WebElement alertButtonEle=driver.findElement(By.xpath("//*[@id='authentication']/button"));
		Actions action=new Actions(driver);
		action.doubleClick(alertButtonEle).perform();
		
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
	}
	
	
}
