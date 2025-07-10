package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	public static  ExtentTest test;
	public  static String path;
	 public  static ExtentReports extent;
	public ExtentReport(String tc)	
	{
		// Constructor can be used to initialize any required resources
	    String dynamicpath=System.getProperty("user.dir");
	    path=dynamicpath+"\\target\\ExtentReport\\";
	   extent=new ExtentReports();
	   System.out.println("Creating ExtentReport at: " + path+tc+"ExtentReport.html");
		ExtentSparkReporter spark=new ExtentSparkReporter(path+tc+"ExtentReport.html");
		extent.attachReporter(spark);
	}
	
	public static ExtentTest getTest() {
		// Method to return the ExtentTest instance

			return test;
	}
	
	public static void setTest(String tc) {
		// Method to return the ExtentTest instance
		 test=extent.createTest(tc).assignAuthor("Nanthakumaran").assignCategory("Regression");
	}
	
	
	public static String getReportPath() {
		// Method to return the ExtentTest instance
		return path;
	}

	public  void flushReport()
	{
	 extent.flush();	
	}
}
