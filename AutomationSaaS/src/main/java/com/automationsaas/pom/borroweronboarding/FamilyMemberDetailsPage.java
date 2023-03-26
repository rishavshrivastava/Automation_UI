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

public class FamilyMemberDetailsPage {

	public WebDriver driver;

	public FamilyMemberDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1")
	private WebElement familymemberdetailsheading;
	
	@FindBy(id="name")
	private WebElement nametextbox;
	
	@FindBy(xpath="//input[contains(@id,'dateOfBirth')]")
	private WebElement dateofbirthtextbox;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	private WebElement yeardropdown;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	private WebElement monthdropdown;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//a")
	private List<WebElement> datelinks;
	
	@FindBy(id="occupation")
	private WebElement occupationtextbox;
	
	@FindBy(id="nameOfOrganization")
	private WebElement nameoforganizationtextbox;
	
	@FindBy(id="familyMemberTextVariable1")
	private WebElement familymembertextvariable1textbox;
	
	@FindBy(id="familyMemberTextVariable2")
	private WebElement familymembertextvariable2textbox;
	
	@FindBy(id="familyMemberTextVariable3")
	private WebElement familymembertextvariable3textbox;
	
	@FindBy(id="familyMemberTextVariable4")
	private WebElement familymembertextvariable4textbox;
	
	@FindBy(id="familyMemberTextVariable5")
	private WebElement familymembertextvariable5textbox;
	
	@FindBy(id="familyMemberTextVariable6")
	private WebElement familymembertextvariable6textbox;
	
	@FindBy(id="familyMemberTextVariable7")
	private WebElement familymembertextvariable7textbox;
	
	@FindBy(xpath="//a[contains(text(),'Skip')]")
	private WebElement skipbutton;
	
	@FindBy(id="createFamilyMemberAjxBtn")
	private WebElement addmorebutton;
	
	@FindBy(id="createFamilyMemberAndCOntinueBtn")
	private WebElement addandcontinuebutton;
	
	@FindBy(xpath="//th[.='Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Name']/preceding-sibling::th)+1]")
	private WebElement nametext;
	
	@FindBy(xpath="//th[.='Date of Birth']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Date of Birth']/preceding-sibling::th)+1]")
	private WebElement dateofbirthtext;
	
	@FindBy(xpath="//th[.='Occupation']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Occupation']/preceding-sibling::th)+1]")
	private WebElement occupationtext;
	
	@FindBy(xpath="//th[.='Name Of Organization']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Name Of Organization']/preceding-sibling::th)+1]")
	private WebElement nameoforganizationtext;
	
	@FindBy(xpath="//th[.='Family Member extra text variable1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Family Member extra text variable1']/preceding-sibling::th)+1]")
	private WebElement familymemberextratextvariable1text;
	
	@FindBy(xpath="//th[.='Family Member extra text variable2']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Family Member extra text variable2']/preceding-sibling::th)+1]")
	private WebElement familymemberextratextvariable2text;
	
	@FindBy(xpath="//th[.='Family Member extra text variable3']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Family Member extra text variable3']/preceding-sibling::th)+1]")
	private WebElement familymemberextratextvariable3text;
	
	@FindBy(xpath="//th[.='Family Member extra text variable4']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Family Member extra text variable4']/preceding-sibling::th)+1]")
	private WebElement familymemberextratextvariable4text;
	
	@FindBy(xpath="//th[.='Family Member extra text variable5']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Family Member extra text variable5']/preceding-sibling::th)+1]")
	private WebElement familymemberextratextvariable5text;
	
	@FindBy(xpath="//th[.='Family Member extra text variable6']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Family Member extra text variable6']/preceding-sibling::th)+1]")
	private WebElement familymemberextratextvariable6text;
	
	@FindBy(xpath="//th[.='Family Member extra text variable7']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Family Member extra text variable7']/preceding-sibling::th)+1]")
	private WebElement familymemberextratextvariable7text;
	
	@FindBy(xpath="//i[@class='fa fa-edit']")
	private WebElement editbutton;
	
	@FindBy(xpath="//i[@class='fa fa-trash-o']")
	private WebElement deletebutton;
	
	@FindBy(xpath="//span[contains(text(),'deleted')]")
	private WebElement deletenotifications;
	
	@FindBy(xpath="//ul[@class='nav alert alert-block alert-danger fade in']/li")
	private List<WebElement> errormessages;
	
	public void validateFamilyMemberDetailsHeading(String pageheading) {
		try {
			Generics.waitForElement(driver, familymemberdetailsheading);
			if (familymemberdetailsheading.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("Family Member Details is displayed", true);
			} else
				Reporter.log("Family Member Details is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateFamilyMemberDetailsHeading", true);
		}
	}
	
