package com.automationsaas.pom.userslist;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class UserDetailsPage extends Base {

	public WebDriver driver;
	public UserDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement usernametextbox;
	
	@FindBy(id="isPhoneVerified")
	private WebElement isphoneverifiedcheckbox;
	
	@FindBy(id="isEmailVerified")
	private WebElement isemailverifiedcheckbox;
	
	@FindBy(id="create")
	private WebElement updatebutton;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successmessage;
	
	public void validateUsername(String product) {
		try {
			Generics.waitForElement(driver, usernametextbox);
			assertEquals(usernametextbox.getAttribute("value"), product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void checkIfPhoneVerified() {
		try {
			Generics.waitForElement(driver, isphoneverifiedcheckbox);
			if(isphoneverifiedcheckbox.isSelected()==false) {
				isphoneverifiedcheckbox.click();
			}
			else if(isphoneverifiedcheckbox.isSelected()==true) {
				Reporter.log("isphoneverifiedcheckbox Checkbox was already selected. Need to review", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void checkIfEmailVerified() {
		try {
			Generics.waitForElement(driver, isemailverifiedcheckbox);
			if(isemailverifiedcheckbox.isSelected()==false) {
				isemailverifiedcheckbox.click();
			}
			else if(isemailverifiedcheckbox.isSelected()==true) {
				Reporter.log("isemailverifiedcheckbox Checkbox was already selected. Need to review", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickUpdate() {
		try {
			Generics.waitForElement(driver, updatebutton);
			updatebutton.click();
			Generics.waitForElement(driver, successmessage);
			System.out.println(successmessage.getText());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
