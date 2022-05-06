package Testng;

import utility.webdriverManager;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Alert extends webdriverManager {
	static WebDriver driver;
	// By inputform = By.xpath("//*[@id=\"alert-modal\"]");

	@Test(priority = 4, enabled = true)
	public void acceptalert() throws InterruptedException {
		driver = driver();
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
		// objalert.dismiss(); //toclick cancel
		String value = objalert.getText(); // togettextvalue
		System.out.println(value);
		objalert.accept();// toclickokbutton
		// objalert.sendKeys("123");
		alertaccept();

	}

	@Test(priority = 5, enabled = true)
	public void test2() throws InterruptedException {
//			  WebElement inputForm = driver.findElement(inputform);
////	     fluentwaiteg(inputform);
//			  inputForm.click();
//			  Thread.sleep(3000);
//			  WebElement javascript = driver.findElement(By.linkText("Javascript Alert"));
//			  javascript.click();
//			  Thread.sleep(3000);
		WebElement clickme = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[3]/div/div[2]/button"));
		javascriptexecutorscrollintoview(clickme);// used to scroll visibility of an element
		Thread.sleep(3000);
		clickme.click();
		Thread.sleep(3000);

		org.openqa.selenium.Alert objalert = driver.switchTo().alert();
		// objalert.dismiss(); //to click cancel
		String value = objalert.getText(); // to get text value
		System.out.println(value);
		String mytext = "Hello";
		objalert.sendKeys("Hello");
		Thread.sleep(3000);
		objalert.accept();// to click ok button
//			  Thread.sleep(3000);

		// objalert.sendKeys("123");
		WebElement entered_text = driver.findElement(By.id("prompt-demo"));
		String val = entered_text.getText();
		Thread.sleep(3000);
		System.out.println(val);

		if (val.contains(mytext)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}
	// @BeforeTest
	// public void beforeTest() {
//			  driver = launchbrowser("Chrome","https://selenium.obsqurazone.com/index.php");
	// }

	@AfterTest
	public void afterTest() {
		closebrowser();
	}
}
