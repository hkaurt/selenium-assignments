package assignment21dec2024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import assignment16dec2024.BaseTest;

public class ForgotPasswordTest extends BaseTest{

	String expectedErrorMsg = "Internal Server Error";
	String expectedHeading = "Forgot Password";
	String expectedFooter = "Elemental Selenium";
	String expectedTitle = "The Internet";
	
	public void clickForgotPasswordLink() {

		// Click on link - Forgot Password
		WebElement forgotPwdLink = driver.findElement(By.linkText("Forgot Password")); 
		//WebElement forgotPwdLink = driver.findElement(By.xpath("//a[text()='Forgot Password']"));  //xpath("//a[@href='/forgot_password']")
		forgotPwdLink.click();

	}

	@Test
	public void VerifyForgotPasswordTest() {

		clickForgotPasswordLink(); // click on Forgot password link

		// Enter email in the Text box
		WebElement emailText = driver.findElement(By.id("email")); //always prefer id attribute if present as its unique and efficient than other locators
		//WebElement emailText = driver.findElement(By.name("email"));
		//WebElement emailText = driver.findElement(By.xpath("//input[@type='text']"));  //xpath("//input[@name='email']")
		
		emailText.sendKeys("hkaur@gmail.com"); 

		// Click on retrieve password button
		WebElement retrievePwdBtn = driver.findElement(By.id("form_submit"));
		//WebElement retrievePwdBtn = driver.findElement(By.className("radius"));
		//WebElement retrievePwdBtn = driver.findElement(By.xpath("//button[@type='submit']"));  //xpath("//button[@class='radius']");
		retrievePwdBtn.click();

		// Verify if actual heading is same as expected heading - "Internal Server Error"
		WebElement actualErrorEle = driver.findElement(By.tagName("h1"));  // if duplicated then use xpath instead
	    //WebElement actualErrorEle = driver.findElement(By.xpath("//h1[text()='Internal Server Error']"));
		
		String actualErrorMsg = actualErrorEle.getText();

		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

	}

	@Test(priority = 1)
	public void VerifyForgotPasswordPageHeadingTest() {

		clickForgotPasswordLink(); // click on Forgot password link

		// find actual page Heading
		WebElement actualHeadingEle = driver.findElement(By.tagName("h2")); 
		//WebElement actualHeadingEle = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));  //xpath("//*[@class='example']/h2"), //xpath("//*[@id='content']/div/h2")
		String actualHeadingText = actualHeadingEle.getText(); // get text of the element

		// Verify the actual Heading matches the expected Heading "Forgot Password"
		Assert.assertEquals(actualHeadingText, expectedHeading); // calling static assertEquals(para1,para2) method of Assert class for comparison and verify

	}

	@Test(priority = 2)
	public void verifyPageFooterTest() {

		clickForgotPasswordLink(); // click on Forgot password link

		// Find Page Footer
		WebElement PageFooterEle = driver.findElement(By.linkText("Elemental Selenium"));
		//WebElement PageFooterEle = driver.findElement(By.xpath("//*[@id='page-footer']/div/div/a"));  //xpath("//a[text()='Elemental Selenium']"),   //xpath("//a[@target='_blank']") //xpath=("//a[@href='http://elementalselenium.com/']") least used
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
