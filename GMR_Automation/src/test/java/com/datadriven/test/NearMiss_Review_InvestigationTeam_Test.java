package com.datadriven.test;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.NearMiss_Util;

public class NearMiss_Review_InvestigationTeam_Test {
	WebDriver driver;
	
	@BeforeMethod
	public void BMTest () throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/GAURAV/workspace/GMR_Automation/driver/chromedriver.exe");
        driver = new ChromeDriver();
		System.out.println("Launch browser successfully");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://gmrehsonlineuat.azurewebsites.net/Account/Login");
		Thread.sleep(10000);
		  
	}
	@DataProvider
	public Iterator<Object[]> GetTestData()
	{
		
		ArrayList<Object[]>testdata=NearMiss_Util.GetDataFromExcel();
		return testdata.iterator();
		
		
	}
	
	@Test(dataProvider="GetTestData",enabled=true)
	public void NearMiss_Review_InvestigationTeam(String UserName,String Password,String Function,String Agency,String SubLocation,String ExactLocation,String Severity,String Descriptionofwhathappened,String ImmediateContainmentAction,
			String Attachments1,String Attachments2,String Attachments3,String Attachments4,String PlantEHSHeadUsername,String PlantEHSHeadPassword,String Clickonthat,String AuthorizationAction,
			String Comment,String searchemployeename,String InvestigationTeamUsername,String InvestigationTeamPassword,String InvestigationTeamAuthorizationAction,String InvestigationTeamComment,
			String PlantEHSHeadAuthorizationaction,String PlantEHSHeadComment,String ReviewOMHeadUsername,String ReviewOMHeadPassword,String ReviewOMHeadAuthorizationAction,
			String ReviewOMHeadComment,String PlantHEADUsername,String PlantHEADPassword,String PlantHEADAuthorizationaction,String PlantHEADComment) throws InterruptedException, AWTException
	{
		//Enter User name 
		driver.findElement(By.id("txtUserName")).sendKeys(InvestigationTeamUsername);
		Thread.sleep(1000);
		//Enter Password
		driver.findElement(By.id("txtPassword")).sendKeys(InvestigationTeamPassword);
		Thread.sleep(1000);
		//Click on submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(60000);
	
		//Click on that 
		driver.findElement(By.partialLinkText(Clickonthat)).click();
		Thread.sleep(30000);

		
		//New window handle
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		
		for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}	

		driver.navigate().refresh();
		Thread.sleep(15000);
		
		//code to do something on new window
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		//Click on Investigation 
		driver.findElement(By.xpath("//a[@class='st_tab']")).click();
		Thread.sleep(15000);
		
		//scroll down
		jse.executeScript("scroll(0, 250);");
		Thread.sleep(8000);

		//Section B : Investigation
		driver.findElement(By.xpath("//span[contains(text(),'Section B : Investigation')]")).click();
		Thread.sleep(2000);
		
		//Sequential occurrence
		driver.findElement(By.xpath("//textarea[@placeholder='Provide chain of event happend before the incident happens']")).sendKeys("Test Sequential occurrence");
		Thread.sleep(2000);
		
		//Activity of the person(s) /injured at the time of the incident
		driver.findElement(By.xpath("//textarea[@placeholder='Provide details of activity going on at incident time at surrounding location of incident']")).sendKeys("Test Activity of the person");
		Thread.sleep(2000);
		
		//scroll down
		jse.executeScript("scroll(0, 250);");

		//Authorization Action
		Select Authorizationaction = new Select(driver.findElement(By.id("ddlAction")));
		Authorizationaction.selectByVisibleText(InvestigationTeamAuthorizationAction);
		Thread.sleep(2000);
		
		//Comment
		driver.findElement(By.id("txtComment")).sendKeys(InvestigationTeamComment);
		Thread.sleep(1000);
			
		//scroll down
		jse.executeScript("scroll(0, 250);");
		
		//Submit 
		driver.findElement(By.xpath("//button[@class='btn btn-success waves-effect w-md waves-light m-b-5']")).click();
		Thread.sleep(5000);
		
		driver.close(); // close newly opened window when done with it
		driver.switchTo().window(parentHandle); // switch back to the original window

	}
	@AfterMethod
	public void AMTest() throws InterruptedException
	{
		driver.quit();
		System.out.println("Close browser successfully");
	}
}
