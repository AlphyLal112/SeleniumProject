package Testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.ExcelRead1;
import utility.webdriverManager;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class url_verify extends webdriverManager {
	static WebDriver driver;
	By inputform=By.xpath("//*[@id='collapsibleNavbar']/ul/li[2]/a");

	@Test(priority = 1, enabled=true)
	public void urlverification() {
		String appurl = driver.getCurrentUrl();
		String expurl = "https://selenium.obsqurazone.com/index.php";
//String expurl ="123";
		SoftAssert objsoftassert=new SoftAssert();
		objsoftassert.assertEquals(appurl, expurl);

		Assert.assertEquals(appurl, expurl);
		System.out.println("testafterassertion");
		objsoftassert.assertAll();
	}

	@Test(priority=2,enabled=true)
 public void showmsg() throws IOException, InterruptedException {
	ExcelRead1 er = new ExcelRead1();
	String my_message = er.readData(0,0);
    WebElement inputForm = driver.findElement(inputform);
    //EXPLICIT WAIT
    explicitwaitelementToBeClickable(inputform);
	inputForm.click();
	Thread.sleep(2000);
	//String mymsg="Hello";
	WebElement Enter_Message = driver.findElement(By.id("single-input-field"));
    Enter_Message.sendKeys("ABC");
    Thread.sleep(2000);
	WebElement Show_Message = driver.findElement(By.id("button-one"));
	Show_Message.click();
	Thread.sleep(2000);
	WebElement Your_Message = driver.findElement(By.id("message-one"));
	String Msg = Your_Message.getText();
	System.out.println(Msg);
	
	if(Msg.contains(my_message)) {
		
	Assert.assertTrue(true);
	}
	else {
		Assert.assertTrue(false);
	}
	}

	@Test(priority=3,enabled=true)
	public void addition() throws InterruptedException  {
		int a=2;
		int b=4;	
		int total=a+b;
		String value_a= Integer.toString(a);
		String value_b=Integer.toString(b);
		String t=Integer.toString(total);
		WebElement Enter_value_a = driver.findElement(By.xpath("//*[@id=\"value-a\"]"));
		Enter_value_a.sendKeys(value_a);
		Thread.sleep(2000);
		WebElement Enter_value_b = driver.findElement(By.xpath("//*[@id=\"value-b\"]"));
		Enter_value_b.sendKeys( value_b);
		Thread.sleep(2000);
		WebElement Get_Total = driver.findElement(By.id("button-two"));
		Get_Total.click();
		WebElement Total = driver.findElement(By.id("message-two"));
	    String c=Total.getText();
		System.out.println(c);
		Thread.sleep(2000);
		if(c.contains(t)) {	
		Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	@BeforeTest
	public void beforeTest() {
	
		driver = launchbrowser("chrome","https://selenium.obsqurazone.com/index.php");
	}

//	@AfterTest
//	public void afterTest() {
//		closebrowser();
//	}

}
