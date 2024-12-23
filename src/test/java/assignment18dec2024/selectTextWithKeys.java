package assignment18dec2024;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class selectTextWithKeys extends BaseTest {

	@Test
	public void selectTxtWithKeys() {

		// open url
		driver.get("https://the-internet.herokuapp.com/");

		// click on form authentication link
		driver.findElement(By.linkText("Form Authentication")).click();

		// sendkeys to username
		WebElement usernameEle = driver.findElement(By.xpath("//*[@id='username']"));
		usernameEle.sendKeys("tomsmith");

		Actions action = new Actions(driver);

		// move cursor to username textbox and click on control+A+X on keyboard
		action.moveToElement(usernameEle).keyDown(Keys.CONTROL).sendKeys("A"+"X").keyUp(Keys.CONTROL);
		
	}
}