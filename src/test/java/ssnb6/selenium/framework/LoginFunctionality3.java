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
import ssnb6.selenium.framework.heatclinic.HomePage;
import ssnb6.selenium.framework.heatclinic.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
