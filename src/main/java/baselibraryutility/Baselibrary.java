package baselibraryutility;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//@SuppressWarnings("deprecation")
public class Baselibrary {

	public static WebDriver driver;
	public static Logger logger;
	public static Random random;

	/**
	 * This Method for launch browser before class
	 */

	public void getLaunchURL(String url, String Browser) {
		logger = LogManager.getLogger("FlexPlus : ");
		logger.info("Using browser = " + Browser);
		logger.info("Using Url = " + url);

		if (Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		} else if (Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			logger.info("Enter the correct driver name");

		}

		driver.manage().window().maximize();
		logger.info("Url opened");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	//	driver.close();

	}

}
