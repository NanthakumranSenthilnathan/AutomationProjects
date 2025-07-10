package frameWork;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webDriverManager {
	public  WebDriver driver;
	public webDriverManager(String browserName) {
		// Constructor can be used to initialize WebDriver if needed
	    if(browserName.equals("Chrome"))
	    {
	    driver=new ChromeDriver();
	    }
	    else if(browserName.equals("Firefox"))
	    {
	    	driver=new FirefoxDriver();
	    }
	    else if(browserName.equals("Edge"))
	    {
	    	driver=new EdgeDriver();
	    }
	    else
	    {
	    	System.out.println("Browser not supported");
	    }
	}

	
	public  WebDriver getDriver() {
		return driver;
	}
	
	public void CloseDriver() throws InterruptedException {
		driver.close();
		Thread.sleep(Duration.ofSeconds(5));
	}
}
