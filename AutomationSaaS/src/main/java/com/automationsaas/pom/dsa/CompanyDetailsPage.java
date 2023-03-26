package com.automationsaas.pom.dsa;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
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

public class CompanyDetailsPage extends Base {

	public WebDriver driver;

	public CompanyDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Company Details')]")
	private WebElement companydetailstab;
	
	//@FindBy(xpath="//b[text()='Company Name']/../following-sibling::input[@id='name']")
	@FindBy(xpath="//form[@id='companyDetailDsa']//following-sibling::div//input[@id='name']")
	
	private WebElement companynametextbox;
	
	@FindBy(id="registrationCode")
	private WebElement registrationcodetextbox;
	
	@FindBy(id="dsaCompanyTextVariable1")
	private WebElement dsacompanytextvariable1textbox;
	
	@FindBy(xpath="//input[contains(@id,'dsaCompanyDateVariable1')]")
	private WebElement dsacompanydatevariable1textbox;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	private WebElement dsacompanydatevariable1_yeardropdown;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	private WebElement dsacompanydatevariable1_monthdropdown;
	
	@FindBy(xpath="//a[contains(@class,'ui-state-default')]")
	private List<WebElement> dsacompanydatevariable1_datelinks;
	
	@FindBy(xpath="//form[@id='companyDetailDsa']//input[@id='line1']")
	private WebElement line1textbox;
	
	@FindBy(xpath="//form[@id='companyDetailDsa']//input[@id='line2']")
	private WebElement line2textbox;
	
	@FindBy(xpath="//form[@id='companyDetailDsa']//input[@id='line3']")
	private WebElement line3textbox;
	
	
	
	@FindBy(xpath="//form[@id='companyDetailDsa']//select[@id='state']")
	private WebElement statetextbox;
	
	@FindBy(xpath="//form[@id='companyDetailDsa']//input[@id='city']")
	private WebElement citytextbox;
	
	@FindBy(xpath="//form[@id='companyDetailDsa']//input[@id='zipCode']")
	private WebElement zipcodetextbox;
	
	@FindBy(xpath="//input[@id='updateDSACompanyDetailButton']")
	private WebElement updatebutton;
	
	//IdentityNumbers 1 & 2
//	@FindBy(xpath="//li[@id='basic_profile_tab']//a") //identityNumberOne
//	private WebElement basicdetailstablabel;
	
	@FindBy(id="companyIdentityNumberOne")
	private WebElement identitynumberonetextbox;
	
	@FindBy(id="companyIdentityNumberTwo")
	private WebElement identitynumbertwotextbox;
	
	@FindBy(xpath="//span[text()='DSA Profile Updated']")
	private WebElement dsaDetailsUpdatedNotification; //
	
	@FindBy(xpath="//*[@id='companyDetailDsa']//li")
	private WebElement invalididentitynumbererrormessage;
	
	@FindBy(xpath = "//span[text()='DSA Profile Updated']")
	private WebElement updatenotification;
	
