package com.datadriven.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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

public class NearMiss_Review_PlantEHSHead_Test {
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
	public void NearMiss_Review_PlantEHSHead(String UserName,String Password,String Function,String Agency,String SubLocation,String ExactLocation,String Severity,String Descriptionofwhathappened,String ImmediateContainmentAction,
			String Attachments1,String Attachments2,String Attachments3,String Attachments4,String PlantEHSHeadUsername,String PlantEHSHeadPassword,String Clickonthat,String AuthorizationAction,
			String Comment,String searchemployeename,String InvestigationTeamUsername,String InvestigationTeamPassword,String InvestigationTeamAuthorizationAction,String InvestigationTeamComment,
			String PlantEHSHeadAuthorizationaction,String PlantEHSHeadComment,String ReviewOMHeadUsername,String ReviewOMHeadPassword,String ReviewOMHeadAuthorizationAction,
			String ReviewOMHeadComment,String PlantHEADUsername,String PlantHEADPassword,String PlantHEADAuthorizationaction,String PlantHEADComment) throws InterruptedException, AWTException
	{
		//Enter User name 
		driver.findElement(By.id("txtUserName")).sendKeys(PlantEHSHeadUsername);
		Thread.sleep(1000);
		//Enter Password
		driver.findElement(By.id("txtPassword")).sendKeys(PlantHEADPassword);
		Thread.sleep(1000);
		//Click on submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(60000);
		
		//For you Review
		driver.findElement(By.xpath("//div[contains(@class,'lead-statistics relative two bg-warning')]//i[@class='arrow icofont-arrow-right']")).click();
		Thread.sleep(30000);
		//Click on that 
		driver.findElement(By.partialLinkText(Clickonthat)).click();
		Thread.sleep(25000);
						
		//New window handle
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}	
		
		driver.navigate().refresh();
		Thread.sleep(15000);
		
		//code to do something on new window
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//scroll down
		jse.executeScript("scroll(0, 250);");
		
		
		//Authorization Action
		Select Authorizationaction = new Select(driver.findElement(By.id("ddlAction")));
		Authorizationaction.selectByVisibleText(AuthorizationAction);
		Thread.sleep(2000);
		
		//Comment
		driver.findElement(By.id("txtComment")).sendKeys(Comment);
		Thread.sleep(3000);

		//Add investigation team member 
		driver.findElement(By.xpath("//button[@class='btn btn-primary waves-effect waves-light btn-xs']")).click();
		Thread.sleep(1000);
		
		//search employee name 
		driver.findElement(By.id("txtInvestigationTeamName_value")).sendKeys(searchemployeename);
		Thread.sleep(5000);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		
		//save 
		driver.findElement(By.xpath("//button[@class='btn btn-icon btn-success btn-xs waves-effect waves-light m-r-5']")).click();
		Thread.sleep(2000);
		
		//scroll down
		jse.executeScript("scroll(0, 250);");
		
		//Submit 
		driver.findElement(By.xpath("//button[@class='btn btn-success waves-effect w-md waves-light m-b-5']")).click();
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
