package assignment21dec2024;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import assignment18dec2024.BaseTest;

public class DropDownTest extends BaseTest {

	@Test
	public void selectDropDownTest() {

		// open url-https://the-internet.herokuapp.com/
		driver.navigate().to("https://the-internet.herokuapp.com/"); // driver.get("url");

		// click on 'Dropdown' link
		driver.findElement(By.linkText("Dropdown")).click();
		//driver.findElement(By.xpath("//a[text()='Dropdown']")).click();

		// select 'option1'
		WebElement optionEle = driver.findElement(By.id("dropdown"));
		//WebElement optionEle = driver.findElement(By.xpath("//*[@id='dropdown']"));

		Select select = new Select(optionEle);
		select.selectByIndex(1); // accepts para int
		select.selectByContainsVisibleText("ion 2"); // accepts para String
		select.selectByValue("1"); // accepts String as para
		select.selectByVisibleText("Option 2"); // accepts para String

	}

	//@Test
	public void DemoqaDropDownTest() {

		// open url-https://demoqa.com/select-menu
		driver.navigate().to("https://demoqa.com/select-menu");

		// no select tag
		// Select Value
		// click on dropdown box
		driver.findElement(By.xpath("//*[@id='withOptGroup']/div")).click();

		// driver.findElement(By.id("withOptGroup")).click();

		// click on Group 1, Option 1 to select
		// driver.findElement(By.xpath("//*[@id='withOptGroup']/div/div[1]/div[1]")).click();
		driver.findElement(By.xpath("//*[text()='Group 1, option 1']")).click();

		// Select One
		// click on dropdown box
		driver.findElement(By.xpath("//*[@id='selectOne']/div")).click();

		// click on other
		driver.findElement(By.xpath("//*[@id='selectOne']/div/div[1]/div")).click();
		/////////driver.findElement(By.xpath("//*[text()='Other']")).click();

		// select tag present in dom //Standard multi select

		// Old Style Select Menu

		// WebElement oldSelectMenuEle
		// =driver.findElement(By.xpath("//*[@id='oldSelectMenu']"));
		WebElement oldSelectMenuEle = driver.findElement(By.id("oldSelectMenu"));

		Select select = new Select(oldSelectMenuEle);
		select.selectByValue("red");
		select.selectByVisibleText("Blue");
		select.selectByContainsVisibleText("ua");
		select.selectByIndex(5);

		// Standard multi select
		//WebElement multiSelectEle = driver.findElement(By.xpath("//*[@id='cars']"));
		//WebElement multiSelectEle = driver.findElement(By.xpath("//*[@name='cars']"));
		WebElement multiSelectEle = driver.findElement(By.id("cars"));
		//WebElement multiSelectEle = driver.findElement(By.name("cars"));
		Select select1 = new Select(multiSelectEle);
		select1.selectByVisibleText("Volvo");
		select1.selectByContainsVisibleText("udi");
		select1.selectByValue("opel");
		select1.selectByIndex(2);
		select1.deselectAll();

	}

}
