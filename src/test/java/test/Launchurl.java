package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.webdriverManager;
public  class Launchurl {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	// TODO Auto-generated method stub
	webdriverManager objmanager = new webdriverManager();
	driver = objmanager.launchbrowser("chrome","https://selenium.obsqurazone.com/index.php");
	String appurl =driver.getCurrentUrl();
	String expurl ="https://selenium.obsqurazone.com/index.php";
	//String expurl ="123";

	if(appurl.contains(expurl)) {
	System.out.println("passed");
	}else {
	System.out.println("failed");
	}
	objmanager.closebrowser();

	}

	}