package stepDefinitions;


import Utils.ExtentReport;
import Utils.PropertiesConfig;
import frameWork.webDriverManager;

public class cukeHookSteps {
	 webDriverManager driverManager;
	 ExtentReport extentReport;
	 PropertiesConfig propertiesConfig;
	 
	@io.cucumber.java.Before
	public void beforeScenario() {
		System.out.println("Before Scenario: Setting up preconditions.");
		extentReport = new ExtentReport("TestScenario");
		propertiesConfig=new PropertiesConfig();
	}
	
	@io.cucumber.java.After
	public void afterScenario() throws InterruptedException {
		System.out.println("After Scenario: Cleaning up postconditions.");
		extentReport.flushReport();
	}
	
}
