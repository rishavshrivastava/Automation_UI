package com.automationsaas.pom.dsa;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
//import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class BasicDetailPage extends Base {

	public WebDriver driver;

	public BasicDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Basic Detail')]")
	private WebElement basicdetailtab;

	@FindBy(id = "username")
	private WebElement emailaddresstext;

	@FindBy(id = "title")
	private WebElement titledropdown;

	@FindBy(id = "firstName")
	private WebElement firstnametextbox;

	@FindBy(id = "lastName")
	private WebElement lastnametextbox;

	@FindBy(xpath = "//input[contains(@id,'dateOfBirth')]")
	private WebElement dateofbirthtextbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement dateofbirthyeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement dateofbirthmonthdropdown;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private List<WebElement> dateofbirthdatelinks;

	@FindBy(id = "gender")
	private WebElement genderdropdown;

	@FindBy(xpath = "//input[contains(@id,'dsaProfileTextVariable1')]")
	private WebElement dsaprofiletextvariable1textbox;

	@FindBy(xpath = "//input[contains(@id,'dsaProfileDateVariable1')]")
	private WebElement dsaprofiledatevariable1textbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement dsaprofiledatevariable1yeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement dsaprodiledatevariable1monthdropdown;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private List<WebElement> dsaprofiledatevariable1datelinks;

	@FindBy(xpath = "(//b[text()='Address'])[1]/../../following-sibling::div/input[@id='line1']")
	private WebElement personaladdressline1textbox;

	@FindBy(xpath = "(//b[text()='Address'])[1]/../../following-sibling::div/input[@id='line2']")
	private WebElement personaladdressline2textbox;

	@FindBy(xpath = "(//b[text()='Address'])[1]/../../following-sibling::div/input[@id='line3']")
	private WebElement persoanladdressline3textbox;

	@FindBy(id = "subDistrict")
	private WebElement personaladdresssubDistricttextbox;

	@FindBy(id = "district")
	private WebElement personaladdressdistrict;

	// @FindBy(xpath =
	// "(//b[text()='Address'])[1]/../../following-sibling::div/input[@id='state']")
	@FindBy(id = "state")
	private WebElement personaladdressstatetextbox;

	@FindBy(id = "city")
	private WebElement personaladdresscitytextbox;

	@FindBy(id = "country")
	private WebElement personaladdresscountrytextbox;

	@FindBy(xpath = "(//b[text()='Address'])[1]/../../following-sibling::div/input[@id='zipCode']")
	private WebElement personaladdresszipcodetextbox;

	@FindBy(id = "livingSince")
	private WebElement personaladdresslivingsincetextbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement personaladdress_livingsinceyeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement personaladdress_livingsincemonthdropdown;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private List<WebElement> personaladdress_livingsincedatelinks;

	@FindBy(id = "ownershipType")
	private WebElement personaladdressownershiptypetextbox;

	@FindBy(xpath = "(//b[text()='Address'])[2]/../../following-sibling::div/input[@id='addressOneLine1']")
	private WebElement addressoneline1textbox;

	@FindBy(xpath = "(//b[text()='Address'])[2]/../../following-sibling::div/input[@id='addressOneLine2']")
	private WebElement addressoneline2textbox;

	@FindBy(xpath = "(//b[text()='Address'])[2]/../../following-sibling::div/input[@id='addressOneLine3']")
	private WebElement addressoneline3textbox;

	@FindBy(id = "addressOneSubDistrict")
	private WebElement addressonesubdistricttextbox;

	@FindBy(id = "addressOneDistrict")
	private WebElement addressonedistricttextbox;

	// @FindBy(xpath =
	// "(//b[text()='Address'])[2]/../../following-sibling::div/input[@id='addressOneState']")
	@FindBy(id = "addressOneState")
	private WebElement addressonestatetextbox;

	@FindBy(xpath = "(//b[text()='Address'])[2]/../../following-sibling::div/input[@id='addressOneCity']")
	private WebElement addressonecitytextbox;

	@FindBy(id = "addressOneCountry")
	private WebElement addressonecountrytextbox;

	@FindBy(xpath = "(//b[text()='Address'])[2]/../../following-sibling::div/input[@id='addressOneZipCode']")
	private WebElement addressonezipcodetextbox;

	@FindBy(id = "addressOneLivingSince")
	private WebElement addressonelivingsincetextbox;

	@FindBy(id = "addressOneOwnershipType")
	private WebElement addressoneownershiptypetextbox;

	@FindBy(xpath = "(//input[@value='Update'])[1]") //
	private WebElement updatebutton;

	@FindBy(xpath = "//span[text()='DSA Profile Updated']")
	private WebElement updatenotification;

	// IdentityNumbers 1 & 2
	@FindBy(xpath = "//li[@id='basic_profile_tab']//a") // identityNumberOne
	private WebElement basicdetailstablabel;

	@FindBy(xpath = "//input[@id='identityNumberOne']")
	private WebElement identitynumberonetextbox;

	@FindBy(xpath = "//input[@id='identityNumberTwo']")
	private WebElement identitynumbertwotextbox;

	@FindBy(xpath = "//span[text()='DSA Profile Updated']")
	private WebElement dsaDetailsUpdatedNotification; //

	@FindBy(xpath = "//*[@id='basic_detail_dsa']//li")
	private WebElement invalididentitynumbererrormessage;

	public void clickBasicDetail() {
		try {
			Generics.waitForElement(driver, basicdetailtab);
			basicdetailtab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateEmailAddress(String value) {
		try {
			Generics.waitForElement(driver, emailaddresstext);
			assertEquals(emailaddresstext.getAttribute("value"), value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectTitle(String value) {
		try {
			Generics.waitForElement(driver, titledropdown);
			Select titleOptions = new Select(titledropdown);
			titleOptions.selectByVisibleText(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterFirstName(String value) {
		try {
			Generics.waitForElement(driver, firstnametextbox);
			firstnametextbox.click();
			firstnametextbox.clear();
			firstnametextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterLastName(String value) {
		try {
			Generics.waitForElement(driver, lastnametextbox);
			lastnametextbox.click();
			lastnametextbox.clear();
			lastnametextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectDateOfBirth(String yearvalue, String monthvalue, String datevalue) {
		try {
			Generics.waitForElement(driver, dateofbirthtextbox);
			dateofbirthtextbox.click();

			Select yearOptions = new Select(dateofbirthyeardropdown);
			yearOptions.selectByVisibleText(yearvalue);

			Select monthOptions = new Select(dateofbirthmonthdropdown);
			monthOptions.selectByVisibleText(monthvalue);

			for (int i = 0; i < dateofbirthdatelinks.size(); i++) {
				if (dateofbirthdatelinks.get(i).getText().equalsIgnoreCase(datevalue)) {
					Generics.waitForElement(driver, dateofbirthdatelinks.get(i));
					dateofbirthdatelinks.get(i).click();
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectGender(String gendervalue) {
		try {
			Generics.waitForElement(driver, genderdropdown);
			Select genderOptions = new Select(genderdropdown);
			genderOptions.deselectByVisibleText(gendervalue);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterDSAProfileTextVariable1(String value) {
		try {
			Generics.waitForElement(driver, dsaprofiletextvariable1textbox);
			dsaprofiletextvariable1textbox.click();
			dsaprofiletextvariable1textbox.clear();
			dsaprofiletextvariable1textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectDSAProfileDateVariable1(String yearvalue, String monthvalue, String datevalue) {
		try {
			Generics.waitForElement(driver, dsaprofiledatevariable1textbox);
			dsaprofiledatevariable1textbox.click();

			Select yearOptions = new Select(dsaprofiledatevariable1yeardropdown);
			yearOptions.selectByVisibleText(yearvalue);

			Select monthOptions = new Select(dsaprodiledatevariable1monthdropdown);
			monthOptions.selectByVisibleText(monthvalue);

			for (int i = 0; i < dsaprofiledatevariable1datelinks.size(); i++) {
				if (dsaprofiledatevariable1datelinks.get(i).getText().equalsIgnoreCase(datevalue)) {
					Generics.waitForElement(driver, dsaprofiledatevariable1datelinks.get(i));
					dsaprofiledatevariable1datelinks.get(i).click();
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterPersonalAddress(String line1value, String line2value, String line3value, String statevalue,
			String cityvalue, String zipcodevalue) {
		try {
			Generics.waitForElement(driver, personaladdressline1textbox);
			personaladdressline1textbox.click();
			personaladdressline1textbox.clear();
			personaladdressline1textbox.sendKeys(line1value);

			Generics.waitForElement(driver, personaladdressline2textbox);
			personaladdressline2textbox.click();
			personaladdressline2textbox.clear();
			personaladdressline2textbox.sendKeys(line2value);

			Generics.waitForElement(driver, persoanladdressline3textbox);
			persoanladdressline3textbox.click();
			persoanladdressline3textbox.clear();
			persoanladdressline3textbox.sendKeys(line3value);

			Generics.waitForElement(driver, personaladdressstatetextbox);
			personaladdressstatetextbox.click();
			personaladdressstatetextbox.clear();
			personaladdressstatetextbox.sendKeys(statevalue);

			Generics.waitForElement(driver, personaladdresscitytextbox);
			personaladdresscitytextbox.click();
			personaladdresscitytextbox.clear();
			personaladdresscitytextbox.sendKeys(cityvalue);

			Generics.waitForElement(driver, personaladdresszipcodetextbox);
			personaladdresszipcodetextbox.click();
			personaladdresszipcodetextbox.clear();
			personaladdresszipcodetextbox.sendKeys(zipcodevalue);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterAddressOne(String line1value, String line2value, String line3value, String statevalue,
			String cityvalue, String zipcodevalue) {
		try {
			Generics.waitForElement(driver, addressoneline1textbox);
			addressoneline1textbox.click();
			addressoneline1textbox.clear();
			addressoneline1textbox.sendKeys(line1value);

			Generics.waitForElement(driver, addressoneline2textbox);
			addressoneline2textbox.click();
			addressoneline2textbox.clear();
			addressoneline2textbox.sendKeys(line2value);

			Generics.waitForElement(driver, addressoneline3textbox);
			addressoneline3textbox.click();
			addressoneline3textbox.clear();
			addressoneline3textbox.sendKeys(line3value);

			Generics.waitForElement(driver, addressonestatetextbox);
			addressonestatetextbox.click();
			addressonestatetextbox.clear();
			addressonestatetextbox.sendKeys(statevalue);

			Generics.waitForElement(driver, addressonecitytextbox);
			addressonecitytextbox.click();
			addressonecitytextbox.clear();
			addressonecitytextbox.sendKeys(cityvalue);

			Generics.waitForElement(driver, addressonezipcodetextbox);
			addressonezipcodetextbox.click();
			addressonezipcodetextbox.clear();
			addressonezipcodetextbox.sendKeys(zipcodevalue);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickUpdateButton() {
		try {
			Generics.waitForElement(driver, updatebutton);
			updatebutton.click();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateBasicDetail(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, emailaddresstext);
				assertEquals(emailaddresstext.getAttribute("value"), product);
				break;

			case 1:
				Generics.waitForElement(driver, titledropdown);
				Select titleoptions = new Select(titledropdown);
				WebElement title = titleoptions.getFirstSelectedOption();
				assertEquals(title.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, firstnametextbox);
				assertEquals(firstnametextbox.getAttribute("value"), product);
				break;

			case 3:
				Generics.waitForElement(driver, lastnametextbox);
				assertEquals(lastnametextbox.getAttribute("value"), product);
				break;

			case 4:
				Generics.waitForElement(driver, dateofbirthtextbox);
				assertEquals(dateofbirthtextbox.getAttribute("value"), product);
				break;

			case 5:
				Generics.waitForElement(driver, genderdropdown);
				Select genderoptions = new Select(genderdropdown);
				WebElement gender = genderoptions.getFirstSelectedOption();
				assertEquals(gender.getText(), product);
				break;

			case 6:
				Generics.waitForElement(driver, dsaprofiletextvariable1textbox);
				assertEquals(dsaprofiletextvariable1textbox.getAttribute("value"), product);
				break;

			case 7:
				Generics.waitForElement(driver, dsaprofiledatevariable1textbox);
				assertEquals(dsaprofiledatevariable1textbox.getAttribute("value"), product);
				break;

			case 8:
				Generics.waitForElement(driver, personaladdressline1textbox);
				assertEquals(personaladdressline1textbox.getAttribute("value"), product);
				break;

			case 9:
				Generics.waitForElement(driver, personaladdressline2textbox);
				assertEquals(personaladdressline2textbox.getAttribute("value"), product);
				break;

			case 10:
				Generics.waitForElement(driver, persoanladdressline3textbox);
				assertEquals(persoanladdressline3textbox.getAttribute("value"), product);
				break;

			case 11:
				Generics.waitForElement(driver, personaladdresssubDistricttextbox);
				assertEquals(personaladdresssubDistricttextbox.getAttribute("value"), product);
				break;

			case 12:
				Generics.waitForElement(driver, personaladdressdistrict);
				assertEquals(personaladdressdistrict.getAttribute("value"), product);
				break;

			case 13:
				Generics.waitForElement(driver, personaladdressstatetextbox);
				Select state = new Select(personaladdressstatetextbox);
				WebElement personaladdressstate = state.getFirstSelectedOption();
				assertEquals(personaladdressstate.getText(), product);
				break;

			case 14:
				Generics.waitForElement(driver, personaladdresscitytextbox);
				assertEquals(personaladdresscitytextbox.getAttribute("value"), product);
				break;

			case 15:
				Generics.waitForElement(driver, personaladdresscountrytextbox);
				assertEquals(personaladdresscountrytextbox.getAttribute("value"), product);
				break;

			case 16:
				Generics.waitForElement(driver, personaladdresszipcodetextbox);
				assertEquals(personaladdresszipcodetextbox.getAttribute("value"), product);
				break;
			case 17:
				Generics.waitForElement(driver, personaladdresslivingsincetextbox);
				assertEquals(personaladdresslivingsincetextbox.getAttribute("value"), product);
				break;
			case 18:
				Generics.waitForElement(driver, personaladdressownershiptypetextbox);
				Generics.waitForElement(driver, personaladdressownershiptypetextbox);
				Select ownershiptype = new Select(personaladdressownershiptypetextbox);
				WebElement personaladdressownership = ownershiptype.getFirstSelectedOption();
				assertEquals(personaladdressownership.getText(), product);
				break;

			case 19:
				Generics.waitForElement(driver, addressoneline1textbox);
				assertEquals(addressoneline1textbox.getAttribute("value"), product);
				break;

			case 20:
				Generics.waitForElement(driver, addressoneline2textbox);
				assertEquals(addressoneline2textbox.getAttribute("value"), product);
				break;

			case 21:
				Generics.waitForElement(driver, addressoneline3textbox);
				assertEquals(addressoneline3textbox.getAttribute("value"), product);
				break;

			case 22:
				Generics.waitForElement(driver, addressonesubdistricttextbox);
				assertEquals(addressonesubdistricttextbox.getAttribute("value"), product);
				break;

			case 23:
				Generics.waitForElement(driver, addressonedistricttextbox);
				assertEquals(addressonedistricttextbox.getAttribute("value"), product);
				break;

			case 24:
				Generics.waitForElement(driver, addressonestatetextbox);
				Select state1 = new Select(addressonestatetextbox);
				WebElement addressonestate = state1.getFirstSelectedOption();
				assertEquals(addressonestate.getText(), product);
				break;

			case 25:
				Generics.waitForElement(driver, addressonecitytextbox);
				assertEquals(addressonecitytextbox.getAttribute("value"), product);
				break;

			case 26:
				Generics.waitForElement(driver, addressonecountrytextbox);
				assertEquals(addressonecountrytextbox.getAttribute("value"), product);
				break;

			case 27:
				Generics.waitForElement(driver, addressonezipcodetextbox);
				assertEquals(addressonezipcodetextbox.getAttribute("value"), product);
				break;
			case 28:
				Generics.waitForElement(driver, addressonelivingsincetextbox);
				assertEquals(addressonelivingsincetextbox.getAttribute("value"), product);
				break;

			case 29:
				Generics.waitForElement(driver, addressoneownershiptypetextbox);
				assertEquals(addressoneownershiptypetextbox.getAttribute("value"), product);
				break;

			case 30:
				Generics.waitForElement(driver, identitynumberonetextbox);
				// String value=identitynumberonetextbox.getText();
				System.out.println(identitynumberonetextbox.getAttribute("value"));
				// System.out.println(product);
				boolean startsWith = identitynumberonetextbox.getAttribute("value").startsWith("xxxxxxxx");
				boolean endsWith = identitynumberonetextbox.getAttribute("value").endsWith(product);

				assertEquals(startsWith, true, "Identity Number One does not starts with prefix 'xxxxxxxx' masking");
				assertEquals(endsWith, true, "Last 4 digits of Identity Number One is not matching.");
				// assertEquals(addressonezipcodetextbox.getAttribute("value"), product);
				break;

			case 31:
				Generics.waitForElement(driver, identitynumbertwotextbox);
				String value2 = identitynumbertwotextbox.getAttribute("value");
				boolean startsWith2 = value2.startsWith("xxxxxx");
				boolean endsWith2 = value2.endsWith(product);
				assertEquals(true, startsWith2, "Identity Number Two does not starts with prefix 'xxxxxx' masking");
				assertEquals(true, endsWith2, "Last 4 digits of Identity Number Two is not matching.");
				// assertEquals(addressonezipcodetextbox.getAttribute("value"), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void editBasicDetails(int i, String product, String yearvalue, String monthvalue, String datevalue) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, titledropdown);
				Select title = new Select(titledropdown);
				title.selectByValue(product);
				// title.selectByVisibleText(product);
				break;

			case 1:
				Generics.waitForElement(driver, firstnametextbox);
				firstnametextbox.click();
				firstnametextbox.clear();
				firstnametextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, lastnametextbox);
				lastnametextbox.click();
				lastnametextbox.clear();
				lastnametextbox.sendKeys(product);
				break;

			case 3:
				Generics.waitForElement(driver, dateofbirthtextbox);
				dateofbirthtextbox.click();

				Generics.waitForElement(driver, dateofbirthyeardropdown);
				Select year = new Select(dateofbirthyeardropdown);
				year.selectByVisibleText(yearvalue);

				Generics.waitForElement(driver, dateofbirthmonthdropdown);
				Select month = new Select(dateofbirthmonthdropdown);
				month.selectByVisibleText(monthvalue);

				Generics.waitForElement(driver, dateofbirthdatelinks.get(0));
				for (int j = 0; j < dateofbirthdatelinks.size(); j++) {
					if (dateofbirthdatelinks.get(j).getText().equalsIgnoreCase(datevalue)) {
						dateofbirthdatelinks.get(j).click();
					}
				}
				break;

			case 4:
				Generics.waitForElement(driver, genderdropdown);
				Select gender = new Select(genderdropdown);
				gender.selectByVisibleText(product);
				break;

			case 5:
				Generics.waitForElement(driver, dsaprofiletextvariable1textbox);
				dsaprofiletextvariable1textbox.click();
				dsaprofiletextvariable1textbox.clear();
				dsaprofiletextvariable1textbox.sendKeys(product);
				break;

			case 6:
				Generics.waitForElement(driver, personaladdressline1textbox);
				personaladdressline1textbox.click();
				personaladdressline1textbox.clear();
				personaladdressline1textbox.sendKeys(product);
				break;

			case 7:
				Generics.waitForElement(driver, personaladdressline2textbox);
				personaladdressline2textbox.click();
				personaladdressline2textbox.clear();
				personaladdressline2textbox.sendKeys(product);
				break;

			case 8:
				Generics.waitForElement(driver, persoanladdressline3textbox);
				persoanladdressline3textbox.click();
				persoanladdressline3textbox.clear();
				persoanladdressline3textbox.sendKeys(product);
				break;

			case 9:
				Generics.waitForElement(driver, personaladdressstatetextbox);
				Select stateOptions = new Select(personaladdressstatetextbox);
				stateOptions.selectByVisibleText(product);
				break;

			case 10:
				Generics.waitForElement(driver, personaladdresscitytextbox);
				personaladdresscitytextbox.click();
				personaladdresscitytextbox.clear();
				personaladdresscitytextbox.sendKeys(product);
				break;

			case 11:
				Generics.waitForElement(driver, personaladdresszipcodetextbox);
				personaladdresszipcodetextbox.click();
				personaladdresszipcodetextbox.clear();
				personaladdresszipcodetextbox.sendKeys(product);
				break;

			case 12:
				Generics.waitForElement(driver, addressoneline1textbox);
				addressoneline1textbox.click();
				addressoneline1textbox.clear();
				addressoneline1textbox.sendKeys(product);
				break;

			case 13:
				Generics.waitForElement(driver, addressoneline2textbox);
				addressoneline2textbox.click();
				addressoneline2textbox.clear();
				addressoneline2textbox.sendKeys(product);
				break;

			case 14:
				Generics.waitForElement(driver, addressoneline3textbox);
				addressoneline3textbox.click();
				addressoneline3textbox.clear();
				addressoneline3textbox.sendKeys(product);
				break;

			case 15:
				Generics.waitForElement(driver, addressonestatetextbox);
				Select stateOptions1 = new Select(addressonestatetextbox);
				stateOptions1.selectByVisibleText(product);
				break;

			case 16:
				Generics.waitForElement(driver, addressonecitytextbox);
				addressonecitytextbox.click();
				addressonecitytextbox.clear();
				addressonecitytextbox.sendKeys(product);
				break;

			case 17:
				Generics.waitForElement(driver, addressonezipcodetextbox);
				addressonezipcodetextbox.click();
				addressonezipcodetextbox.clear();
				addressonezipcodetextbox.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickBasicDetailsUpdate() {
		try {
			Generics.waitForElement(driver, updatebutton);
			updatebutton.click();
			Generics.waitForElement(driver, updatenotification);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void checkIfBasicDetailsAreDisabled(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, titledropdown);
				assertEquals(titledropdown.getAttribute("disabled"), product);
				break;

			case 1:
				Generics.waitForElement(driver, firstnametextbox);
				assertEquals(firstnametextbox.getAttribute("disabled"), product);
				break;

			case 2:
				Generics.waitForElement(driver, lastnametextbox);
				assertEquals(lastnametextbox.getAttribute("disabled"), product);
				break;

			case 3:
				Generics.waitForElement(driver, dateofbirthtextbox);
				assertEquals(dateofbirthtextbox.getAttribute("disabled"), product);
				break;

			case 4:
				Generics.waitForElement(driver, genderdropdown);
				assertEquals(genderdropdown.getAttribute("disabled"), product);
				break;

			case 5:
				Generics.waitForElement(driver, dsaprofiletextvariable1textbox);
				assertEquals(dsaprofiletextvariable1textbox.getAttribute("disabled"), product);
				break;

			case 6:
				Generics.waitForElement(driver, personaladdressline1textbox);
				assertEquals(personaladdressline1textbox.getAttribute("disabled"), product);
				break;

			case 7:
				Generics.waitForElement(driver, personaladdressline2textbox);
				assertEquals(personaladdressline2textbox.getAttribute("disabled"), product);
				break;

			case 8:
				Generics.waitForElement(driver, persoanladdressline3textbox);
				assertEquals(persoanladdressline3textbox.getAttribute("disabled"), product);
				break;

			case 9:
				Generics.waitForElement(driver, personaladdressstatetextbox);
				assertEquals(personaladdressstatetextbox.getAttribute("disabled"), product);
				break;

			case 10:
				Generics.waitForElement(driver, personaladdresscitytextbox);
				assertEquals(personaladdresscitytextbox.getAttribute("disabled"), product);
				break;

			case 11:
				Generics.waitForElement(driver, personaladdresszipcodetextbox);
				assertEquals(personaladdresszipcodetextbox.getAttribute("disabled"), product);
				break;

			case 12:
				Generics.waitForElement(driver, addressoneline1textbox);
				assertEquals(addressoneline1textbox.getAttribute("disabled"), product);
				break;

			case 13:
				Generics.waitForElement(driver, addressoneline2textbox);
				assertEquals(addressoneline2textbox.getAttribute("disabled"), product);
				break;

			case 14:
				Generics.waitForElement(driver, addressoneline3textbox);
				assertEquals(addressoneline3textbox.getAttribute("disabled"), product);
				break;

			case 15:
				Generics.waitForElement(driver, addressonestatetextbox);
				assertEquals(addressonestatetextbox.getAttribute("disabled"), product);
				break;

			case 16:
				Generics.waitForElement(driver, addressonecitytextbox);
				assertEquals(addressonecitytextbox.getAttribute("disabled"), product);
				break;

			case 17:
				Generics.waitForElement(driver, addressonezipcodetextbox);
				assertEquals(addressonezipcodetextbox.getAttribute("disabled"), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// cmy- id 1-valid case
	public void validateDSAIdentityNumbersValidCase(String regexpattern, String identitynumber) {
		try {
			Generics.waitForElement(driver, basicdetailstablabel);
			Generics generics = new Generics();
			assertTrue(generics.validateregexpattern(regexpattern, identitynumber),
					"Invalid value for the regex pattern configured");
			identitynumberonetextbox.click();
			identitynumberonetextbox.clear();
			identitynumberonetextbox.sendKeys(identitynumber);
			Generics.waitForElement(driver, updatebutton);
			updatebutton.click();
			Generics.waitForElement(driver, dsaDetailsUpdatedNotification);
			assertEquals(dsaDetailsUpdatedNotification.getText(), "DSA Profile Updated",
					"Unable to update the DSA basic details with the valid IdenityNumberOne");

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	//// cmy- id 1-invalid case
	public void validateDSAIdentityNumbersInValidCase(String regexpattern, String identitynumber) {
		try {
			Generics.waitForElement(driver, basicdetailstablabel);
			Generics generics = new Generics();
			assertFalse(generics.validateregexpattern(regexpattern, identitynumber),
					"Regex pattern is accepting the invalid identity Number");
			identitynumberonetextbox.click();
			identitynumberonetextbox.clear();
			identitynumberonetextbox.sendKeys(identitynumber);
			Generics.waitForElement(driver, updatebutton);
			updatebutton.click();
			Generics.waitForElement(driver, invalididentitynumbererrormessage);
			assertEquals(invalididentitynumbererrormessage.getText().trim(),
					"Identity number one should follow ^[0-9]{12}$ regex pattern");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	// cmy- id 2-valid case
	public void validateDSAIdentityNumberTwoValidCase(String regexpattern, String identitynumber) {
		try {
			Generics.refreshPage(driver);
			Generics.waitForElement(driver, basicdetailstablabel);
			Generics generics = new Generics();
			assertTrue(generics.validateregexpattern(regexpattern, identitynumber),
					"Invalid value(Idenitity Number Two) for the regex pattern configured");
			identitynumbertwotextbox.click();
			identitynumbertwotextbox.clear();
			identitynumbertwotextbox.sendKeys(identitynumber);
			Generics.waitForElement(driver, updatebutton);
			updatebutton.click();
			Generics.waitForElement(driver, dsaDetailsUpdatedNotification);
			assertEquals(dsaDetailsUpdatedNotification.getText(), "DSA Profile Updated",
					"Unable to update the DSA basic details with the valid IdenityNumberOne");

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	//// cmy- id 2-invalid case
	public void validateDSAIdentityNumberTwoInValidCase(String regexpattern, String identitynumber) {
		try {
			Generics.refreshPage(driver);
			Generics.waitForElement(driver, basicdetailstablabel);
			Generics generics = new Generics();
			assertFalse(generics.validateregexpattern(regexpattern, identitynumber),
					"Regex pattern is accepting the invalid identity Number");
			identitynumbertwotextbox.click();
			identitynumbertwotextbox.clear();
			identitynumbertwotextbox.sendKeys(identitynumber);
			Generics.waitForElement(driver, updatebutton);
			updatebutton.click();
			Generics.waitForElement(driver, invalididentitynumbererrormessage);
			assertEquals(invalididentitynumbererrormessage.getText().trim(),
					"Identity number two should follow ^[A-Z]{5}[0-9]{4}[A-Z]{1}$ regex pattern");

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void validateDSAIdentityNumberOneFromtextbox(String identitynumber) {
		try {
			Generics.waitForElement(driver, basicdetailstablabel);
			assertEquals(identitynumberonetextbox.getText(), identitynumber,
					"After Refreshing the Basic details page, Identity Number One is not same as updated");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void validateDSAIdentityNumberTwoFromtextbox(String identitynumber) {
		try {
			Generics.waitForElement(driver, basicdetailstablabel);
			assertEquals(identitynumbertwotextbox.getText(), identitynumber,
					"After Refreshing the Basic details page, Identity Number Two is not same as updated");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editPersonalAddress(int i, String product, String year, String month, String date) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, personaladdressline1textbox);
				personaladdressline1textbox.click();
				personaladdressline1textbox.clear();
				personaladdressline1textbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, personaladdressline2textbox);
				personaladdressline2textbox.click();
				personaladdressline2textbox.clear();
				personaladdressline2textbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, persoanladdressline3textbox);
				persoanladdressline3textbox.click();
				persoanladdressline3textbox.clear();
				persoanladdressline3textbox.sendKeys(product);
				break;

			case 3:
				Generics.waitForElement(driver, personaladdresssubDistricttextbox);
				personaladdresssubDistricttextbox.click();
				personaladdresssubDistricttextbox.clear();
				personaladdresssubDistricttextbox.sendKeys(product);
				break;

			case 4:
				Generics.waitForElement(driver, personaladdressdistrict);
				personaladdressdistrict.click();
				personaladdressdistrict.clear();
				personaladdressdistrict.sendKeys(product);
				break;

			case 5:
				Generics.waitForElement(driver, personaladdressstatetextbox);
				personaladdressstatetextbox.click();
				Select states = new Select(personaladdressstatetextbox);
				states.selectByVisibleText(product);
				break;

			case 6:
				Generics.waitForElement(driver, personaladdresscitytextbox);
				personaladdresscitytextbox.click();
				personaladdresscitytextbox.clear();
				personaladdresscitytextbox.sendKeys(product);
				break;

			case 7:
				Generics.waitForElement(driver, personaladdresscountrytextbox);
				personaladdresscountrytextbox.click();
				personaladdresscountrytextbox.clear();
				personaladdresscountrytextbox.sendKeys(product);
				break;

			case 8:
				Generics.waitForElement(driver, personaladdresszipcodetextbox);
				personaladdresszipcodetextbox.click();
				personaladdresszipcodetextbox.clear();
				personaladdresszipcodetextbox.sendKeys(product);
				break;

			case 9:
				Generics.waitForElement(driver, personaladdresslivingsincetextbox);
				personaladdresslivingsincetextbox.click();
				Generics.waitForElement(driver, personaladdress_livingsinceyeardropdown);
				Select years = new Select(personaladdress_livingsinceyeardropdown);
				years.selectByVisibleText(year);
				Generics.waitForElement(driver, personaladdress_livingsincemonthdropdown);
				Select months = new Select(personaladdress_livingsincemonthdropdown);
				months.selectByVisibleText(month);
				for (int j = 0; j < personaladdress_livingsincedatelinks.size(); j++) {
					if (personaladdress_livingsincedatelinks.get(j).getText().equalsIgnoreCase(date)) {
						personaladdress_livingsincedatelinks.get(j).click();
					}
				}
				break;
				
			case 10:
				Generics.waitForElement(driver, personaladdressownershiptypetextbox);
				Select ownershiptype = new Select(personaladdressownershiptypetextbox);
				ownershiptype.selectByVisibleText(product);
				break;

			default:
				Reporter.log("No value found", true);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
