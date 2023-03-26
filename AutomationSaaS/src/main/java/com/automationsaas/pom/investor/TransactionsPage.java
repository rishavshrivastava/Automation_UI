package com.automationsaas.pom.investor;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationsaas.utilities.Base;

public class TransactionsPage extends Base {

	public WebDriver driver;

	public TransactionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//th[.='Remaining Balance']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Remaining Balance']/preceding-sibling::th)+1]")
	private List<WebElement> completedtransactions_remainingbalancetext;

	@FindBy(xpath = "//th[.='Type']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Type']/preceding-sibling::th)+1]")
	private List<WebElement> completedtransactions_typetext;

	@FindBy(xpath = "//th[.='Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Amount']/preceding-sibling::th)+1]")
	private List<WebElement> completedtransactions_amounttext;

	public void validateCompletedTransactions(int expectedamount, int expectedremainingamount) {

		// Amount
		int a1 = 0;
		for (int i = 0; i < completedtransactions_amounttext.size(); i++) {
			String amount = completedtransactions_amounttext.get(i).getText().replace("Rs", "").replace(",", "");
			int a2 = Integer.parseInt(amount);
			int sum = a1 + a2;
			a1 = sum;
		}
		assertEquals(a1, expectedamount);

		// Remaining Balance
		int b1 = 0;
		for (int i = 0; i < completedtransactions_remainingbalancetext.size(); i++) {
			String amount = completedtransactions_remainingbalancetext.get(i).getText().replace("Rs", "").replace(",",
					"");
			int b2 = Integer.parseInt(amount);
			int sum = b1 + b2;
			b1 = sum;
		}
		assertEquals(b1, expectedremainingamount);
	}
}
