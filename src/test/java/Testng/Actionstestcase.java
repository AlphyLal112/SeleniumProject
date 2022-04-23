package Testng;

import org.testng.annotations.Test;

import utility.ExcelRead1;
import utility.webdriverManager;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Actionstestcase extends webdriverManager {
	WebDriver driver;

	@Test(priority = 0, enabled = false)
	public void f() throws IOException, InterruptedException {
		ExcelRead1 er = new ExcelRead1();

		String my_message = er.readData(0, 0);
		WebElement inputForm = driver.findElement(By.xpath("//*[@id='collapsibleNavbar']/ul/li[2]/a"));
		inputForm.click();
		Thread.sleep(2000);
		// String my_message = "Hello";
		WebElement Enter_Message = driver.findElement(By.id("single-input-field"));
		Actions objactions = new Actions(driver);
//  Action click = objactions.click(Enter_Message).build();
//  click.perform();
//  Thread.sleep(3000);
//  Action sendkeys = objactions.sendKeys(my_message).build();
//  sendkeys.perform();
		objactions.click(Enter_Message).keyDown(Keys.SHIFT).sendKeys(my_message).build().perform();

		Thread.sleep(2000);
		WebElement Show_Message = driver.findElement(By.xpath("//*[@id=\"button-one\"]"));
		Show_Message.click();
		Thread.sleep(4000);
		WebElement Your_Message = driver.findElement(By.id("message-one"));
		String your_message1 = Your_Message.getText();
		System.out.println(your_message1);

		if (your_message1.contains(my_message)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Test (priority=1, enabled=true)
    public void dragdrop() {
		Actions objactions = new Actions(driver);
		WebElement Others = driver.findElement(By.id("others"));
		Others.click();
		WebElement from = driver.findElement(By.xpath("//*[@id=\"todrag\"]/span[1]"));
		WebElement to = driver.findElement(By.xpath("//*[@id=\"mydropzone\"]"));
		objactions.dragAndDrop(from, to).build().perform();
	}

	@BeforeTest
	public void beforeTest() {
		driver = launchbrowser("Chrome", "https://selenium.obsqurazone.com/index.php");
	}

	@AfterTest
	public void afterTest() {
		closebrowser();
	}

}
