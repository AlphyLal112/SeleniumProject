package Testng;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import utility.webdriverManager;

public class Alert extends webdriverManager {
	static WebDriver driver;

	@Test(enabled = false)
	public void f() throws InterruptedException {
		WebElement inputForm = driver.findElement(By.xpath("//*[@id=\"alert-modal\"]"));
		inputForm.click();
		Thread.sleep(3000);
		WebElement javascript = driver.findElement(By.linkText("Javascript Alert"));
		javascript.click();
		Thread.sleep(3000);
		WebElement clickme = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div/div[2]/p[4]/button"));
		clickme.click();
		Thread.sleep(3000);

		org.openqa.selenium.Alert objalert = driver.switchTo().alert();
		// objalert.dismiss() //toclick cancel
		String value = objalert.getText(); // togettextvalue
		System.out.println(value);
		objalert.accept();// toclickokbutton
		// objalert.sendKeys("123");

	}

	@Test(enabled = true)
	public void test2() throws InterruptedException {
		WebElement inputForm = driver.findElement(By.xpath("//*[@id=\"alert-modal\"]"));
		inputForm.click();
		Thread.sleep(3000);
		WebElement javascript = driver.findElement(By.linkText("Javascript Alert"));
		javascript.click();
		Thread.sleep(3000);
		WebElement clickme = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[3]/div/div[2]/button"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", clickme); // used to scroll visibility of an element
		Thread.sleep(3000);
		clickme.click();
		Thread.sleep(3000);

		org.openqa.selenium.Alert objalert = driver.switchTo().alert();
		String value = objalert.getText(); // togettextvalue;
		System.out.println(value);
		String my_name="Alphy";
		objalert.sendKeys("Alphy");
		objalert.accept();// toclickokbutton
		//objalert.dismiss(); //toclick cancel
		WebElement Entered_name=driver.findElement(By.id("prompt-demo"));
		String name = Entered_name.getText();
		System.out.println(name);
		if(name.contains(my_name)) {
			
			Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
			}
		
	
		// objalert.sendKeys("123");

	


	@BeforeTest
	public void beforeTest() {
		driver = launchbrowser("Chrome", "https://selenium.obsqurazone.com/index.php");
	}

	@AfterTest
	public void afterTest() {
		closebrowser();
	}
}
