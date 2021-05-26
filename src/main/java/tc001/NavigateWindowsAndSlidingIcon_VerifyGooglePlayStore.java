package tc001;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigateWindowsAndSlidingIcon_VerifyGooglePlayStore {

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
		Thread.sleep(3000);
		builder.moveToElement(sliding_icon).click().perform();
		driver.findElementByXPath("//span[text()='Google Play']").click();
		
		//Navigate to new tab
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		System.out.println(tabs.size());
		driver.switchTo().window(tabs.get(1));
	
		Thread.sleep(3000);
		String title = driver.findElementByXPath("//h1[@class='AHFaub']/child::span[text()='SalesforceA']").getText();
		System.out.println(title);
		WebElement install = driver.findElementByXPath("//button[@aria-label='Install']");
		
		if(title.matches("SalesforceA")){
				System.out.println("The text is visible");
		}
		if(install.isEnabled()) {
			System.out.println("The button is enabled");
		}
	}

}
