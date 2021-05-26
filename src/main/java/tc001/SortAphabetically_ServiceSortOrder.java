package tc001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortAphabetically_ServiceSortOrder {

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
		Actions builder = new Actions(driver);
		WebElement sliding_icon= driver.findElementByXPath("//button[contains(@class,'rightArrowButton')]");
		builder.moveToElement(sliding_icon).click().perform(); 
		Thread.sleep(1000);
		builder.moveToElement(sliding_icon).click().perform();
		Thread.sleep(500);
		builder.moveToElement(sliding_icon).click().perform();
		Thread.sleep(3000);
		driver.findElementByXPath("(//span[text()='Get Started'])[7]").click();
		Thread.sleep(3000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles()); 
		System.out.println(tabs.size()); 
		driver.switchTo().window(tabs.get(1));
		
		driver.findElementByXPath("//div[@id='dropdown-list']").click();
		driver.findElementByXPath("//span[@title='Menu Item Three']/p").click();
		driver.findElementByXPath("//a[text()='Services']").click();
		Thread.sleep(3000);
		List<WebElement> rows = driver.findElementsByXPath("//div[contains(@class,'slds-card__body')]/child::h2[contains(@class,'f5')]/div/span/span");
		int a = rows.size();
		System.out.println("Row size:" + a);
		Thread.sleep(3000);
		ArrayList<String> services = new ArrayList<String>();
		for(int i=1; i<=a; i++) {
		String list = driver.findElementByXPath("(//div[contains(@class,'slds-card__body')]/child::h2[contains(@class,'f5')]/div/span/span)["+i+"]").getText();
		System.out.println(list);
		services.add(list);
		
		}
		Thread.sleep(3000);
		Collections.sort(services);
		System.out.println("****List after sorting****");
		List<WebElement> rows1 = driver.findElementsByXPath("//div[contains(@class,'slds-card__body')]/child::h2[contains(@class,'f5')]/div/span/span");
		int a1 = rows1.size();
		System.out.println("Row size:" + a1);
		List<String> sortedServices = new ArrayList<String>();
		for(int j=1; j<=a1; j++) {
			String sortedServicesList = driver.findElementByXPath("(//div[contains(@class,'slds-card__body')]/child::h2[contains(@class,'f5')]/div/span/span)["+j+"]").getText();
		System.out.println(sortedServicesList);
		sortedServices.add(sortedServicesList);
		}
		System.out.println("");
		if(services.equals(sortedServices)){
			System.out.println("The list matches");
		}
	}
}
