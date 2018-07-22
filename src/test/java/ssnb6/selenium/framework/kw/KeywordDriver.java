package ssnb6.selenium.framework.kw;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import ssnb6.selenium.framework.heatclinic.HomePage;
import ssnb6.selenium.framework.heatclinic.LoginPage;
import ssnb6.selenium.framework.utils.ExcelReader;

public class KeywordDriver {

	private static String EXCEL_FILE_LOCATION = System.getProperty("user.dir") + "/src/test/resources/HeatclinicKeyword.xlsx";;
	
	protected WebDriver driver = null;
	protected HomePage homePage;
	protected LoginPage loginPage;

	public  KeywordDriver() {
	}
	
	public  KeywordDriver(WebDriver driver) {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
	}
	
	@DataProvider
	public Object[][] getScriptList() {
		Object[][] data = null;		
		ExcelReader reader = new ExcelReader(EXCEL_FILE_LOCATION);
		data = reader.getExcelSheetData("ScriptList", true);
		return data;
	}
	
	public void KWScriptDriver(String scriptTab) {
		Object[][] kw = null;
		
		ExcelReader reader = new ExcelReader(EXCEL_FILE_LOCATION);
		kw = reader.getExcelSheetData(scriptTab, true);
		
		for(int i = 0; i < kw.length; i ++) {
			
			String stepId = kw[i][0].toString();
			String keyword = kw[i][1].toString();
			String data = kw[i][2].toString();
			System.out.println("KW: " + keyword);
			processKeyword(keyword,data);
		}
			
	}
	
	public void processKeyword(String kw, String data) {
		
		if(kw.toLowerCase().contentEquals("verifyHomepageTitle".toLowerCase())) {
			homePage.verifyHomepageTitle();
		}
		else if(kw.toLowerCase().contentEquals("gotoLoginPage".toLowerCase())){
			homePage.gotoLoginPage();
		}
		else if(kw.toLowerCase().contentEquals("verifyLoginpageTitle".toLowerCase())){
			loginPage.verifyLoginpageTitle();		
		}
		else if(kw.toLowerCase().contentEquals("Login".toLowerCase())){
			String[] part = data.split("\\|"); 
			String user = part[0];
			String password = part[1];	
			loginPage.Login(user, password);
		}
		else if(kw.toLowerCase().contentEquals("verifyHomepageTitle".toLowerCase())){
			homePage.verifyHomepageTitle();
		}
		else if(kw.toLowerCase().contentEquals("verifyLoginSuccess".toLowerCase())){
			homePage.verifyLoginSuccess(data);
		}
		else {
			throw new RuntimeException("Unknown Keyword: " + kw);
		}
		
	}
	
}
