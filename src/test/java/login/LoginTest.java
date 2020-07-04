package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;


public class LoginTest {

	private WebDriver driver;
	
	// this will be run before class - it is precondition which needs to be executed before test start
	@BeforeClass
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//executable//chromedriver.exe");
	    // set chrome to open in incognito mode by using ChromeOptions class
		ChromeOptions option= new ChromeOptions();
		option.addArguments("incognito");
	    // pass option object to ChromeDriver
		driver= new ChromeDriver(option);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    //set browser size, but creating Dimension object 
	    Dimension dim = new Dimension(1000, 700);
	    driver.manage().window().setSize(dim);
	    // open sauce demo page
	    driver.get("https://www.saucedemo.com/");
	   
		
	}
	
	
	//test - Log in as normal user and log out

	@Test 
	public void loginNormalUserAndLogOut () {
		 // create LoginPage object and pass driver to it
		LoginPage login= new LoginPage(driver);
		// use login object to access methods from LoginPage class    
		 login.fillInUsername("standard_user");
		 login.fillInPassword("secret_sauce");
		 
		// when script click on submit button, user will be taken to new page, so we need to create object of that page, in order to access methods and fields from that method
		 
		 DashboardPage dash = login.clickSubmit();
		// assertion is done in Test Case
		 Assert.assertEquals(dash.getCurrentUrl(),"https://www.saucedemo.com/inventory.html", "User is on correct page");
		 //open left menu
		 dash.openMenu();
		 
		// logout will take user to new page so we need to create new object of that page
		 
		 LoginPage login_new = dash.clickLogOut();
		 //assert that user is on correct page
		 String pageTitle= login_new.getPageTitle();
		 Assert.assertEquals(pageTitle, "Swag Labs", "User is on correct page");
		 
	}
	
	@AfterClass
	public void TearDown() {
		
		driver.quit();
	}
	
	
}
