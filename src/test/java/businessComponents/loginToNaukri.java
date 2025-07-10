package businessComponents;

import Utils.PropertiesConfig;
import coreComponents.coreComponents;
import frameWork.webDriverManager;

import java.io.IOException;
import java.sql.Date;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.NaukriPageObjects;

public class loginToNaukri extends coreComponents {
	static WebDriverWait wait;
	public void login(WebDriver driver) throws IOException
	{
	 try {
		 wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NaukriPageObjects.Login_btn)));		
		 String username=( PropertiesConfig.getProperty("username"));
		 String password=( PropertiesConfig.getProperty("password"));
		 Click(driver, NaukriPageObjects.Login_btn);
		 sendKeys(driver, NaukriPageObjects.Username_input, username);
		 sendKeys(driver, NaukriPageObjects.Password_input, password);
		 Click(driver, NaukriPageObjects.LoginPrimary_btn);
		 if(getElements(driver, NaukriPageObjects.ChatBotClose_btn).size()>0)
		 {
			
			 javascriptClick(driver, NaukriPageObjects.ChatBotClose_btn);
			 System.out.println("Chat bot closed");
		 }
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NaukriPageObjects.Viewprofile_btn)));	
		 LogPassScreenshot("Login Successfull", driver);
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Exception in login "+e.toString());
		LogPassScreenshot(" login failed", driver);	
	}
	}
	
	public void updateHeadline(WebDriver driver) throws IOException
	{
	 try {
		 String newcontent=( PropertiesConfig.getProperty("newcontent"));
		 
		 Click(driver, NaukriPageObjects.Viewprofile_btn);
		 Thread.sleep(2000);
		 waitFor(driver,NaukriPageObjects.Profilename_hdr);
		 Thread.sleep(2000);
		 javascriptClick(driver, NaukriPageObjects.EditResumehead_btn);
		 Thread.sleep(2000);
		 waitFor(driver, NaukriPageObjects.Resumehead_txt);
		 Thread.sleep(2000);
		 String old=getText(driver, NaukriPageObjects.Resumehead_txt);
		 if(old.equals(newcontent))
		 {
			 newcontent=( PropertiesConfig.getProperty("newcontentalt"));
		 }
		 Thread.sleep(2000);
		 sendKeys(driver, NaukriPageObjects.Resumehead_txt, newcontent);
		 Thread.sleep(2000);
		 Click(driver, NaukriPageObjects.Savehead_btn);
		 Thread.sleep(2000);
		 //Re enter
		 waitFor(driver,NaukriPageObjects.Profilename_hdr);
		 Thread.sleep(2000);
		 javascriptClick(driver, NaukriPageObjects.EditResumehead_btn);
		 Thread.sleep(2000);
		 waitFor(driver, NaukriPageObjects.Resumehead_txt);
		 Thread.sleep(2000);
		 sendKeys(driver, NaukriPageObjects.Resumehead_txt, old);
		 Thread.sleep(2000);
		 Click(driver, NaukriPageObjects.Savehead_btn);
		 Thread.sleep(2000);
		 LogPassScreenshot("Header updated successfully", driver);
		 LogPass(Calendar.getInstance().toString());
	    } catch (Exception e) {
		// TODO: handle exception
		System.out.println("Exception in updateHeadline "+e.toString());
		LogPassScreenshot(" updateHeadline failed", driver);	
	}
	}
}
