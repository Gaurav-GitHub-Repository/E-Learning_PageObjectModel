package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage {

  WebDriver driver;	
  	
  public LoginPage(WebDriver driver)
  {
	this.driver=driver;
  }
  
  //Locators for Email, Password and Sign In button
  By Email = By.xpath("//input[@id='login-email' and @name='email']/self::input");
  By Password = By.xpath("//input[@id='login-password' and @name='password']/self::input");
  By SignIn = By.xpath("//button[text()='Sign in']/self::button");
  
  //Method to enter email
  public void email(String email_value)
  {
	  driver.findElement(Email).sendKeys(email_value);	  
  }  
  //Method to enter password 
  public void password(String password_value)
  {
	  driver.findElement(Password).sendKeys(password_value);	
  }
  //Method to click on signin button
  public void signin()
  {
	  driver.findElement(SignIn).click(); 
  }
}
