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
import ssnb6.selenium.framework.heatclinic.or.LoginPageObjectRepo;

public class ScriptBase4 {
	protected WebDriver driver = null;
	
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
	

	public void login() {
		//** Step - 4 [Enter user]
		inputText("shiftqa01@gmail.com",LoginPageObjectRepo.USERNAME_TEXTBOX);
		
		//** Step - 5 [Enter password]
		inputText("shiftedtech",LoginPageObjectRepo.PASSWORD_TEXTBOX);
		
		//** Step - 6 [Click login button]
		clickButton(LoginPageObjectRepo.LOGIN_BUTTON);
	}
	public void login(String user, String password) {
		//** Step - 4 [Enter user]
		inputText(user,LoginPageObjectRepo.USERNAME_TEXTBOX);
		
		//** Step - 5 [Enter password]
		inputText(password,LoginPageObjectRepo.PASSWORD_TEXTBOX);
		
		//** Step - 6 [Click login button]
		clickButton(LoginPageObjectRepo.LOGIN_BUTTON);
	}
	
	public void inputText(String text, By by) {
		WebElement element = driver.findElement(by);
		element.clear();
		element.sendKeys(text);
	}
	public void clickButton(By by) {
		WebElement element = driver.findElement(by);
		element.click();
	}
	void verifyText(String text, By by) {
		WebElement element = driver.findElement(by);
		String actual = element.getText();
		Assert.assertEquals(text, actual);
	}
	public void verifyTextStartsWith(String text, By by) {
		WebElement error = driver.findElement(by);
		String errorText = error.getText();
		assertThat(errorText,startsWith("The e-mail address and/or password entered do not match our records") );
	}
	public void verifyTitle(String expected){
		String actual = driver.getTitle();
		Assert.assertEquals(expected, actual);
	}
	public void verifyTitleEx(String expected){
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
		Assert.assertEquals(expected, title);
	}
	
}
