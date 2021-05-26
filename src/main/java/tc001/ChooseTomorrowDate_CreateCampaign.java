package tc001;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChooseTomorrowDate_CreateCampaign {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		driver.get("https://login.salesforce.com");
		driver.findElementById("username").sendKeys("matschie@testleaf.com");
		driver.findElementById("password").sendKeys("India@123");
		driver.findElementById("Login").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//button[text()='View All']").click();
		Thread.sleep(3000);
		
		driver.findElementByXPath("//input[@placeholder='Search apps or items...']").sendKeys("Campaigns", Keys.ENTER);
		driver.findElementByXPath("(//p[@class='slds-truncate'])[1]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//div[text()='New']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//label[starts-with(@class,'label')]/following::input)[1]").sendKeys("COVID CAMP");
		String campaignName = driver.findElementByXPath("(//input[@type='text'])[3]").getText();
		System.out.println(campaignName);
		
		//Choose Tomorrow date
		LocalDate tom= LocalDate.now().plusDays(1);
		String format = tom.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		System.out.println(format);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement startdate = driver.findElementByXPath("(//span[text()='Start Date'])[2]");
		js.executeScript("arguments[0].scrollIntoView();", startdate);
		driver.findElementByXPath("(//div[@class='form-element']/input)[1]").sendKeys(format);
		
		//Choose day after tom as end date
		LocalDate dayaftertom= LocalDate.now().plusDays(2);
		String format1 = dayaftertom.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		System.out.println(format1);
		driver.findElementByXPath("(//div[@class='form-element']/input)[2]").sendKeys(format1);
		
		driver.findElementByXPath("//button[@title='Save']").click();
		
		Thread.sleep(3000);
		String campaign = driver.findElementByXPath("//span[contains(@class ,'toastMessage')]").getText();
		System.out.println(campaign);
		if(campaign.matches("was created")) {
			System.out.println("The campaign is created.");
			}
			else {
				System.out.println("The campaign is not created");
			}
	}

}
