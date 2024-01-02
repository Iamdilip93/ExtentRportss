package extentReport.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

	ExtentReports extent;
	
	@BeforeTest
	public void config() {
		
		//ExtentReports  , ExtentSparkReporter
		
		String path=System.getProperty("user.dir")+ "\\reports\\indexx.html";
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		
	    extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Dilip raut");
		
		
		
		
	}
	
	
	@Test
	public void launchBrowser() throws InterruptedException {
		
		extent.createTest("launchBrowser");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.close();
		extent.flush();
		
	}
	
	
}
