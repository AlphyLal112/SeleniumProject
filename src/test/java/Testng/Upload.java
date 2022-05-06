package Testng;

import org.testng.annotations.Test;

import utility.webdriverManager;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class Upload extends webdriverManager {
	static WebDriver driver;

	@Test(enabled = false)
	public void f() throws InterruptedException {
		WebElement fileupload = driver.findElement(By.id("uploadfile_0"));
		fileupload.sendKeys("C:\\Users\\Abin Lalichan\\Downloads\\Documents\\sample.txt");
		Thread.sleep(4000);

	}

	@Test(enabled = false)
	public void g() throws InterruptedException, AWTException {
		Thread.sleep(4000);
		 javascriptexecutorscroll(0, 300);
		driver.switchTo().frame("JotFormIFrame-72320244964454");
		WebElement fileupload = driver.findElement(By.xpath("//*[@id=\"input_5\"]"));
		fileupload.click();
//	  JavascriptExecutor executor = (JavascriptExecutor)driver;
//	  executor.executeScript("arguments[0].click();", fileupload);
		Thread.sleep(2000);

		// put path to your image in a clipboard
		StringSelection ss = new StringSelection("C:\\Users\\Abin Lalichan\\Downloads\\Documents\\sample.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot = new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(90);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	@Test(enabled = true)
	public void h() throws InterruptedException, AWTException {
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("window.scrollBy(0,700)");
		driver.switchTo().frame("JotFormIFrame-72320244964454");
		WebElement fileupload = driver.findElement(By.xpath("//*[@id=\"id_5\"]"));
		fileupload.click();

	}

	@BeforeTest
	public void beforeTest() throws IOException {
		driver = launchbrowser("chrome", "https://demo.guru99.com/test/autoit.html");// testdata using excel
	}

	@AfterTest
	public void afterTest() {
		closebrowser();
	}

}
