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
	
	@Test(priority=1,enabled=false)
	public void EHS_ObserVation_Report_Employee() throws InterruptedException, AWTException
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
		//EHS Observation side bar 
		driver.findElement(By.xpath("//span[text()='EHS Observation']")).click();
		Thread.sleep(1000);
		
		//Report EHS Observation 
		driver.findElement(By.xpath("//span[text()='Report EHS Observation']")).click();
		Thread.sleep(10000);
	
		//Location/SubLocation 
		driver.findElement(By.id("txtLocation_value")).sendKeys("Boiler 1-W");
		Thread.sleep(6000);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		//Exact Location
		driver.findElement(By.id("txtExactLocation")).sendKeys("Test");
		Thread.sleep(2000);

		//Responsible Function 
		driver.findElement(By.id("txtFunction_value")).sendKeys("Boiler Maintenance");
		Thread.sleep(6000);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		//Agency
		driver.findElement(By.id("txtAgency_value")).sendKeys("Test Agency");
		Thread.sleep(2000);

		//Observation Category
		Select ObservationCategory = new Select(driver.findElement(By.xpath("//select[@name='ddlObservationType']")));
		ObservationCategory.selectByVisibleText("Un-Safe Condition");
		Thread.sleep(1000);
	
		//No Of Persons
		driver.findElement(By.id("txtNoOfPerson")).sendKeys("10");
		Thread.sleep(1000);
		
		//Observation Severity
		Select ObservationSeverity = new Select(driver.findElement(By.xpath("//select[@name='ddlInjuryPotential1']")));
		ObservationSeverity.selectByVisibleText("Medium severity");
		Thread.sleep(1000);
		
		//Observation Type 
		Select ObservationType = new Select(driver.findElement(By.xpath("//select[@name='ddlObservationCategory']")));
		ObservationType.selectByVisibleText("Electrical Safety");
		Thread.sleep(1000);
		
		//Observation Detail
		driver.findElement(By.id("txtRemarks")).sendKeys("Test Remarks");
		Thread.sleep(1000);

		//Attachments
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\GAURAV\\workspace\\GMR_Automation\\Images\\Image.jpg");
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\GAURAV\\workspace\\GMR_Automation\\Images\\CeilingFan.jpg");
		//driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\GAURAV\\workspace\\GMR_Automation\\Images\\Electric panel room.jpg");
		//driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\GAURAV\\workspace\\GMR_Automation\\Images\\unsafe.jpg");

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
		driver.findElement(By.xpath("//textarea[@name='txtTaskDescription']")).sendKeys("Test task assign");
		Thread.sleep(2000);
		
		//Responsibility 
		driver.findElement(By.xpath("//input[@name='txtResponsible']")).sendKeys("Gaurav Kumar");
		Thread.sleep(7000);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		
		//Priority
		Select priority = new Select(driver.findElement(By.xpath("//select[@name='ddlTaskPriority']")));
		priority.selectByVisibleText("Low");
		Thread.sleep(2000);
		
		//Save CAPA
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		Thread.sleep(4000);

		
		//Submit
		driver.findElement(By.xpath("//button[@class='btn btn-success waves-effect w-md waves-light m-b-5']")).click();
		Thread.sleep(10000);
	
	}
	
	@Test(priority=2,enabled=false)
	public void EHS_Observation_Review_SectionHead() throws InterruptedException, AWTException
	{
		//Enter User name 
		driver.findElement(By.id("txtUserName")).sendKeys("akash");
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
		driver.findElement(By.partialLinkText("GWEL/SO/2020/")).click();
		Thread.sleep(20000);
		
		//New window handle
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}	
		//code to do something on new window
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//scroll down
		jse.executeScript("scroll(0, 250);");
		
		//Authorization Action
		Select Authorizationaction = new Select(driver.findElement(By.id("ddlAction")));
		Authorizationaction.selectByVisibleText("Reviewed & completed");
		Thread.sleep(2000);
		
		//Comment
		driver.findElement(By.id("txtComment")).sendKeys("Test comment");
		Thread.sleep(2000);
		
		
		//Submit 
		driver.findElement(By.xpath("//button[@class='btn btn-success waves-effect w-md waves-light m-b-5']")).click();
		Thread.sleep(10000);
		
		driver.close(); // close newly opened window when done with it
		driver.switchTo().window(parentHandle); // switch back to the original window


	}
	
	@Test(priority=3,enabled=false)
	public void EHS_Observation_Review_CAPA_Person() throws InterruptedException, AWTException
	{
		//Enter User name 
		driver.findElement(By.id("txtUserName")).sendKeys("gaurav007");
		Thread.sleep(1000);
	
		//Enter Password
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		Thread.sleep(1000);
		
		//Click on submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(15000);

		//Click on observation 
		driver.findElement(By.partialLinkText("Action Item of EHS")).click();
		Thread.sleep(5000);
		
		//New window handle
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}	
		//code to do something on new window
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//scroll down
		jse.executeScript("scroll(0, 250);");
		
		//Authorization Action
		Select Authorizationaction = new Select(driver.findElement(By.id("ddlAction")));
		Authorizationaction.selectByVisibleText("Complete (If Review L1 added)");
		Thread.sleep(2000);
	
		//Comment
		driver.findElement(By.id("txtComment")).sendKeys("Task completed Test comment");
		Thread.sleep(1000);
				
		//Attachments
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\GAURAV\\workspace\\Vguard_Automation\\Images\\Image.jpg");
		
		//click on upload all 
		driver.findElement(By.xpath("//button[@name='btnUploadAll']")).click();
		Thread.sleep(4000);
				
		//Submit
		driver.findElement(By.xpath("//button[@class='btn btn-success w-md waves-light m-b-5 ng-binding ng-scope waves-effect']")).click();
		Thread.sleep(5000);
		
		driver.close(); // close newly opened window when done with it
		driver.switchTo().window(parentHandle); // switch back to the original window
		
	}
	@Test(priority=4,enabled=false)
	public void EHS_Observation_CAPA_Review_DepartmentHead() throws InterruptedException, AWTException
	{
		//Enter User name 
		driver.findElement(By.id("txtUserName")).sendKeys("akash");
		Thread.sleep(1000);
		//Enter Password
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		Thread.sleep(1000);
		//Click on submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(10000);
		
		//For you Review
		driver.findElement(By.xpath("//div[contains(@class,'lead-statistics relative two bg-warning')]//i[@class='arrow icofont-arrow-right']")).click();
		Thread.sleep(10000);
		//Click on that 
		driver.findElement(By.partialLinkText("Action Item of EHS")).click();
		Thread.sleep(5000);
						
		//New window handle
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}	
		//code to do something on new window
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//scroll down
		jse.executeScript("scroll(0, 250);");
		
		//Authorization Action
		Select Authorizationaction = new Select(driver.findElement(By.id("ddlAction")));
		Authorizationaction.selectByVisibleText("Approve & Close (If Review L2 not added)");
		Thread.sleep(2000);
		
		//Comment
		driver.findElement(By.id("txtComment")).sendKeys("Test comment");
		Thread.sleep(3000);
			
		jse.executeScript("scroll(0, 250);");
		
		//Submit 
		driver.findElement(By.xpath("//button[@class='btn btn-success w-md waves-light m-b-5 ng-binding ng-scope waves-effect']")).click();
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
