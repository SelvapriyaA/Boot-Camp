package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pre_PostRequisites {

	
	WebDriver driver;
	@BeforeMethod(alwaysRun=true)
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
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}	
}
