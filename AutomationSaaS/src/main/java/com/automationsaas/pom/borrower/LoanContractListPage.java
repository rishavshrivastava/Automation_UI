package com.automationsaas.pom.borrower;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationsaas.utilities.Generics;

public class LoanContractListPage {

	public WebDriver driver;

	public LoanContractListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@id='addressDetailTable']//th[.='Serial No']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Serial No']/preceding-sibling::th)+1]")
	private List<WebElement> loanid;
	
	@FindBy(xpath="//table[@id='contractsTable']//th[.='Contract Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Contract Name']/preceding-sibling::th)+1]/a")
	private List<WebElement> contractname;
	
	@FindBy(xpath="//table[@id='contractsTable']//th[.='Current Status']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Current Status']/preceding-sibling::th)+1]")
	private List<WebElement> currentstatus;
	
	@FindBy(xpath="//table[@id='contractsTable']//th[.='Accepted / Uploaded By']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Accepted / Uploaded By']/preceding-sibling::th)+1]")
	private WebElement accepted_uploadedby;
	
	@FindBy(xpath="//table[@id='contractsTable']//th[.='Acceptd / Uploaded at Status']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Acceptd / Uploaded at Status']/preceding-sibling::th)+1]")
	private WebElement accepted_uploadedatstatus;
	
	@FindBy(xpath="//table[@id='contractsTable']//th[.='Contract accepted date and time']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Contract accepted date and time']/preceding-sibling::th)+1]")
	private WebElement contractaccepteddateandtime;
	
	@FindBy(id="accept")
	private WebElement loancontractacceptbutton;
	
	@FindBy(xpath="//span[contains(text(),'Accepted')]")
	private WebElement loancontractacceptnotification;
	
	@FindBy(id="reject")
	private WebElement loancontractrejectbutton;
	
	@FindBy(xpath="//span[contains(text(),'Rejected')]")
	private WebElement loancontractrejectnotification;
	
	@FindBy(xpath="//div[@id='waitingSpinnerBasicDetail']//img[@src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']")
	private WebElement waitspinnerforbasicdetailspage;
	
	
	public void acceptRejectContract(int i, String action) {
		try {
			Generics.waitForElement(driver, contractname.get(i));
			contractname.get(i).click();
			if(action.equalsIgnoreCase("accept")) {
				loancontractacceptbutton.click();
//				Generics.waitForElement(driver, loancontractacceptnotification);
			}
			else if (action.equalsIgnoreCase("reject")) {
				loancontractrejectbutton.click();
//				Generics.waitForElement(driver, loancontractrejectnotification);
			}
			else {
				System.out.println("No Status Selected");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
