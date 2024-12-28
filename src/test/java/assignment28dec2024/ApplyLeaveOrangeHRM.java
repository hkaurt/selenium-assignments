package assignment28dec2024;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import assignment18dec2024.BaseTest;

public class ApplyLeaveOrangeHRM extends BaseTest {

	/*
	 * Login to OrangeHR
	 * portal-https://opensource-demo.orangehrmlive.com/web/index.php/auth/login Go
	 * to UserMenu and select About - Verify the Company Name, Close the pop up
	 * Click on Leave-> Click on Apply Add detail and apply for leave Go to My Leave
	 * tab Verify that your entry is available in the table- Verify Date, Leave
	 * Type, No of Days, Comment and Actions is "Cancel"
	 */

	@Test
	public void verifyLeave() {

		// open url and login to OrangeHrm portal
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

//		//verify dashboard 
//		String dashboardHead = driver.findElement(By.xpath("//div[@id='app']/div/div[1]/header/div[1]/div[1]/span")).getText(); //xpath("//div[@id='app']//span/h6")
//		Assert.assertEquals(dashboardHead,"Dashboard");

		// go to UserMenu
		driver.findElement(By.xpath("//div[@id='app']/div/div[1]/header/div[1]/div[3]/ul/li")).click();

		// select About
		driver.findElement(By.linkText("About")).click();

		// get company name and verify
		String companyName = driver.findElement(By.xpath("//p[text()='OrangeHRM']")).getText();
		Assert.assertEquals(companyName, "OrangeHRM");

		// close pop up
		driver.findElement(By.xpath("//button[text()='×']")).click();

		// go to leave
		driver.findElement(By.xpath("//span[text()='Leave']")).click();

//		//verify leave page
//		String leavePgH=driver.findElement(By.xpath("//div[@id='app']/div/div[1]/header/div[1]/div[1]/span/h6")).getText();
//		Assert.assertEquals(leavePgH, "Leave");

		// click on apply
		driver.findElement(By.xpath("//a[text()='Apply']")).click();

//		//verify 'apply leave' page 
//		String leaveFormHead=driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/h6")).getText();
//		Assert.assertEquals(leaveFormHead, "Apply Leave");

		// fill the form

		// 1.select 'Leave Type' from drop down- 'CAN - FMLA'
		driver.findElement(By.xpath("//form/div[1]/div/div[1]/div/div[2]")).click();

		driver.findElement(By.xpath("//span[text()='CAN - FMLA']")).click();
		// driver.findElement(By.xpath("//div[@class='oxd-select-option']/span[text()='CAN - FMLA']")).click();

		// 2.enter 'From Date'
		driver.findElement(By.xpath("//form/div[2]/div/div[1]/div/div[2]/div/div/input")).sendKeys("2024-28-12");

		// 3.enter 'To Date'
		WebElement toDateEle = driver.findElement(By.xpath("//form/div[2]/div/div[2]/div/div[2]/div/div/input"));

		// using Actions class to clear the auto date in the 'To Date' text field and
		// entering date
		Actions action = new Actions(driver);
		action.click(toDateEle).keyDown(Keys.CONTROL).sendKeys("A" + "X").keyUp(Keys.CONTROL).sendKeys("2024-28-12").keyDown(Keys.TAB).perform();

		// 4.add comment: vacation applied by H
		driver.findElement(By.xpath("//form/div[4]/div/div/div/div[2]/textarea")).sendKeys("vacation applied by H");

		// click on 'Apply' button
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// verify pop up confirmation message
		String confirmMsg = driver.findElement(By.xpath("//p[contains(string(),'Failed to Submit:')]")).getText();
		Assert.assertEquals(confirmMsg, "Failed to Submit: No Working Days Selected");

	}
}
