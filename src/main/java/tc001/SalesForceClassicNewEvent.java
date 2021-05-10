package tc001;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceClassicNewEvent {

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
		Thread.sleep(3000);
		driver.findElementByXPath("//div[@data-aura-class='forceEntityIcon'][1]").click();
		driver.findElementByXPath("//a[text()='Switch to Salesforce Classic']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//li[@id='Dashboard_Tab']").click();
		driver.findElementByXPath("//a[text()='Go to Dashboard List']").click();
		driver.findElementByXPath("//input[@title='New Dashboard...']").click();
		List<WebElement> columnsize = driver.findElementsByXPath("//button[text()= 'Medium']");
		for(WebElement medium : columnsize)
			medium.click();
		driver.findElementByXPath("(//span[text()='Wide'])[3]").click(); 
		Actions builder = new Actions(driver);
		WebElement drag = driver.findElementByXPath("//img[@alt='Pie Chart']");
		WebElement drop = driver.findElementByXPath("//*[@id=\"ext-gen137\"]");
		builder.dragAndDrop(drag, drop).perform();
		
		

	}

}
