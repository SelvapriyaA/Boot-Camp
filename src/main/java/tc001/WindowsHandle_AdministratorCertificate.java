package tc001;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandle_AdministratorCertificate {

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
		driver.findElementByXPath("//span[text()='Learn More']").click();
		Thread.sleep(3000);
		String mainwindow=driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> it=s1.iterator();
		while(it.hasNext()) {
			String childwindow = it.next();
	
		if(!mainwindow.equalsIgnoreCase(childwindow))
		driver.switchTo().window(childwindow);	
		}
		Actions actions = new Actions(driver);
		WebElement ele = driver.findElementByXPath("//span[text()='Resources']");
		actions.moveToElement(ele).perform();
		driver.findElementByXPath("//a[@href='https://trailhead.salesforce.com/credentials/administratoroverview/']").click();
		String first_tab=driver.getWindowHandle();
		Set<String> s2 = driver.getWindowHandles();
		Iterator<String> it1=s2.iterator();
		while(it1.hasNext()) {
			String childwindow2=it1.next();
		if(!mainwindow.equalsIgnoreCase(childwindow2) && !first_tab.equalsIgnoreCase(childwindow2))
		driver.switchTo().window(childwindow2);
		}
		System.out.println("****List of certificates****");
		List<WebElement> certificationlist= driver.findElementsByXPath("//div[contains(@class,'cs-card')]/child::div[contains(@class,'Fz')]/a[contains(@href,'/credentials/')]");
		for(int i=0;i<certificationlist.size();i++)
			System.out.println(certificationlist.get(i).getText());
		System.out.println();
		
		String administrator = driver.findElementByXPath("//a[@href='/credentials/administrator']").getText(); 
		System.out.println(administrator);
		if(administrator.matches("Administrator"))                                     
				System.out.println("The certificate is available");       
		else{                                                     
			System.out.println("The certificate is not available");
		}
		
		driver.findElementByXPath("//a[text()='Administrator']").click();
		System.out.println();
		System.out.println("****Classes and Workshops****");
		String workshop = driver.findElementByXPath("//*//div[contains(@class,'Maw(50rem)')]/child::div[contains(@class,'cs-box-2')]/ul").getText();
		System.out.println(workshop);
		String title = driver.getTitle();
		System.out.println();
		System.out.println(title);
		
		System.out.println();
		if(title.contains("Administrator"))
			System.out.println("The title matches");
		else {
			System.out.println("The title does not match");
		}
		}
		}




