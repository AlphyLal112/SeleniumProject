package Testng;

import org.testng.annotations.Test;

import utility.webdriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Checkbox extends webdriverManager{
	WebDriver driver;

	@Test
  public void f() throws InterruptedException {
	  WebElement inputForm = driver.findElement(By.xpath("//*[@id='collapsibleNavbar']/ul/li[2]/a"));
	  inputForm.click();
	  Thread.sleep(2000);
	  WebElement checkboxdemo = driver.findElement(By.linkText("Checkbox Demo"));
	  checkboxdemo.click();
	  Thread.sleep(2000);
	  WebElement checked = driver.findElement(By.id("gridCheck"));
	  checked.click();
	  Thread.sleep(2000);
	  String my_message="Success - Check box is checked";
	  WebElement result = driver.findElement(By.xpath("//*[@id=\"message-one\"]"));
	  String Msg = result.getText();
	  System.out.println(Msg);
	  if (Msg.contains(my_message)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
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
