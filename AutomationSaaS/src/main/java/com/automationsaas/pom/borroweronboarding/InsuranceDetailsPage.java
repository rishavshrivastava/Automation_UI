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

public class InsuranceDetailsPage {

	public WebDriver driver;

	public InsuranceDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1")
	private WebElement insurancedetailsheading;
	
	@FindBy(id="insuranceName")
	private WebElement insurancenametextbox;
	
	@FindBy(id="insuranceAmount")
	private WebElement amounttextbox;
	
	@FindBy(xpath="//input[contains(@id,'startDate')]")
	private WebElement startdatetextbox;
	
	@FindBy(xpath="//input[contains(@id,'endDate')]")
	private WebElement enddatetextbox;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	private WebElement yeardropdown;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	private WebElement monthdropdown;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//a")
	private List<WebElement> datelinks;
	
	@FindBy(id="insuranceType")
	private WebElement typeofinsurancedropdown;
	
	@FindBy(id="insuranceTextVariable1")
	private WebElement insurancetextvariable1textbox;
	
	@FindBy(id="insuranceTextVariable2")
	private WebElement insurancetextvariable2textbox;
	
	@FindBy(id="insuranceTextVariable4")
	private WebElement insurancetextvariable4textbox;
	
	@FindBy(id="insuranceTextVariable5")
	private WebElement insurancetextvariable5textbox;
	
	@FindBy(id="insuranceTextVariable6")
	private WebElement insurancetextvariable6textbox;
	
	@FindBy(id="insuranceTextVariable7")
	private WebElement insurancetextvariable7textbox;
	
	@FindBy(id="insuranceTextVariable8")
	private WebElement insurancetextvariable8textbox;
	
	@FindBy(id="insuranceTextVariable9")
	private WebElement insurancetextvariable9textbox;
	
	@FindBy(id="insuranceTextVariable10")
	private WebElement insurancetextvariable10textbox;
	
	@FindBy(id="createInsuranceAjxBtn")
	private WebElement addmorebutton;
	
	@FindBy(xpath="//div[@id='waitingSpinnerCreateInsurance']//img[@src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']")
	private WebElement addmorespinner;
	
	@FindBy(xpath="//th[.='Insurer Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Insurer Name']/preceding-sibling::th)+1]")
	private WebElement savedinsurancename;
	
	@FindBy(xpath="//th[.='Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Amount']/preceding-sibling::th)+1]")
	private WebElement savedamount;
	
	@FindBy(xpath="//th[.='Start Date']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Start Date']/preceding-sibling::th)+1]")
	private WebElement savedstartdatetext;
	
	@FindBy(xpath="//th[.='End Date']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='End Date']/preceding-sibling::th)+1]")
	private WebElement savedenddatetext;
	
	@FindBy(xpath="//th[.='Type of Insurance']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Type of Insurance']/preceding-sibling::th)+1]")
	private WebElement savedtypeofinsurance;
	
	@FindBy(xpath="//th[.='Insurance Text Variable 1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Insurance Text Variable 1']/preceding-sibling::th)+1]")
	private WebElement savedinsurancetextvariable1;
	
	@FindBy(xpath="//th[.='Insurance Text Variable 2']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Insurance Text Variable 2']/preceding-sibling::th)+1]")
	private WebElement savedinsurancetextvariable2;
	
	@FindBy(xpath="//th[.='Insurance Text Variable 4']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Insurance Text Variable 4']/preceding-sibling::th)+1]")
	private WebElement savedinsurancetextvariable4;
	
	@FindBy(xpath="//th[.='Insurance Text Variable 5']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Insurance Text Variable 5']/preceding-sibling::th)+1]")
	private WebElement savedinsurancetextvariable5;
	
	@FindBy(xpath="//th[.='Insurance Text Variable 6']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Insurance Text Variable 6']/preceding-sibling::th)+1]")
	private WebElement savedinsurancetextvariable6;
	
