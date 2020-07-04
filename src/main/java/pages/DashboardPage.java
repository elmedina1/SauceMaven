package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DashboardPage {

	private By menu = By.className("bm-burger-button");
	private By logoutLink = By.id("logout_sidebar_link");
	private WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;

	}

	public String getCurrentUrl() {

		return driver.getCurrentUrl();
	}

	public void openMenu() {

		driver.findElement(menu).click();
	}

	// click on Logout will take user to new/old page Login so we need to return
	// handler to that page
	public LoginPage clickLogOut() {

		driver.findElement(logoutLink).click();
		return new LoginPage(driver);
	}

}
