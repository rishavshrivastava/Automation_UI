package com.automationsaas.pom.borroweronboarding;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.automationsaas.utilities.Generics;

public class VehicleDetailsPage {

	public WebDriver driver;

	public VehicleDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1")
	private WebElement vehicledetailsheading;
	
	@FindBy(id="brandName")
	private WebElement brandnametextbox;
	
	@FindBy(id="licenseNumber")
	private WebElement licensenumbertextbox;
	
	@FindBy(id="purchaseDate")
	private WebElement purchasedatetextbox;
	
	@FindBy(id="vehicleOwnedTextVariable1")
	private WebElement vehicleownedextratextveriable1textbox;
	
	@FindBy(id="vehicleOwnedTextVariable2")
	private WebElement vehicleownedextratextvariable2textbox;
	
	@FindBy(xpath="//input[contains(@id,'vehicleOwnedDateVariable1')]")
	private WebElement vehicleownedextradatevariable1textbox;
	
	@FindBy(xpath="//input[contains(@id,'vehicleOwnedDateVariable2')]")
	private WebElement vehicleownedextradatevariable2textbox;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	private WebElement yeardropdown;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	private WebElement monthdropdown;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//a")
	private List<WebElement> datelinks;
	
	@FindBy(id="createVehicleOwnedAjxBtn")
	private WebElement addmorebutton;
	
	@FindBy(xpath="//div[@id='waitingSpinnerCreateLoan']//img[@src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']")
	private WebElement addmorespinner;
	
	@FindBy(xpath="//th[.='Brand Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Brand Name']/preceding-sibling::th)+1]")
	private WebElement savedbrandname;
	
	@FindBy(xpath="//th[.='License Number']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='License Number']/preceding-sibling::th)+1]")
	private WebElement savedlicensenumber;
	
	@FindBy(xpath="//th[.='Purchase Date']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Purchase Date']/preceding-sibling::th)+1]")
	private WebElement savedpurchasedate;
	
	@FindBy(xpath="//th[.='Vehicle Owned extra text variable1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Vehicle Owned extra text variable1']/preceding-sibling::th)+1]")
	private WebElement savedvehicleownedextratextvariable1;
	
	@FindBy(xpath="//th[.='Vehicle Owned extra text variable2']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Vehicle Owned extra text variable2']/preceding-sibling::th)+1]")
	private WebElement savedvehicleownedextratextvariable2;
	
	@FindBy(xpath="//th[.='Vehicle Owned extra date variable1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Vehicle Owned extra date variable1']/preceding-sibling::th)+1]")
	private WebElement savedvehicleownedextradatevariable1;
	
	@FindBy(xpath="//th[.='Vehicle Owned extra date variable2']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Vehicle Owned extra date variable2']/preceding-sibling::th)+1]")
	private WebElement savedvehicleownedextradatevariable2;
	
	@FindBy(id="edit_vehicle_modal_opener")
	private WebElement editbutton;
	
	@FindBy(xpath="//form[@id='vehicleOwnedDetailForm']//input[@id='brandName']")
	private WebElement updatebrandnametextbox;
	
	@FindBy(xpath="//form[@id='vehicleOwnedDetailForm']//input[@id='licenseNumber']")
	private WebElement updatelicensenumbertextbox;
	
	@FindBy(id="purchaseDate")
	private WebElement updatepurchasedatetextbox;
	
	@FindBy(xpath="//form[@id='vehicleOwnedDetailForm']//input[@id='vehicleOwnedTextVariable1']")
	private WebElement updatevehicleownedtextvariable1;
	
	@FindBy(xpath="//form[@id='vehicleOwnedDetailForm']//input[@id='vehicleOwnedTextVariable2']")
	private WebElement updatevehicleownedtextvariable2;
	
	@FindBy(xpath="//form[@id='vehicleOwnedDetailForm']//input[contains(@id,'vehicleOwnedDateVariable1')]")
	private WebElement updatevehicleownedextradatevariable1;
	
	@FindBy(xpath="//form[@id='vehicleOwnedDetailForm']//input[contains(@id,'vehicleOwnedDateVariable2')]")
	private WebElement updatevehicleownedextradatevariable2;
	
	@FindBy(id="updateVehicleOwnedDetailBtn")
	private WebElement updatedonebutton;
	
	@FindBy(xpath="//div[@id='waitingUpdateVehicleOwnedDetailBtn']//img[@src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']")
	private WebElement updatedonebuttonspinner;
	
	@FindBy(xpath="//span[contains(text(),'updated')]")
	private WebElement otherloanupdatenotification;
	
	@FindBy(xpath="//button[@id='edit_vehicle_modal_opener']/following-sibling::button")
	private WebElement deletebutton;
	
	@FindBy(xpath="//span[contains(text(),'Vehicle record')]")
	private WebElement otherloandeletenotification;
	
	@FindBy(id="createVehicleOwnedAndContinueBtn")
	private WebElement addandcontinuebutton;
	