	public void enterName(String value) {
		try {
			Generics.waitForElement(driver, nametextbox);
			nametextbox.click();
			nametextbox.clear();
			nametextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectDateOfBirth(String year, String month, String date) {
		try {
			Generics.waitForElement(driver, dateofbirthtextbox);
			dateofbirthtextbox.click();
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
	
	public void enterOccupation(String value) {
		try {
			Generics.waitForElement(driver, occupationtextbox);
			occupationtextbox.click();
			occupationtextbox.clear();
			occupationtextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterNameOfOrganization(String value) {
		try {
			Generics.waitForElement(driver, nameoforganizationtextbox);
			nameoforganizationtextbox.click();
			nameoforganizationtextbox.clear();
			nameoforganizationtextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterFamilyMemberExtraTextVariable1(String value) {
		try {
			Generics.waitForElement(driver, familymembertextvariable1textbox);
			familymembertextvariable1textbox.click();
			familymembertextvariable1textbox.clear();
			familymembertextvariable1textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterFamilyMemberExtraTextVariable2(String value) {
		try {
			Generics.waitForElement(driver, familymembertextvariable2textbox);
			familymembertextvariable2textbox.click();
			familymembertextvariable2textbox.clear();
			familymembertextvariable2textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterFamilyMemberExtraTextVariable3(String value) {
		try {
			Generics.waitForElement(driver, familymembertextvariable3textbox);
			familymembertextvariable3textbox.click();
			familymembertextvariable3textbox.clear();
			familymembertextvariable3textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterFamilyMemberExtraTextVariable4(String value) {
		try {
			Generics.waitForElement(driver, familymembertextvariable4textbox);
			familymembertextvariable4textbox.click();
			familymembertextvariable4textbox.clear();
			familymembertextvariable4textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterFamilyMemberExtraTextVariable5(String value) {
		try {
			Generics.waitForElement(driver, familymembertextvariable5textbox);
			familymembertextvariable5textbox.click();
			familymembertextvariable5textbox.clear();
			familymembertextvariable5textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterFamilyMemberExtraTextVariable6(String value) {
		try {
			Generics.waitForElement(driver, familymembertextvariable6textbox);
			familymembertextvariable6textbox.click();
			familymembertextvariable6textbox.clear();
			familymembertextvariable6textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterFamilyMemberExtraTextVariable7(String value) {
		try {
			Generics.waitForElement(driver, familymembertextvariable7textbox);
			familymembertextvariable7textbox.click();
			familymembertextvariable7textbox.clear();
			familymembertextvariable7textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickAddMore() {
		try {
			Generics.waitForElement(driver, addmorebutton);
			addmorebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateFamilyMemberDetails(int i, String value) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, nametext);
				assertEquals(nametext.getText(), value);
				break;
				
			case 1:
				Generics.waitForElement(driver, dateofbirthtext);
				assertEquals(dateofbirthtext.getText(), value);
				break;
				
			case 2:
				Generics.waitForElement(driver, occupationtext);
				assertEquals(occupationtext.getText(), value);
				break;
				
			case 3:
				Generics.waitForElement(driver, nameoforganizationtext);
				assertEquals(nameoforganizationtext.getText(), value);
				break;
				
			case 4:
				Generics.waitForElement(driver, familymemberextratextvariable1text);
				assertEquals(familymemberextratextvariable1text.getText(), value);
				break;
				
			case 5:
				Generics.waitForElement(driver, familymemberextratextvariable2text);
				assertEquals(familymemberextratextvariable2text.getText(), value);
				break;
				
			case 6:
				Generics.waitForElement(driver, familymemberextratextvariable3text);
				assertEquals(familymemberextratextvariable3text.getText(), value);
				break;
				
			case 7:
				Generics.waitForElement(driver, familymemberextratextvariable4text);
				assertEquals(familymemberextratextvariable4text.getText(), value);
				break;
				
			case 8:
				Generics.waitForElement(driver, familymemberextratextvariable5text);
				assertEquals(familymemberextratextvariable5text.getText(), value);
				break;
				
			case 9:
				Generics.waitForElement(driver, familymemberextratextvariable6text);
				assertEquals(familymemberextratextvariable6text.getText(), value);
				break;
				
			case 10:
				Generics.waitForElement(driver, familymemberextratextvariable7text);
				assertEquals(familymemberextratextvariable7text.getText(), value);
				break;
		
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickDelete() {
		try {
			Generics.waitForElement(driver, deletebutton);
			deletebutton.click();
			Generics.alertAction(driver, "Yes");
			Generics.waitForElement(driver, deletenotifications);
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
