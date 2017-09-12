package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	
	//Login Button to move to login page
	By signin=By.cssSelector("[href*='sign_in']");
	By title=By.cssSelector("#content>div>div>h2");
	By navBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	public LandingPage(WebDriver driver) {		
	this.driver=driver;	
	}
	public WebElement getLogin() {		
		return driver.findElement(signin);
	}
	public WebElement getTitle() {		
		return driver.findElement(title);
	}
	public WebElement getNavigationBar() {		
		return driver.findElement(navBar);
	}
	
}
