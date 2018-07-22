package ssnb6.selenium.framework.kw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KWScriptBase {

	protected WebDriver driver = null;
	protected KeywordDriver kwd = null;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().arch32().setup();
		driver = new ChromeDriver();
		
		kwd = new KeywordDriver(driver);
		
		driver.navigate().to("http://heatclinic.shiftedtech.com/");
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
		kwd = null;
	}
}
