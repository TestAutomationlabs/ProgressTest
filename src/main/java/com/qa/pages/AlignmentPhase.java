package com.qa.pages;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.TestBase.TestBase;
import com.relevantcodes.extentreports.ExtentTest;

public class AlignmentPhase extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Next Phase')]")
	WebElement NextPhase;

	@FindBy(xpath = "//div[@class='icon-alignment icon f-70p']")
	WebElement AlignmentIcon;

	@FindBy(xpath = "//select[@class='form-control cursor-pointer']")
	WebElement Select_Procurment;

	@FindBy(xpath = "//div[@class='Toastify__toast-body']")
	WebElement toast_message;

	@FindBy(xpath = "//div/input[@placeholder='Supplier']")
	WebElement SupplierDropdown;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[4]/div/div/input")
	WebElement RequestorDropdown;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[5]/div/div/input")
	WebElement ProjectFocusDropdown;

	@FindBy(xpath = "//span[starts-with(text(),'Upd')]")
	WebElement UpdateButton;

	@FindBy(xpath = "//span[contains(text(),'Export')]")
	WebElement ExportButton;

	public String threedaysbefore = "";
	public String tomorrowddate = "";
	public String todaysdate = "";

	
	
	public AlignmentPhase() {
		PageFactory.initElements(driver, this);
	}

	public void verifyAlignmentValidation(ExtentTest test) throws InterruptedException {
		if (AlignmentIcon.isDisplayed()) 
		{

			System.out.println("Alignment icon is displayed hence user is click on the alignment icon");
			// WebElement sele= driver.findElement(By.xpath("//select[@class='form-control
			// cursor-pointer']"));
			Select sct = new Select(Select_Procurment);
			sct.selectByVisibleText("Procurement");
			Thread.sleep(4000);

			System.out.println("----------------Progress Title validation in Procurement Page------------------");
			driver.findElement(By.xpath("//h5[contains(text(),'Process8')]"));
			// driver.findElement(By.xpath("//*[@id=\"Project_ALI_0\"]")).click();
			driver.findElement(By.xpath("//*[@id='Project_ALI_0']")).click();
			Thread.sleep(3000);
			System.out.println("More icon is clicked");
			// driver.findElement(By.xpath("//li/span[contains(text(),'Move to next
			// phase')]"));
			try {
				List<WebElement> more_options = driver.findElements(By.xpath("//li/span"));
				System.out.println("Size of moreoptions =" + more_options.size());
				for (int x = 0; x < more_options.size(); x++) {
					System.out.println("List of more option is is" + more_options.get(x).getText());
					if (more_options.get(x).getText().contains("Move to next phase")) {
						Thread.sleep(2000);
						more_options.get(x).click();
						System.out.println("Move to next phase is clicked");
					} else {
						System.out.println("more options is not visible for title");
					}

				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Staleelementexception found");
			}
		}

		else {
			System.out.println("Alignment icon is not displayed");
		}
		Thread.sleep(4000);

		/// String toastvalidation=toast_message.getText();
		// System.out.println("On moving to the alignment phase to the proposal phase
		/// is" +toastvalidation);

	}

	public void CalenderDetails() {

		Date date = new Date();

		// For three days before//
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.add(Calendar.DAY_OF_YEAR, -3);
		Date before = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("d");
		threedaysbefore = formatter.format(before);
		System.out.println(threedaysbefore);

		// For tomorrows date//
		Calendar calendar1 = Calendar.getInstance();
		// get a date to represent "today"
		Date today = calendar1.getTime();
		SimpleDateFormat formatter_today = new SimpleDateFormat("d");
		System.out.println("today:    " + today);
		// add one day to the date/calendar
		calendar1.add(Calendar.DAY_OF_YEAR, 1);

		// now get "tomorrow"
		Date tomorrow = calendar1.getTime();
		SimpleDateFormat formatter_tomorrow= new SimpleDateFormat("d");
		tomorrowddate = formatter.format(tomorrow);

		// print out tomorrow's date
		System.out.println("tomorrow: " + tomorrow);
		System.out.println("Date");

	}

	public void verifyDateRangeStartDate(ExtentTest test) throws IOException, InterruptedException {
		CalenderDetails();
		System.out.println(threedaysbefore);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div/input")).click();
		System.out.println("DateRange button is clicked");
		List<WebElement> dates = driver.findElements(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div"));

		int count = dates.size();
		System.out.println(count);

		for (int i = 0; i < count; i++) {
			String text = driver
					.findElements(By.xpath(
							"//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div"))
					.get(i).getText();

			if (text.equalsIgnoreCase(threedaysbefore)) {
				driver.findElements(
						By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div"))
						.get(i).click();
				break;
			}
		}
	}

	public void verifyDateRangeEndDate(ExtentTest test) throws IOException, InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/input")).click();

		List<WebElement> dates_enddate = driver
				.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div[2]/div[3]/div/div[2]/div[2]/div/div"));
		int count_enddate = dates_enddate.size();
		System.out.println("count_enddate");

		for (int j = 0; j < count_enddate; j++) {
			String text_enddate = driver
					.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div[2]/div[3]/div/div[2]/div[2]/div/div")).get(j)
					.getText();
			if (text_enddate.equalsIgnoreCase(tomorrowddate)) {
				driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div[2]/div[3]/div/div[2]/div[2]/div/div"))
						.get(j).click();
				break;
			}

		}
	}

	public void verifySupplierDropDown(ExtentTest test) throws InterruptedException {
		SupplierDropdown.click();
		Thread.sleep(3000);
		List<WebElement> supplier_dropdown = driver.findElements(
				By.xpath("//input[@placeholder='Supplier']//following::div[@id='list-group-suggestions']/a"));
		int count_supplierdropdown = supplier_dropdown.size();
		System.out.println("supplier_dropdown size is " + count_supplierdropdown);
		Thread.sleep(4000);
		for (int m = 0; m < supplier_dropdown.size(); m++) {
			System.out.println(supplier_dropdown.get(m).getText());
			// String
			// supplier_text=driver.findElements(By.xpath("//div[@id='list-group-suggestions']/a")).get(m).getText();
			if (supplier_dropdown.get(m).getText().equals("Boston Consulting Group"))
				;
			{
				supplier_dropdown.get(m).click();
				break;
			}

		}
	}

	public void verifyRequestor(ExtentTest test) throws InterruptedException {
		RequestorDropdown.click();
		Thread.sleep(4000);
		List<WebElement> requestor_dropdown = driver.findElements(By.xpath("//div[@id='list-group-suggestions']/a"));
		int count_requestordropdown = requestor_dropdown.size();
		System.out.println("requestor dropdown size is" + count_requestordropdown);
		Thread.sleep(3000);
		for (int x = 0; x < requestor_dropdown.size(); x++) {
			System.out.println(requestor_dropdown.get(x).getText());
			if (requestor_dropdown.get(x).getText().equals("Sagar Lankegowda")) {
				requestor_dropdown.get(x).click();
				break;
			}
		}
	}

	public void verifyProjectFocus(ExtentTest test) throws InterruptedException {
		ProjectFocusDropdown.click();
		Thread.sleep(3000);
		List<WebElement> projectfocus_dropdown = driver.findElements(
				By.xpath("//input[@placeholder='Project Focus']//following::div[@id='list-group-suggestions']/a"));
		int count_projectfocus_dropdown = projectfocus_dropdown.size();
		System.out.println("project focus dropdwon size is" + count_projectfocus_dropdown);
		Thread.sleep(3000);
		for (int y = 0; y < projectfocus_dropdown.size(); y++) {
			System.out.println(projectfocus_dropdown.get(y).getText());
			if (projectfocus_dropdown.get(y).getText().equals("Implementation & Change Management")) {
				projectfocus_dropdown.get(y).click();
				break;
			}
		}

	}

	public void verifyUpdate(ExtentTest test) throws InterruptedException {
		try {
			if (UpdateButton.isDisplayed()) {
				UpdateButton.click();
			} else {
				System.out.println("update button is not displayed");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Staleelementexception found");
		}
		List<WebElement> search_list = driver
				.findElements(By.xpath("//*[contains(@id,'mCSB')]/div/div[2]/div/div/div[1]"));
		int count_searchlist = search_list.size();
		System.out.println("Total rows" + count_searchlist);
		for (int m = 0; m <= count_searchlist; m++) {
			System.out.println("Searchlist text is" + search_list.get(m).getText());

		}

	}

	public void verifyExport(ExtentTest test) {
		if (ExportButton.isDisplayed()) {
			ExportButton.click();
			System.out.println("Data is downloaded to excel");
		} else {
			System.out.println("Export button is not displayed");
		}
	}
}
