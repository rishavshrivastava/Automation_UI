package com.automationsaas.pom.userslist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class UsersPage extends Base {

	public WebDriver driver;
	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailtextbox;
	
	@FindBy(id="search")
	private WebElement searcbutton;
	
	@FindBy(xpath="//i[@class='fa fa-edit']")
	private WebElement editbutton;
	
	public void enterEmailAddress(String product) {
		try {
			Generics.waitForElement(driver, emailtextbox);
			emailtextbox.click();
			emailtextbox.clear();
			emailtextbox.sendKeys(product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickSearch() {
		try {
			Generics.waitForElement(driver, searcbutton);
			searcbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickEdit() {
		try {
			Generics.waitForElement(driver, editbutton);
			editbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
