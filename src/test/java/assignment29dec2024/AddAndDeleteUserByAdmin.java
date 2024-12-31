package assignment29dec2024;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddAndDeleteUserByAdmin extends BaseTest {

// Verify that an admin user can be successfully added and deleted from the application
	@Test
	public void verifyAddAndDeleteUserByAdminTest() throws InterruptedException {

//	1. Launch browser and go to OrangeHr login page 
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

//	2. Login with correct credentials
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

//	3. Click on Admin followed by User Management
		driver.findElement(By.xpath("//span[text()='Admin']")).click();

//	4. Click on Add button
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();

//	5. Select User Role as Admin
		driver.findElement(By.xpath("//form/div[1]/div/div[1]/div/div[2]/div")).click();
		driver.findElement(By.xpath("//div[@role='option']/span[text()='Admin']")).click();

//	6. Enter two characters "Re" in Employee Name text field, wait and select a suggested name - Ranga  Akunuri 
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("ra");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Ranga  Akunuri']")).click();

//	7. Select Status as Enabled
		driver.findElement(By.xpath("//form//div[3]//div[@tabindex='0']")).click();
		driver.findElement(By.xpath("//span[text()='Enabled']")).click();

//	8. Set a unique Username 
		driver.findElement(By.xpath("//form//div[4]//input")).sendKeys("R_Ranga");

//	9. Set Password as Enter@123 and set confirm password
		driver.findElement(By.xpath("//form/div[2]/div/div[1]//input[@type='password']")).sendKeys("Enter@123");
		driver.findElement(By.xpath("//form/div[2]/div/div[2]//input[@type='password']")).sendKeys("Enter@123");

//	10. Click on Save
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();

//	*11. Verify that user creation success message is displayed - Successfully Saved
		String actualConfirmMsg = driver.findElement(By.xpath("//p[text()='Successfully Saved']")).getText();

		Assert.assertEquals(actualConfirmMsg, "Successfully Saved");

//		*12. Verify that the newly added user is added to the list "Records Found"

		//find "Records Found" table
		List<WebElement> rows = driver.findElements(By.xpath("//div[@role='table']//div[@class='oxd-table-card']"));

		//loop through each row starting from 1 until expected ele is found- it will give us i - row number to verify rest of ele
		int i;
		for (i = 1; i < rows.size(); i++) {
			String eleXpath = "//div[@role='table']/div[2]/div[" + i + "]/div/div[2]/div";

			String actualUserName = driver.findElement(By.xpath(eleXpath)).getText();

			if (actualUserName.equals("R_Ranga")) {
				Assert.assertTrue(true);           //verify new user - "R_Ranga" is added
				break;
			}
		}

//	*13. Verify that all the details are correct for the user in its row 

		//verify actualrole="Admin" in same row
		String actualRole = driver
				.findElement(By.xpath("//div[@role='table']/div[2]/div[" + i + "]//div[text()='" + "Admin" + "']"))
				.getText();

		Assert.assertEquals(actualRole, "Admin");

		//verify actualEmpName="Ranga Akunuri" in same row
		String actualEmpName = driver
				.findElement(
						By.xpath("//div[@role='table']/div[2]/div[" + i + "]//div[text()='" + "Ranga Akunuri" + "']"))
				.getText();

		Assert.assertEquals(actualEmpName, "Ranga Akunuri");

		//verify actualStatus="Enabled" in same row
		String actualStatus = driver
				.findElement(By.xpath("//div[@role='table']/div[2]/div[" + i + "]//div[text()='" + "Enabled" + "']"))
				.getText();
		Assert.assertEquals(actualStatus, "Enabled");

//	14. Click on Delete icon against the user, Select "Yes Delete" on prompt
		WebElement deleteUserBtn = driver
				.findElement(By.xpath("//div[@role='table']/div[2]/div[" + i + "]//button[1]"));
		deleteUserBtn.click();
		driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();

//	*15. Verify that "Successfully Deleted" message is displayed
		String actualUserDeleteMsg = driver.findElement(By.xpath("//p[text()='Successfully Deleted']")).getText();
		Assert.assertEquals(actualUserDeleteMsg, "Successfully Deleted");

//	*16. Verify that the user is not displayed under Records Found table

		for (i = 1; i < rows.size(); i++) {

			String eleXpath = "//div[@role='table']/div[2]/div[" + i + "]/div/div[2]/div";
			String actualUserName = driver.findElement(By.xpath(eleXpath)).getText();

			if (actualUserName.equals("R_Ranga")) {
				Assert.assertTrue(false);
				break;
			}
		}
	}
}
