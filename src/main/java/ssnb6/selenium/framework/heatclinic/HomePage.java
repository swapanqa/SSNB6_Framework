package ssnb6.selenium.framework.heatclinic;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyHomepageTitle() {
		List<WebElement> titleTags = driver.findElements(By.tagName("title"));
		String title  = "";
		if(titleTags.size() > 1) {
			//String title = titleTags.get(1).getText();
			//String title = titleTags.get(1).getCssValue("text");
			title = titleTags.get(1).getAttribute("text");
		}
		else {
			title = titleTags.get(0).getAttribute("text");
		}
		Assert.assertEquals("Broadleaf Demo - Heat Clinic", title);
	}
	
	public void gotoLoginPage() {
		WebElement loginLink = driver.findElement(By.linkText("Login"));
		loginLink.click();
	}
	
	public void verifyLoginSuccess(String userName) {
		WebElement myAccountLink = driver.findElement(By.cssSelector("a.my-account"));
		String myText = myAccountLink.getText();
		Assert.assertEquals(userName, myText);
	}
}
