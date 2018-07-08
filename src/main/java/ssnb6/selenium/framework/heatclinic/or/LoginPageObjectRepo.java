package ssnb6.selenium.framework.heatclinic.or;

import org.openqa.selenium.By;

public class LoginPageObjectRepo {

	public static final By USERNAME_TEXTBOX = By.name("j_username");
	public static final By PASSWORD_TEXTBOX = By.name("j_password");
	public static final By LOGIN_BUTTON = By.cssSelector("input.login_button.big.red");
	public static final By ERROR_MSG_LABEL = By.cssSelector("span.error");
	
}
