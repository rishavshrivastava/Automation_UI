package com.automationsaas.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base implements Interface {

	public static WebDriver driver;
	File downloadfolder;

	@BeforeSuite
	public void beforeExecutionCleanup() {
		File screenshot = new File(execution_report_path);
		for (File file : screenshot.listFiles()) {
			file.delete();
		}
		
		downloadfolder = new File(upload_contractfile_path);
		for (File file : downloadfolder.listFiles()) {
			file.delete();
		}
	}

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void launchBrowser() {

		try {

			ArrayList<String> browser = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Browser");
			Reporter.log("Browser Invoked from Chrome, Firefox and Edge is: " + browser.get(1), true);
			
			if (browser.get(1).equalsIgnoreCase("firefox")) {
				WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
				driver = new FirefoxDriver();

			} else if (browser.get(1).equalsIgnoreCase("chrome")) {
				WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
				downloadfolder = new File(upload_contractfile_path);
				ChromeOptions options = new ChromeOptions();
//				options.addArguments("headless");
//				options.addArguments("window-size=1200x600");
//				options.addArguments("--window-size=2560,1440");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_settings.popups", 0);
				prefs.put("download.default_directory", downloadfolder.getAbsolutePath());
				options.setExperimentalOption("prefs", prefs);
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(cap);

			} else if (browser.get(1).equalsIgnoreCase("EDGE")) {
				WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
				driver = new EdgeDriver();

			} else
				Reporter.log("There is no such method implemented for the given browser", true);

		} catch (Exception e) {
			Reporter.log("Browser is not selected-Please enter valid browser name", true);
			Reporter.log("Till now we are only supporting Chrome, Firefox and Edge", true);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1964, 1029));
		
		Dimension dimension = driver.manage().window().getSize();
		Reporter.log("dimension is " + dimension, true);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
