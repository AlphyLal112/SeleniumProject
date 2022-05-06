package stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Runner.CucumberRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewTest {

	static WebDriver driver;

	@Given("user want to click on input form")
	@Test
	public  void First() throws InterruptedException {
		CucumberRunner obj = new CucumberRunner();
		driver = obj.driver;
		WebElement inputForm = driver.findElement(By.xpath("//*[@id=\"collapsibleNavbar\"]/ul/li[2]/a"));
		inputForm.click();
		Thread.sleep(2000);

	}
	@When("user enter a value")
	@Test
	public  void second() throws InterruptedException {
		String s = "Hello";
		WebElement Enter_Message = driver.findElement(By.xpath("//*[@id=\"single-input-field\"]"));
		Enter_Message.sendKeys(s);
		System.out.println("Hello entered ");
		driver.findElement(By.xpath("//*[@id=\"button-one\"]")).click();
		System.out.println("Button clicked");
		Thread.sleep(2000);
	}

	@Then("display entered value")
	@Test
	public  void Third() throws InterruptedException {

		WebElement Your_Message = driver.findElement(By.xpath("//*[@id=\"message-one\"]"));
		String Msg = Your_Message.getText();
		System.out.println(Msg);
		Thread.sleep(2000);

	}

}
