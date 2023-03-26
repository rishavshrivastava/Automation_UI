package com.automationsaas.pom.rolesandpermissions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class AdminLoanApplicationModulePermissionPage extends Base {
	
	public WebDriver driver;
	public AdminLoanApplicationModulePermissionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'AdminLoanApplicationModulePermission')]")
	private WebElement adminloanapplicationmodulepermissiontab;
	
	@FindBy(id="forViewAll")
	private WebElement canviewcheckbox;
	
	@FindBy(id="forEditAll")
	private WebElement foreditcheckbox;
	
	@FindBy(id="submitBorrowerSettings")
	private WebElement updatebutton;
	
	public void clickAdminLoanApplicationModulePermission() {
		try {
			Generics.waitForElement(driver, adminloanapplicationmodulepermissiontab);
			adminloanapplicationmodulepermissiontab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickCanView() {
		try {
			Generics.waitForElement(driver, canviewcheckbox);
			canviewcheckbox.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickCanEdit() {
		try {
			Generics.waitForElement(driver, foreditcheckbox);
			foreditcheckbox.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickUpdate() {
		try {
			Generics.waitForElement(driver, updatebutton);
			updatebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
