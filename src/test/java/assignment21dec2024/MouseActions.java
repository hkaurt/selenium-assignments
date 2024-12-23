package assignment21dec2024;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import assignment18dec2024.BaseTest;

public class MouseActions extends BaseTest {

	@Test
	public void rightClick() {

		// open url
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");

		//find element
		//WebElement rightClickButton=driver.findElement(By.xpath("//*[@id='authentication']/span"));
		//WebElement rightClickButton=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		WebElement rightClickButton=driver.findElement(By.xpath("//span[text()='right click me']"));
		
		//right click on it
		Actions action= new Actions(driver);
		action.contextClick(rightClickButton).perform();
		
		//click on quit
		//driver.findElement(By.xpath("//*[@id='authentication']/ul/li[7]/span")).click();
		driver.findElement(By.xpath("//*[text()='Quit']")).click();

		//handle alert- jsAlert
		Alert jsAlert= driver.switchTo().alert();
		jsAlert.accept();
		
	}
}
