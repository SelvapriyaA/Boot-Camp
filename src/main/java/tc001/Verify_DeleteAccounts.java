package tc001;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_DeleteAccounts {

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
		driver.findElementByXPath("//button[text()='View All']").click();
		driver.findElementByXPath("//p[text()='Sales']").click();
		Thread.sleep(3000);
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//span[text()='Accounts']"));	
		WebElement search = driver.findElementByXPath("//input[@name='Account-search-input']");
		search.sendKeys("CITI");
		search.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElementByXPath("//div[@data-aura-class='forceVirtualAction']").click();
		driver.findElementByXPath("//a[@title='Delete']").click();
		driver.findElementByXPath("//span[text()='Delete']").click();
		WebElement search1 = driver.findElementByXPath("//input[@name='Account-search-input']");
		search1.clear();
		search1.sendKeys("CITI", Keys.ENTER);
		Thread.sleep(3000);
		String results = driver.findElementByXPath("//div[contains(@class,'slds-text-align_center')]/p").getText();
		System.out.println(results);
		if(results.matches("No items to display.")){
		System.out.println("The account is deleted");
		}
		else {
			System.out.println("The account is not deleted");
		}
	}
}