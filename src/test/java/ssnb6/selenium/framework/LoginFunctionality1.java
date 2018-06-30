package ssnb6.selenium.framework;


import java.sql.Driver;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.jna.platform.win32.SetupApi;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
