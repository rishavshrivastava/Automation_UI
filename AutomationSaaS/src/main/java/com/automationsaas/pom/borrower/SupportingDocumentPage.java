package com.automationsaas.pom.borrower;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationsaas.utilities.Generics;

public class SupportingDocumentPage {

	public WebDriver driver;

	public SupportingDocumentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Supporting Documents')]")
	private WebElement supportingdocumenttab;
	
	@FindBy(xpath="//a[contains(.,'Loan Application Document')]")
	private WebElement loanapplicationdocumentaccordionlink;
	
	@FindBy(xpath="//a[contains(text(),'Co Applicant Document')]")
	private WebElement coapplicantaccordionlink;
	
	@FindBy(xpath="//a[contains(text(),'Document For Reference')]")
	private WebElement referenceaccordionlink;

	@FindBy(xpath = "//div[contains(@id,'MAIN_APPLICANT')]//th[.='Serial No']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Serial No']/preceding-sibling::th)+1]")
	private List<WebElement> loanapplicationdocumentserialnumber;

	@FindBy(xpath = "//div[contains(@id,'MAIN_APPLICANT')]//th[.='Document Category']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Document Category']/preceding-sibling::th)-1]")
	private List<WebElement> loanapplicationdocumentcategory;

	@FindBy(xpath = "//div[contains(@id,'MAIN_APPLICANT')]//th[.='Document Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Document Name']/preceding-sibling::th)-6]")
	private List<WebElement> loanapplicationdocumentname;

	@FindBy(xpath = "//div[contains(@id,'CO_APPLICANT')]//th[.='Serial No']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Serial No']/preceding-sibling::th)+1]")
	private List<WebElement> coapplicantserialnumber;

	@FindBy(xpath = "//div[contains(@id,'CO_APPLICANT')]//th[.='Document Category']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Document Category']/preceding-sibling::th)-1]")
	private List<WebElement> coapplicantdocumentcategory;

	@FindBy(xpath = "//div[contains(@id,'CO_APPLICANT')]//th[.='Document Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Document Name']/preceding-sibling::th)-6]")
	private List<WebElement> coapplicantdocumentname;

	@FindBy(xpath = "//div[contains(@id,'REFERENCE')]//th[.='Serial No']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Serial No']/preceding-sibling::th)+1]")
	private List<WebElement> referenceserialnumber;
	
	@FindBy(xpath="//div[contains(@id,'REFERENCE')]//th[.='Document Category']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Document Category']/preceding-sibling::th)-1]")
	private List<WebElement> referencedocumentcategory;
	
	@FindBy(xpath="//div[contains(@id,'REFERENCE')]//th[.='Document Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Document Name']/preceding-sibling::th)-6]")
	private List<WebElement> referencedocumentname;
	
	@FindBy(xpath="//div[@id='MAIN_APPLICANT_0e3e690c-e16c-4352-ad31-3ecf0b639446']//i[@class='fa fa-upload']")
	private List<WebElement> loanapplicationdocumentsuploadbuttons;
	
	@FindBy(xpath="//div[@id='MAIN_APPLICANT_0e3e690c-e16c-4352-ad31-3ecf0b639446']//i[@class='fa fa-download']")
	private List<WebElement> loanapplicationdocumentsdownloadbutton;
	
	@FindBy(xpath="//div[@id='supportingDocumentListToDelete']//i[@class='fa fa-times']")
	private WebElement loanapplicationdocuments_popup_actionbutton;
	
	@FindBy(xpath="//form[@id='loanApplicationDocumentUploadForm']//button")
	private WebElement loanapplicationdocuments_popup_donebutton;
	
	@FindBy(xpath="//form[@id='loanApplicationDocumentUploadForm']//input[@name='document']")
	private WebElement loanapplicationdocuments_popup_choosefileinput;
	
	@FindBy(xpath="//span[contains(text(),'uploaded successfully')]")
	private WebElement uploadnotification;
	
	@FindBy(xpath="//th[.='#']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='#']/preceding-sibling::th)+1]")
	private List<WebElement> supportingdocumentuploadedfilecount;
	
	@FindBy(xpath="//div[@id='modal-loan-document-upload']//button[contains(text(),'×')]")
	private WebElement supportingdocument_closebutton;
	
	@FindBy(xpath="//i[@class='fa fa-times']")
	private List<WebElement> documentactionbuttons;
	
	@FindBy(xpath = "//span[contains(text(),'Deleted Successfully')]")
	private WebElement deletenotifications;

