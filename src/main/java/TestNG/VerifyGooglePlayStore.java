package TestNG;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyGooglePlayStore extends BaseClass{
	
	
	
	@Test(priority=2)
	public void servicesName() throws InterruptedException {
		Actions builder = new Actions(driver);
		WebElement sliding_icon= driver.findElement(By.xpath("//button[contains(@class,'rightArrowButton')]"));
		builder.moveToElement(sliding_icon).click().perform();
		Thread.sleep(3000);
		builder.moveToElement(sliding_icon).click().perform();
		Thread.sleep(1000);
		builder.moveToElement(sliding_icon).click().perform();
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
		System.out.println(a);
		List<String> services = new ArrayList<String>();
		for(int i=0; i<services.size(); i++) {
			String list = driver.findElement(By.xpath("//div[contains(@class,'slds-card__body')]/child::h2[contains(@class,'f5')]/div/span/span["+i+"]")).getText();
		System.out.println(list);
		services.add(list);
		}
		Thread.sleep(3000);
		
		List<WebElement> rows1 = driver.findElements(By.xpath("//div[contains(@class,'slds-card__body')]/child::h2[contains(@class,'f5')]/div/span/span"));
		int a1 = rows1.size();
		System.out.println(a1);
		List<String> sortedServices = new ArrayList<String>();
		for(int j=0; j<sortedServices.size(); j++) {
			String sortedServicesList = driver.findElement(By.xpath("//div[contains(@class,'slds-card__body')]/child::h2[contains(@class,'f5')]/div/span/span["+j+"]")).getText();
		System.out.println(sortedServicesList);
		sortedServices.add(sortedServicesList);
		}}
		
	


}