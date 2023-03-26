package com.automationsaas.pom.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class LoginPage extends Base {

	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@id='borrowerSignUp']//a[contains(.,'Borrower')]")
	private WebElement borrowerlink;
	
	@FindBy(xpath="//span[@id='dsaSignUp']//a")
	private WebElement dsalink;
	
	@FindBy(xpath="//span[@id='investorSignUp']//a")
	private WebElement investorlink;
	
	@FindBy(id="username")
	private WebElement usernametextbox;
	
	@FindBy(id="password")
	private WebElement passwordtextbox;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginbutton;
	
	@FindBy(xpath="//a[@id='registerBtn']")
	private WebElement registerbutton;
	
	public void clickRegisterButton() {
		try {
			Generics.waitForElement(driver, registerbutton);
			registerbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickBorrower() {
		try {
			Generics.waitForElement(driver, borrowerlink);
			borrowerlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickDSA() {
		try {
			Generics.waitForElement(driver, dsalink);
			dsalink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickInvestor() {
		try {
			Generics.waitForElement(driver, investorlink);
			investorlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterUsername(String username) {
		try {
			Generics.waitForElement(driver, usernametextbox);
			usernametextbox.click();
			usernametextbox.clear();
			usernametextbox.sendKeys(username);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterPassword(String password) {
		try {
			Generics.waitForElement(driver, passwordtextbox);
			passwordtextbox.click();
			passwordtextbox.clear();
			passwordtextbox.sendKeys(password);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickLogin() {
		try {
			Generics.waitForElement(driver, loginbutton);
			loginbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
