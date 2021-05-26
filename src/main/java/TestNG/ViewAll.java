package TestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewAll {

	WebDriver driver;
	
	@Test(groups= {"Workgroup"})
	@Parameters({"url", "username", "password"})
	public void setUp(String url, String username, String password) throws InterruptedException {
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
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(3000);
	}
	
	@Test (groups= {"Sales"})
	public void createOpportunity() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[text()='Opportunities']")));
		driver.findElement(By.xpath("//div[text()='New']")).click();
		WebElement name = driver.findElement(By.xpath("//input[@name='Name']"));
		name.sendKeys("Salesforce Automation by Priya");
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		driver.findElement(By.xpath("(//input[@aria-haspopup='listbox'])[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value= 'Needs Analysis']")).click();
		driver.findElement(By.xpath("//button[@name= 'SaveEdit']")).click();
		String opp = driver.findElement(By.xpath("//a[@title ='Salesforce Automation by Priya']")).getText();
		System.out.println(opp);
	}
	@Test (groups= {"Sales"}, dependsOnMethods= {"createOpportunity"})
	public void deleteAccount() throws InterruptedException {
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Opportunities']")));	
		WebElement search = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		search.sendKeys("Salesforce Automation by Priya");
		search.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@data-aura-class='forceVirtualAction'])[1]")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		
	}
	@Test (groups= {"Workgroup"})
	public void sortNames() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Work", Keys.ENTER);
		driver.findElement(By.xpath("(//p[@class='slds-truncate'])[1]")).click();
		Thread.sleep(3000);
		//Store the elements in webtable
		System.out.println("****Before sorting the workgroup names****"); 
		WebElement webtable = driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']"));
			List<WebElement> actuallist = webtable.findElements(By.xpath("//tbody/tr/th"));
	for(int i = 0;i<actuallist.size();i++) {
			System.out.println(actuallist.get(i).getText());
			}
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='slds-cell-fixed']/child::a)[1]")).click();
		Thread.sleep(3000);
		System.out.println();
		System.out.println("****After sorting the workgroup names****"); 
		WebElement sortedwebtable = driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']"));
		List<WebElement> sortedlist = sortedwebtable.findElements(By.xpath("//tbody/tr/th"));
	for(int j = 0;j<sortedlist.size();j++) {
		System.out.println(sortedlist.get(j).getText());
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();

}}

