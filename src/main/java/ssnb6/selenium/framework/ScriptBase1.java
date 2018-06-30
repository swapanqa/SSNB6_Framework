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

public class ScriptBase1 {
	private WebDriver driver = null;
	
	@Before
	public void SetUp() {
		
		WebDriverManager.chromedriver().arch32().setup();
		
		driver = new ChromeDriver();
		
		driver.navigate().to("http://heatclinic.shiftedtech.com/");
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
	public void verifyHomepageTitle() {
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
	}
	public void verifyLoginpageTitle() {
		String title3 = driver.getTitle();
		Assert.assertEquals("Broadleaf Commerce Demo Store - Heat Clinic - Login", title3);
	}
	public void Login(String user, String password) {
		WebElement emailTextbox = driver.findElement(By.name("j_username"));
		emailTextbox.sendKeys(user);
		
		//** Step - 5
		WebElement passwordtextbox = driver.findElement(By.name("j_password"));
		passwordtextbox.sendKeys(password);
		
		//** Step - 6
		WebElement loginButton = driver.findElement(By.cssSelector("input.login_button.big.red"));
		loginButton.click();
	}
	public void gotoLoginPage() {
		WebElement loginLink = driver.findElement(By.linkText("Login"));
		loginLink.click();
	}
	public void verifyLoginSuccess(String userName) {
		WebElement myAccountLink = driver.findElement(By.cssSelector("a.my-account"));
		String myText = myAccountLink.getText();
		Assert.assertEquals(userName, myText);
	}	
	public void verifyLoginNotSuccess() {
		WebElement error = driver.findElement(By.cssSelector("span.error"));
		String errorText = error.getText();
		assertThat(errorText,startsWith("The e-mail address and/or password entered do not match our records") );
	}

}
