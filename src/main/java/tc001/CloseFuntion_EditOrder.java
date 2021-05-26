package tc001;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CloseFuntion_EditOrder {

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
		Thread.sleep(3000);
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//button[text()='View All']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//p[text()='Service Console']").click();
		driver.findElementByXPath("//button[@title='Show Navigation Menu']/child::lightning-primitive-icon").click();
		driver.findElementByXPath("//span[@class='slds-media__body']/span[text()='Orders']").click();
		driver.findElementByXPath("(//lightning-icon[@data-aura-class='forceIcon']/child::lightning-primitive-icon)[6]").click();
		driver.findElementByXPath("//span[text()='All Orders']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//a[contains(@class,'rowActionsPlaceHolder')]/child::span[contains(@class,'slds-icon_container')]/span)[1]").click();
		driver.findElementByXPath("//a[@title='Edit']").click();
		driver.findElementByXPath("(//span[@class='deleteIcon'])[2]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//div[@title='Orange']").click();
		driver.findElementByXPath("(//span[@class='deleteIcon'])[1]").click();
		driver.findElementByXPath("//div[@title='00000401']").click();
		driver.findElementByXPath("(//span[text()='Save'])[3]").click();
	}}
