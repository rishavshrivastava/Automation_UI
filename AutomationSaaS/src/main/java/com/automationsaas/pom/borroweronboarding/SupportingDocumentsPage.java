package com.automationsaas.pom.borroweronboarding;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.automationsaas.utilities.Generics;

public class SupportingDocumentsPage {

	public WebDriver driver;

	public SupportingDocumentsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//h2)[1]")
	private WebElement supportingdocumentsheading;

	// Aadhar
	@FindBy(xpath = "//label[text()='Adhar Card']/../../following-sibling::div//a[text()='Upload']")
	private WebElement aadharuploadbutton;

	@FindBy(xpath = "//label[contains(text(),'Adhar Card')]/../following-sibling::div/a[contains(@id,'save_document_button')]")
	private WebElement popupaadharuploadbutton;

	@FindBy(xpath = "//label[text()='Adhar Card']/../../following-sibling::div//img[@src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']")
	private WebElement aadharuploadspinner;

	@FindBy(xpath = "//label[text()='Adhar Card']/../../following-sibling::div//a[text()='Upload More']")
	private WebElement aadharuploadmorebutton;

	@FindBy(xpath = "//h4[contains(text(),'Upload Adhar Card')]/../following-sibling::div//span")
	private WebElement alreadyuploadedaadhardocuments;

	@FindBy(xpath = "//h4[contains(text(),'Upload Adhar Card')]/../following-sibling::div//button")
	private WebElement alreadyuploadedaadhardocumentdeletebutton;

	// Pan
	@FindBy(xpath = "//label[text()='Pan Card']/../../following-sibling::div//a[text()='Upload']")
	private WebElement panuploadbutton;

	@FindBy(xpath = "//label[contains(text(),'Pan Card')]/../following-sibling::div/a[contains(@id,'save_document_button')]")
	private WebElement popuppanuploadbutton;

	@FindBy(xpath = "//label[text()='Pan Card']/../../following-sibling::div//img[@src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']")
	private WebElement panuploadspinner;

	@FindBy(xpath = "//label[text()='Pan Card']/../../following-sibling::div//a[text()='Upload More']")
	private WebElement panuploadmorebutton;

	@FindBy(xpath = "//h4[contains(text(),'Upload Pan Card')]/../following-sibling::div//span")
	private WebElement alreadyuploadedpandocuments;

	@FindBy(xpath = "//h4[contains(text(),'Upload Pan Card')]/../following-sibling::div//button")
	private WebElement alreadyuploadedpandocumentdeletebutton;

	// Address Proof
	@FindBy(xpath = "//label[text()='Address Proof']/../../following-sibling::div//a[text()='Upload']")
	private WebElement addressproofuploadbutton;

	@FindBy(xpath = "//label[contains(text(),'Address Proof')]/../following-sibling::div/a[contains(@id,'save_document_button')]")
	private WebElement popupaddressuploadbutton;

	@FindBy(xpath = "//label[text()='Address Proof']/../../following-sibling::div//img[@src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']")
	private WebElement addressproofuploadspinner;

	@FindBy(xpath = "//label[text()='Address Proof']/../../following-sibling::div//a[text()='Upload More']")
	private WebElement addressproofuploadmorebutton;

	@FindBy(xpath = "//h4[contains(text(),'Upload Address Proof')]/../following-sibling::div//span")
	private WebElement alreadyuploadedaddressproofdocuments;

	@FindBy(xpath = "//h4[contains(text(),'Upload Address Proof')]/../following-sibling::div//button")
	private WebElement alreadyuploadedaddressproofdocumentdeletebutton;

	@FindBy(xpath = "//input[contains(@id,'upload_document_button')]")
	private WebElement choosfilelink;

	@FindBy(xpath = "//input[@id='termsChecked']/..//a")
	private WebElement termsandconditionlink;

	@FindBy(id = "submit_all_documents")
	private WebElement submitbutton;

	@FindBy(id = "continueToProfile")
	private WebElement continuetoprofilelink;
	
	@FindBy(xpath="//th[.='#']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='#']/preceding-sibling::th)+1]")
	private List<WebElement> supportingdocumentuploadedfilecount;
	
	@FindBy(xpath="//div[@id='modal-onboarding-document-template']//button[contains(text(),'×')]")
	private WebElement supportingdocument_closebutton;
	
