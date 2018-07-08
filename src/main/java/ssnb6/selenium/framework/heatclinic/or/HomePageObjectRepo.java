package ssnb6.selenium.framework.heatclinic.or;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.openqa.selenium.By;


public class HomePageObjectRepo {
	
	public static  By LOGIN_LINK = null;
	public static  By MY_ACCOUNT_LINK = null;
	
	static{	
		String fileName = System.getProperty("user.dir") + "/src/main/resources/Homepage.properties";
		
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(fileName);
			// load a properties file
			prop.load(input);
			

			LOGIN_LINK = By.linkText(prop.getProperty("LOGIN_LINK"));
			MY_ACCOUNT_LINK = By.cssSelector(prop.getProperty("MY_ACCOUNT_LINK"));

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		
	}
}
