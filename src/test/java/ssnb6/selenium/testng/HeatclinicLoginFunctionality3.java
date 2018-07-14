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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class HeatclinicLoginFunctionality3 extends TestNgScriptBase1{
	
	
	@Test(dataProvider ="getTestData")
	public void validUserAndPassword1(String userid, String password, String username) {
		homePage.verifyHomepageTitle();
		homePage.gotoLoginPage();
		loginPage.verifyLoginpageTitle();
		loginPage.Login(userid,password);
		homePage.verifyHomepageTitle();
		homePage.verifyLoginSuccess(username);	
	}

	
	
	@DataProvider
	public Object[][] getTestData(){
		Object[][] data = {
				
				            {"shiftqa01@gmail.com","shiftedtech","Shift"},
							{"nefaur.rb@gmail.com","123456nrb","Nefaur"},
							{"arifurkh64@yahoo.com","iq9006564","Arifur"}
				           
						   };
		
		return data;
	}
}
