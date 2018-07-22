package ssnb6.selenium.testng;

import javax.management.RuntimeErrorException;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ssnb6.selenium.framework.heatclinic.HomePage;
import ssnb6.selenium.framework.heatclinic.LoginPage;
import ssnb6.selenium.framework.kw.KWScriptBase;
import ssnb6.selenium.framework.kw.KeywordDriver;
import ssnb6.selenium.framework.utils.ExcelReader;

public class KWScript extends KWScriptBase {
	
	@Test(dataProviderClass=KeywordDriver.class, dataProvider="getScriptList")
	public void KWDriver(String scriptId, String scriptName, String scriptTab, String run) {
		if(run.toUpperCase().contentEquals("N")) {
			throw new SkipException("This test is skiped");
		}
		
		System.out.println("Running test : " + scriptName);
		kwd.KWScriptDriver(scriptTab);
	
	}
	
	

}