	@FindBy(id="ajax-spinner-loader01ae8271-50f3-4e34-b309-3636e7ace788")
	private WebElement spinner;
	
	@FindBy(xpath="//i[@class='fa fa-times']")
	private List<WebElement> documentactionbuttons;
	
	@FindBy(xpath = "//span[contains(text(),'deleted successfully')]")
	private WebElement deletenotifications;
	
	@FindBy(xpath = "(//a[contains(text(),'Submit')])[1]")
	private WebElement companyrepresentative_documentssubmit;
	
	@FindBy(xpath="(//h4[contains(text(),'Upload Documents')]//preceding-sibling::button[contains(text(),'×')])[1]")
	private WebElement companyrepresentative_documentmodalclose;
	
	@FindBy(xpath = "//a[contains(text(),'Upload More')]")
	private WebElement uploadmorebutton;
	
	

	public void validateSupportingDocumentsHeading(String pageheading) {
		try {
			Generics.waitForElement(driver, supportingdocumentsheading);
			if (supportingdocumentsheading.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("Supporting documents is displayed", true);
			} else
				Reporter.log("Supporting documents is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateSupportingDocumentsHeading", true);
		}
	}

	public void uploadDocument(String filename, String uploadfilepath) {
		try {
			WebElement fileUploadButton = driver
					.findElement(By.xpath("(//label[text()='" + filename + "']/../../following-sibling::div//a)[1]"));

			Generics.waitForElement(driver, fileUploadButton);
			fileUploadButton.click();

			WebElement chooseFileLink = driver.findElement(By.xpath("//h4[contains(text(),'Upload " + filename
					+ "')]/../following-sibling::div//input[contains(@id,'upload')]"));
			Generics.waitForElement(driver, chooseFileLink);
			chooseFileLink.sendKeys(uploadfilepath);

			WebElement popupUploadButton = driver.findElement(By.xpath("//h4[contains(text(),'Upload " + filename
					+ "')]/../following-sibling::div//a[contains(@id,'save_document_button')]"));
			Generics.waitForElement(driver, popupUploadButton);
			popupUploadButton.click();
			
			Generics.waitForElementToInvisible(driver, spinner);

			WebElement uploadMoreButton = driver
					.findElement(By.xpath("//label[text()='" + filename + "']/../../..//a[text()='Upload More']"));
			Generics.waitForElement(driver, uploadMoreButton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void uploadCompanyRepresentativeDocument(String filename, String uploadfilepath) {
		try {
			WebElement fileUploadButton = driver
					.findElement(By.xpath("(//label[text()='" + filename + "']/../../following-sibling::div//a)[1]"));

			Generics.waitForElement(driver, fileUploadButton);
			fileUploadButton.click();

			WebElement chooseFileLink = driver.findElement(By.xpath("//h4[contains(text(),'Upload " + filename
					+ "')]/../following-sibling::div//input[contains(@id,'upload')]"));
			Generics.waitForElement(driver, chooseFileLink);
			chooseFileLink.sendKeys(uploadfilepath);

			WebElement popupUploadButton = driver.findElement(By.xpath("//h4[contains(text(),'Upload " + filename
					+ "')]/../following-sibling::div//a[contains(@id,'save_document_button')]"));
			Generics.waitForElement(driver, popupUploadButton);
			popupUploadButton.click();
			
			//Generics.waitForElement(driver, uploadmorebutton);

			WebElement uploadMoreButton = driver
					.findElement(By.xpath("//label[text()='" + filename + "']/../../..//a[text()='Upload More']"));
			Generics.waitForElement(driver, uploadMoreButton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void validateUploadedDocument(String filename, int filecount) {
		try {
			WebElement fileUploadButton = driver.findElement(By.xpath("(//label[text()='" + filename + "']/../../following-sibling::div//a)[1]"));
			Generics.waitForElement(driver, fileUploadButton);
			fileUploadButton.click();
			assertEquals(supportingdocumentuploadedfilecount.size(), filecount);
			supportingdocument_closebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//upload more document  : Divya
	
	public void uploadMoreDocument(String filename, String uploadfilepath) {
		try {
			WebElement uploadMoreButton = driver.findElement(By.xpath("//label[text()='" + filename + "']/../../..//a[text()='Upload More']"));
			Generics.waitForElement(driver, uploadMoreButton);
			uploadMoreButton.click();

			WebElement chooseFileLink = driver.findElement(By.xpath("//label[contains(text(),'"+filename+"')]/following-sibling::input"));
			Generics.waitForElement(driver, chooseFileLink);
			chooseFileLink.sendKeys(uploadfilepath);

			WebElement popupUploadButton = driver.findElement(By.xpath("//label[contains(text(),'"+filename+"')]/../following-sibling::div/a"));
			Generics.waitForElement(driver, popupUploadButton);
			popupUploadButton.click();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	
	
	public void deleteUploadedDocument(String filename, int numberofdocumentstobedeleted) {
		try {
			for(int i=0; i<numberofdocumentstobedeleted;i++) {
				WebElement fileUploadButton = driver.findElement(By.xpath("(//label[text()='" + filename + "']/../../following-sibling::div//a)[1]"));
				Generics.waitForElement(driver, fileUploadButton);
				fileUploadButton.click();
				Generics.waitForElement(driver, documentactionbuttons.get(i));
				documentactionbuttons.get(i).click();
				Generics.waitForElement(driver, deletenotifications);
				supportingdocument_closebutton.click();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void uploadCoApplicantDocument(String filename, String uploadfilepath) {
		try {
			WebElement fileUploadButton = driver.findElement(By.xpath("(//h2[contains(text(),'Supporting Documents')]/../..//label[text()='"+filename+"']/../../following-sibling::div//a)[2]"));

			Generics.waitForElement(driver, fileUploadButton);
			fileUploadButton.click();

			WebElement chooseFileLink = driver.findElement(By.xpath("//h4[contains(text(),'Upload "+filename+"')]/../following-sibling::div//input[contains(@id,'upload')]"));
			Generics.waitForElement(driver, chooseFileLink);
			chooseFileLink.sendKeys(uploadfilepath);

			WebElement popupUploadButton = driver.findElement(By.xpath("//h4[contains(text(),'Upload "+filename+"')]/../following-sibling::div//a[contains(@id,'save_document_button')]"));
			Generics.waitForElement(driver, popupUploadButton);
			popupUploadButton.click();

			WebElement uploadMoreButton = driver.findElement(By.xpath("(//h2[contains(text(),'Supporting Documents')]/../..//label[text()='"+filename+"']/../../following-sibling::div//a[text()='Upload More'])[2]"));
			Generics.waitForElement(driver, uploadMoreButton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void uploadReferenceDocument(String filename, String uploadfilepath) {
		try {
			WebElement fileUploadButton = driver.findElement(By.xpath("(//h2[contains(text(),'Supporting Documents')]/../..//label[text()='"+filename+"']/../../following-sibling::div//a)[3]"));

			Generics.waitForElement(driver, fileUploadButton);
			fileUploadButton.click();
			Thread.sleep(2000);
			WebElement chooseFileLink = driver.findElement(By.xpath("//h4[contains(text(),'Upload "+filename+"')]/../following-sibling::div//input[contains(@id,'upload')]"));
			Generics.waitForElement(driver, chooseFileLink);
			chooseFileLink.sendKeys(uploadfilepath);

			WebElement popupUploadButton = driver.findElement(By.xpath("//h4[contains(text(),'Upload "+filename+"')]/../following-sibling::div//a[contains(@id,'save_document_button')]"));
			Generics.waitForElement(driver, popupUploadButton);
			popupUploadButton.click();

			WebElement uploadMoreButton = driver.findElement(By.xpath("(//h2[contains(text(),'Supporting Documents')]/../..//label[text()='"+filename+"']/../../following-sibling::div//a[text()='Upload More'])[3]"));
			Generics.waitForElement(driver, uploadMoreButton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void checkTermsAndConditions() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('termsChecked').click()");
	}

	public void clickSubmit() {
		try {
			Generics.waitForElement(driver, submitbutton);
			submitbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickCompanyRepresentativeDocumentsSubmit() {
		try {
			Generics.waitForElement(driver, companyrepresentative_documentssubmit);
			companyrepresentative_documentssubmit.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickCompanyRepDocumentModalClose() {
		try {
			Generics.waitForElement(driver, companyrepresentative_documentmodalclose);
			companyrepresentative_documentmodalclose.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	public void clickContinueToProfile() {
		try {
			Generics.waitForElement(driver, continuetoprofilelink);
			continuetoprofilelink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
