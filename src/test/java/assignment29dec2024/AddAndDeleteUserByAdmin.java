package assignment29dec2024;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import assignment23dec2024.HrmBaseTest;

public class AddAndDeleteUserByAdmin extends HrmBaseTest {

	// Verify that an admin user can be successfully added and deleted from the
	// application
	@Test
	public void verifyAddAndDeleteUserByAdminTest() {

//      1. open url and 2. login to OrangeHrm portal
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

//		3. Click on Admin followed by User Management
		driver.findElement(By.xpath("//span[text()='Admin']")).click();

//		4. Click on Add button
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();

//		5. Select User Role as Admin
		driver.findElement(By.xpath("//label[text()='User Role']/parent::div/following-sibling::div")).click();
		driver.findElement(By.xpath("//div[@role='option']/span[text()='Admin']")).click();

//		6. Enter two characters "Ra" in Employee Name text field, wait and select a suggested name - Ranga  Akunuri 
		driver.findElement(By.xpath(
				"//label[text()='Employee Name']/parent::div/following-sibling::div//input[@placeholder='Type for hints...']"))
				.sendKeys("ra");

		driver.findElement(By.xpath("//span[text()='Ranga  Akunuri']")).click();

//		7. Select Status as Enabled
		driver.findElement(By.xpath("//label[text()='Status']/parent::div/following-sibling::div")).click();
		driver.findElement(By.xpath("//span[text()='Enabled']")).click();

//		8. Set a unique Username 
		driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div//input"))
				.sendKeys("R_Ranga");

//		9. Set Password as Enter@123 and set confirm password
		driver.findElement(
				By.xpath("//label[text()='Password']/parent::div/following-sibling::div//input[@type='password']"))
				.sendKeys("Enter@123");
		driver.findElement(By.xpath(
				"//label[text()='Confirm Password']/parent::div/following-sibling::div//input[@type='password']"))
				.sendKeys("Enter@123");

//		10. Click on Save
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();

//		*11. Verify that user creation success message is displayed - Successfully Saved
		String actScsMsg = driver.findElement(By.xpath("//p[text()='Successfully Saved']")).getText();
		Assert.assertEquals(actScsMsg, "Successfully Saved");

//		*12. Verify that the newly added user is added to the list "Records Found"

		// find "Records Found" table
		List<WebElement> rows = driver.findElements(By.xpath("//div[@role='table']//div[@class='oxd-table-card']"));

		// loop through each row starting from 1 until expected ele is found- it will
		// give us i - row number to verify rest of ele
		String eUsrNm="R_Ranga";
		int i;
		Boolean isPresent = false;
		for (i = 1; i <= rows.size(); i++) {
			String eleXpath = "//div[@role='table']/div[2]/div[" + i + "]/div/div[2]/div";
			String actUsrNm = driver.findElement(By.xpath(eleXpath)).getText();

			if (actUsrNm.equals(eUsrNm)) {
				isPresent = true;
				break;
			}
		}

		Assert.assertTrue(isPresent); // verify record is present and correct username

//		*13. Verify that all the details are correct for the user in its row 

		// verify actrole="Admin" in same row
		String actRole = driver
				.findElement(By.xpath("//div[text()='" + eUsrNm + "']/parent:: div/following-sibling::div//div[text()='" + "Admin" + "']"))
				.getText();

		Assert.assertEquals(actRole, "Admin");

		// verify actRole="Ranga Akunuri" in same row
		String actEmpNm = driver
				.findElement(
						By.xpath("//div[text()='" + eUsrNm + "']/parent:: div/following-sibling::div//div[text()='" + "Ranga Akunuri" + "']"))
				.getText();

		Assert.assertEquals(actEmpNm, "Ranga Akunuri");

		// verify actStatus="Enabled" in same row
		String actStatus = driver
				.findElement(By.xpath("//div[@role='table']/div[2]/div[" + i + "]//div[text()='" + "Enabled" + "']"))
				.getText();
		Assert.assertEquals(actStatus, "Enabled");

//		14. Click on Delete icon against the user, Select "Yes Delete" on prompt
		WebElement dltUsrBtn = driver.findElement(By.xpath("//div[@role='table']/div[2]/div[" + i + "]//button[1]"));
		dltUsrBtn.click();
		driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();

//		*15. Verify that "Successfully Deleted" message is displayed
		String actUsrDltMsg = driver.findElement(By.xpath("//p[text()='Successfully Deleted']")).getText();
		Assert.assertEquals(actUsrDltMsg, "Successfully Deleted");

//		*16. Verify that the user is not displayed under Records Found table

		List<WebElement> usernames = driver.findElements(By.xpath("//div[@role='table']/div[2]/div/div/div[2]/div"));

		isPresent = false;
		for (WebElement username : usernames) {
			if (username.getText().equals("R_Ranga")) {
				isPresent = true;
				break;
			}
		}
		Assert.assertFalse(isPresent);
	}

}