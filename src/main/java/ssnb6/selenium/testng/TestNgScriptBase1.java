package ssnb6.selenium.testng;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import ssnb6.selenium.framework.heatclinic.HomePage;
import ssnb6.selenium.framework.heatclinic.LoginPage;

public class TestNgScriptBase1 {

	protected WebDriver driver = null;
	
	protected HomePage homePage;
	protected LoginPage loginPage;
	
	
	
	@org.testng.annotations.BeforeClass
	public void BeforeClass() {
		System.out.println("Running ... BeforeClass");	

		
		
	}
	
	@BeforeMethod
	public void SetUp() {
		System.out.println("Running ... BeforeMethod");	
		WebDriverManager.chromedriver().arch32().setup();
		
		driver = new ChromeDriver();
		
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		
		
		driver.navigate().to("http://heatclinic.shiftedtech.com/");
	}
	

	
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Running ... AfterMethod");	
		driver.close();
		driver.quit();
		
		homePage = null;
		loginPage = null;
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Running ... AfterClass");	
		
	}
}
