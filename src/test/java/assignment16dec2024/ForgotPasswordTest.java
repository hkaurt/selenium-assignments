package assignment16dec2024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest {

	String expectedErrorMsg = "Internal Server Error";
	String expectedHeading = "Forgot Password";
	String expectedFooter = "Elemental Selenium";
	String expectedTitle = "The Internet";

	public void clickForgotPasswordLink() {

		// Click on link - Forgot Password
		WebElement forgotPwdLink = driver.findElement(By.linkText("Forgot Password")); // locate the element
		forgotPwdLink.click();

	}

	@Test
	public void VerifyForgotPasswordTest() {

		clickForgotPasswordLink(); // click on Forgot password link

		// Enter email in the Text box
		WebElement emailText = driver.findElement(By.xpath("//*[@id='email']"));
		emailText.sendKeys("hkaur@gmail.com"); //

		// Click on retrieve password button
		WebElement retrievePwdBtn = driver.findElement(By.xpath("//*[@id='form_submit']"));
		retrievePwdBtn.click();

		// Verify if actual heading is same as expected heading - "Internal Server Error"
		WebElement actualErrorEle = driver.findElement(By.xpath("/html/body/h1"));
		String actualErrorMsg = actualErrorEle.getText();

		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

	}

	@Test(priority = 1)
	public void VerifyForgotPasswordPageHeadingTest() {

		clickForgotPasswordLink(); // click on Forgot password link

		// find actual page Heading
		WebElement actualHeadingEle = driver.findElement(By.xpath("//*[@id='content']/div/h2")); // page
		String actualHeadingText = actualHeadingEle.getText(); // get text of the element

		// Verify the actual Heading matches the expected Heading "Forgot Password"
		Assert.assertEquals(actualHeadingText, expectedHeading); // calling static assertEquals(para1,para2) method of Assert class for comparison and verify

	}

	@Test(priority = 2)
	public void verifyPageFooterTest() {

		clickForgotPasswordLink(); // click on Forgot password link

		// Find Page Footer
		WebElement PageFooterEle = driver.findElement(By.xpath("//*[@id='page-footer']/div/div/a"));
		String PageFooterText = PageFooterEle.getText();

		// Verify actual Page footer is same as expected page
		Assert.assertEquals(PageFooterText, expectedFooter);

	}

	@Test(priority = 3)
	public void verifyTitleTest() {

		clickForgotPasswordLink();  // click on Forgot password link

		// Find actual page title
		String actualTitle = driver.getTitle();

		// Verify actual page title is same as expected title - "The Internet"
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
}