	public void clickSupportingDocument() {
		try {
			Generics.waitForElement(driver, supportingdocumenttab);
			supportingdocumenttab.click();
			Thread.sleep(2000); //Temporary Code
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickLoanApplicationDocumentAccordion() {
		try {
			Generics.waitForElement(driver, loanapplicationdocumentaccordionlink);
			loanapplicationdocumentaccordionlink.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickCoApplicantDocumentAccordion() {
		try {
			Generics.waitForElement(driver, coapplicantaccordionlink);
			coapplicantaccordionlink.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickDocumentForReferenceAccordionLink() {
		try {
			Generics.waitForElement(driver, referenceaccordionlink);
			referenceaccordionlink.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateLoanApplicationDocument(int i, String serialnumber, String documentcategory,
			String documentdetails) {
		try {
			Generics.waitForElement(driver, loanapplicationdocumentserialnumber.get(i));
			assertEquals(loanapplicationdocumentserialnumber.get(i).getText(), serialnumber);

			Generics.waitForElement(driver, loanapplicationdocumentcategory.get(i));
			assertEquals(loanapplicationdocumentcategory.get(i).getText(), documentcategory);

			Generics.waitForElement(driver, loanapplicationdocumentname.get(i));
//			assertEquals(loanapplicationdocumentname.get(i).getText(), documentdetails);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void downloadDocument(String documenttype) {
		try {
			WebElement downloadbotton = driver.findElement(By.xpath("//div[contains(@id,'MAIN_APPLICANT')]//td[text()='"+documenttype+"']/following-sibling::td/a"));
			downloadbotton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void uploadDocument(String filename, String uploadfilepath) {
		try {
			WebElement fileUploadButton = driver.findElement(By.xpath("//div[contains(@id,'MAIN_APPLICANT')]//th[.='Document Category']/ancestor::thead/following-sibling::tbody/tr/td[text()='"+filename+"']/following-sibling::td/button/i[@class='fa fa-upload']"));
			Generics.waitForElement(driver, fileUploadButton);
			fileUploadButton.click();

			WebElement chooseFileLink = driver.findElement(By.xpath("//form[@id='loanApplicationDocumentUploadForm']//input[@name='document']"));
			Generics.waitForElement(driver, chooseFileLink);
			chooseFileLink.sendKeys(uploadfilepath);

			WebElement popupUploadButton = driver.findElement(By.xpath("//form[@id='loanApplicationDocumentUploadForm']//button[contains(text(),'Done')]"));
			Generics.waitForElement(driver, popupUploadButton);
			popupUploadButton.click();
			
			Generics.waitForElement(driver, uploadnotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateDocumentCount(String filename, int count) {
		try {
			WebElement fileUploadButton = driver.findElement(By.xpath("//div[contains(@id,'MAIN_APPLICANT')]//th[.='Document Category']/ancestor::thead/following-sibling::tbody/tr/td[text()='"+filename+"']/following-sibling::td/button/i[@class='fa fa-upload']"));
			Generics.waitForElement(driver, fileUploadButton);
			fileUploadButton.click();
			assertEquals(supportingdocumentuploadedfilecount.size(), count);
			Generics.waitForElement(driver, supportingdocument_closebutton);
			supportingdocument_closebutton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUploadedDocument(String filename, int numberofdocumentstobedeleted) {
		try {
			for(int i=0; i<numberofdocumentstobedeleted;i++) {
				WebElement fileUploadButton = driver.findElement(By.xpath("//div[contains(@id,'MAIN_APPLICANT')]//th[.='Document Category']/ancestor::thead/following-sibling::tbody/tr/td[text()='"+filename+"']/following-sibling::td/button/i[@class='fa fa-upload']"));
				Generics.waitForElement(driver, fileUploadButton);
				fileUploadButton.click();
				Generics.waitForElement(driver, documentactionbuttons.get(i));
				documentactionbuttons.get(i).click();
				Generics.waitForElement(driver, deletenotifications);
				Generics.waitForElement(driver, supportingdocument_closebutton);
				supportingdocument_closebutton.click();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateDownloadedDocument(String filename, int count) {
		try {
			WebElement fileUploadButton = driver.findElement(By.xpath("//div[contains(@id,'MAIN_APPLICANT')]//td[text()='"+filename+"']/following-sibling::td/button/i"));
			Generics.waitForElement(driver, fileUploadButton);
			fileUploadButton.click();
			assertEquals(supportingdocumentuploadedfilecount.size(), count);
			Generics.waitForElement(driver, supportingdocument_closebutton);
			supportingdocument_closebutton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateCoApplicantDocument(int i, String serialnumber, String documentcategory,
			String documentdetails) {
		try {
			Generics.waitForElement(driver, coapplicantserialnumber.get(i));
			assertEquals(coapplicantserialnumber.get(i).getText(), serialnumber);

			Generics.waitForElement(driver, coapplicantdocumentcategory.get(i));
			assertEquals(coapplicantdocumentcategory.get(i).getText(), documentcategory);

			Generics.waitForElement(driver, coapplicantdocumentname.get(i));
			assertEquals(coapplicantdocumentname.get(i).getText(), documentdetails);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateReferenceDocument(int i, String serialnumber, String documentcategory,
			String documentdetails) {
		try {
			Generics.waitForElement(driver, referenceserialnumber.get(i));
			assertEquals(referenceserialnumber.get(i).getText(), serialnumber);

			Generics.waitForElement(driver, referencedocumentcategory.get(i));
			assertEquals(referencedocumentcategory.get(i).getText(), documentcategory);

			Generics.waitForElement(driver, referencedocumentname.get(i));
			assertEquals(referencedocumentname.get(i).getText(), documentdetails);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
