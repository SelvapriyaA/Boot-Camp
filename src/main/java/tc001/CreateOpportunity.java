package tc001;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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
		driver.findElementByXPath("//p[text()='Sales']").click();
		Thread.sleep(3000);
		driver.executeScript("arguments[0].click();",driver.findElementByXPath("//span[text()='Opportunities']"));
		driver.findElementByXPath("//div[text()='New']").click();
		WebElement name = driver.findElementByXPath("//input[@name='Name']");
		name.sendKeys("Salesforce Automation by Priya");
		driver.findElementByXPath("//input[@name='CloseDate']").sendKeys("5/8/2021");
		driver.findElementByXPath("(//input[@aria-haspopup='listbox'])[3]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//lightning-base-combobox-item[@data-value= 'Needs Analysis']").click();
		driver.findElementByXPath("//button[@name= 'SaveEdit']").click();
		String opp = driver.findElementByXPath("//a[@title ='Salesforce Automation by Priya']").getText();
		System.out.println(opp);
		if(opp.equals("Salesforce Automation by Priya")) {
			System.out.println("The name is correct and verified");
			}
			else {
				System.out.println("The name does not match");
			}
	}
}

