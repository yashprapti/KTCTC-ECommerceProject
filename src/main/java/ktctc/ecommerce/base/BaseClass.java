package ktctc.ecommerce.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	// public static WebDriver driver;

	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	// loadConfig method is to load the configuration

	@BeforeSuite
	public static void loadConfig() {
//		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void launchApp() {
		WebDriverManager.chromedriver().setup();
		String BrowserName = prop.getProperty("browser");
		if (BrowserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if (BrowserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}
		// Maximize the screen
		driver.get().manage().window().maximize();
		// Delete all the cookies
		// driver.manage().deleteAllCookies();
		// Implicit TimeOuts
//    			driver.manage().timeouts().implicitlyWait
//    			(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
//    			//PageLoad TimeOuts
//    			driver.manage().timeouts().pageLoadTimeout
//    			(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
		driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Launching the URL
		// driver.get("http://automationpractice.com/index.php?");
		driver.get().get(prop.getProperty("url"));
	}

//    @AfterSuite(groups = { "Smoke", "Regression","Sanity" })
//	public void afterSuite() {
//		ExtentManager.endReport();
//	}
}
