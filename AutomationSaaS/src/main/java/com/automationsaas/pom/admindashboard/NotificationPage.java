package com.automationsaas.pom.admindashboard;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.Interface;

public class NotificationPage implements Interface {
	public WebDriver driver;
	public NotificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Phone Verification
	@FindBy(xpath = "//h2[contains(text(),'SMS Notifications')]")
	private WebElement smsnotificationheading;

	@FindBy(xpath = "//input[@name='mobileNo']")
	private WebElement mobilenumbertextbox;

	@FindBy(id = "search")
	private WebElement smssearchbutton;
	
	@FindBy(xpath = "//*[@id='header-navbar']//li[2]//a")
	private WebElement notificationdropdown;
	
	@FindBy(id="reports_smsNotifications")
	private WebElement smsnotification;
	
	@FindBy(id="reportsEmailNotifications")
	private WebElement emailnotification;
	
	@FindBy(xpath="//span[contains(text(),'OTP has been Verified Successfully')]")
	private WebElement otpsuccessvalidationnotification;
	
	//Email Verification
	@FindBy(xpath = "//h2[contains(text(),'Email Notifications')]")
	private WebElement emailnotificationheading;

	@FindBy(xpath = "//input[@name='emailAddress']")
	private WebElement emailtextbox;

	@FindBy(id = "search")
	private WebElement emailsearchbutton;

	@FindBy(id = "content")
	private WebElement userverificationemailmessage;

	@FindBy(xpath = "//button[text()='Close']")
	private WebElement emailclosebutton;
	
	
	public void clickOnNotification() {
		try {
			Generics.waitForElement(driver, notificationdropdown);
			notificationdropdown.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickonSMSNotification() {
		try {
			Generics.waitForElement(driver, smsnotification);
			smsnotification.click();		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickonEmailNotification() {
		try {
			Generics.waitForElement(driver, emailnotification);
			emailnotification.click();		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String smsOTP(String mobilenumber) {
		String SMS_OTP = null;
		try {
			Generics.waitForElement(driver, smsnotificationheading);
			String smsNotificationHeading = smsnotificationheading.getText();
			assertEquals(smsNotificationHeading, "SMS Notifications");
			Generics.waitForElement(driver, mobilenumbertextbox);
			mobilenumbertextbox.sendKeys(mobilenumber);
			smssearchbutton.click();
			WebElement smsmessage = driver.findElement(By.xpath(
					"//td[count(//tr/th[.='Mobile Number']/preceding-sibling::th)+1][contains(text(),'" + mobilenumber
							+ "')]/following-sibling::td[count(//tr/th[.='Text']/preceding-sibling::th)]"));
			Generics.waitForElement(driver, smsmessage);
			String smsMessage = smsmessage.getText();
			SMS_OTP = smsMessage.replaceAll("[^0-9]", "");
			System.out.println("SMS_OTP: " + SMS_OTP);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return SMS_OTP;
	}
	
	public String userVerificationEmail(String email,String eSubject) {
	String emailLink=null;
	try {
		Generics.waitForElement(driver, emailnotificationheading);
		String smsNotificationHeading = emailnotificationheading.getText();
		assertEquals(smsNotificationHeading, "Email Notifications");
		Generics.waitForElement(driver, emailtextbox);
		emailtextbox.sendKeys(email);
		emailsearchbutton.click();
		WebElement emailsubject = driver.findElement(By.xpath("(//div[@class='main-box-body clearfix'])//td[contains(text(),'"+email+"')]/following-sibling::td[contains(text(),'"+eSubject+"')]"));
		Generics.waitForElement(driver, emailsubject);
		WebElement emailshowbutton = driver.findElement(By.xpath("(//div[@class='main-box-body clearfix'])//td[contains(text(),'"+email+"')]/following-sibling::td/button[contains(text(),'Show')]"));
		Generics.waitForElement(driver, emailshowbutton);
		emailshowbutton.click();
		Generics.waitForElement(driver, userverificationemailmessage);
		emailLink = userverificationemailmessage.getText();
		System.out.println("email link : " + emailLink);
		emailclosebutton.click();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
		return emailLink;
	}
}
