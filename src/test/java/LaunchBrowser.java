import java.io.File;
import java.io.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.ExtentReportCreation;


public class LaunchBrowser {

	public static WebDriver driver;
	public static ExtentReportCreation report=new ExtentReportCreation();
	public static void main(String args[])
	{
		try {} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void verifyBrokenLink(String link,WebDriver driver) throws IOException
	{
	 URL url=new URL(link);
	 HttpURLConnection connect= (HttpURLConnection)url.openConnection();
	 connect.setConnectTimeout(500);
	 connect.connect();
	 if(!(connect.getResponseCode()==200))	
	 {
		 System.out.println("URL is broken");
	 }
	}
	
	public static void CaptureScreennshot() throws IOException
	{
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date dt=new Date();
		String name=dt.toString().replace(":", "_").replace(" ", "_")+".png";
		String destination="src/main/java/Screenshots/"+name;
		FileUtils.copyFile(screenshot,new File( destination));
	}
	
	
}

