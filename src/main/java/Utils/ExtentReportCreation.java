package Utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportCreation {

	 public ExtentTest test;
	 public  ExtentReports extent;
	 public  String path;
    
	public  void createReport(String tc)
	{
	    String dynamicpath=System.getProperty("user.dir");
	    path=dynamicpath+"\\target\\ExtentReport\\";
		extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter(path+tc+"ExtentReport.html");
		extent.attachReporter(spark);
		 test=extent.createTest(tc).assignAuthor("Nanthakumaran").assignCategory("Regression");
		 
	}
	public  void LogPass(String msg) {
	 test.log(Status.PASS, msg);
	}
	
	public  void LogPassScreenshot(String msg,WebDriver driver) throws IOException {
		 String screenshot=TakeScreenshots.CaptureScrennshot( msg, driver,path+"Screenshots/");
		 test.log(Status.PASS, msg,MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
		}
	
	public  void LogFail(String msg) {
		 test.log(Status.FAIL, msg);
		}
	
	public  void LogInfo(String msg) {
		 test.log(Status.INFO, msg);
		}
	
	public  void flushReport()
	{
	 extent.flush();	
	}
}
