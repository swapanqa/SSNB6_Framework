package ssnb6.selenium.testng;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class HeatclinicLoginFunctionality extends TestNgScriptBase1{
	
	
	
	@Test(dependsOnMethods="validUserAndInvalidPassword")
	public void validUserAndPassword() {
		homePage.verifyHomepageTitle();
		homePage.gotoLoginPage();
		loginPage.verifyLoginpageTitle();
		loginPage.Login("shiftqa01@gmail.com","shiftedtech");
		homePage.verifyHomepageTitle();
		homePage.verifyLoginSuccess("Shift");	
	}
	
	@Test()
	public void inValidUserAndValidPassword() {		
		homePage.verifyHomepageTitle();
		homePage.gotoLoginPage();
		loginPage.verifyLoginpageTitle();
		loginPage.Login("invalid@gmail.com", "shiftedtech");
		loginPage.verifyLoginpageTitle();
		loginPage.verifyLoginNotSuccess();			
	}
	
	@Test()
	public void validUserAndInvalidPassword() {		
		homePage.verifyHomepageTitle();
		homePage.gotoLoginPage();
		loginPage.verifyLoginpageTitle();
		loginPage.Login("shiftqa01@gmail.com", "invalid");
		loginPage.verifyLoginpageTitle();
		loginPage.verifyLoginNotSuccess();			
	}
	
	

}
