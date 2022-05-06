package Testng;

import org.testng.annotations.Test;

import utility.webdriverManager;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class Popup extends webdriverManager {
	static WebDriver driver;

	@BeforeTest

	public void beforeTest() throws IOException {

		driver = launchbrowser("chrome", "https://demo.guru99.com/popup.php");// testdata using excel
	}

	@Test

	public void f() throws InterruptedException {

		WebElement clickhere = driver.findElement(By.xpath("/html/body/p/a"));
		clickhere.click();
		Thread.sleep(4000);
		String MainWindow = driver.getWindowHandle();

		// To handle all new opened window.
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

				// Switching to Child window
				driver.switchTo().window(ChildWindow);
				driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");

				driver.findElement(By.name("btnLogin")).click();

				// Closing the Child Window.
				driver.close();
			}
		}
		// Switching to Parent window i.e Main Window.
		driver.switchTo().window(MainWindow);

	}

	@AfterTest
	  public void afterTest() {
		  closebrowser();
	  }
}
