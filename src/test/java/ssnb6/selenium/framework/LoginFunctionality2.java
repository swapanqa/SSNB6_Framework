package ssnb6.selenium.framework;

import org.junit.Test;

public class LoginFunctionality2 extends ScriptBase2{
		
	@Test
	public void validUserAndPassword() {
		homePage.verifyHomepageTitle();
		homePage.gotoLoginPage();
		loginPage.verifyLoginpageTitle();
		loginPage.Login("shiftqa01@gmail.com","shiftedtech");
		homePage.verifyHomepageTitle();
		homePage.verifyLoginSuccess("Shift");	
	}

	@Test
	public void inValidUserAndValidPassword() {		
		homePage.verifyHomepageTitle();
		homePage.gotoLoginPage();
		loginPage.verifyLoginpageTitle();
		loginPage.Login("invalid@gmail.com", "shiftedtech");
		loginPage.verifyLoginpageTitle();
		loginPage.verifyLoginNotSuccess();			
	}
	
	@Test
	public void validUserAndInvalidPassword() {		
		homePage.verifyHomepageTitle();
		homePage.gotoLoginPage();
		loginPage.verifyLoginpageTitle();
		loginPage.Login("shiftqa01@gmail.com", "invalid");
		loginPage.verifyLoginpageTitle();
		loginPage.verifyLoginNotSuccess();			
	}
	
	
}
