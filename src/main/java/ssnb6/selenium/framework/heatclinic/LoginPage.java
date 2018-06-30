package ssnb6.selenium.framework.heatclinic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyLoginpageTitle() {
		String title3 = driver.getTitle();
		Assert.assertEquals("Broadleaf Commerce Demo Store - Heat Clinic - Login", title3);
	}
	
	public void Login(String user, String password) {
		WebElement emailTextbox = driver.findElement(By.name("j_username"));
		emailTextbox.sendKeys(user);
		
		//** Step - 5
		WebElement passwordtextbox = driver.findElement(By.name("j_password"));
		passwordtextbox.sendKeys(password);
		
		//** Step - 6
		WebElement loginButton = driver.findElement(By.cssSelector("input.login_button.big.red"));
		loginButton.click();
	}
	public void verifyLoginNotSuccess() {
		WebElement error = driver.findElement(By.cssSelector("span.error"));
		String errorText = error.getText();
		assertThat(errorText,startsWith("The e-mail address and/or password entered do not match our records") );
	}
}
