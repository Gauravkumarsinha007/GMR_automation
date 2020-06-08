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

import com.test.utility.EHSObservation_Util;

public class EHS_Observation_Test {

	
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
	public void EHS_Observation(String UserName,String Password,String Location,String ExactLocation,String ResponsibleFunction,String Agency,String ObservationCategory,
			String NoOfPersons,String ObservationSeverity,String ObservationType,String ObservationDetail,String Attachments1,String Attachments2,String Attachments3,String 
			Attachments4,String ActiontobeTaken,String Responsibility,String Priority,String SectionHeadUserName,String SectionHeadPassword,String Clickonthat,String 
			AuthorizationactionSectionHead,String CommentSectionHead,String CAPAPersonUserName,String CAPAPersonPassword,String ClickonAction,String CAPAPersonAuthorizationAction,
			String capapersonComment,String CAPAReviewDHUsername,String CAPAReviewDHPassword,String CAPAReviewDHAuthorizationaction,String CAPAReviewDHComment) throws InterruptedException, AWTException
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
		//EHS Observation side bar 
		driver.findElement(By.xpath("//span[text()='EHS Observation']")).click();
		Thread.sleep(1000);
		
		//Report EHS Observation 
		driver.findElement(By.xpath("//span[text()='Report EHS Observation']")).click();
		Thread.sleep(10000);
	
		//Location/SubLocation 
		driver.findElement(By.id("txtLocation_value")).sendKeys(Location);
		Thread.sleep(6000);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		//Exact Location
		driver.findElement(By.id("txtExactLocation")).sendKeys(ExactLocation);
		Thread.sleep(2000);

		//Responsible Function 
		driver.findElement(By.id("txtFunction_value")).sendKeys(ResponsibleFunction);
		Thread.sleep(6000);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		//Agency
		driver.findElement(By.id("txtAgency_value")).sendKeys(Agency);
		Thread.sleep(2000);

		//Observation Category
		Select ObservationCategory1 = new Select(driver.findElement(By.xpath("//select[@name='ddlObservationType']")));
		ObservationCategory1.selectByVisibleText(ObservationCategory);
		Thread.sleep(1000);
	
		//No Of Persons
		driver.findElement(By.id("txtNoOfPerson")).sendKeys(NoOfPersons);
		Thread.sleep(1000);
		
		//Observation Severity
		Select ObservationSeverity1 = new Select(driver.findElement(By.xpath("//select[@name='ddlInjuryPotential1']")));
		ObservationSeverity1.selectByVisibleText(ObservationSeverity);
		Thread.sleep(1000);
		
		//Observation Type 
		Select ObservationType1 = new Select(driver.findElement(By.xpath("//select[@name='ddlObservationCategory']")));
		ObservationType1.selectByVisibleText(ObservationType);
		Thread.sleep(1000);
		
		//Observation Detail
		driver.findElement(By.id("txtRemarks")).sendKeys(ObservationDetail);
		Thread.sleep(1000);

		//Attachments
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(Attachments1);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(Attachments2);
		//driver.findElement(By.xpath("//input[@type='file']")).sendKeys(Attachments3);
		//driver.findElement(By.xpath("//input[@type='file']")).sendKeys(Attachments4);

		//click on single upload 
		driver.findElement(By.xpath("//tr[1]//td[6]//button[1]//i[1]")).click();
		Thread.sleep(8000);
		
		//click on upload all 
		driver.findElement(By.xpath("//button[@name='btnUploadAll']")).click();
		Thread.sleep(20000);
		
		//Add Action to be Taken
		driver.findElement(By.xpath("//button[@title='Add Action to be Taken']")).click();
		Thread.sleep(2000);
		
		//Action to be Taken 
		driver.findElement(By.xpath("//textarea[@name='txtTaskDescription']")).sendKeys(ActiontobeTaken);
		Thread.sleep(2000);
		
		//Responsibility 
		driver.findElement(By.xpath("//input[@name='txtResponsible']")).sendKeys(Responsibility);
		Thread.sleep(7000);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		
		//Priority
		Select priority = new Select(driver.findElement(By.xpath("//select[@name='ddlTaskPriority']")));
		priority.selectByVisibleText(Priority);
		Thread.sleep(2000);
		
		//Save CAPA
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		Thread.sleep(4000);

		
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
