package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends Utility {

	WebDriver driver;
	
	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locators for Update profile button, upload button and details like phone number and headline 
	By UpdateButton = By.xpath("//div[@class='setting_section']/ul/li/a/i[@class='fa fa-pencil-square-o fa-2x']");
    By Upload = By.xpath("//form[@id='profile_form']/div/div/div/div/div/div/div/div/div[@class='file-default-preview clickable']");
    By SignInButton = By.linkText("Sign In");
	By EmailAddress = By.xpath("//*[@id='login-email']");
	By Pwd = By.xpath("//*[@id='login-password']");
	By Login_Button = By.xpath("//button[text()='Sign in']");
	
	//Method to click on update button
	public void updatebutton()
	{
		driver.findElement(UpdateButton).click();
	}
	//Method to click on upload button
	public void upload() throws AWTException, InterruptedException, IOException
	{
		Thread.sleep(1000);
		driver.findElement(Upload).click();
		//Upload file using robot class
		try {
		Thread.sleep(1000);
		uploadfie();
		}
		catch(AWTException e)
		{
			e.printStackTrace();
		}
		//Validate details
		int flag=0;	
        if(flag==0)
   	 	{
        	WebElement Phone_Number = driver.findElement(By.xpath("//*[@id='phone_number']"));
        	Phone_Number.clear();
        	Phone_Number.sendKeys("8919876100");
        	WebElement Headline = driver.findElement(By.xpath("//*[@id='headline']"));
        	Headline.clear();
        	Headline.sendKeys("Hi. My name is Gaurav!");
   	 	}
        	else
   	 	{
    		System.out.println("The phone number you entered is not valid. Please enter the correct number along with your area code.");
   	 	}
        
            WebElement UpdateProfile = driver.findElement(By.xpath("//div[@class='modal-footer']/button[@id='user_profile_save']"));
        	Thread.sleep(1000);
        	UpdateProfile.click();
        	//Take screenshot
        	try {
        	Thread.sleep(5000);
        	TakesScreenshot srceenshot = ((TakesScreenshot)driver);
        	File srcfile = srceenshot.getScreenshotAs(OutputType.FILE);
        	File Destination = new File("C:\\Users\\Gaurav\\Documents\\Srceenshot\\file.png");
        	FileHandler.copy(srcfile, Destination);
        	}
        	catch(InterruptedException e)
        	{
        	 e.printStackTrace();  
        	}
        
	}
	
		//Regression Testing
		public void regression() throws IOException, InterruptedException
		{
			driver.findElement(SignInButton).click();
       		Thread.sleep(1000);
       		driver.findElement(EmailAddress).sendKeys("gaurav.pathangej@gmail.com");
            Thread.sleep(1000);
            driver.findElement(Pwd).sendKeys("GauravExcelr");
            Thread.sleep(1000);
            driver.findElement(Login_Button).click();
            	try {
            	   Thread.sleep(5000);
                   TakesScreenshot srceenshot = ((TakesScreenshot)driver);
                   File srcfile = srceenshot.getScreenshotAs(OutputType.FILE);
                   File Destination = new File("C:\\Users\\Gaurav\\Documents\\Srceenshot\\regression.png");
                   FileHandler.copy(srcfile, Destination);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	
}