	public void clickCompanyDetails() {
		try {
			Generics.waitForElement(driver, companydetailstab);
			companydetailstab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateCompanyDetails(int i, String product) {
			try {
				switch (i) {
				case 0:
					Generics.waitForElement(driver, companynametextbox);
					assertEquals(companynametextbox.getAttribute("value"), product);
					break;

				case 1:
					Generics.waitForElement(driver, registrationcodetextbox);
					assertEquals(registrationcodetextbox.getAttribute("value"), product);
					break;

				case 2:
					Generics.waitForElement(driver, dsacompanytextvariable1textbox);
					assertEquals(dsacompanytextvariable1textbox.getAttribute("value"), product);
					break;
					
				case 3:
					Generics.waitForElement(driver, dsacompanydatevariable1textbox);
					assertEquals(dsacompanydatevariable1textbox.getAttribute("value"), product);
					break;
					
				case 4:
					Generics.waitForElement(driver, line1textbox);
					assertEquals(line1textbox.getAttribute("value"), product);
					break;
					
				case 5:
					Generics.waitForElement(driver, line2textbox);
					assertEquals(line2textbox.getAttribute("value"), product);
					break;
					
				case 6:
					Generics.waitForElement(driver, line3textbox);
					assertEquals(line3textbox.getAttribute("value"), product);
					break;
					
				case 7:
					Generics.waitForElement(driver, statetextbox);
					Select state= new Select(statetextbox);
					WebElement addressstate= state.getFirstSelectedOption();
					assertEquals(addressstate.getText(), product);
					break;
					
				case 8:
					Generics.waitForElement(driver, citytextbox);
					assertEquals(citytextbox.getAttribute("value"), product);
					break;
					
				case 9:
					Generics.waitForElement(driver, zipcodetextbox);
					assertEquals(zipcodetextbox.getAttribute("value"), product);
					break;
					
				case 10:
					Generics.waitForElement(driver, identitynumberonetextbox);
					//String value=identitynumberonetextbox.getText();
					System.out.println(identitynumberonetextbox.getAttribute("value"));
					//System.out.println(product);
					boolean startsWith=identitynumberonetextbox.getAttribute("value").startsWith("xxxxxxxx");
					boolean endsWith=identitynumberonetextbox.getAttribute("value").endsWith(product);
					
					assertEquals(startsWith, true,"Identity Number One does not starts with prefix 'xxxxxxxx' masking");
					assertEquals(endsWith, true, "Last 4 digits of Identity Number One is not matching.");
					//assertEquals(addressonezipcodetextbox.getAttribute("value"), product);
					break;
					
				case 11:
					Generics.waitForElement(driver, identitynumbertwotextbox);
					String value2=identitynumbertwotextbox.getAttribute("value");
					boolean startsWith2=value2.startsWith("xxxxxx");
					boolean endsWith2=value2.endsWith(product);
					assertEquals(startsWith2, true, "Identity Number Two does not starts with prefix 'xxxxxx' masking");
					assertEquals(endsWith2, true, "Last 4 digits of Identity Number Two is not matching.");
					break;
					
				default:
					Reporter.log("No value found", true);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	public void editCompanyDetails(int i, String product, String yearvalue, String monthvalue, String datevalue) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, companynametextbox);
				companynametextbox.click();
				companynametextbox.clear();
				companynametextbox.sendKeys(product);
				break;
				
			case 1:
				Generics.waitForElement(driver, registrationcodetextbox);
				registrationcodetextbox.click();
				registrationcodetextbox.clear();
				registrationcodetextbox.sendKeys(product);
				break;
				
			case 2:
				Generics.waitForElement(driver, dsacompanytextvariable1textbox);
				dsacompanytextvariable1textbox.click();
				dsacompanytextvariable1textbox.clear();
				dsacompanytextvariable1textbox.sendKeys(product);
				break;
				
			case 3:
				Generics.waitForElement(driver, dsacompanydatevariable1textbox);
				dsacompanydatevariable1textbox.click();
				
				Generics.waitForElement(driver, dsacompanydatevariable1_yeardropdown);
				Select year = new Select(dsacompanydatevariable1_yeardropdown);
				year.selectByVisibleText(yearvalue);
				
				Generics.waitForElement(driver, dsacompanydatevariable1_monthdropdown);
				Select month = new Select(dsacompanydatevariable1_monthdropdown);
				month.selectByVisibleText(monthvalue);
				
				Generics.waitForElement(driver, dsacompanydatevariable1_datelinks.get(0));
				for(int j=0;j<dsacompanydatevariable1_datelinks.size();j++) {
					if(dsacompanydatevariable1_datelinks.get(j).getText().equalsIgnoreCase(datevalue)) {
						dsacompanydatevariable1_datelinks.get(j).click();
					}
				}
				break;
				
			case 4:
				Generics.waitForElement(driver, line1textbox);
				line1textbox.click();
				line1textbox.clear();
				line1textbox.sendKeys(product);
				break;
				
			case 5:
				Generics.waitForElement(driver, line2textbox);
				line2textbox.click();
				line2textbox.clear();
				line2textbox.sendKeys(product);
				break;
				
				
			case 6:
				
				Generics.waitForElement(driver, line3textbox);
				line3textbox.click();
				line3textbox.clear();
				line3textbox.sendKeys(product);
				break;
				
			case 7:
				Generics.waitForElement(driver, statetextbox);
				Select state= new Select(statetextbox);
				state.selectByVisibleText(product);
				break;
				
			case 8:
				Generics.waitForElement(driver, citytextbox);
				citytextbox.click();
				citytextbox.clear();
				citytextbox.sendKeys(product);
				break;
				
			case 9:
				Generics.waitForElement(driver, zipcodetextbox);
				zipcodetextbox.click();
				zipcodetextbox.clear();
				zipcodetextbox.sendKeys(product);
				break;
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
public void clickCompanyDetailsUpdateButton() {
	try {
		Generics.waitForElement(driver, updatebutton);
		updatebutton.click();
		Generics.waitForElement(driver, updatenotification);}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
}

public void checkIfCompanyDetailsAreDisabled(int i, String product) {
	try {
		switch (i) {
		case 0:
			Generics.waitForElement(driver, companynametextbox);
			assertEquals(companynametextbox.getAttribute("disabled"), product);
			break;
		
		case 1:
			Generics.waitForElement(driver, registrationcodetextbox);
			assertEquals(registrationcodetextbox.getAttribute("disabled"), product);
			break;
			
		case 2:
			Generics.waitForElement(driver, dsacompanytextvariable1textbox);
			assertEquals(dsacompanytextvariable1textbox.getAttribute("disabled"), product);
			break;
			
		case 3:
			Generics.waitForElement(driver, dsacompanydatevariable1textbox);
			assertEquals(dsacompanydatevariable1textbox.getAttribute("disabled"), product);
			break;
	
		case 4:
			Generics.waitForElement(driver, line1textbox);
			assertEquals(line1textbox.getAttribute("disabled"), product);
			break;
			
		case 5:
			Generics.waitForElement(driver, line2textbox);
			assertEquals(line2textbox.getAttribute("disabled"), product);
			break;
			
		case 6:
			Generics.waitForElement(driver, line3textbox);
			assertEquals(line3textbox.getAttribute("disabled"), product);
			break;
			
		case 7:
			Generics.waitForElement(driver, statetextbox);
			assertEquals(statetextbox.getAttribute("disabled"), product);
			break;
			
		case 8:
			Generics.waitForElement(driver, citytextbox);
			assertEquals(citytextbox.getAttribute("disabled"), product);
			break;
			
		case 9:
			Generics.waitForElement(driver, zipcodetextbox);
			assertEquals(zipcodetextbox.getAttribute("disabled"), product);
			break;
			
		default:
			Reporter.log("No value found", true);
		}
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
}

//cmy- id 1-valid case
	public void validateDSAIdentityNumbersValidCase(String regexpattern,String identitynumber) {
		try {
			Generics.refreshPage(driver);
			clickCompanyDetails();
			Generics.waitForElement(driver, companydetailstab);
			Generics generics=new Generics();
			assertTrue(generics.validateregexpattern(regexpattern,identitynumber),"Invalid value for the regex pattern configured");
			identitynumberonetextbox.click();
			identitynumberonetextbox.clear();
			identitynumberonetextbox.sendKeys(identitynumber);
			Generics.waitForElement(driver, updatebutton);
			updatebutton.click();
			Generics.waitForElement(driver, dsaDetailsUpdatedNotification);
			assertEquals(dsaDetailsUpdatedNotification.getText(), "DSA Profile Updated", "Unable to update the DSA basic details with the valid IdenityNumberOne");

		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}
	
	////cmy- id 1-invalid case
	public void validateDSAIdentityNumbersInValidCase(String regexpattern,String identitynumber) {
		try {
			Generics.refreshPage(driver);
			clickCompanyDetails();
			Generics.waitForElement(driver, companydetailstab);
			Generics generics=new Generics();
			//assert.assertFalse(condition, message);
			assertFalse(generics.validateregexpattern(regexpattern,identitynumber),"Regex pattern is accepting the invalid identity Number");
			identitynumberonetextbox.click();
			identitynumberonetextbox.clear();
			identitynumberonetextbox.sendKeys(identitynumber);
			Generics.waitForElement(driver, updatebutton);
			updatebutton.click();
			//identitynumbertwotextbox.click();//test
			//Generics.waitForFewSecondstoLoad(10000);
			Generics.waitForElement(driver, invalididentitynumbererrormessage);
			assertEquals(invalididentitynumbererrormessage.getText().trim(), "Identity number one should follow ^[0-9]{12}$ regex pattern");
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}
	
	//cmy- id 2-valid case
	public void validateDSAIdentityNumberTwoValidCase(String regexpattern,String identitynumber) {
		try {
			Generics.refreshPage(driver);
			clickCompanyDetails();
			Generics.waitForElement(driver, companydetailstab);
			Generics generics=new Generics();
			assertTrue(generics.validateregexpattern(regexpattern,identitynumber),"Invalid value(Idenitity Number Two) for the regex pattern configured");
			identitynumbertwotextbox.click();
			identitynumbertwotextbox.clear();
			identitynumbertwotextbox.sendKeys(identitynumber);
			Generics.waitForElement(driver, updatebutton);
			updatebutton.click();
			Generics.waitForElement(driver, dsaDetailsUpdatedNotification);
			assertEquals(dsaDetailsUpdatedNotification.getText(), "DSA Profile Updated", "Unable to update the DSA basic details with the valid IdenityNumberOne");

		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}
	
	////cmy- id 2-invalid case
	public void validateDSAIdentityNumberTwoInValidCase(String regexpattern,String identitynumber) {
		try {
			Generics.refreshPage(driver);
			clickCompanyDetails();
			Generics.waitForElement(driver, companydetailstab);
			Generics generics=new Generics();
			//assert.assertFalse(condition, message);
			assertFalse(generics.validateregexpattern(regexpattern,identitynumber),"Regex pattern is accepting the invalid identity Number");
			identitynumbertwotextbox.click();
			identitynumbertwotextbox.clear();
			identitynumbertwotextbox.sendKeys(identitynumber);
			Generics.waitForElement(driver, updatebutton);
			updatebutton.click();
			Generics.waitForElement(driver, invalididentitynumbererrormessage);
			assertEquals(invalididentitynumbererrormessage.getText().trim(), "Identity number two should follow ^[A-Z]{5}[0-9]{4}[A-Z]{1}$ regex pattern");

		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}
	
	public void validateDSAIdentityNumberOneFromtextbox(String identitynumber) {
			try {
				Generics.waitForElement(driver, companydetailstab);
				assertEquals(identitynumberonetextbox.getText(), identitynumber,"Company details page, Identity Number One is not same as updated");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void validateDSAIdentityNumberTwoFromtextbox(String identitynumber) {
		try {
			Generics.waitForElement(driver, companydetailstab);
			assertEquals(identitynumbertwotextbox.getText(), identitynumber,"Company details page, Identity Number Two is not same as updated");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}