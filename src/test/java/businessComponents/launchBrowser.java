package businessComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import coreComponents.coreComponents;


public class launchBrowser extends coreComponents {

	public void getUrl(WebDriver driver,String name, String url) throws IOException {
		initializeReport(name);
		driver.get(url);
		driver.manage().window().maximize();
		LogPassScreenshot(name+" Launched Successfully", driver);
	}
	public void urlLaunch(WebDriver driver) throws IOException {
		driver.manage().window().maximize();
		LogPassScreenshot("Driver Launched Successfully", driver);
	}
}
