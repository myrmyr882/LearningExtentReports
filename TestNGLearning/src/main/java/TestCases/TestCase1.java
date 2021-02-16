package TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TestCase1 {
	
	@BeforeSuite
	public void setUp() {
		System.out.println("BeforeSuite-- setUp");
	}
	@BeforeTest
	public void launchBrowser() {
		System.out.println(" BeforeTest-- launchBrowser");
	}
	@BeforeClass
	public void login() {
		System.out.println("BeforeClass-- login");
	}
	@BeforeMethod
	public void enterUrl() {
		System.out.println(" BeforeMethod--enterUrl");
	}
	@Test
	public void titleTest() {
		System.out.println(" Test-- titleTest");
	}
	@AfterMethod
	public void searchTest() {
		System.out.println(" AfterMethod --searchTest");
	}
	@AfterClass
	public void logout() {
		System.out.println(" AfterClass-- logout");
	}
	@AfterTest
	public void closeBrowser() {
		System.out.println(" AfterTest -- closeBrowser");
	}
	@AfterSuite
	public void deleteAllCookies() {
		System.out.println(" AfterSuite -- deleteAllCookies");
	}
}
