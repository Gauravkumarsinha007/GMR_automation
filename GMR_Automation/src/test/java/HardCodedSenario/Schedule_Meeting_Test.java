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

public class Schedule_Meeting_Test {
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
	public void Meeting_Employee() throws InterruptedException, AWTException
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
		Thread.sleep(10000);
		
		//open Meeting Url
		driver.get("https://gmrehsonlineuat.azurewebsites.net/Meeting/ScheduleMeeting");
		Thread.sleep(30000);
		
		//Meeting Type 
		Select MeetingType = new Select(driver.findElement(By.id("ddlMeetingType")));
		MeetingType.selectByVisibleText("Department EHS Meeting");
		Thread.sleep(2000);
		
		//Function
		Select Function = new Select(driver.findElement(By.id("ddlFunctions")));
		Function.selectByVisibleText("Chemistry");
		Thread.sleep(5000);
		
		//Meeting Topic 
		Select MeetingTopic = new Select(driver.findElement(By.id("ddlMeetingTopic")));
		MeetingTopic.selectByVisibleText("Quarterly meeting");
		Thread.sleep(2000);

		//Duration 
		driver.findElement(By.xpath("//timepicker-pop[@id='txtMeetingDuration']//input[@placeholder='HH']")).clear();
		driver.findElement(By.xpath("//timepicker-pop[@id='txtMeetingDuration']//input[@placeholder='HH']")).sendKeys("1");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//timepicker-pop[@id='txtMeetingDuration']//input[@placeholder='MM']")).clear();
		driver.findElement(By.xpath("//timepicker-pop[@id='txtMeetingDuration']//input[@placeholder='MM']")).sendKeys("15");
		Thread.sleep(2000);
	
		//Meeting Host 
		driver.findElement(By.id("txtMeetingHost_value")).sendKeys("Gaurav Kumar");
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		
		//Meeting Venue 
		Select MeetingVenue =new Select(driver.findElement(By.id("ddlMeetingVenue")));
		MeetingVenue.selectByVisibleText("Mercury");
		Thread.sleep(2000);
				
