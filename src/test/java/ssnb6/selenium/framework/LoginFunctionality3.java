package ssnb6.selenium.framework;


import org.junit.Test;
import ssnb6.selenium.framework.heatclinic.HomePage;
import ssnb6.selenium.framework.heatclinic.LoginPage;

public class LoginFunctionality3 extends ScriptBase3{
		
	@Test
	public void validUserAndPassword() {
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		homePage.verifyHomepageTitle();
		homePage.gotoLoginPage();
		loginPage.verifyLoginpageTitle();
		loginPage.Login("shiftqa01@gmail.com","shiftedtech");
		homePage.verifyHomepageTitle();
		homePage.verifyLoginSuccess("Shift");	
	}

	@Test
	public void inValidUserAndValidPassword() {	
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		homePage.verifyHomepageTitle();
		homePage.gotoLoginPage();
		loginPage.verifyLoginpageTitle();
		loginPage.Login("invalid@gmail.com", "shiftedtech");
		loginPage.verifyLoginpageTitle();
		loginPage.verifyLoginNotSuccess();				
	}
	
	@Test
	public void validUserAndInvalidPassword() {	
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		homePage.verifyHomepageTitle();
		homePage.gotoLoginPage();
		loginPage.verifyLoginpageTitle();
		loginPage.Login("shiftqa01@gmail.com", "invalid");
		loginPage.verifyLoginpageTitle();
		loginPage.verifyLoginNotSuccess();				
	}
	
	
}
