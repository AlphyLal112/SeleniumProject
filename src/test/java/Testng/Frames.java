package Testng;

import org.testng.annotations.Test;

import utility.webdriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class Frames extends webdriverManager{
	static WebDriver driver;
  @Test (priority=1)
  public void f() throws InterruptedException {
	  Thread.sleep(1000);
	  WebElement iframe = driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/iframe"));
	  driver.switchTo().frame(iframe);
	  WebElement javascript = driver.findElement(By.xpath("//*[@id=\"topnav\"]/div/div[1]/a[5]"));
	  javascript .click();
	  Thread.sleep(1000);
	  driver.switchTo().defaultContent();
  }
  @BeforeTest
  public void beforeTest() {
	  driver = launchbrowser("chrome","https://www.w3schools.com/html/html_iframe.asp\n");
  }
  @AfterTest
  public void afterTest() {
  
		closebrowser();
	}
}
