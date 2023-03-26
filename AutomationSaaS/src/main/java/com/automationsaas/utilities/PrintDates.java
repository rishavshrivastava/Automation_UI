package com.automationsaas.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class PrintDates extends Base {

	public static void printRepaymentDates(WebDriver driver, String repaymentType, int loanTenure, String filepath,
			String sheetname) {
		try {
			String currenturl = driver.getCurrentUrl();
			// navigating to holiday list
			WebElement configuration = driver.findElement(By.xpath("//span[text()='Configuration']"));
			Generics.waitForElement(driver, configuration);
			configuration.click();
			WebElement claendarholiday = driver.findElement(By.xpath("//span[contains(text(),'Calendar Holidays')]"));
			Generics.waitForElement(driver, claendarholiday);
			driver.findElement(By.xpath("//span[contains(text(),'Calendar Holidays')]")).click();
			WebElement calendarholidaylist = driver.findElement(By.xpath("//div[@id='calendar_holiday_list']"));
			Generics.waitForElement(driver, calendarholidaylist);

			// getting no. of holiday dates present in holiday list
			List<WebElement> holidayrows = driver.findElements(By.xpath("//table//tbody/tr"));
			// storing all holiday dates in array
			ArrayList<String> holiday_dates = new ArrayList<String>();
			for (int m = 1; m <= holidayrows.size() / 3; m++) {
				holiday_dates.add(driver
						.findElement(By.xpath(
								"//th[text() ='Holiday Date']/../../following-sibling::tbody//tr[" + m + "]/td[3]"))
						.getText());
			}
			String pattern = "dd/MM/yyyy";
			DateFormat dateFormat = new SimpleDateFormat(pattern);
			Calendar calendar = null;
			int holiday = 2;
			if (repaymentType.equalsIgnoreCase("Holiday Repayment")) {
				System.out.println(repaymentType);
				for (int i = 0; i <= loanTenure + holiday; i++) {
					calendar = Calendar.getInstance();
					calendar.add(Calendar.MONTH, i);
					String todays_date = dateFormat.format(calendar.getTime());
					while (holiday_dates.contains(todays_date)) {
						calendar.add(Calendar.DATE, 1);
						todays_date = dateFormat.format(calendar.getTime());
					}
					ReadWriteExcel.putData(filepath, sheetname, i + 1, 1, todays_date);
				}
			}

			if (repaymentType.equalsIgnoreCase("Flat Repayment")) {
				System.out.println(repaymentType);
				int j = 1;
				for (int i = 0; i <= loanTenure; i += 12) {
					calendar = Calendar.getInstance();
					calendar.add(Calendar.MONTH, i);
					String todays_date = dateFormat.format(calendar.getTime());
					while (holiday_dates.contains(todays_date)) {
						calendar.add(Calendar.DATE, 1);
						todays_date = dateFormat.format(calendar.getTime());
					}
					ReadWriteExcel.putData(filepath, sheetname, j, 2, todays_date);
					j++;
				}
			}

			if (repaymentType.equalsIgnoreCase("Daily Bullet Repayment")) {
				System.out.println(repaymentType);
				int j = 1;
				for (int i = 0; i <= loanTenure; i += 4) {
					calendar = Calendar.getInstance();
					calendar.add(Calendar.DATE, i);
					String todays_date = dateFormat.format(calendar.getTime());
					while (holiday_dates.contains(todays_date)) {
						calendar.add(Calendar.DATE, 1);
						todays_date = dateFormat.format(calendar.getTime());
					}
					ReadWriteExcel.putData(filepath, sheetname, j, 3, todays_date);
					j++;
				}
			}

			if (repaymentType.equalsIgnoreCase("Flat Rate Repayment")
					|| repaymentType.equalsIgnoreCase("Even Repayment")) {
				Reporter.log(repaymentType, true);
				int j = 1;
				for (int i = 0; i <= loanTenure; i++) {
					calendar = Calendar.getInstance();
					calendar.add(Calendar.MONTH, i);
					String todays_date = dateFormat.format(calendar.getTime());
					while (holiday_dates.contains(todays_date)) {
						calendar.add(Calendar.DATE, 1);
						todays_date = dateFormat.format(calendar.getTime());
					}
					if(repaymentType.equalsIgnoreCase("Even Repayment")) {
						ReadWriteExcel.putData(filepath, sheetname, j, 5, todays_date);
					}
					else if(repaymentType.equalsIgnoreCase("Flat Rate Repayment")) {
						ReadWriteExcel.putData(filepath, sheetname, j, 4, todays_date);
					}
					j++;
				}
			}
			driver.get(currenturl);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