	@FindBy(xpath="//a[contains(text(),'Skip')]")
	private WebElement skipbutton;
	
	@FindBy(xpath="//ul[@class='nav alert alert-block alert-danger fade in']/li")
	private List<WebElement> errormessages;
	
	public void clickSkip() {
		try {
			Generics.waitForElement(driver, skipbutton);
			skipbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
	public void validateVehicleDetailsHeading(String pageheading) {
		try {
			Generics.waitForElement(driver, vehicledetailsheading);
			if (vehicledetailsheading.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("Vehicle details is displayed", true);
			} else
				Reporter.log("Vehicle details is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateOtherLoanDetailsHeading", true);
		}
	}
	
	public void enterBrandName(String brandname) {
		try {
			Generics.waitForElement(driver, brandnametextbox);
			brandnametextbox.click();
			brandnametextbox.clear();
			brandnametextbox.sendKeys(brandname);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterLicenseNumber(String licensenumber) {
		try {
			Generics.waitForElement(driver, licensenumbertextbox);
			licensenumbertextbox.click();
			licensenumbertextbox.clear();
			licensenumbertextbox.sendKeys(licensenumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterPurchaseDate(String year, String month, String date) {
		try {
			Generics.waitForElement(driver, purchasedatetextbox);
			purchasedatetextbox.click();
			Generics.waitForElement(driver, yeardropdown);
			Select years = new Select(yeardropdown);
			years.selectByVisibleText(year);
			Generics.waitForElement(driver, monthdropdown);
			Select months = new Select(monthdropdown);
			months.selectByVisibleText(month);
			for(int i=0;i<datelinks.size();i++) {
				if(datelinks.get(i).getText().equalsIgnoreCase(date)) {
					datelinks.get(i).click();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterVehicleOwnedExtraTextVariable1(String vehicleownedextratextvariable) {
		try {
			Generics.waitForElement(driver, vehicleownedextratextveriable1textbox);
			vehicleownedextratextveriable1textbox.click();
			vehicleownedextratextveriable1textbox.clear();
			vehicleownedextratextveriable1textbox.sendKeys(vehicleownedextratextvariable);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterVehicleOwnedExtraTextVariable2(String vehicleownedextratextvariable) {
		try {
			Generics.waitForElement(driver, vehicleownedextratextvariable2textbox);
			vehicleownedextratextvariable2textbox.click();
			vehicleownedextratextvariable2textbox.clear();
			vehicleownedextratextvariable2textbox.sendKeys(vehicleownedextratextvariable);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectVehicleOwnedExtraDateVariable1(String year, String month, String date) {
		try {
			Generics.waitForElement(driver, vehicleownedextradatevariable1textbox);
			vehicleownedextradatevariable1textbox.click();
			Generics.waitForElement(driver, yeardropdown);
			Select years = new Select(yeardropdown);
			years.selectByVisibleText(year);
			Generics.waitForElement(driver, monthdropdown);
			Select months = new Select(monthdropdown);
			months.selectByVisibleText(month);
			for(int i=0;i<datelinks.size();i++) {
				if(datelinks.get(i).getText().equalsIgnoreCase(date)) {
					datelinks.get(i).click();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectVehicleOwnedExtraTextVariable1", true);
		}
	}
	
	public void selectVehicleOwnedExtraDateVariable2(String year, String month, String date) {
		try {
			Generics.waitForElement(driver, vehicleownedextradatevariable2textbox);
			vehicleownedextradatevariable2textbox.click();
			Generics.waitForElement(driver, yeardropdown);
			Select years = new Select(yeardropdown);
			years.selectByVisibleText(year);
			Generics.waitForElement(driver, monthdropdown);
			Select months = new Select(monthdropdown);
			months.selectByVisibleText(month);
			for(int i=0;i<datelinks.size();i++) {
				if(datelinks.get(i).getText().equalsIgnoreCase(date)) {
					datelinks.get(i).click();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectVehicleOwnedExtraTextVariable1", true);
		}
	}
	
	public void clickAddMore() {
		try {
			Generics.waitForElement(driver, addmorebutton);
			addmorebutton.click();
			Generics.waitForElementToInvisible(driver, addmorespinner);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateSavedVehicleDetails(String brandname, String licensenumber, String purchasedate, String vehicleownedextratextvariable1value,
			String vehicleownedextratextvariable2value, String vehicleownedextradatevariable1, String vehicleownedextradatevariable2) {
		try {
			Generics.waitForElement(driver, savedbrandname);
			assertEquals(savedbrandname.getText(), brandname);
			
			Generics.waitForElement(driver, savedlicensenumber);
			assertEquals(savedlicensenumber.getText(), licensenumber);
			
			Generics.waitForElement(driver, savedpurchasedate);
			assertEquals(savedpurchasedate.getText(), purchasedate);
			
			Generics.waitForElement(driver, savedvehicleownedextratextvariable1);
			assertEquals(savedvehicleownedextratextvariable1.getText(), vehicleownedextratextvariable1value);
			
			Generics.waitForElement(driver, savedvehicleownedextratextvariable2);
			assertEquals(savedvehicleownedextratextvariable2.getText(), vehicleownedextratextvariable2value);
			
			Generics.waitForElement(driver, savedvehicleownedextradatevariable1);
			assertEquals(savedvehicleownedextradatevariable1.getText(), vehicleownedextradatevariable1);
			
			Generics.waitForElement(driver, savedvehicleownedextradatevariable2);
			assertEquals(savedvehicleownedextradatevariable2.getText(), vehicleownedextradatevariable2);
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
	
	public void editVehicleDetails(String brandname, String licensenumber, String year, String month, String date, String vehicleownedextratextvariable1,
			String vehicleownedextratextvariable2, String vehicleOwnedExtraDateVariable1year, String vehicleOwnedExtraDateVariable1month,
			String vehicleOwnedExtraDateVariable1date, String vehicleOwnedExtraDateVariable2year, String vehicleOwnedExtraDateVariable2month,
			String vehicleOwnedExtraDateVariable2date) {
		try {
			Generics.waitForElement(driver, updatebrandnametextbox);
			updatebrandnametextbox.click();
			updatebrandnametextbox.clear();
			updatebrandnametextbox.sendKeys(brandname);
			
			Generics.waitForElement(driver, updatelicensenumbertextbox);
			updatelicensenumbertextbox.click();
			updatelicensenumbertextbox.clear();
			updatelicensenumbertextbox.sendKeys(licensenumber);
			
			Generics.waitForElement(driver, updatepurchasedatetextbox);
			updatepurchasedatetextbox.click();
			Generics.waitForElement(driver, yeardropdown);
			Select years = new Select(yeardropdown);
			years.selectByVisibleText(year);
			Generics.waitForElement(driver, monthdropdown);
			Select months = new Select(monthdropdown);
			months.selectByVisibleText(month);
			for(int i=0;i<datelinks.size();i++) {
				if(datelinks.get(i).getText().equalsIgnoreCase(date)) {
					datelinks.get(i).click();
				}
			}
			
			Generics.waitForElement(driver, updatevehicleownedtextvariable1);
			updatevehicleownedtextvariable1.click();
			updatevehicleownedtextvariable1.clear();
			updatevehicleownedtextvariable1.sendKeys(vehicleownedextratextvariable1);
			
			Generics.waitForElement(driver, updatevehicleownedtextvariable2);
			updatevehicleownedtextvariable2.click();
			updatevehicleownedtextvariable2.clear();
			updatevehicleownedtextvariable2.sendKeys(vehicleownedextratextvariable2);
			
			Generics.waitForElement(driver, updatevehicleownedextradatevariable1);
			updatevehicleownedextradatevariable1.click();
			Generics.waitForElement(driver, yeardropdown);
			Select vehicleOwnedExtraDateVariable1Years = new Select(yeardropdown);
			vehicleOwnedExtraDateVariable1Years.selectByVisibleText(vehicleOwnedExtraDateVariable1year);
			Generics.waitForElement(driver, monthdropdown);
			Select vehicleOwnedExtraDateVariable1Months = new Select(monthdropdown);
			vehicleOwnedExtraDateVariable1Months.selectByVisibleText(vehicleOwnedExtraDateVariable1month);
			for(int i=0;i<datelinks.size();i++) {
				if(datelinks.get(i).getText().equalsIgnoreCase(vehicleOwnedExtraDateVariable1date)) {
					datelinks.get(i).click();
				}
			}
			
			Generics.waitForElement(driver, updatevehicleownedextradatevariable2);
			updatevehicleownedextradatevariable2.click();
			Generics.waitForElement(driver, yeardropdown);
			Select vehicleOwnedExtraDateVariable2Years = new Select(yeardropdown);
			vehicleOwnedExtraDateVariable2Years.selectByVisibleText(vehicleOwnedExtraDateVariable2year);
			Generics.waitForElement(driver, monthdropdown);
			Select vehicleOwnedExtraDateVariable2Months = new Select(monthdropdown);
			vehicleOwnedExtraDateVariable2Months.selectByVisibleText(vehicleOwnedExtraDateVariable2month);
			for(int i=0;i<datelinks.size();i++) {
				if(datelinks.get(i).getText().equalsIgnoreCase(vehicleOwnedExtraDateVariable2date)) {
					datelinks.get(i).click();
				}
			}
			
			Generics.waitForElement(driver, updatedonebutton);
			updatedonebutton.click();
			Generics.waitForElement(driver, otherloanupdatenotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickDelete() {
		try {
			Generics.waitForElement(driver, deletebutton);
			deletebutton.click();
			driver.switchTo().alert().accept();
			Generics.waitForElement(driver, otherloandeletenotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickAddAndContinue() {
		try {
			Generics.waitForElement(driver, addandcontinuebutton);
			addandcontinuebutton.click();
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
					assertEquals(true, false);
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
