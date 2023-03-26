package com.automationsaas.pom.configuresettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationsaas.utilities.Generics;

public class ConfigureSettingsPage {

	public WebDriver driver;

	public ConfigureSettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'CATEGORY 5')]")
	private WebElement category5tab;
	
	@FindBy(id="tenantVariableSetting_c0b4e89b-dfd6-40f2-9e7a-1dd24610c941")
	private WebElement showLoanRepaymentRescheduleSummaryWhileBorrowerOnboardingCheckBox;
	
	@FindBy(xpath="//span[contains(text(),'updated')]")
	private WebElement updatenotifications;
	
	public void clickCategory5() {
		try {
			Generics.waitForElement(driver, category5tab);
			category5tab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickShowLoanRepaymentRescheduleSummaryWhileBorrowerOnboarding(String select) {
		try {
			Generics.waitForElement(driver, showLoanRepaymentRescheduleSummaryWhileBorrowerOnboardingCheckBox);
			if(select.equalsIgnoreCase("yes")) {
				if(showLoanRepaymentRescheduleSummaryWhileBorrowerOnboardingCheckBox.isSelected()==false) {
					showLoanRepaymentRescheduleSummaryWhileBorrowerOnboardingCheckBox.click();
					Generics.waitForElement(driver, updatenotifications);
					System.out.println(updatenotifications.getText());
				}
				else if(showLoanRepaymentRescheduleSummaryWhileBorrowerOnboardingCheckBox.isSelected()==true) {
					
				}
				
			}
			
			if(select.equalsIgnoreCase("No")) {
				if(showLoanRepaymentRescheduleSummaryWhileBorrowerOnboardingCheckBox.isSelected()==false) {
					
				}
				else if(showLoanRepaymentRescheduleSummaryWhileBorrowerOnboardingCheckBox.isSelected()==true) {
					showLoanRepaymentRescheduleSummaryWhileBorrowerOnboardingCheckBox.click();
					Generics.waitForElement(driver, updatenotifications);
					System.out.println(updatenotifications.getText());
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
