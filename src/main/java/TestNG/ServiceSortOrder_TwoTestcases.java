package TestNG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceSortOrder_TwoTestcases {
	WebDriver driver;
	@BeforeMethod
	@Parameters({"url", "username", "password"})
	public void slidingIcon(String url, String username, String password) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
		Actions builder = new Actions(driver);
		WebElement sliding_icon= driver.findElement(By.xpath("//button[contains(@class,'rightArrowButton')]"));
		builder.moveToElement(sliding_icon).click().perform();
		Thread.sleep(3000);
		builder.moveToElement(sliding_icon).click().perform();
	}
	
	@Test
	public void servicesName() throws InterruptedException {
		Thread.sleep(3000);
		Actions builder = new Actions(driver);
		WebElement sliding_icon= driver.findElement(By.xpath("//button[contains(@class,'rightArrowButton')]"));builder.moveToElement(sliding_icon).click().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[text()='Get Started'])[7]")).click();
		Thread.sleep(3000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles()); 
		System.out.println(tabs.size()); 
		driver.switchTo().window(tabs.get(1));
		
		driver.findElement(By.xpath("//div[@id='dropdown-list']")).click();
		driver.findElement(By.xpath("//span[@title='Menu Item Three']/p")).click();
		driver.findElement(By.xpath("//a[text()='Services']")).click();
		Thread.sleep(3000);
		List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@class,'slds-card__body')]/child::h2[contains(@class,'f5')]/div/span/span"));
		int a = rows.size();
		System.out.println("Row size:" + a);
		Thread.sleep(3000);
		ArrayList<String> services = new ArrayList<String>();
		for(int i=1; i<=a; i++) {
		String list = driver.findElement(By.xpath("(//div[contains(@class,'slds-card__body')]/child::h2[contains(@class,'f5')]/div/span/span)["+i+"]")).getText();
		System.out.println(list);
		services.add(list);
		
		}
		Thread.sleep(3000);
		Collections.sort(services);
		System.out.println("****List after sorting****");
		List<WebElement> rows1 = driver.findElements(By.xpath("//div[contains(@class,'slds-card__body')]/child::h2[contains(@class,'f5')]/div/span/span"));
		int a1 = rows1.size();
		System.out.println("Row size:" + a1);
		List<String> sortedServices = new ArrayList<String>();
		for(int j=1; j<=a1; j++) {
			String sortedServicesList = driver.findElement(By.xpath("(//div[contains(@class,'slds-card__body')]/child::h2[contains(@class,'f5')]/div/span/span)["+j+"]")).getText();
		System.out.println(sortedServicesList);
		sortedServices.add(sortedServicesList);
		}
		System.out.println("");
		if(services.equals(sortedServices)){
			System.out.println("The list matches");
		}}
		
	@Test(enabled= false)
	public void googlePlayStore() throws InterruptedException {
	driver.findElement(By.xpath("//span[text()='Google Play']")).click();
	
	//Navigate to new tab
	ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
	System.out.println(tabs1.size());
	driver.switchTo().window(tabs1.get(1));

	Thread.sleep(3000);
	String title = driver.findElement(By.xpath("//h1[@class='AHFaub']/child::span[text()='SalesforceA']")).getText();
	System.out.println(title);
	Assert.assertEquals(title, "SalesforceA");
	
	WebElement install = driver.findElement(By.xpath("//button[@aria-label='Install']"));
	if(install.isEnabled()) {
		System.out.println("The button is enabled");
		
	}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
}
}
