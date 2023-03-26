package com.automationsaas.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Generics {

	// Generate random number
	public static String getRandomNumber(int length) {
		Random random = new Random();
		int randomNumber = 0;
		boolean loop = true;
		while (loop) {
			randomNumber = random.nextInt();
			if (Integer.toString(randomNumber).length() == length && !Integer.toString(randomNumber).startsWith("-")) {
				loop = false;
			}
		}
		return Integer.toString(randomNumber);
	}

	// Generate random string
	public static String getRandomAlphaString(int n) {

		String AlphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphabetString.length() * Math.random());
			sb.append(AlphabetString.charAt(index));
		}
		return sb.toString();
	}

	// Generate time stamp
	public static long generateTimeStamp() {
		long timestamp = new java.sql.Timestamp(System.currentTimeMillis()).getTime();
		return timestamp;
	}

	// Scroll Page
	public static void scrollPage(WebDriver driver, int number) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + number + ")", "");
	}

	// Wait condition
	public static void waitForElement(WebDriver driver, WebElement element) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	// Wait condition_2
	public static void waitForElementToInvisible(WebDriver driver, WebElement element) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	// Wait condition_3
	public static void waitForElementToBeEnabled(WebDriver driver, WebElement element) throws InterruptedException {
		for (int i = 0; i <= 60; i++) {
			if (element.isEnabled()) {
				break;
			}
			Thread.sleep(1000);
		}
	}

	// Wait condition_4
	public static void refreshForElementToVisible(WebDriver driver, String locator, String presenttext)
			throws InterruptedException {
		for (int second = 0; second <= 120; second++) {
			String updatedprogressbar = driver.findElement(By.xpath(locator)).getText();
			if (updatedprogressbar.equalsIgnoreCase(presenttext)) {
				driver.navigate().refresh();
			} else if (updatedprogressbar != (presenttext)) {
				break;
			}
			Thread.sleep(1000);
		}
	}

	// Wait condition_4
	public static void waitForElementToClickable(WebDriver driver, String locator) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}

	// Wait condition_5
	public static void waitForFileDownloaded(WebDriver driver, final String path, final String fileName) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
		wait.until(new Function<WebDriver, Object>() {
			@Override
			public Object apply(WebDriver x) {
				File[] files = new File(path).listFiles();
				for (File file : files) {
					if (file.getName().contains(fileName)) {
						return true;
					}
				}
				return false;
			}
		});
	}

	// Get current date
	public static String getCurrentDate() {
		String pattern = "dd/MM/yyyy";
		String dateInString = new SimpleDateFormat(pattern).format(new Date());
		return dateInString;
	}

	// Take Screenshot
	public static void takeScreenShots(WebDriver driver, String screenshot_path) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(screenshot_path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Upload File
	public void uploadDocument(WebDriver driver, WebElement firstuploadButton, WebElement seconduploadbutton,
			WebElement choosefile, String upload_file_path) throws InterruptedException {
		Generics.waitForElement(driver, firstuploadButton);
		firstuploadButton.click();
		Generics.waitForElement(driver, seconduploadbutton);
		choosefile.sendKeys(upload_file_path);
		seconduploadbutton.click();
		Generics.waitForElement(driver, firstuploadButton);
	}

	// Alert Accept
	public static void alertAction(WebDriver driver, String action) {
		if (action.equalsIgnoreCase("Yes")) {
			driver.switchTo().alert().accept();
		} else if (action.equalsIgnoreCase("No")) {
			driver.switchTo().alert().dismiss();
		}
	}

	// This will give the count of the elemnt wrt the locators
	public static int getElementCount(List<WebElement> element) {
		return element.size();
	}

	/**
	 * @author chandrashekar
	 *
	 */
	// Wait condition_6
	public static void waitForFewSecondstoLoad(long millisecondstoWait) {
		try {
			Thread.sleep(millisecondstoWait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean validateDownloadFile(String file_path, String expectedfilename) {
		File[] files = new File(file_path).listFiles();
		for (File file : files) {
			if (file.getName().contains(expectedfilename)) {
				return true;
			}
		}
		return false;
	}

	public static void refreshPage(WebDriver driver) {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean validateregexpattern(String regexpattern, String values) {

		String regex = regexpattern;
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(values);

		return m.matches();
	}

	public static String getLastNCharsOfString(String str, int n) {
		String lastnChars = str;
		if (lastnChars.length() > n) {
			lastnChars = lastnChars.substring(lastnChars.length() - n, lastnChars.length());
		}
		return lastnChars;
	}

	public static String parseJson(String jsonfile, String key) {

		try {
			JSONParser parser = new JSONParser();

			Object obj = parser.parse(new FileReader(jsonfile));

			JSONObject jsonObject = (JSONObject) obj;
			return jsonObject.get(key).toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static String jsonParser(String file, String key_value) {
		String value = null;
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = null;

			jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));

			value = (String) jsonObject.get(key_value);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return value;
	}
}