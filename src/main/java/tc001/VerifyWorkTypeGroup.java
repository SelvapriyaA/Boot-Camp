package tc001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyWorkTypeGroup {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com");
		driver.findElementById("username").sendKeys("matschie@testleaf.com");
		driver.findElementById("password").sendKeys("India@123");
		driver.findElementById("Login").click();
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		driver.findElementByXPath("//input[@placeholder='Search apps or items...']").sendKeys("Work", Keys.ENTER);
		driver.findElementByXPath("(//p[@class='slds-truncate'])[1]").click();
		Thread.sleep(3000);
		//Store the elements in webtable
		WebElement webtable = driver.findElementByXPath("//table[@data-aura-class='uiVirtualDataTable']");
			List<WebElement> actuallist = webtable.findElements(By.xpath("//tbody/tr/th"));
			System.out.println("Workgroup Names");
		for(int i = 0;i<actuallist.size();i++) {
			System.out.println(actuallist.get(i).getText());
			}
		driver.findElementByXPath("(//div[@class='slds-cell-fixed']/child::a)[1]").click();
		System.out.println("After sorting the workgroup names"); 
		WebElement sortedwebtable = driver.findElementByXPath("//table[@data-aura-class='uiVirtualDataTable']");
		List<WebElement> sortedlist = sortedwebtable.findElements(By.xpath("//tbody/tr/th"));
		System.out.println("Workgroup Names");
	for(int j = 0;j<sortedlist.size();j++) {
		System.out.println(sortedlist.get(j).getText());
		}
	if(actuallist== sortedlist)
		System.out.println("The list is sorted");
	else {
		System.out.println("The list is not sorted");
		}}}


