package tc001;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceClassicNewEvent {

	public static void main(String[] args) {
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
		driver.findElementByXPath("//div[@data-aura-class='forceEntityIcon'][1]").click();
		driver.findElementByXPath("//a[text()='Switch to Salesforce Classic']").click();
		driver.findElementByXPath("//a[text()='Dashboards']").click();
		driver.findElementByXPath("//a[text()='Go to Dashboard List']").click();
		driver.findElementByXPath("//input[@title='New Dashboard...']").click();
		List<WebElement> columnsize = driver.findElementsByXPath("//button[text()= 'Medium']");
		for(WebElement medium : columnsize)
			medium.click();
		driver.findElementByXPath("//span[text()='Wide']").click(); 
		WebElement drag = driver.findElementByXPath("//img[@alt='Pie Chart']");
		WebElement drop = driver.findElementByXPath("//div[@id='ext-comp-1064']");
		Actions builder = new Actions(driver);
		builder.dragAndDrop(drag, drop);
		
		

	}

}
