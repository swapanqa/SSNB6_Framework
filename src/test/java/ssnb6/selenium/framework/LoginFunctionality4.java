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

public class LoginFunctionality4 extends ScriptBase4{
		

	@Before
	public void SetUp() {
		super.SetUp();
	}
	
	
	@Test
	public void validUserAndPassword() {
		
		//** Step - 1 [Verify Home page title]
		verifyTitleEx("Broadleaf Demo - Heat Clinic");
		
		//** Step - 2 [Click Login link]
		clickButton(By.linkText("Login"));

		//** Step - 3 [Verify Loginpage title]
		
		verifyTitle("Broadleaf Commerce Demo Store - Heat Clinic - Login");
		
		//** Step - 4 [Enter user]
		inputText("shiftqa01@gmail.com",By.name("j_username"));
		
		//** Step - 5 [Enter password]
		inputText("shiftedtech",By.name("j_password"));
		
		//** Step - 6 [Click login button]
		clickButton(By.cssSelector("input.login_button.big.red"));
		
		//**Step - 7 [Verify Home page title]
		verifyTitleEx("Broadleaf Demo - Heat Clinic");
		
		//** Step - 8 [Veryfy account name]
		verifyText("Shift", By.cssSelector("a.my-account"));
	}
	@Test
	public void invalidPassword() {
		
		//** Step - 1 [Verify Home page title]
		verifyTitleEx("Broadleaf Demo - Heat Clinic");
		
		//** Step - 2 [Click Login link]
		clickButton(By.linkText("Login"));

		//** Step - 3 [Verify Loginpage title]
		
		verifyTitle("Broadleaf Commerce Demo Store - Heat Clinic - Login");
		
		//** Step - 4 [Enter user]
		inputText("shiftqa01@gmail.com",By.name("j_username"));
		
		//** Step - 5 [Enter password]
		inputText("invalid",By.name("j_password"));
		
		//** Step - 6 [Click login button]
		clickButton(By.cssSelector("input.login_button.big.red"));
		
		//** Step - 7 [Verify Loginpage title]
		
		verifyTitle("Broadleaf Commerce Demo Store - Heat Clinic - Login");
		
		//** Step - 8 [Verify error msg]
		verifyTextStartsWith("The e-mail address and/or password entered do not match our records",By.cssSelector("span.error"));
		
	}
	

	@After
	public void tearDown() {
		super.tearDown();
	}

}
