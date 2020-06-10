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

import com.test.utility.Incident_Util;

public class Incident_Invstegation_Review_Plant_HEAD_Test {
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
		
		ArrayList<Object[]>testdata=Incident_Util.GetDataFromExcel();
		return testdata.iterator();
		
		
	}
	
	@Test(dataProvider="GetTestData",enabled=true)
	public void Incident_Invstegation_Review_Plant_HEAD(String Username,String Password,String Function,String Agency,String SubLocation,String Shift,String ExactLocation,String Descriptionofwhathappened,
			String ImmediateContainmentAction,String Employee,String Name,String Age,String DepartmentOP,String Gender,String Attachments1,String Attachments2,String Attachments3,
			String Attachments4,String HODUsername,String HODPassword,String Clickonthat,String AuthorizationAction,String Comment,String PlantEHSHeadUsername,String PlantEHSHeadPassword,
			String AuthorizationActionPlantEHSHead,String CommentPlantEHSHead,String searchemployee,String InvestigationTeamUsername,String InvestigationTeamPassword,String TypeofInjury,
			String NatureofInjury,String AuthorizationActionInvestigationTeam,String CommentInvestigationTeam,String PlantEHSHUsername,String PlantEHSHPassword,String AuthorizationActionPlantEHSH,
			String CommentPlantEHSH,String InvstegationOMHeadUsername,String InvstegationOMHeadPassword,String AuthorizationActionInvstegationOMHead,String InvstegationOMHeadComment,
			String InvstegationPlantHEADUsername,String InvstegationPlantHEADPassword,String Actiontobetaken,String Responsibility,String Priority,String AuthorizationActionInvstegationPlantHEAD,
			String InvstegationPlantHEADComment) throws InterruptedException, AWTException
	{
		//Enter User name 
		driver.findElement(By.id("txtUserName")).sendKeys(InvstegationPlantHEADUsername);
		Thread.sleep(1000);
		//Enter Password
		driver.findElement(By.id("txtPassword")).sendKeys(InvstegationPlantHEADPassword);
		Thread.sleep(1000);
		//Click on submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(60000);
		
		//For you Review
		driver.findElement(By.xpath("//div[contains(@class,'lead-statistics relative two bg-warning')]//i[@class='arrow icofont-arrow-right']")).click();
		Thread.sleep(30000);
		//Click on that 
		driver.findElement(By.partialLinkText(Clickonthat)).click();
		Thread.sleep(20000);
						
		//New window handle
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}	
		driver.navigate().refresh();
		Thread.sleep(35000);
	
		//code to do something on new window
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		//Click on Investigation 
		driver.findElement(By.xpath("//a[@class='st_tab']")).click();
		Thread.sleep(15000);
					
		//scroll down
		jse.executeScript("scroll(0, 250);");
	
			//Section F : IMPROVE & CONTROL (Recommendation(s))
			driver.findElement(By.xpath("//span[contains(text(),'Section F : IMPROVE & CONTROL (Recommendation(s))')]")).click();
			Thread.sleep(1000);
			
			//Add Action to be Taken
			driver.findElement(By.xpath("//button[@id='btnAddCAPA300']")).click();
			Thread.sleep(1000);
			
			//Action to be taken 
			driver.findElement(By.xpath("//textarea[@name='txtTaskDescription']")).sendKeys(Actiontobetaken);
			Thread.sleep(1000);
			
			//Responsibility 
			driver.findElement(By.xpath("//input[@name='txtResponsible']")).sendKeys(Responsibility);
			Thread.sleep(2000);
			
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(5000);
			
			//Priority
			Select priority = new Select(driver.findElement(By.xpath("//select[@name='ddlTaskPriority']")));
			priority.selectByVisibleText(Priority);
			Thread.sleep(5000);
			
			//Save CAPA
			driver.findElement(By.xpath("//button[@ng-click='SaveCapa(frmAddTask,taskToAdd,taskToAdd.responsibleAdd,reviewerAdd,addOptions,txtResponsibleId,txtReviewerId);']")).click();
			Thread.sleep(10000);

			//scroll down
			jse.executeScript("scroll(0, 250);");
		
		//Authorization Action
		Select Authorizationaction = new Select(driver.findElement(By.id("ddlAction")));
		Authorizationaction.selectByVisibleText(AuthorizationActionInvstegationPlantHEAD);
		Thread.sleep(2000);
		
		//Comment
		driver.findElement(By.id("txtComment")).sendKeys(InvstegationPlantHEADComment);
		Thread.sleep(1000);
				
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
