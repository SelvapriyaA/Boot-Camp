package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleProgram {
	
	@BeforeSuite //1
	public void setUp() {
		System.out.println("Launch Browser");
		}
	
	@BeforeTest //2
	public void openUrl() {
		System.out.println("Launch url");
		}
	
	@BeforeClass //3
	public void goToMail() {
		System.out.println("Click GMail");
		}
	
	@BeforeMethod (alwaysRun= true) //4
	public void createAccount() {
		System.out.println("Click on SignUp");
		}
	
	@Test(groups= {"a"})  //5
	public void firstname() {
		System.out.println("Enter firstname");
		}
	
	@Test (priority=3,groups= {"a","b"})
	public void reloadPage() {
		System.out.println("Reload Page");
	}
	
	@Test(groups= {"a"},priority= 1)
	public void setProfilePic() {
		System.out.println("Set profile picture");
	}
	
	@Test (groups= {"a"}, priority= 2,threadPoolSize = 2, invocationCount= 2)
	public void deleteProfile() {
		System.out.println("Delete profile");
	}
	
	@Test (groups= {"c"})
	public void signOut() {
		System.out.println("Sign Out");
	}
	
	@AfterMethod(alwaysRun=true) //6
	public void lastname() {
		System.out.println("Enter lastname");
		}
	
	@AfterClass  //7
	public void emailID() {
		System.out.println("Enter EmailID");
		}
	
	@AfterTest //8
	public void retypeEmailID() {
		System.out.println("Retype EmailID");
		}
	
	@AfterSuite //9
	public void submit() {
		System.out.println("Click submit");
		}
}
