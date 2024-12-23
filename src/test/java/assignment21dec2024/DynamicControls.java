package assignment21dec2024;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import assignment16dec2024.BaseTest;

public class DynamicControls extends BaseTest{
	
	@Test
	public void removeButtonTest() {
		
		//click on Dynamic Controls link
		driver.findElement(By.linkText("Dynamic Controls")).click();

		//click on 'Remove' button
		driver.findElement(By.xpath("//*[@id='checkbox-example']/button")).click();
		
		//verify expected "It's gone!" message with actual message
		String message=driver.findElement(By.xpath("//*[@id='message']")).getText();
		Assert.assertEquals(message, "It's gone!");   
		
	}
	
	
}
