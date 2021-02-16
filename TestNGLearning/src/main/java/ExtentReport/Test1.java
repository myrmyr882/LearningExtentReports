package ExtentReport;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Test1 {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setReport() {
		htmlReporter = new ExtentHtmlReporter("./reports/extent.html");
		
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Learning TestNG - extent report");
		htmlReporter.config().setReportName("Basic reports");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Automation Tester","Yeshwanth");
		extent.setSystemInfo("Organization","testing company");
		
	}
	@Test
	public void setUp() {
		test = extent.createTest("starting");
		System.out.println("Inside printout of method set");
	}
	@Test
	public void launchBrowser() {
		test = extent.createTest("launch Browser");
		Assert.fail(" Fail-- launchBrowser");
		//System.out.println("Inside printout of method launch");
	}
	@Test
	public void isSkip() {
		test = extent.createTest("Skip test");

		throw new SkipException("-- Skip method");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			String methodName = result.getMethod().getMethodName();
			String logText = "<b>"+ "TEST CASE : - " + methodName.toUpperCase()+ "PASSED" +"</b>";

			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			test.fail(m);
		
	}else if(result.getStatus() == ITestResult.SKIP) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>"+ "TEST CASE : - " + methodName.toUpperCase()+ "PASSED" +"</b>";

		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		test.skip(m);
	}else if (result.getStatus() == ITestResult.SUCCESS) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>"+ "TEST CASE : - " + methodName.toUpperCase()+ "PASSED" +"</b>";

		Markup m = MarkupHelper.createLabel(logText, ExtentColor.TEAL);
		test.pass(m);
		}
	}
	@AfterTest
	public void endReport() {
		extent.flush();
	}
	
	
}
