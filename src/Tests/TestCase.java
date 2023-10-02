package Tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.DashboardPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.LogoutPage;


public class TestCase {

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		// TODO Auto-generated method stub
    
	System.setProperty("WebDriver.Chrome.Driver", "C:\\Selenium Temp\\ChromeDriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//Navigate to portal
    driver.get("https://elearning.excelr.com/");
    //Create object of HomePage
    HomePage homepage = new HomePage(driver);
    homepage.SignIn();
    //Create object of LoginPage
    LoginPage loginpage = new LoginPage(driver);
    //Enter valid credentials
    loginpage.email("gaurav.pathangej@gmail.com");
    loginpage.password("GauravExcelr");
    loginpage.signin();
    //Create object of DashboardPage
	DashboardPage dashboard = new DashboardPage(driver);
	dashboard.updatebutton();
	dashboard.upload();
	//Create object of Logout Page
	LogoutPage logout = new LogoutPage(driver);
	logout.logout();
	//Regression Testing
	dashboard.regression();
	
	
	
	}

}
