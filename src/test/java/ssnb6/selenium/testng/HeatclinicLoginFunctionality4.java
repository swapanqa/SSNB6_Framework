package ssnb6.selenium.testng;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Thrown;
import ssnb6.selenium.testng.data.HeatclinicLoginData;


public class HeatclinicLoginFunctionality4 extends TestNgScriptBase1{
	
	
	@Test(dataProviderClass=HeatclinicLoginData.class, dataProvider ="getTestDataExcelByPOI")
	public void validUserAndPassword1(String run,String userid, String password, String username) {
		if(run.toUpperCase().contentEquals("N")) {
			throw new SkipException("This test is skiped");
		}
		
		homePage.verifyHomepageTitle();
		homePage.gotoLoginPage();
		loginPage.verifyLoginpageTitle();
		loginPage.Login(userid,password);
		homePage.verifyHomepageTitle();
		homePage.verifyLoginSuccess(username);	
	}

	
	
}
