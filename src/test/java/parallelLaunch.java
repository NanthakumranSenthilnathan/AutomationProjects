import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utils.ExtentReportCreation;

@org.testng.annotations.Test
public class parallelLaunch {
	public static WebDriver driver;
	public static ExtentReportCreation extentReportCreation2= new ExtentReportCreation();
	
	@Test
	public void parallelLaunch1()
	{
	
		try {
	    extentReportCreation2.createReport("FirstTc");		
		ChromeOptions cp=new ChromeOptions();
	//	cp.setBinary("D:\\Automation\\Selenium Automation\\Drivers\\chrome-win64\\chrome-win64\\chrome.exe");
		cp.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		//cp.addArguments("--headless");
		driver=new ChromeDriver(cp);
		extentReportCreation2.LogInfo("Test initialised");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.get("https://www.amazon.in");
		js.executeScript("alert('launched');");
		driver.manage().window().maximize();
		String inputBox="//input[@id='twotabsearchtextbox']";
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		extentReportCreation2.LogPassScreenshot("URL Launch Success", driver);
		/*
		WebElement element = fluentWait.until(new Function<WebDriver, WebElement>() {
		    public WebElement apply(WebDriver driver) {
		        return driver.findElement(By.xpath(inputBox));
		    }
		});
		*/
		fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(inputBox)));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement el=wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(inputBox))));
		el.click();
		extentReportCreation2.LogPassScreenshot("Clicked", driver);
		el.sendKeys("Laptop");
		el.sendKeys(Keys.ENTER);
		Thread.sleep(Duration.ofSeconds(2));
		extentReportCreation2.LogPassScreenshot("Searched", driver);
		//driver.navigate().back();
		extentReportCreation2.LogPassScreenshot("Back to Home Page", driver);
		System.out.println("Testing Done");
		extentReportCreation2.flushReport();
		driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
