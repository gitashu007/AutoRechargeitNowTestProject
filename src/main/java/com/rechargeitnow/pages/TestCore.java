package com.rechargeitnow.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestCore extends Page{

	public static Properties object = new Properties();
	public static Properties config = new Properties();
	public static WebDriver driver1;
	public static AppiumDriver driver;
	public static String SCREENSHOT_FOLDER = "target/Screenshots/";
	public static final String SCREENSHOT_FORMAT = ".png";

	@BeforeSuite
	public void beforeSuite() throws MalformedURLException{

		try{
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//config.properties");
			config.load(fis);
		}
		catch(Exception e){
			e.printStackTrace();
		}

		if(config.getProperty("Platform").toLowerCase().contains("windows")){
			log("----------- Launching Browser on desktop-------------", ILogLevel.TESTCASE);

			if(config.getProperty("Browser").toLowerCase().contains("firefox")){
				driver1 = new FirefoxDriver();
			}
			else if(config.getProperty("Browser").toLowerCase().contains("chrome")){
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\chromedriver.exe");
				driver1 = new ChromeDriver();
				
			}
		}
		
		if(config.getProperty("Platform").toLowerCase().equals("android")){
			log("----------- Launching Device -------------", ILogLevel.TESTCASE);

			if(config.getProperty("Application_Type").toLowerCase().equals("wap")){

				if(config.getProperty("Browser").toLowerCase().equals("chrome")){
					File classpathRoot = new File(System.getProperty("user.dir"));
					File app = new File(classpathRoot, "/src/main/resources/drivers/chromedriver.exe");

					DesiredCapabilities capabilities=DesiredCapabilities.android();
					capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.CHROME);
					capabilities.setCapability(MobileCapabilityType.PLATFORM,Platform.ANDROID);
					capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, config.getProperty("Platform_Name"));
					capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, config.getProperty("Device_Name"));
					capabilities.setCapability(MobileCapabilityType.VERSION,config.getProperty("Android_Version"));
					capabilities.setCapability("newCommandTimeout", 60 * 5);
					capabilities.setCapability("chromedriverExecutable", app.getAbsolutePath());
					
					driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

					log("----------- Launching Chrome Browser -------------", ILogLevel.TESTCASE);

				}

			}
		}

	}

	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method) throws IOException, InterruptedException, MalformedURLException {
		if(config.getProperty("Platform").toLowerCase().equals("windows")){
            driver.manage().window().maximize();
			driver.get(config.getProperty("site_url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
		
		if(config.getProperty("Platform").toLowerCase().equals("android")){
		driver.get(config.getProperty("site_url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		log("--------------------------------------------------------", ILogLevel.TESTCASE);
		log("---------Test ["+method.getName()+"] Started------------", ILogLevel.TESTCASE);
		log("--------------------------------------------------------", ILogLevel.TESTCASE);
	}

	@AfterMethod

	public void setScreenshot(ITestResult result) {

		if(!result.isSuccess()){
			try {
				if ( driver != null) {
					File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					try {
						FileUtils.copyFile(f, new File(SCREENSHOT_FOLDER+ result.getName() + SCREENSHOT_FORMAT)
								.getAbsoluteFile());
					} catch (IOException e) { 
						e.printStackTrace(); 
					}
				}

			} catch (ScreenshotException se) {
				se.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	@AfterSuite

	public void tearDown() {


		if (driver != null) {

			driver.close();
			driver.quit();


		}	
	}


}


