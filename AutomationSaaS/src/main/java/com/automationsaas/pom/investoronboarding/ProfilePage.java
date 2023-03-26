package com.automationsaas.pom.investoronboarding;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class ProfilePage extends Base {

	public WebDriver driver;

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="close_OTP_modal_2")
	private WebElement continuewithoutvalidationbutton;
	
	@FindBy(xpath = "//h1")
	private WebElement profileheading;
	
	@FindBy(id="amountToInvest")
	private WebElement amounttoinvesttextbox;
	
	@FindBy(id="grossIncome")
	private WebElement grossincometextbox;
	
	@FindBy(id="investorProfileTextVariable1")
	private WebElement investorprofiletextvariable1;
	
	@FindBy(id="line1")
	private WebElement addressline1;
	
	@FindBy(id="line2")
	private WebElement addressline2;
	
	@FindBy(id="line3")
	private WebElement addressline3;
	
	@FindBy(id="state")
	private WebElement statetextbox;
	
	@FindBy(id="city")
	private WebElement citytextbox;
	
	@FindBy(id="zipCode")
	private WebElement zipcodetextbox;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement continuebutton;
	
	@FindBy(xpath="//ul[@class='nav alert alert-block alert-danger fade in']/li")
	private List<WebElement> errormessages;
	
	public void clickContinueWithoutValidation() {
		try {
			Generics.waitForElement(driver, continuewithoutvalidationbutton);
			continuewithoutvalidationbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateProfilePageHeading(String pageheading) {
		try {
			Generics.waitForElement(driver, profileheading);
			if (profileheading.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("Profile is displayed", true);
			} else
				Reporter.log("Profile is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateProfilePageHeading", true);
		}
	}
	
	public void enterAmountToInvest(String amount) {
		try {
			Generics.waitForElement(driver, amounttoinvesttextbox);
			amounttoinvesttextbox.click();
			amounttoinvesttextbox.clear();
			amounttoinvesttextbox.sendKeys(amount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterGrossIncome(String amount) {
		try {
			Generics.waitForElement(driver, grossincometextbox);
			grossincometextbox.click();
			grossincometextbox.clear();
			grossincometextbox.sendKeys(amount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterInvestorProfileTextVariable1(String variable) {
		try {
			Generics.waitForElement(driver, investorprofiletextvariable1);
			investorprofiletextvariable1.click();
			investorprofiletextvariable1.clear();
			investorprofiletextvariable1.sendKeys(variable);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterAddress(String line1, String line2, String line3, String state, String city, String zipcode) {
		try {
			Generics.waitForElement(driver, addressline1);
			addressline1.click();
			addressline1.clear();
			addressline1.sendKeys(line1);
			
			Generics.waitForElement(driver, addressline2);
			addressline2.click();
			addressline2.clear();
			addressline2.sendKeys(line2);
			
			Generics.waitForElement(driver, addressline3);
			addressline3.click();
			addressline3.clear();
			addressline3.sendKeys(line3);
			
			Generics.waitForElement(driver, statetextbox);
			Select stateOptions = new Select(statetextbox);
			stateOptions.selectByVisibleText(state);
			
			Generics.waitForElement(driver, citytextbox);
			citytextbox.click();
			citytextbox.clear();
			citytextbox.sendKeys(city);
			
			Generics.waitForElement(driver, citytextbox);
			zipcodetextbox.click();
			zipcodetextbox.clear();
			zipcodetextbox.sendKeys(zipcode);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickContinue() {
		try {
			Generics.waitForElement(driver, continuebutton);
			continuebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateMandatoryFieldsErrorMessages(int count, String i) {
		try {
			Generics.waitForElement(driver, errormessages.get(0));
			assertEquals(errormessages.size(), count);
			for(int j=0; j<errormessages.size(); j++) {
				if(i.equals(errormessages.get(j).getText())) {
					assertEquals(errormessages.get(j).getText(), i);
					break;
				}
				else if(!i.equals(errormessages.get(j).getText()) && j==count-1) {
					Reporter.log("Can't able to match - "+i, true);
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
