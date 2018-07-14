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


public class HeatclinicLoginFunctionality2 extends TestNgScriptBase1{
	
	
	
	@Test()
	public void validUserAndPassword1() {
		homePage.verifyHomepageTitle();
		homePage.gotoLoginPage();
		loginPage.verifyLoginpageTitle();
		loginPage.Login("shiftqa01@gmail.com","shiftedtech");
		homePage.verifyHomepageTitle();
		homePage.verifyLoginSuccess("Shift");	
	}
	@Test()
	public void validUserAndPassword2() {
		homePage.verifyHomepageTitle();
		homePage.gotoLoginPage();
		loginPage.verifyLoginpageTitle();
		loginPage.Login("nefaur.rb@gmail.com","123456nrb");
		homePage.verifyHomepageTitle();
		homePage.verifyLoginSuccess("Nefaur");	
	}
	@Test()
	public void validUserAndPassword3() {
		homePage.verifyHomepageTitle();
		homePage.gotoLoginPage();
		loginPage.verifyLoginpageTitle();
		loginPage.Login("shiftqa01@gmail.com","shiftedtech");
		homePage.verifyHomepageTitle();
		homePage.verifyLoginSuccess("Shift");	
	}
	@Test()
	public void validUserAndPassword4() {
		homePage.verifyHomepageTitle();
		homePage.gotoLoginPage();
		loginPage.verifyLoginpageTitle();
		loginPage.Login("nefaur.rb@gmail.com","123456nrb");
		homePage.verifyHomepageTitle();
		homePage.verifyLoginSuccess("Nefaur");	
	}
}
