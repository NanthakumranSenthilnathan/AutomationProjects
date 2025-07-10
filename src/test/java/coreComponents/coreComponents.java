package coreComponents;


import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Pages.NaukriPageObjects;
import Utils.ExtentReport;
import Utils.TakeScreenshots;

public class coreComponents {

	public static ExtentTest test;
	public  String path=ExtentReport.getReportPath();
	
	public  void initializeReport(String Tc) {
		ExtentReport.setTest(Tc);
		test=ExtentReport.getTest();
		}
	
	public  void LogPass(String msg) {
		 test.log(Status.PASS, msg);
		}
		
		public  void LogPassScreenshot(String msg,WebDriver driver) throws IOException {
			 String screenshot=TakeScreenshots.CaptureScrennshot( msg, driver,path+"Screenshots\\");
			 test.log(Status.PASS, msg,MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
			}
		
		public  void LogFail(String msg) {
			 test.log(Status.FAIL, msg);
			}
		
		public  void LogInfo(String msg) {
			 test.log(Status.INFO, msg);
			}
		
		public void javascriptClick(WebDriver driver, String locator)
		{
			try {
				 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));	
				 WebElement button = driver.findElement(By.xpath(locator));
			     JavascriptExecutor js = (JavascriptExecutor) driver;
			     js.executeScript("arguments[0].scrollIntoView(true);", button);
			     js.executeScript("arguments[0].click();", button);
			 	System.out.println("Successfully clicked");
			} catch (Exception e) {
				// TODO: handle exceptio
				System.out.println("Exception in javascriptClick "+e.toString());
			}
		}
		
		
		public List<WebElement> getElements(WebDriver driver, String locator)
		{
			List<WebElement> Elements=new ArrayList<WebElement>();
			try {
				Elements=driver.findElements(By.xpath(locator));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception in Click "+e.toString());
			}
		    return Elements;
		}
		
		public void Click(WebDriver driver, String locator)
		{
			try {
				 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));	
				 WebElement button = driver.findElement(By.xpath(locator));
			     button.click();    
			     System.out.println("Successfully clicked");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception in Click "+e.toString());
			}
		}
		
		public void waitFor(WebDriver driver, String locator)
		{
			try {
				 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));	
				 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));	
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception in waitFor "+e.toString());
			}
		}
		
		public String getText(WebDriver driver, String locator)
		{
			String value="";
			try {
				WebElement text = driver.findElement(By.xpath(locator));
				value= text.getText();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception in getText "+e.toString());
			}
			return value;
		}
		
		public void sendKeys(WebDriver driver, String locator,String input)
		{
			try {
				 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));	
				 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
				 WebElement button = driver.findElement(By.xpath(locator));
				 button.click(); 
				 button.clear();
				 button.sendKeys(input); 
				 System.out.println("Entered successfully");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception in sendKeys "+e.toString());
			}
		}
}
