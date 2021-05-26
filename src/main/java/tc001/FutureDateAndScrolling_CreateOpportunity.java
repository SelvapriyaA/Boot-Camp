package tc001;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FutureDateAndScrolling_CreateOpportunity {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com");
		driver.findElementById("username").sendKeys("matschie@testleaf.com");
		driver.findElementById("password").sendKeys("India@123");
		driver.findElementById("Login").click();
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//button[text()='View All']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//p[text()='Content']").click();	
		Thread.sleep(3000);
		driver.findElementByXPath("//span[text()='View All Key Deals']").click();
		driver.findElementByXPath("//a[@title='Select List View']").click();	
		driver.findElementByXPath("(//a[@role='option']/child::span[text()='All Opportunities'])[1]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//div[@title='New']").click();	
		driver.findElementByXPath("//input[@name='Name']").sendKeys("SRM Steels");	
		driver.findElementByXPath("(//input[@aria-haspopup='listbox'])[4]").click();	
		driver.findElementByXPath("//lightning-base-combobox-item[@data-value='New Customer']").click();
		Thread.sleep(3000);
		
		//To scroll down
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement lead =driver.findElementByXPath("(//lightning-combobox[contains(@class,'slds-form-element')]/child::div/lightning-base-combobox/div/div)[5]");
		js.executeScript("arguments[0].scrollIntoView();", lead);
		lead.click();
		driver.findElementByXPath("//lightning-base-combobox-item[@data-value='Partner Referral']").click();	
		driver.findElementByXPath("//input[@name='Amount']").sendKeys("75000");	
		
		//to get current date from system	
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String date1 =dateFormat.format(date);
		System.out.println(date1);
		
		//To choose 20th day of next month
		LocalDate date2 = LocalDate.now().plusMonths(1).minusDays(11);
		String changeformat = date2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(changeformat);
		
		driver.findElementByXPath("//input[@name='CloseDate']").sendKeys(changeformat);
		driver.findElementByXPath("(//input[@aria-haspopup='listbox'])[3]").click();
		driver.findElementByXPath("//lightning-base-combobox-item[@data-value= 'Needs Analysis']").click();
		
		WebElement source = driver.findElementByXPath("(//div[@class='slds-form-element__control']/child::div/lightning-base-combobox)[3]");
		js.executeScript("arguments[0].scrollIntoView();", source);
		source.click();
		driver.findElementByXPath("(//span[@class='slds-media__body']/child::span/span[@class='slds-truncate'])[1]").click();
		driver.findElementByXPath("//button[@name='SaveEdit']").click();
		
		String opp = driver.findElementByXPath("//a[contains(@title,'SRM Steels')]").getText();
		System.out.println(opp);
		if(opp.matches("SRM Steels")) {
			System.out.println("The opportunity is created");
			}
			else {
				System.out.println("The opportunity is not created");
			}
}
}
