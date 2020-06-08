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

import com.test.utility.EHSObservation_Util;

public class EHS_Observation_CAPAPerson_Test {
	
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
		
		ArrayList<Object[]>testdata=EHSObservation_Util.GetDataFromExcel();
		return testdata.iterator();
		
		
	}
	
	@Test(dataProvider="GetTestData",enabled=true)
	public void EHS_Observation_Review(String UserName,String Password,String Location,String ExactLocation,String ResponsibleFunction,String Agency,String ObservationCategory,
			String NoOfPersons,String ObservationSeverity,String ObservationType,String ObservationDetail,String Attachments1,String Attachments2,String Attachments3,String 
			Attachments4,String ActiontobeTaken,String Responsibility,String Priority,String SectionHeadUserName,String SectionHeadPassword,String Clickonthat,String 
			AuthorizationactionSectionHead,String CommentSectionHead,String CAPAPersonUserName,String CAPAPersonPassword,String ClickonAction,String CAPAPersonAuthorizationAction,
			String capapersonComment,String CAPAReviewDHUsername,String CAPAReviewDHPassword,String CAPAReviewDHAuthorizationaction,String CAPAReviewDHComment) throws InterruptedException, AWTException
	{
		//Enter User name 
		driver.findElement(By.id("txtUserName")).sendKeys(CAPAPersonUserName);
		Thread.sleep(1000);
		//Enter Password
		driver.findElement(By.id("txtPassword")).sendKeys(CAPAPersonPassword);
		Thread.sleep(1000);
		//Click on submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(20000);

		//Click on observation 
		driver.findElement(By.partialLinkText(ClickonAction)).click();
		Thread.sleep(20000);
		
		//New window handle
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}	
		driver.navigate().refresh();
		Thread.sleep(30000);
		//code to do something on new window
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//scroll down
		jse.executeScript("scroll(0, 250);");
		
		//Authorization Action
		Select Authorizationaction = new Select(driver.findElement(By.id("ddlAction")));
		Authorizationaction.selectByVisibleText(CAPAPersonAuthorizationAction);
		Thread.sleep(5000);
	
		//Comment
		driver.findElement(By.id("txtComment")).sendKeys(capapersonComment);
		Thread.sleep(3000);
				
		//Attachments
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(Attachments1);
		Thread.sleep(3000);
			
		//click on upload all 
		driver.findElement(By.xpath("//button[@name='btnUploadAll']")).click();
		Thread.sleep(8000);
				
		//Submit
		driver.findElement(By.xpath("//button[@class='btn btn-success w-md waves-light m-b-5 ng-binding ng-scope waves-effect']")).click();
		Thread.sleep(10000);
		
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
