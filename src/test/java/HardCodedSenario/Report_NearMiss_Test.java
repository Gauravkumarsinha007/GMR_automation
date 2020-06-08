package HardCodedSenario;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Report_NearMiss_Test {
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
		
		@Test(priority=1,enabled=false)
		public void Report_NearMiss_Employee() throws InterruptedException, AWTException
		{
			
			Robot robot = new Robot();

			//Enter User name 
			driver.findElement(By.id("txtUserName")).sendKeys("gaurav007");
			Thread.sleep(1000);
			//Enter Password
			driver.findElement(By.id("txtPassword")).sendKeys("admin");
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
			driver.findElement(By.id("txtFunction_value")).sendKeys("Boiler Maintenance");
			Thread.sleep(5000);
			
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(2000);

			//Agency/Sub-Agency
			driver.findElement(By.id("txtAgency_value")).sendKeys("SV Logistics");
			Thread.sleep(5000);
			
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			
			//Location/ Sub-Location 
			driver.findElement(By.id("txtLocation_value")).sendKeys("Boiler 1-W");
			Thread.sleep(5000);
			
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(2000);

			//Exact Location
			driver.findElement(By.xpath("//input[@placeholder='Exact Location']")).sendKeys("Test Location");
			Thread.sleep(2000);

			//Severity
			Select Severity = new Select(driver.findElement(By.id("ddlSeverityType")));
			Severity.selectByVisibleText("Medium");
			Thread.sleep(2000);
			
			//Description of what happened
			driver.findElement(By.id("txtDescription")).sendKeys("Test Desc for AT For Near Miss Using script");
			Thread.sleep(1000);
			
			//Immediate/Containment Action Taken (Also mention who visited site first and what action was proposed by him? if applicable)
			driver.findElement(By.xpath("//textarea[@ng-model='incidentFIRDetail.ImmediateAction']")).sendKeys("Tets Action Now");
			Thread.sleep(1000);

			//Attachments
			driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\GAURAV\\workspace\\Vguard_Automation\\Images\\Image.jpg");
			driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\GAURAV\\workspace\\Vguard_Automation\\Images\\CeilingFan.jpg");
			driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\GAURAV\\workspace\\Vguard_Automation\\Images\\Electric panel room.jpg");
			driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\GAURAV\\workspace\\Vguard_Automation\\Images\\unsafe.jpg");
			
			//click on single upload 
			driver.findElement(By.xpath("//tr[1]//td[6]//button[1]//i[1]")).click();
			Thread.sleep(1000);
			
			//click on upload all 
			driver.findElement(By.xpath("//button[@name='btnUploadAll']")).click();
			Thread.sleep(5000);

			//Save as draft
//			driver.findElement(By.xpath("//button[@class='btn btn-warning m-b-5 ng-scope']")).click();
//			Thread.sleep(1000);
			
			//Submit
			driver.findElement(By.xpath("//button[@class='btn btn-success waves-effect w-md waves-light m-b-5']")).click();
			Thread.sleep(10000);
			
		}
		
		@Test(priority=2,enabled=false)
		public void NearMiss_Review_PlantEHSHead() throws InterruptedException, AWTException
		{
			//Enter User name 
			driver.findElement(By.id("txtUserName")).sendKeys("mahesh");
			Thread.sleep(1000);
			//Enter Password
			driver.findElement(By.id("txtPassword")).sendKeys("admin");
			Thread.sleep(1000);
			//Click on submit
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(60000);
			
			//For you Review
			driver.findElement(By.xpath("//div[contains(@class,'lead-statistics relative two bg-warning')]//i[@class='arrow icofont-arrow-right']")).click();
			Thread.sleep(30000);
			//Click on that 
			driver.findElement(By.partialLinkText("GWEL/NM/2020")).click();
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
			Authorizationaction.selectByVisibleText("Send for investigation");
			Thread.sleep(2000);
			
			//Comment
			driver.findElement(By.id("txtComment")).sendKeys("Send for investigation");
			Thread.sleep(3000);

			//Add investigation team member 
			driver.findElement(By.xpath("//button[@class='btn btn-primary waves-effect waves-light btn-xs']")).click();
			Thread.sleep(1000);
			
			//search employee name 
			driver.findElement(By.id("txtInvestigationTeamName_value")).sendKeys("Gaurav Kumar");
			Thread.sleep(2000);
			
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

		
		@Test(priority=3,enabled=true)
		public void NearMiss_Review_InvestigationTeam() throws InterruptedException, AWTException
		{
			//Enter User name 
			driver.findElement(By.id("txtUserName")).sendKeys("gaurav007");
			Thread.sleep(1000);
			//Enter Password
			driver.findElement(By.id("txtPassword")).sendKeys("admin");
			Thread.sleep(1000);
			//Click on submit
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(60000);
		
			//Click on that 
			driver.findElement(By.partialLinkText("GWEL/NM/2020")).click();
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
			Authorizationaction.selectByVisibleText("Investigation Completed & Send for EHS Head Review");
			Thread.sleep(2000);
			
			//Comment
			driver.findElement(By.id("txtComment")).sendKeys("Investigation Completed & Send for EHS Head Review");
			Thread.sleep(1000);
				
			//scroll down
			jse.executeScript("scroll(0, 250);");
			
			//Submit 
			driver.findElement(By.xpath("//button[@class='btn btn-success waves-effect w-md waves-light m-b-5']")).click();
			Thread.sleep(5000);
			
			driver.close(); // close newly opened window when done with it
			driver.switchTo().window(parentHandle); // switch back to the original window
		
		}
		
		@Test(priority=4,enabled=true)
		public void NearMiss_Invstegation_Review_PlantEHSHead() throws InterruptedException, AWTException
		{
			//Enter User name 
			driver.findElement(By.id("txtUserName")).sendKeys("mahesh");
			Thread.sleep(1000);
			//Enter Password
			driver.findElement(By.id("txtPassword")).sendKeys("admin");
			Thread.sleep(8000);
			//Click on submit
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(60000);
			
			//For you Review
			driver.findElement(By.xpath("//div[contains(@class,'lead-statistics relative two bg-warning')]//i[@class='arrow icofont-arrow-right']")).click();
			Thread.sleep(30000);
			//Click on that 
			driver.findElement(By.partialLinkText("GWEL/NM/2020")).click();
			Thread.sleep(20000);
							
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
						
			//Authorization Action
			Select Authorizationaction = new Select(driver.findElement(By.id("ddlAction")));
			Authorizationaction.selectByVisibleText("Send for O&M Review");
			Thread.sleep(2000);
			
			//Comment
			driver.findElement(By.id("txtComment")).sendKeys("Send for O&M Review");
			Thread.sleep(1000);
					
			//Submit 
			driver.findElement(By.xpath("//button[@class='btn btn-success waves-effect w-md waves-light m-b-5']")).click();
			Thread.sleep(5000);
			
			driver.close(); // close newly opened window when done with it
			driver.switchTo().window(parentHandle); // switch back to the original window
			
		}

		@Test(priority=5,enabled=true)
		public void NearMiss_Invstegation_Review_O_M_Head() throws InterruptedException, AWTException
		{
			//Enter User name 
			driver.findElement(By.id("txtUserName")).sendKeys("ravi");
			Thread.sleep(1000);
			//Enter Password
			driver.findElement(By.id("txtPassword")).sendKeys("admin");
			Thread.sleep(1000);
			//Click on submit
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(60000);
			
			//For you Review
			driver.findElement(By.xpath("//div[contains(@class,'lead-statistics relative two bg-warning')]//i[@class='arrow icofont-arrow-right']")).click();
			Thread.sleep(30000);
			//Click on that 
			driver.findElement(By.partialLinkText("GWEL/NM/2020")).click();
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

			//Click on Investigation 
			driver.findElement(By.xpath("//a[@class='st_tab']")).click();
			Thread.sleep(15000);
						
			//scroll down
			jse.executeScript("scroll(0, 250);");
		
			//Authorization Action
			Select Authorizationaction = new Select(driver.findElement(By.id("ddlAction")));
			Authorizationaction.selectByVisibleText("Send for Plant Head review");
			Thread.sleep(5000);
			
			//Comment
			driver.findElement(By.id("txtComment")).sendKeys("Send for Plant Head review");
			Thread.sleep(3000);
					
			//Submit 
			driver.findElement(By.xpath("//button[@class='btn btn-success waves-effect w-md waves-light m-b-5']")).click();
			Thread.sleep(5000);
			
			driver.close(); // close newly opened window when done with it
			driver.switchTo().window(parentHandle); // switch back to the original window
			
		}

		@Test(priority=6,enabled=true)
		public void NearMiss_Invstegation_Review_Plant_HEAD() throws InterruptedException, AWTException
		{
			//Enter User name 
			driver.findElement(By.id("txtUserName")).sendKeys("ankur");
			Thread.sleep(1000);
			//Enter Password
			driver.findElement(By.id("txtPassword")).sendKeys("admin");
			Thread.sleep(1000);
			//Click on submit
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(60000);
			
			//For you Review
			driver.findElement(By.xpath("//div[contains(@class,'lead-statistics relative two bg-warning')]//i[@class='arrow icofont-arrow-right']")).click();
			Thread.sleep(30000);
			//Click on that 
			driver.findElement(By.partialLinkText("GWEL/NM/2020")).click();
			Thread.sleep(20000);
							
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
		
			//Authorization Action
			Select Authorizationaction = new Select(driver.findElement(By.id("ddlAction")));
			Authorizationaction.selectByVisibleText("Completed");
			Thread.sleep(2000);
			
			//Comment
			driver.findElement(By.id("txtComment")).sendKeys("Completed");
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
