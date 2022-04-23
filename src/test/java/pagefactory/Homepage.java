package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	public Homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//*[@id='collapsibleNavbar']/ul/li[2]/a")
public WebElement inputform;
@FindBy(linkText="Select Input")
public WebElement singleinput;
public void loadpage() {
inputform.click();
singleinput.click();
}
}

