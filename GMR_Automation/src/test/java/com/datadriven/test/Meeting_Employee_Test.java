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


import com.test.utility.Meeting_Util;

public class Meeting_Employee_Test {

	
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
		
		ArrayList<Object[]>testdata=Meeting_Util.GetDataFromExcel();
		return testdata.iterator();
		
		
	}
	
	@Test(dataProvider="GetTestData",enabled=true)
	public void Meeting_Employee(String UserName,String Password,String url,String MeetingType,String Function,String MeetingTopic,String DurationHH,String DurationMM,
			String MeetingHost,String Meetingvenue,String Meetingagenda,String Employeename,String Email,String Attach1,String Attach2,String AuthorizationactionCompleted,
			String Comment,String AuthorizationactionPostpone,String Postponecomment,String Authorizationactioncancelled,String cancelledcomment) throws InterruptedException, AWTException
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
		Thread.sleep(10000);
		
		//open Meeting Url
		driver.get(url);
		Thread.sleep(30000);
		
		//Meeting Type 
		Select MeetingType1 = new Select(driver.findElement(By.id("ddlMeetingType")));
		MeetingType1.selectByVisibleText(MeetingType);
		Thread.sleep(2000);
		
		//Function
		Select Function1 = new Select(driver.findElement(By.id("ddlFunctions")));
		Function1.selectByVisibleText(Function);
		Thread.sleep(5000);
		
		//Meeting Topic 
		Select MeetingTopic1 = new Select(driver.findElement(By.id("ddlMeetingTopic")));
		MeetingTopic1.selectByVisibleText(MeetingTopic);
		Thread.sleep(2000);

		//Duration 
		driver.findElement(By.xpath("//timepicker-pop[@id='txtMeetingDuration']//input[@placeholder='HH']")).clear();
		driver.findElement(By.xpath("//timepicker-pop[@id='txtMeetingDuration']//input[@placeholder='HH']")).sendKeys(DurationHH);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//timepicker-pop[@id='txtMeetingDuration']//input[@placeholder='MM']")).clear();
		driver.findElement(By.xpath("//timepicker-pop[@id='txtMeetingDuration']//input[@placeholder='MM']")).sendKeys(DurationMM);
		Thread.sleep(2000);
	
		//Meeting Host 
		driver.findElement(By.id("txtMeetingHost_value")).sendKeys(MeetingHost);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		
		//Meeting Venue 
		Select MeetingVenue =new Select(driver.findElement(By.id("ddlMeetingVenue")));
		MeetingVenue.selectByVisibleText(Meetingvenue);
		Thread.sleep(2000);
				
		//Meeting Agendas
		//Add Meeting agenda 
		driver.findElement(By.xpath("//a[@class='btn btn-primary waves-effect waves-light btn-xs m-t-5 pull-right']")).click();
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("//input[@name='txtCheckListName']")).sendKeys(Meetingagenda);
		Thread.sleep(2000);
		
		//Save 
		driver.findElement(By.xpath("//a[@class='btn btn-icon btn-success btn-xs waves-effect waves-light m-r-5']")).click();
		Thread.sleep(2000);

		//Meeting Attendees
		//Add Participants
		driver.findElement(By.xpath("//button[@id='btnAddEmployee']")).click();
		Thread.sleep(2000);

		//Employee name 
		driver.findElement(By.id("txtVictimName_value")).sendKeys(Employeename);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		
		//Email id 
		driver.findElement(By.xpath("//input[@placeholder='Email Id']")).sendKeys(Email);
		Thread.sleep(4000);
		//save
		driver.findElement(By.xpath("//button[@class='btn btn-icon btn-success btn-xs waves-effect waves-light m-r-5']")).click();
		Thread.sleep(2000);
		
		//Attach file 
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(Attach1);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(Attach2);
		Thread.sleep(2000);
		
		//click on single upload 
		driver.findElement(By.xpath("//tr[1]//td[6]//button[1]//i[1]")).click();
		Thread.sleep(1000);
		
		//click on upload all 
		driver.findElement(By.xpath("//button[@name='btnUploadAll']")).click();
		Thread.sleep(5000);
		
		//Is Meeting Schedule 
		driver.findElement(By.xpath("//label[contains(text(),'Is Meeting Schedule ?')]")).click();
		Thread.sleep(2000);
		
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

