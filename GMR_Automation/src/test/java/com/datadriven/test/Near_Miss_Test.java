package com.datadriven.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.NearMiss_Util;

public class Near_Miss_Test {


	
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
	public void Report_NearMiss_Employee(String UserName,String Password,String Function,String Agency,String SubLocation,String ExactLocation,String Severity,String Descriptionofwhathappened,String ImmediateContainmentAction,
			String Attachments1,String Attachments2,String Attachments3,String Attachments4,String PlantEHSHeadUsername,String PlantEHSHeadPassword,String Clickonthat,String AuthorizationAction,
			String Comment,String searchemployeename,String InvestigationTeamUsername,String InvestigationTeamPassword,String InvestigationTeamAuthorizationAction,String InvestigationTeamComment,
			String PlantEHSHeadAuthorizationaction,String PlantEHSHeadComment,String ReviewOMHeadUsername,String ReviewOMHeadPassword,String ReviewOMHeadAuthorizationAction,
			String ReviewOMHeadComment,String PlantHEADUsername,String PlantHEADPassword,String PlantHEADAuthorizationaction,String PlantHEADComment) throws InterruptedException, AWTException
	{
		Robot robot = new Robot();

		//Enter User name 
		driver.findElement(By.id("txtUserName")).sendKeys(UserName);
		Thread.sleep(1000);
		//Enter Password
		driver.findElement(By.id("txtPassword")).sendKeys(Password);
		Thread.sleep(1000);
		//Click on submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(30000);
		
		//click on side bar
		driver.findElement(By.xpath("//a[@class='nav-link toggleMenubar']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnBack")).click();
		Thread.sleep(1000);
		//Incident side bar 
		driver.findElement(By.xpath("//span[@class='site-menu-title'][text()='Near Miss']")).click();
		Thread.sleep(1000);
		
		//Report Incident
		driver.findElement(By.xpath("//span[text()='Report Near Miss']")).click();
		Thread.sleep(10000);

		
		//Function/Sub-Function 
		driver.findElement(By.id("txtFunction_value")).sendKeys(Function);
		Thread.sleep(5000);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		//Agency/Sub-Agency
		driver.findElement(By.id("txtAgency_value")).sendKeys(Agency);
		Thread.sleep(5000);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		
		//Location/ Sub-Location 
		driver.findElement(By.id("txtLocation_value")).sendKeys(SubLocation);
		Thread.sleep(5000);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		//Exact Location
		driver.findElement(By.xpath("//input[@placeholder='Exact Location']")).sendKeys(ExactLocation);
		Thread.sleep(2000);

		//Severity
		Select Severity1 = new Select(driver.findElement(By.id("ddlSeverityType")));
		Severity1.selectByVisibleText(Severity);
		Thread.sleep(2000);
		
		//Description of what happened
		driver.findElement(By.id("txtDescription")).sendKeys(Descriptionofwhathappened);
		Thread.sleep(1000);
		
		//Immediate/Containment Action Taken (Also mention who visited site first and what action was proposed by him? if applicable)
		driver.findElement(By.xpath("//textarea[@ng-model='incidentFIRDetail.ImmediateAction']")).sendKeys(ImmediateContainmentAction);
		Thread.sleep(1000);

		//Attachments
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(Attachments1);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(Attachments2);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(Attachments3);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(Attachments4);
		
		//click on single upload 
		driver.findElement(By.xpath("//tr[1]//td[6]//button[1]//i[1]")).click();
		Thread.sleep(1000);
		
		//click on upload all 
		driver.findElement(By.xpath("//button[@name='btnUploadAll']")).click();
		Thread.sleep(5000);

		//Save as draft
//		driver.findElement(By.xpath("//button[@class='btn btn-warning m-b-5 ng-scope']")).click();
//		Thread.sleep(1000);
		
		//Submit
		driver.findElement(By.xpath("//button[@class='btn btn-success waves-effect w-md waves-light m-b-5']")).click();
		Thread.sleep(10000);

		
	}

	@AfterMethod
	public void AMTest() throws InterruptedException
	{
		driver.quit();
		System.out.println("Close browser successfully");
	}
	
}
