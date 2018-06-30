package ssnb6.selenium.framework;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ssnb6.selenium.framework.heatclinic.HomePage;
import ssnb6.selenium.framework.heatclinic.LoginPage;

public class ScriptBase2 {
	private WebDriver driver = null;
	
	protected HomePage homePage;
	protected LoginPage loginPage;
	
	
	@Before
	public void SetUp() {
		
		WebDriverManager.chromedriver().arch32().setup();
		
		driver = new ChromeDriver();
		driver.navigate().to("http://heatclinic.shiftedtech.com/");
		
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
		
		homePage = null;
		loginPage = null;
		
	}
	
}
