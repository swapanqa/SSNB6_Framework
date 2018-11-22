package ssnb6.selenium.framework;


import org.junit.Test;

public class LoginFunctionality1 extends ScriptBase1{
		
	@Test
	public void validUserAndPassword() {
		verifyHomepageTitle();
		gotoLoginPage();
		verifyLoginpageTitle();
		Login("shiftqa01@gmail.com","shiftedtech");
		verifyHomepageTitle();
		verifyLoginSuccess("Shift");	
	}

	@Test
	public void inValidUserAndValidPassword() {		
		verifyHomepageTitle();
		gotoLoginPage();
		verifyLoginpageTitle();
		Login("invalid@gmail.com", "shiftedtech");
		verifyLoginpageTitle();
		verifyLoginNotSuccess();			
	}
	
	@Test
	public void validUserAndInvalidPassword() {		
		verifyHomepageTitle();
		gotoLoginPage();
		verifyLoginpageTitle();
		Login("shiftqa01@gmail.com", "invalid");
		verifyLoginpageTitle();
		verifyLoginNotSuccess();			
	}
	
	
}
