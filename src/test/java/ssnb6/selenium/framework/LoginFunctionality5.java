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
import ssnb6.selenium.framework.heatclinic.or.HomePageObjectRepo;
import ssnb6.selenium.framework.heatclinic.or.LoginPageObjectRepo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginFunctionality5 extends ScriptBase4{
		

	@Before
	public void SetUp() {
		super.SetUp();
	}
	
	
	@Test
	public void validUserAndPassword() {
		
		//** Step - 1 [Verify Home page title]
		verifyTitleEx("Broadleaf Demo - Heat Clinic");
		
		//** Step - 2 [Click Login link]
		clickButton(HomePageObjectRepo.LOGIN_LINK);

		//** Step - 3 [Verify Loginpage title]
		
		verifyTitle("Broadleaf Commerce Demo Store - Heat Clinic - Login");
		
		login();
		
		//**Step - 7 [Verify Home page title]
		verifyTitleEx("Broadleaf Demo - Heat Clinic");
		
		//** Step - 8 [Veryfy account name]
		verifyText("Shift", HomePageObjectRepo.MY_ACCOUNT_LINK);
	}


	@Test
	public void invalidPassword() {
		
		//** Step - 1 [Verify Home page title]
		verifyTitleEx("Broadleaf Demo - Heat Clinic");
		
		//** Step - 2 [Click Login link]
		clickButton(HomePageObjectRepo.LOGIN_LINK);

		//** Step - 3 [Verify Loginpage title]
		
		verifyTitle("Broadleaf Commerce Demo Store - Heat Clinic - Login");
		
		login("shiftqa01@gmail.com","invalid");
		
		//** Step - 7 [Verify Loginpage title]
		
		verifyTitle("Broadleaf Commerce Demo Store - Heat Clinic - Login");
		
		//** Step - 8 [Verify error msg]
		verifyTextStartsWith("The e-mail address and/or password entered do not match our records",LoginPageObjectRepo.ERROR_MSG_LABEL);
		
	}
	

	@After
	public void tearDown() {
		super.tearDown();
	}

}
