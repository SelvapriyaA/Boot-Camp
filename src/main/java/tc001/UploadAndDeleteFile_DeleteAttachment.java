package tc001;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadAndDeleteFile_DeleteAttachment {

	public static void main(String[] args) throws InterruptedException, AWTException {
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
		driver.findElementByXPath("(//a[@title='Bootcamp'])[1]").click();
		Thread.sleep(3000);
		/*WebElement upload_file = driver.findElementByXPath("//div[@title='Upload Files']");
		Thread.sleep(3000);
		upload_file.sendKeys("D:\\Priya\\Testleaf\\Upload\\Bootcamp.txt");
		Thread.sleep(3000);
		driver.findElementByXPath("//span[text()='Done']").click(); */
		
		WebElement upload_file = driver.findElementByXPath("//div[@title='Upload Files']");
    	upload_file.click(); 
    	Thread.sleep(2000); 
 
    	// creating object of Robot class
    	Robot rb = new Robot();
 
    	// copying File path to Clipboard
    	StringSelection str = new StringSelection("D:\\Priya\\Testleaf\\Upload\\Bootcamp.txt");
    	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
 
     	// press Contol+V for pasting
     	rb.keyPress(KeyEvent.VK_CONTROL);
     	rb.keyPress(KeyEvent.VK_V);
 
    	// release Contol+V for pasting
    	rb.keyRelease(KeyEvent.VK_CONTROL);
    	rb.keyRelease(KeyEvent.VK_V);
 
    	// for pressing and releasing Enter
    	rb.keyPress(KeyEvent.VK_ENTER);
    	rb.keyRelease(KeyEvent.VK_ENTER); 
    	
    	Thread.sleep(2000); 
    	driver.findElementByXPath("//span[text()='Done']").click();
    	Thread.sleep(3000);
		driver.findElementByXPath("//span[@class='view-all-label']").click();	
		Thread.sleep(3000);
		driver.findElementByXPath("(//a[contains(@class,'rowActionsPlaceHolder')]/child::span[contains(@class,'slds-icon_container')]/span)[17]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//a[@title='Delete' and @role='menuitem'])").click();
		driver.findElementByXPath("//span[text()='Delete' ]").click(); 
		
		String delete = driver.findElementByXPath("//span[contains(@class ,'toastMessage')]").getText();
		System.out.println(delete);
		if(delete.matches("was deleted.")) {
			System.out.println("The record is deleted.");
			}
			else {
				System.out.println("The record is not deleted.");
			}
	}}
