package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import businessComponents.launchBrowser;
import businessComponents.loginToNaukri;
import frameWork.webDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class browserLaunchDefinitions {
   	webDriverManager manager = new webDriverManager("Chrome");
	WebDriver driver=manager.getDriver();
	launchBrowser launch = new launchBrowser();
	loginToNaukri naukri=new loginToNaukri();
	@Given("^Browser launched (.*) and (.*)$")
	public void browser_launched_https_www_amazon_in(String name,String url) throws IOException {
	    System.out.println("Browser launched with name: " + name + " and URL: " + url);
	    launch.getUrl(driver, name, url);
	   
	}
	 
	@When("Login in to the Naukri application")
	public void naukri_login() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		naukri.login(driver);
	}
	
	@Then("Update the Resume Headline")
	public void resume_headline() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		naukri.updateHeadline(driver);
	}

	
	@Then("Browser launched successfully")
	public void browser_launched_successfully() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		launch.urlLaunch(driver);
	}

	
	@And("Close Driver")
	public void close_driver() throws InterruptedException {
		driver.close();
	}

}
