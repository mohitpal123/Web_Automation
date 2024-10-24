package logintestpage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baselibraryutility.Baselibrary;
import pageutility.LoginPage;
import propertyutility.Propertyutility;

public class LoginPageTest extends Baselibrary {
	LoginPage LoginPage;

	@BeforeTest
	public void launchURL() {
		getLaunchURL(Propertyutility.readdata("url"), Propertyutility.readdata("Browser"));
		LoginPage = new LoginPage();
	}

	@Test(priority = 0)
	public void login() throws Exception

	{

		String user = Propertyutility.readdata("username");
		String pass = Propertyutility.readdata("password");
		logger.info("Useing user name : " + user);
		logger.info("Useing user pass : " + pass);
		try {
			LoginPage.doLogin(user, pass);

		} catch (Exception e) {
			System.err.println("Issue in method " + e);
			e.printStackTrace();
		}

	}
}
