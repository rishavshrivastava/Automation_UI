package com.automationsaas.pom.rolesandpermissions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class AdminInvestorModulePermissionPage extends Base {
	
	public WebDriver driver;
	public AdminInvestorModulePermissionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'AdminInvestorModulePermission')]")
	private WebElement admininvestormodulepermissiontab;
	
	@FindBy(id="forViewAll")
	private WebElement canviewcheckbox;
	
	@FindBy(id="forEditAll")
	private WebElement caneditcheckbox;
	
	@FindBy(id="submitBorrowerSettings")
	private WebElement submitbutton;
	
	public void clickAdminInvestorModulePermission() {
		try {
			Generics.waitForElement(driver, admininvestormodulepermissiontab);
			admininvestormodulepermissiontab.click();
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
			Generics.waitForElement(driver, caneditcheckbox);
			caneditcheckbox.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickUpdate() {
		try {
			Generics.waitForElement(driver, submitbutton);
			submitbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
