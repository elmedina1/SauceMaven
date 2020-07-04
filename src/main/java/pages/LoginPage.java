package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	//define driver object
	private WebDriver driver;
	//define locators
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By submitBtn = By.className("btn_action");
 
	// constructor
	public LoginPage(WebDriver driver) {
		// set driver define on class level to instance of driver that is passed
		this.driver = driver;
	}
   
	//fill in username field
	public void fillInUsername(String name) {
		
		driver.findElement(username).sendKeys(name);
	}

   // fill in password
	public void fillInPassword(String pass) {
		
		driver.findElement(password).sendKeys(pass);
	}

	// click on Submit button. As action opens new page we need to return handler of that page
	public DashboardPage clickSubmit() {
		
		driver.findElement(submitBtn).click();
		return new DashboardPage(driver);
	}

 // get page title
	
	public String getPageTitle() {
		
	 return driver.getTitle();
	}
	

}
