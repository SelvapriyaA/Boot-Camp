package TestNG;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdministratorCertification extends BaseClass{

		
	@Test(priority=1, invocationCount =2, threadPoolSize= 2)
	public void logIn() throws InterruptedException {
		
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		System.out.println(tabs.size());
		driver.switchTo().window(tabs.get(1));
		
		Actions actions = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//span[text()='Resources']"));
		actions.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[@href='https://trailhead.salesforce.com/credentials/administratoroverview/']")).click();
		
		ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
		System.out.println(tabs1.size());
		driver.switchTo().window(tabs1.get(2));
		
		System.out.println("****List of certificates****");
		List<WebElement> certificationlist= driver.findElements(By.xpath("//div[contains(@class,'cs-card')]/child::div[contains(@class,'Fz')]/a[contains(@href,'/credentials/')]"));
		for(int i=0;i<certificationlist.size();i++)
			System.out.println(certificationlist.get(i).getText());
		System.out.println();
		
		Thread.sleep(3000);
		String administrator = driver.findElement(By.xpath("//a[@href='/credentials/administrator']")).getText(); 
		System.out.println(administrator);
		Assert.assertEquals(administrator, "Administrator");
		
		driver.findElement(By.xpath("//a[text()='Administrator']")).click();
		System.out.println();
		System.out.println("****Classes and Workshops****");
		String workshop = driver.findElement(By.xpath("//*//div[contains(@class,'Maw(50rem)')]/child::div[contains(@class,'cs-box-2')]/ul")).getText();
		System.out.println(workshop);
		
		Thread.sleep(3000);
		System.out.println();
		String title = driver.getTitle();
		System.out.println(title);
		
		
		Assert.assertEquals(title, "Certification - Administrator");
	}
	
	
	
}
