package com.automationsaas.pom.investor;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class PersonalProfilePage extends Base {

	public WebDriver driver;
	public PersonalProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Personal Profile']")
	private WebElement personalprofiletab;
	
	@FindBy(id="amountToInvest")
	private WebElement amountlookingtoinvesttextbox;
	
	@FindBy(id="grossIncome")
	private WebElement grossincometextbox;
	
	@FindBy(xpath="//div[@id='individualOrCompanyDetails']//input[@id='investorProfileTextVariable1']")
	private WebElement investorprofiletextvariable1textbox;
	
	@FindBy(id="line1")
	private WebElement address_line1textbox;
	
	@FindBy(id="line2")
	private WebElement address_line2textbox;
	
	@FindBy(id="line3")
	private WebElement address_line3textbox;
	
	@FindBy(id="state")
	private WebElement address_statetextbox;
	
	@FindBy(id="city")
	private WebElement address_citytextbox;
	
	@FindBy(id="zipCode")
	private WebElement address_zipcodetextbox;
	
	@FindBy(xpath="//span[contains(text(),'Updated')]")
	private WebElement personalprofileupdatenotification;
	
	@FindBy(xpath="//div[@id='submitButtonIndividualDetail']//button[text()='Update']")
	private WebElement submitbutton;

	
	public void clickPersonalProfile() {
		try {
			Generics.waitForElement(driver, personalprofiletab);
			personalprofiletab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validatePersonalProfile(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, amountlookingtoinvesttextbox);
				assertEquals(amountlookingtoinvesttextbox.getAttribute("value"), product);
				break;

			case 1:
				Generics.waitForElement(driver, grossincometextbox);
				assertEquals(grossincometextbox.getAttribute("value"), product);
				break;
				
			case 2:
				Generics.waitForElement(driver, investorprofiletextvariable1textbox);
				assertEquals(investorprofiletextvariable1textbox.getAttribute("value"), product);
				break;
				
			case 3:
				Generics.waitForElement(driver, address_line1textbox);
				assertEquals(address_line1textbox.getAttribute("value"), product);
				break;
				
			case 4:
				Generics.waitForElement(driver, address_line2textbox);
				assertEquals(address_line2textbox.getAttribute("value"), product);
				break;
				
			case 5:
				Generics.waitForElement(driver, address_line3textbox);
				assertEquals(address_line3textbox.getAttribute("value"), product);
				break;
				
			case 6:
				Generics.waitForElement(driver, address_statetextbox);
				assertEquals(address_statetextbox.getAttribute("value"), product);
				break;
				
			case 7:
				Generics.waitForElement(driver, address_citytextbox);
				assertEquals(address_citytextbox.getAttribute("value"), product);
				break;
				
			case 8:
				Generics.waitForElement(driver, address_zipcodetextbox);
				assertEquals(address_zipcodetextbox.getAttribute("value"), product);
				break;
				
			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void editPersonalProfile(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, amountlookingtoinvesttextbox);
				amountlookingtoinvesttextbox.click();
				amountlookingtoinvesttextbox.clear();
				amountlookingtoinvesttextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, grossincometextbox);
				grossincometextbox.click();
				grossincometextbox.clear();
				grossincometextbox.sendKeys(product);
				break;
				
			case 2:
				Generics.waitForElement(driver, investorprofiletextvariable1textbox);
				investorprofiletextvariable1textbox.click();
				investorprofiletextvariable1textbox.clear();
				investorprofiletextvariable1textbox.sendKeys(product);
				break;
				
			case 3:
				Generics.waitForElement(driver, address_line1textbox);
				address_line1textbox.click();
				address_line1textbox.clear();
				address_line1textbox.sendKeys(product);
				break;
				
			case 4:
				Generics.waitForElement(driver, address_line2textbox);
				address_line2textbox.click();
				address_line2textbox.clear();
				address_line2textbox.sendKeys(product);
				break;
				
			case 5:
				Generics.waitForElement(driver, address_line3textbox);
				address_line3textbox.click();
				address_line3textbox.clear();
				address_line3textbox.sendKeys(product);
				break;
				
			case 6:
				Generics.waitForElement(driver, address_statetextbox);
				Select stateOptions = new Select(address_statetextbox);
				stateOptions.selectByVisibleText(product);
				break;
				
			case 7:
				Generics.waitForElement(driver, address_citytextbox);
				address_citytextbox.click();
				address_citytextbox.clear();
				address_citytextbox.sendKeys(product);
				break;
				
			case 8:
				Generics.waitForElement(driver, address_zipcodetextbox);
				address_zipcodetextbox.click();
				address_zipcodetextbox.clear();
				address_zipcodetextbox.sendKeys(product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickPersonalProfileUpdate() {
		try {
			Generics.waitForElement(driver, submitbutton);
			submitbutton.click();
			Generics.waitForElement(driver, personalprofileupdatenotification);
			Generics.waitForElement(driver, submitbutton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void checkIfPersonalProfilePageAreDisabled(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, amountlookingtoinvesttextbox);
				assertEquals(amountlookingtoinvesttextbox.getAttribute("disabled"), product);
				break;
				
			case 1:
				Generics.waitForElement(driver, grossincometextbox);
				assertEquals(grossincometextbox.getAttribute("disabled"), product);
				break;
				
			case 2:
				Generics.waitForElement(driver, investorprofiletextvariable1textbox);
				assertEquals(investorprofiletextvariable1textbox.getAttribute("disabled"), product);
				break;
				
			case 3:
				Generics.waitForElement(driver, address_line1textbox);
				assertEquals(address_line1textbox.getAttribute("disabled"), product);
				break;
				
			case 4:
				Generics.waitForElement(driver, address_line2textbox);
				assertEquals(address_line2textbox.getAttribute("disabled"), product);
				break;
				
			case 5:
				Generics.waitForElement(driver, address_line3textbox);
				assertEquals(address_line3textbox.getAttribute("disabled"), product);
				break;
				
			case 6:
				Generics.waitForElement(driver, address_statetextbox);
				assertEquals(address_statetextbox.getAttribute("disabled"), product);
				break;
				
			case 7:
				Generics.waitForElement(driver, address_citytextbox);
				assertEquals(address_citytextbox.getAttribute("disabled"), product);
				break;
				
			case 8:
				Generics.waitForElement(driver, address_zipcodetextbox);
				assertEquals(address_zipcodetextbox.getAttribute("disabled"), product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
