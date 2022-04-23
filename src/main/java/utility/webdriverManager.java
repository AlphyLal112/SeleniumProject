package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.common.io.Files;



public class webdriverManager {
	static WebDriver driver ;
	public WebDriver launchbrowser(String browser,String url) {
	if(browser.toLowerCase().contains("Firefox")) {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Abin Lalichan\\selenium\\geckodriver.exe");
 		driver = new FirefoxDriver();
 		driver.manage().window().maximize();
 		driver.get(url);
 		return driver; 
	}
	else if(browser.toLowerCase().contains("chrome")){
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Abin Lalichan\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
		}
	else if(browser.toLowerCase().contains("ie")){
		System.setProperty("webdriver.ie.driver","C:\\Users\\Abin Lalichan\\selenium\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
    	driver.get(url);
	    return driver;
	}
	else 
	{
		System.out.println("Incorrect Browser");
	}
	return driver;
}

public static void screenshot() throws IOException {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
	LocalDateTime now = LocalDateTime.now();
	System.out.println(dtf.format(now));

	TakesScreenshot scrShot = ((TakesScreenshot)driver);

	File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

	File DestFile = new File("C:\\Users\\Abin Lalichan\\eclipse-workspace\\Javaprogram\\seleniumproject\\src\\test\\resources\\screenshot\\test"+ dtf.format(now) + ".png");
	Files.copy(SrcFile, DestFile);

}

public void closebrowser() {
	driver.close();
}

}
