import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.ExtentReportCreation;

public class BeforeAfterMethodsTest {

  @BeforeMethod
  public void beforeMethodTest() {	  
	  ChromeOptions cp=new ChromeOptions();
		cp.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		//cp.addArguments("--headless");
		//driver=new ChromeDriver(cp);
  }
}