	@FindBy(xpath="//th[.='Insurance Text Variable 7']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Insurance Text Variable 7']/preceding-sibling::th)+1]")
	private WebElement savedinsurancetextvariable7;
	
	@FindBy(xpath="//th[.='Insurance Text Variable 8']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Insurance Text Variable 8']/preceding-sibling::th)+1]")
	private WebElement savedinsurancetextvariable8;
	
	@FindBy(xpath="//th[.='Insurance Text Variable 9']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Insurance Text Variable 9']/preceding-sibling::th)+1]")
	private WebElement savedinsurancetextvariable9;
	
	@FindBy(xpath="//th[.='Insurance Text Variable 10']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Insurance Text Variable 10']/preceding-sibling::th)+1]")
	private WebElement savedinsurancetextvariable10;
	
	@FindBy(xpath="//div[@id='insurance_list']//button[1]")
	private WebElement editbutton;
	
	@FindBy(xpath="//form[@id='insuranceDetailUpdateForm']//input[@id='insuranceName']")
	private WebElement updateinsurernametextbox;
	
	@FindBy(xpath="//form[@id='insuranceDetailUpdateForm']//input[@id='insuranceAmount']")
	private WebElement updateamounttextbox;
	
	@FindBy(xpath="//form[@id='insuranceDetailUpdateForm']//input[contains(@id,'startDate')]")
	private WebElement updatestartdatetextbox;
	
	@FindBy(xpath="//form[@id='insuranceDetailUpdateForm']//input[contains(@id,'endDate')]")
	private WebElement updateenddatetextbox;
	
	@FindBy(xpath="//form[@id='insuranceDetailUpdateForm']//select[contains(@id,'insuranceType')]")
	private WebElement updatetypeofinsurancedropdown;
	
	@FindBy(xpath="//form[@id='insuranceDetailUpdateForm']//input[@id='insuranceTextVariable1']")
	private WebElement updateinsurancetextvariable1textbox;
	
	@FindBy(xpath="//form[@id='insuranceDetailUpdateForm']//input[@id='insuranceTextVariable2']")
	private WebElement updateinsurancetextvariable2textbox;
	
	@FindBy(xpath="//form[@id='insuranceDetailUpdateForm']//input[@id='insuranceTextVariable4']")
	private WebElement updateinsurancetextvariable4textbox;
	
	@FindBy(xpath="//form[@id='insuranceDetailUpdateForm']//input[@id='insuranceTextVariable5']")
	private WebElement updateinsurancetextvariable5textbox;
	
	@FindBy(xpath="//form[@id='insuranceDetailUpdateForm']//input[@id='insuranceTextVariable6']")
	private WebElement updateinsurancetextvariable6textbox;
	
	@FindBy(xpath="//form[@id='insuranceDetailUpdateForm']//input[@id='insuranceTextVariable7']")
	private WebElement updateinsurancetextvariable7textbox;
	
	@FindBy(xpath="//form[@id='insuranceDetailUpdateForm']//input[@id='insuranceTextVariable8']")
	private WebElement updateinsurancetextvariable8textbox;
	
	@FindBy(xpath="//form[@id='insuranceDetailUpdateForm']//input[@id='insuranceTextVariable9']")
	private WebElement updateinsurancetextvariable9textbox;
	
	@FindBy(xpath="//form[@id='insuranceDetailUpdateForm']//input[@id='insuranceTextVariable10']")
	private WebElement updateinsurancetextvariable10textbox;
	
	@FindBy(xpath="//button[text()='Done']")
	private WebElement updatedonebutton;
	
	@FindBy(xpath="//span[contains(text(),'updated')]")
	private WebElement insurancedetailsupdatenotification;
	
	@FindBy(xpath="//div[@id='insurance_list']//button[2]")
	private WebElement deletebutton;
	
	@FindBy(xpath="//span[contains(text(),'deleted')]")
	private WebElement insurancedetailsdeletenotification;
	
	@FindBy(id="createInsuranceAndContinueBtn")
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
	
