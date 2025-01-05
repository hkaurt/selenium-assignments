package assignment28dec2024;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import assignment18dec2024.BaseTest;
import assignment23dec2024.HrmBaseTest;

public class ApplyLeaveOrangeHRM extends HrmBaseTest {

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

//      1. open url and 2. login to OrangeHrm portal
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

//		//verify dashboard 
//		String actDbHd = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
//		Assert.assertEquals(actDbHd,"Dashboard");

		// go to UserMenu
		driver.findElement(By.xpath("//img[@alt='profile picture']/following-sibling::p")).click();

		// select About
		driver.findElement(By.linkText("About")).click();

		// get company name and verify
		String actCompNm = driver
				.findElement(By
						.xpath("//p[text()='Company Name: ']/parent::div/following-sibling::div/p[text()='OrangeHRM']"))
				.getText();
		Assert.assertEquals(actCompNm, "OrangeHRM");

		// close pop up
		driver.findElement(By.xpath("//button[text()='×']")).click();

		// go to leave
		driver.findElement(By.xpath("//span[text()='Leave']")).click();

//		//verify leave page
//		String actlvPgHd=driver.findElement(By.xpath("//h6[text()='Leave']")).getText();
//		Assert.assertEquals(actlvPgHd, "Leave");

		// click on apply
		driver.findElement(By.xpath("//a[text()='Apply']")).click();

		// verify 'apply leave' page
		String actLvFrmHd = driver.findElement(By.xpath("//h6[text()='Apply Leave']")).getText();
		Assert.assertEquals(actLvFrmHd, "Apply Leave");

		// fill the form

		// 1.select 'Leave Type' from drop down- 'CAN - FMLA'
		driver.findElement(By.xpath("//label[text()='Leave Type']/parent::div/following-sibling::div")).click();
		driver.findElement(By.xpath("//span[text()='CAN - FMLA']")).click();

		// 2.enter 'From Date'
		driver.findElement(By.xpath(
				"//label[text()='From Date']/parent::div/following-sibling::div//input[@placeholder='yyyy-dd-mm']"))
				.sendKeys("2024-28-12");

		// 3.enter 'To Date'
		WebElement toDateEle = driver.findElement(By.xpath(
				"//label[text()='To Date']/parent::div/following-sibling::div//input[@placeholder='yyyy-dd-mm']"));

		// using Actions class to clear the auto date in the 'To Date' text field and
		// entering date
		Actions action = new Actions(driver);
		action.click(toDateEle).keyDown(Keys.CONTROL).sendKeys("A" + "X").keyUp(Keys.CONTROL).sendKeys("2024-29-12")
				.keyDown(Keys.TAB).perform();

		// 4.add comment: vacation applied by H
		driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea"))
				.sendKeys("vacation applied by H");

		// click on 'Apply' button
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// verify pop up confirmation message
		String cfmMsg = driver.findElement(By.xpath("//p[text()='Failed to Submit:']")).getText();
		Assert.assertEquals(cfmMsg, "Failed to Submit: No Working Days Selected");

	}
}
