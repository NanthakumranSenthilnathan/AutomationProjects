package Utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshots {

	public static String CaptureScrennshot(String msg,WebDriver driver,String path) throws IOException
	{
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date dt=new Date();
		String name=msg.replace(":", "_").replace(" ", "_")+dt.toString().replace(":", "_").replace(" ", "_")+".png";
		String destination=path+name;
		FileUtils.copyFile(screenshot,new File( destination));
		return destination;
	}
}
