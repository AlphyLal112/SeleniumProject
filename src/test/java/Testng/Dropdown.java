package Testng;

import org.testng.annotations.Test;

import pagefactory.Homepage;
import utility.webdriverManager;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Dropdown extends webdriverManager {
	static WebDriver driver;
	Homepage objhome;

	@Test(priority=1 ,enabled=true)
	public void dropdown() throws InterruptedException, IOException {
		//page object model without pagefactory
		//WebElement inputForm = driver.findElement(By.xpath("//*[@id='collapsibleNavbar']/ul/li[2]/a"));
		//inputForm.click();
		//WebElement singleinput = driver.findElement(By.linkText("Select Input"));
		//singleinput.click();
		try {
			//page object model with pagefactory
		//objhome=new Homepage(driver);
		//objhome.inputform.click();
		//objhome.singleinput.click();
		objhome.loadpage();
		WebElement dropDown = driver.findElement(By.id("single-input-field"));
		Select objselect = new Select(dropDown);
		Thread.sleep(2000);
		objselect.selectByValue("Green");
		screenshot();
		Thread.sleep(2000);
		
		objselect.selectByIndex(2);
		Thread.sleep(2000);
		objselect.selectByVisibleText("Red");
		screenshot();
		Thread.sleep(2000);
		Assert.assertTrue(true);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
		
	}

	@Test(priority=2 ,enabled=true)
	public void multidropdown() throws InterruptedException {
		WebElement dropDown = driver.findElement(By.id("multi-select-field"));
		Select objselect = new Select(dropDown);
		objselect.selectByIndex(0);
		WebElement firstinput = driver.findElement(By.xpath("//*[@id=\"button-first\"]"));
		firstinput.click();
		Thread.sleep(2000);
		objselect.selectByValue("Green");
		WebElement allinput = driver.findElement(By.id("button-all"));
		allinput.click();
		Thread.sleep(2000);
		
	}

	@BeforeTest
	public void beforeTest() {
		driver = launchbrowser("chrome","https://selenium.obsqurazone.com/index.php");
	}

	@AfterTest
	public void afterTest() {
		closebrowser();
	}
}
