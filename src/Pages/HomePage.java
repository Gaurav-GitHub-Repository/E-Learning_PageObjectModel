package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locators for SignIN button
	By SignInButton = By.linkText("Sign In");
	
	//Method to click on Sign In
	public void SignIn()
	{
		driver.findElement(SignInButton).click();
	}
}
