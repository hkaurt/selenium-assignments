package assignment18dec2024;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownTest extends BaseTest {

	@Test
	public void selectDropDownTest() throws InterruptedException {

		// open url-https://the-internet.herokuapp.com/
		driver.navigate().to("https://the-internet.herokuapp.com/"); // driver.get("url");

		// click on 'Dropdown' link
		driver.findElement(By.linkText("Dropdown")).click();

		// select 'option1'
		WebElement optionEle = driver.findElement(By.xpath("//*[@id='dropdown']"));
		Select select = new Select(optionEle);
		select.selectByIndex(1); // accepts para int
		Thread.sleep(3000);
		select.selectByContainsVisibleText("ion 2"); // accepts para String
		Thread.sleep(3000);
		select.selectByValue("1"); // accepts String as para
		Thread.sleep(3000);
		select.selectByVisibleText("Option 2"); // accepts para String
		Thread.sleep(3000);
		select.deselectAll();

	}

	@Test
	public void DemoqaDropDownTest() {

		// open url-https://demoqa.com/select-menu
		driver.navigate().to("https://demoqa.com/select-menu");

		// no select tag
		// Select Value
		// click on dropdown box
		driver.findElement(By.xpath("//*[@id='withOptGroup']/div")).click();
		// click on Group 1, Option 1 to select
		driver.findElement(By.xpath("//*[@id='withOptGroup']/div/div[1]/div[1]")).click();

		// Select One
		// click on dropdown box
		driver.findElement(By.xpath("//*[@id='selectOne']/div")).click();
		// click on other
		driver.findElement(By.xpath("//*[@id='selectOne']/div/div[1]/div[1]")).click();

		// select tag present in dom //Standard multi select
		
		// Old Style Select Menu

		WebElement oldSelectMenuEle = driver.findElement(By.xpath("//*[@id='oldSelectMenu']"));
		Select select = new Select(oldSelectMenuEle);
		select.selectByValue("red");
		select.selectByVisibleText("Blue");
		select.selectByContainsVisibleText("ua");
		select.selectByIndex(5);

		// Standard multi select
		WebElement multiSelectEle = driver.findElement(By.xpath("//*[@id='cars']"));
		Select select1 = new Select(multiSelectEle);
		select1.selectByVisibleText("Volvo");
		select1.selectByContainsVisibleText("udi");
		select1.selectByValue("opel");
		select1.selectByIndex(2);
		select1.deselectAll();

	}
	
	

}
