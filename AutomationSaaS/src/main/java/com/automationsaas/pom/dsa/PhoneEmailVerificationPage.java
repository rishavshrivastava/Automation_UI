package com.automationsaas.pom.dsa;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationsaas.utilities.Generics;

public class PhoneEmailVerificationPage {
	public WebDriver driver;

	public PhoneEmailVerificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="otpText")
	private WebElement otptextbox;
	
	@FindBy(id="check_otp")
	private WebElement validateotpbutton;
	
	@FindBy(xpath = "//*[@id='content-wrapper']//h4")
	private WebElement linkverificationsuccessmessage;
	
	@FindBy(xpath="//a[contains(text(),'Continue to Profile')]")
	private WebElement continuetoprofilelink;
	
	public void enterOTP(String otp) {
		try {
			Generics.waitForElement(driver, otptextbox);
			otptextbox.click();
			otptextbox.clear();
			otptextbox.sendKeys(otp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnValidateOTPbutton(String otpnotification) {
		try {
			Generics.waitForElement(driver, validateotpbutton);
			validateotpbutton.click();
			//driver.navigate().refresh();   Update this incase the script is failing or SMS OTP defect is resolved.
			Generics.waitForElementToInvisible(driver, validateotpbutton);
			Generics.refreshPage(driver);
			
			assertFalse(driver.getPageSource().contains(otpnotification),"Phone Verifcation by SMS OTP failed.");
		}	
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void verifyEmailLink(String message) {
		assertTrue(linkverificationsuccessmessage.getText().contains(message),"Email verification link failed." );
		continuetoprofilelink.click();
	}
}
