package ssnb6.selenium.framework;

import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginFunctionality0 extends ScriptBase1{
		
	private WebDriver driver = null;
	
	@Before
	public void SetUp() {
		
		WebDriverManager.chromedriver().arch32().setup();
		
		driver = new ChromeDriver();
		
		driver.navigate().to("http://heatclinic.shiftedtech.com/");
	}
	
	
	@Test
	public void validUserAndPassword() {
		
		//** Step - 1 [Verify Home page title]
		List<WebElement> titleTags = driver.findElements(By.tagName("title"));
		String title  = "";
		if(titleTags.size() > 1) {
			//String title = titleTags.get(1).getText();
			//String title = titleTags.get(1).getCssValue("text");
			title = titleTags.get(1).getAttribute("text");
		}
		else {
			title = titleTags.get(0).getAttribute("text");
		}
		Assert.assertEquals("Broadleaf Demo - Heat Clinic", title);
		
		//** Step - 2 [Click Login link]
		WebElement loginLink = driver.findElement(By.linkText("Login"));
		loginLink.click();
		
		//** Step - 3 [Verify Loginpage title]
		String title3 = driver.getTitle();
		Assert.assertEquals("Broadleaf Commerce Demo Store - Heat Clinic - Login", title3);
		
		//** Step - 4 [Enter user]
		WebElement emailTextbox = driver.findElement(By.name("j_username"));
		emailTextbox.sendKeys("shiftqa01@gmail.com");
		
		//** Step - 5 [Enter password]
		WebElement passwordtextbox = driver.findElement(By.name("j_password"));
		passwordtextbox.sendKeys("shiftedtech");
		
		//** Step - 6 [Click login button]
		WebElement loginButton = driver.findElement(By.cssSelector("input.login_button.big.red"));
		loginButton.click();
		
		//**Step - 7 [Verify Home page title]
		List<WebElement> titleTags2 = driver.findElements(By.tagName("title"));
		String title2  = "";
		if(titleTags2.size() > 1) {
			//String title = titleTags.get(1).getText();
			//String title = titleTags.get(1).getCssValue("text");
			title2 = titleTags2.get(1).getAttribute("text");
		}
		else {
			title2 = titleTags2.get(0).getAttribute("text");
		}
		Assert.assertEquals("Broadleaf Demo - Heat Clinic", title2);
		
		//** Step - 8 [Veryfy account name]
		WebElement myAccountLink = driver.findElement(By.cssSelector("a.my-account"));
		String myText = myAccountLink.getText();
		Assert.assertEquals("Shift", myText);
	}
	

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
