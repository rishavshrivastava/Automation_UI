package com.automationsaas.pom.rolesandpermissions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class SystemAdminPage extends Base {
	
	public WebDriver driver;
	public SystemAdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Edit Permissions')]")
	private WebElement editpermissionbutton;
	
	public void clickEditPermission() {
		try {
			Generics.waitForElement(driver, editpermissionbutton);
			editpermissionbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
