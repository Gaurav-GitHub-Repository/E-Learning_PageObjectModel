package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {

	WebDriver driver;
	
	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
	}

	//Locator for Logout button
	By Logout = By.xpath("//div[@id='contain-all']/header/div/div[3]/nav/a[3]");

	//Method to click on logout button
	public void logout()
	{
		driver.findElement(Logout).click();
	}
}
