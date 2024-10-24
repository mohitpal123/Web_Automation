package pageutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import baselibraryutility.Baselibrary;

public class LoginPage extends Baselibrary {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@name='username']")
	WebElement userName;
	@FindBy(xpath = "//*[@name='password']")
	WebElement password;
	@FindBy(xpath = "//*[@type='submit']")
	WebElement Login;

	public void doLogin(String user, String pass) throws Exception {
		Thread.sleep(2000);
		logger.info("Enter Username");
		userName.sendKeys(user);
		logger.info("Enter Password");
		password.sendKeys(pass);
		logger.info("Click on SignIn button");
		Login.click();
		logger.info("Login sussessfully");

	}

}
