package assignment21dec2024;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import assignment18dec2024.BaseTest;

public class selectTextWithKeys extends BaseTest {

	@Test
	public void selectTxtWithKeys() {

		// open url
		driver.get("https://the-internet.herokuapp.com/");

		// click on form authentication link
		driver.findElement(By.linkText("Form Authentication")).click();
		// driver.findElement(By.xpath("//a[text()='Form Authentication']")).click();  // xpath("//*[@id='content']/ul/li[21]/a"), //xpath("//a[@href='/login']")

		// sendkeys to username
		WebElement usernameEle = driver.findElement(By.id("username"));
		// WebElement usernameEle = driver.findElement(By.name("username"));
		// WebElement usernameEle = driver.findElement(By.xpath("//*[@type='text']"));

		usernameEle.sendKeys("tomsmith");

		Actions action = new Actions(driver);

		// move cursor to username textbox and click on control+A+C on keyboard
		action.moveToElement(usernameEle).keyDown(Keys.CONTROL).sendKeys("A" + "C").keyUp(Keys.CONTROL);

	}
}