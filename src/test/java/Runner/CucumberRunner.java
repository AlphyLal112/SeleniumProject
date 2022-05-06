package Runner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
		@CucumberOptions(
				features = "src/test/resources/Feature/Input.feature",
				glue = "stepDef",
				plugin= {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm" , 
						"pretty", "json:cucumber-reports/Cucumber.json"}
				
				)
		public class CucumberRunner extends AbstractTestNGCucumberTests {
			public static WebDriver driver ;
			@BeforeSuite
			public  void launchbrowser() {
				
				System.setProperty("webdriver.chrome.driver","C:\\Users\\Abin Lalichan\\selenium\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.get("https://selenium.obsqurazone.com/index.php");
			}
				
		@AfterSuite

		public  void teardown()
		{
			driver.quit();

		}
		}

	