		//Meeting Agendas
		//Add Meeting agenda 
		driver.findElement(By.xpath("//a[@class='btn btn-primary waves-effect waves-light btn-xs m-t-5 pull-right']")).click();
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("//input[@name='txtCheckListName']")).sendKeys("Test Agenda");
		Thread.sleep(2000);
		
		//Save 
		driver.findElement(By.xpath("//a[@class='btn btn-icon btn-success btn-xs waves-effect waves-light m-r-5']")).click();
		Thread.sleep(2000);

		//Meeting Attendees
		//Add Participants
		driver.findElement(By.xpath("//button[@id='btnAddEmployee']")).click();
		Thread.sleep(2000);

		//Employee name 
		driver.findElement(By.id("txtVictimName_value")).sendKeys("Gaurav Kumar");
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		
		//Email id 
		driver.findElement(By.xpath("//input[@placeholder='Email Id']")).sendKeys("Test@gmail.com");
		Thread.sleep(4000);
		//save
		driver.findElement(By.xpath("//button[@class='btn btn-icon btn-success btn-xs waves-effect waves-light m-r-5']")).click();
		Thread.sleep(2000);
		
		//Attach file 
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\GAURAV\\workspace\\Vguard_Automation\\Images\\Image.jpg");
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\GAURAV\\workspace\\Vguard_Automation\\Images\\CeilingFan.jpg");
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

	
	@Test(priority=2,enabled=false)
	public void Meeting_Completed() throws InterruptedException, AWTException
	{
		
		//Enter User name 
		driver.findElement(By.id("txtUserName")).sendKeys("gaurav007");
		Thread.sleep(1000);
		//Enter Password
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		Thread.sleep(1000);
		//Click on submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(10000);
		
		//open Meeting Url
		driver.get("https://gmrehsonlineuat.azurewebsites.net/Meeting/ScheduleMeeting");
		Thread.sleep(30000);
	
		//click on side bar
		driver.findElement(By.xpath("//a[@class='nav-link toggleMenubar']")).click();
		Thread.sleep(4000);

		//Schedule Meeting
		driver.findElement(By.xpath("//ul[@class='site-menu-sub active-sub']//span[@class='site-menu-title'][contains(text(),'My Meeting')]")).click();
		Thread.sleep(30000);
		
		//Click on Edit Meeting 
		driver.findElement(By.xpath("//tr[1]//a[@title='Edit']")).click();
		Thread.sleep(25000);
		
		//New window handle
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		
		for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}	
		//code to do something on new window
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//scroll down
		jse.executeScript("scroll(0, 250);");
		Thread.sleep(2000);
		//Meeting attendees
		driver.findElement(By.xpath("//tbody[1]//tr[1]//td[11]//div[1]//div[1]//input[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//tbody[2]//tr[1]//td[11]//div[1]//div[1]//input[1]")).click();
		Thread.sleep(2000);
	
		//scroll down
		jse.executeScript("scroll(0, 250);");

		//Authorization Action
		Select Authorizationaction = new Select(driver.findElement(By.id("ddlAction")));
		Authorizationaction.selectByVisibleText("Completed");
		Thread.sleep(2000);
		
		//Comment
		driver.findElement(By.id("txtComment")).sendKeys("Test comment Completed");
		Thread.sleep(1000);
			
		//Submit 
		driver.findElement(By.xpath("//button[@class='btn btn-success waves-effect w-md waves-light m-b-5']")).click();
		Thread.sleep(5000);

		//driver.close(); // close newly opened window when done with it
		driver.switchTo().window(parentHandle); // switch back to the original window
	
	}


	@Test(priority=3,enabled=false)
	public void Meeting_Postpone() throws InterruptedException, AWTException
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
		Thread.sleep(10000);
		
		//open Meeting Url
		driver.get("https://gmrehsonlineuat.azurewebsites.net/Meeting/ScheduleMeeting");
		Thread.sleep(30000);
	
		//click on side bar
		driver.findElement(By.xpath("//a[@class='nav-link toggleMenubar']")).click();
		Thread.sleep(4000);

		//Schedule Meeting
		driver.findElement(By.xpath("//ul[@class='site-menu-sub active-sub']//span[@class='site-menu-title'][contains(text(),'My Meeting')]")).click();
		Thread.sleep(30000);
		
		//Click on Edit Meeting 
		driver.findElement(By.xpath("//tr[1]//a[@title='Edit']")).click();
		Thread.sleep(25000);
		
		//New window handle
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		
		for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}	
		//code to do something on new window
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//scroll down
		jse.executeScript("scroll(0, 250);");
		Thread.sleep(2000);

		//Authorization Action
		Select Authorizationaction = new Select(driver.findElement(By.id("ddlAction")));
		Authorizationaction.selectByVisibleText("Postpone");
		Thread.sleep(5000);
		
		//Meeting date time 
		driver.findElement(By.xpath("//div[@class='col-md-6']//input[@placeholder='HH']")).click();
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_UP);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		//scroll down
		jse.executeScript("scroll(0, 250);");
		Thread.sleep(2000);
		 
		//Comment
		driver.findElement(By.id("txtComment")).sendKeys("Test comment Postpone");
		Thread.sleep(1000);
			
		//Submit 
		driver.findElement(By.xpath("//button[@class='btn btn-success waves-effect w-md waves-light m-b-5']")).click();
		Thread.sleep(5000);

		
		driver.close(); // close newly opened window when done with it
		driver.switchTo().window(parentHandle); // switch back to the original window
	
	}

	@Test(priority=4,enabled=false)
	public void Meeting_cancel() throws InterruptedException, AWTException
	{
		//Enter User name 
		driver.findElement(By.id("txtUserName")).sendKeys("gaurav007");
		Thread.sleep(1000);
		//Enter Password
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		Thread.sleep(1000);
		//Click on submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(10000);
		
		//open Meeting Url
		driver.get("https://gmrehsonlineuat.azurewebsites.net/Meeting/ScheduleMeeting");
		Thread.sleep(30000);
	
		//click on side bar
		driver.findElement(By.xpath("//a[@class='nav-link toggleMenubar']")).click();
		Thread.sleep(4000);

		//Schedule Meeting
		driver.findElement(By.xpath("//ul[@class='site-menu-sub active-sub']//span[@class='site-menu-title'][contains(text(),'My Meeting')]")).click();
		Thread.sleep(30000);
		
		//Click on Edit Meeting 
		driver.findElement(By.xpath("//tr[1]//a[@title='Edit']")).click();
		Thread.sleep(25000);
		
		//New window handle
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		
		for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}	
		//code to do something on new window
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//scroll down
		jse.executeScript("scroll(0, 250);");
		Thread.sleep(2000);

		//Authorization Action
		Select Authorizationaction = new Select(driver.findElement(By.id("ddlAction")));
		Authorizationaction.selectByVisibleText("Cancel");
		Thread.sleep(5000);
			 
		//Comment
		driver.findElement(By.id("txtComment")).sendKeys("Test comment Cancel");
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
		//driver.quit();
		System.out.println("Close browser successfully");
	}
	
}