	public void validateInsuranceDetailsHeading(String pageheading) {
		try {
			Generics.waitForElement(driver, insurancedetailsheading);
			if (insurancedetailsheading.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("Insurance details is displayed", true);
			} else
				Reporter.log("Insurance details is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateInsuranceDetailsHeading", true);
		}
	}
	
	public void enterInsurerName(String insurername) {
		try {
			Generics.waitForElement(driver, insurancenametextbox);
			insurancenametextbox.click();
			insurancenametextbox.clear();
			insurancenametextbox.sendKeys(insurername);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterAmount(String amount) {
		try {
			Generics.waitForElement(driver, amounttextbox);
			amounttextbox.click();
			amounttextbox.clear();
			amounttextbox.sendKeys(amount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterStartDate(String year, String month, String date) {
		try {
			Generics.waitForElement(driver, startdatetextbox);
			startdatetextbox.click();
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
	
	public void enterEndDate(String year, String month, String date) {
		try {
			Generics.waitForElement(driver, enddatetextbox);
			enddatetextbox.click();
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
	
	public void selectTypeOfInsurance(String typeofinsurance) {
		try {
			Generics.waitForElement(driver, typeofinsurancedropdown);
			Select typeOfInsuranceOptions = new Select(typeofinsurancedropdown);
			typeOfInsuranceOptions.selectByVisibleText(typeofinsurance);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterInsuranceTextVariable1(String insurancetextvariable1) {
		try {
			Generics.waitForElement(driver, insurancetextvariable1textbox);
			insurancetextvariable1textbox.click();
			insurancetextvariable1textbox.clear();
			insurancetextvariable1textbox.sendKeys(insurancetextvariable1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterInsuranceTextVariable2(String insurancetextvariable2) {
		try {
			Generics.waitForElement(driver, insurancetextvariable2textbox);
			insurancetextvariable2textbox.click();
			insurancetextvariable2textbox.clear();
			insurancetextvariable2textbox.sendKeys(insurancetextvariable2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterInsuranceTextVariable4(String insurancetextvariable4) {
		try {
			Generics.waitForElement(driver, insurancetextvariable4textbox);
			insurancetextvariable4textbox.click();
			insurancetextvariable4textbox.clear();
			insurancetextvariable4textbox.sendKeys(insurancetextvariable4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterInsuranceTextVariable5(String insurancetextvariable5) {
		try {
			Generics.waitForElement(driver, insurancetextvariable5textbox);
			insurancetextvariable5textbox.click();
			insurancetextvariable5textbox.clear();
			insurancetextvariable5textbox.sendKeys(insurancetextvariable5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterInsuranceTextVariable6(String insurancetextvariable6) {
		try {
			Generics.waitForElement(driver, insurancetextvariable6textbox);
			insurancetextvariable6textbox.click();
			insurancetextvariable6textbox.clear();
			insurancetextvariable6textbox.sendKeys(insurancetextvariable6);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterInsuranceTextVariable7(String insurancetextvariable7) {
		try {
			Generics.waitForElement(driver, insurancetextvariable7textbox);
			insurancetextvariable7textbox.click();
			insurancetextvariable7textbox.clear();
			insurancetextvariable7textbox.sendKeys(insurancetextvariable7);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterInsuranceTextVariable8(String insurancetextvariable8) {
		try {
			Generics.waitForElement(driver, insurancetextvariable8textbox);
			insurancetextvariable8textbox.click();
			insurancetextvariable8textbox.clear();
			insurancetextvariable8textbox.sendKeys(insurancetextvariable8);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterInsuranceTextVariable9(String insurancetextvariable9) {
		try {
			Generics.waitForElement(driver, insurancetextvariable9textbox);
			insurancetextvariable9textbox.click();
			insurancetextvariable9textbox.clear();
			insurancetextvariable9textbox.sendKeys(insurancetextvariable9);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterInsuranceTextVariable10(String insurancetextvariable10) {
		try {
			Generics.waitForElement(driver, insurancetextvariable10textbox);
			insurancetextvariable10textbox.click();
			insurancetextvariable10textbox.clear();
			insurancetextvariable10textbox.sendKeys(insurancetextvariable10);
		} catch (InterruptedException e) {
			e.printStackTrace();
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
	
	public void validateSavedInsuranceDetails(String insurancename, String amount, String startdate, String enddate, String typeofinsurance,
			String insurancetextvariable1, String insurancetextvariable2, String insurancetextvariable4, String insurancetextvariable5,
			String insurancetextvariable6, String insurancetextvariable7, String insurancetextvariable8, String insurancetextvariable9,
			String insurancetextvariable10) {
		try {
			Generics.waitForElement(driver, savedinsurancename);
			assertEquals(savedinsurancename.getText(), insurancename);
			
			Generics.waitForElement(driver, savedamount);
			assertEquals(savedamount.getText(), amount);
			
			Generics.waitForElement(driver, savedstartdatetext);
			assertEquals(savedstartdatetext.getText(), startdate);
			
			Generics.waitForElement(driver, savedenddatetext);
			assertEquals(savedenddatetext.getText(), enddate);
			
			Generics.waitForElement(driver, savedtypeofinsurance);
			assertEquals(savedtypeofinsurance.getText(), typeofinsurance);
			
			Generics.waitForElement(driver, savedinsurancetextvariable1);
			assertEquals(savedinsurancetextvariable1.getText(), insurancetextvariable1);
			
			Generics.waitForElement(driver, savedinsurancetextvariable2);
			assertEquals(savedinsurancetextvariable2.getText(), insurancetextvariable2);
			
			Generics.waitForElement(driver, savedinsurancetextvariable4);
			assertEquals(savedinsurancetextvariable4.getText(), insurancetextvariable4);
			
			Generics.waitForElement(driver, savedinsurancetextvariable5);
			assertEquals(savedinsurancetextvariable5.getText(), insurancetextvariable5);
			
			Generics.waitForElement(driver, savedinsurancetextvariable6);
			assertEquals(savedinsurancetextvariable6.getText(), insurancetextvariable6);
			
			Generics.waitForElement(driver, savedinsurancetextvariable7);
			assertEquals(savedinsurancetextvariable7.getText(), insurancetextvariable7);
			
			Generics.waitForElement(driver, savedinsurancetextvariable8);
			assertEquals(savedinsurancetextvariable8.getText(), insurancetextvariable8);
			
			Generics.waitForElement(driver, savedinsurancetextvariable9);
			assertEquals(savedinsurancetextvariable9.getText(), insurancetextvariable9);
			
			Generics.waitForElement(driver, savedinsurancetextvariable10);
			assertEquals(savedinsurancetextvariable10.getText(), insurancetextvariable10);
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
	
	public void editInsuranceDetails(String insurancename, String amount, String startyear, String startmonth, String startdate, String endyear, String endmonth,
			String enddate, String typeofinsurance, String insurancetextvariable1, String insurancetextvariable2, String insurancetextvariable4, String insurancetextvariable5,
			String insurancetextvariable6, String insurancetextvariable7, String insurancetextvariable8, String insurancetextvariable9, String insurancetextvariable10) {
		try {
			Generics.waitForElement(driver, updateinsurernametextbox);
			updateinsurernametextbox.click();
			updateinsurernametextbox.clear();
			updateinsurernametextbox.sendKeys(insurancename);
			
			Generics.waitForElement(driver, updateamounttextbox);
			updateamounttextbox.click();
			updateamounttextbox.clear();
			updateamounttextbox.sendKeys(amount);
			
			Generics.waitForElement(driver, updatestartdatetextbox);
			updatestartdatetextbox.click();
			Generics.waitForElement(driver, yeardropdown);
			Select startYears = new Select(yeardropdown);
			startYears.selectByVisibleText(startyear);
			Generics.waitForElement(driver, monthdropdown);
			Select startMonths = new Select(monthdropdown);
			startMonths.selectByVisibleText(startmonth);
			for(int i=0;i<datelinks.size();i++) {
				if(datelinks.get(i).getText().equalsIgnoreCase(startdate)) {
					datelinks.get(i).click();
				}
			}
			
			Generics.waitForElement(driver, updateenddatetextbox);
			updateenddatetextbox.click();
			Generics.waitForElement(driver, yeardropdown);
			Select endYears = new Select(yeardropdown);
			endYears.selectByVisibleText(endyear);
			Generics.waitForElement(driver, monthdropdown);
			Select endMonths = new Select(monthdropdown);
			endMonths.selectByVisibleText(endmonth);
			for(int i=0;i<datelinks.size();i++) {
				if(datelinks.get(i).getText().equalsIgnoreCase(enddate)) {
					datelinks.get(i).click();
				}
			}
			
			Generics.waitForElement(driver, updatetypeofinsurancedropdown);
			Select typeOfInsuranceOptions = new Select(updatetypeofinsurancedropdown);
			typeOfInsuranceOptions.selectByVisibleText(typeofinsurance);
			
			Generics.waitForElement(driver, updateinsurancetextvariable1textbox);
			updateinsurancetextvariable1textbox.click();
			updateinsurancetextvariable1textbox.clear();
			updateinsurancetextvariable1textbox.sendKeys(insurancetextvariable1);
			
			Generics.waitForElement(driver, updateinsurancetextvariable2textbox);
			updateinsurancetextvariable2textbox.click();
			updateinsurancetextvariable2textbox.clear();
			updateinsurancetextvariable2textbox.sendKeys(insurancetextvariable2);
			
			Generics.waitForElement(driver, updateinsurancetextvariable4textbox);
			updateinsurancetextvariable4textbox.click();
			updateinsurancetextvariable4textbox.clear();
			updateinsurancetextvariable4textbox.sendKeys(insurancetextvariable4);
			
			Generics.waitForElement(driver, updateinsurancetextvariable5textbox);
			updateinsurancetextvariable5textbox.click();
			updateinsurancetextvariable5textbox.clear();
			updateinsurancetextvariable5textbox.sendKeys(insurancetextvariable5);
			
			Generics.waitForElement(driver, updateinsurancetextvariable6textbox);
			updateinsurancetextvariable6textbox.click();
			updateinsurancetextvariable6textbox.clear();
			updateinsurancetextvariable6textbox.sendKeys(insurancetextvariable6);
			
			Generics.waitForElement(driver, updateinsurancetextvariable7textbox);
			updateinsurancetextvariable7textbox.click();
			updateinsurancetextvariable7textbox.clear();
			updateinsurancetextvariable7textbox.sendKeys(insurancetextvariable7);
			
			Generics.waitForElement(driver, updateinsurancetextvariable8textbox);
			updateinsurancetextvariable8textbox.click();
			updateinsurancetextvariable8textbox.clear();
			updateinsurancetextvariable8textbox.sendKeys(insurancetextvariable8);
			
			Generics.waitForElement(driver, updateinsurancetextvariable9textbox);
			updateinsurancetextvariable9textbox.click();
			updateinsurancetextvariable9textbox.clear();
			updateinsurancetextvariable9textbox.sendKeys(insurancetextvariable9);
			
			Generics.scrollPage(driver, 500);
			
			Generics.waitForElement(driver, updateinsurancetextvariable10textbox);
			updateinsurancetextvariable10textbox.click();
			updateinsurancetextvariable10textbox.clear();
			updateinsurancetextvariable10textbox.sendKeys(insurancetextvariable10);
			
			Generics.waitForElement(driver, updatedonebutton);
			updatedonebutton.click();
			Generics.waitForElement(driver, insurancedetailsupdatenotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickDelete() {
		try {
			Generics.waitForElement(driver, deletebutton);
			deletebutton.click();
			driver.switchTo().alert().accept();
			Generics.waitForElement(driver, insurancedetailsdeletenotification);
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
