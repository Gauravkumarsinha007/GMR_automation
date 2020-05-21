package HardCodedSenario;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
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
	
	@Test(priority=1,enabled=true)
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
		Thread.sleep(20000);
		
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
		Thread.sleep(5000);
	
		//Location/SubLocation 
		driver.findElement(By.id("txtLocation_value")).sendKeys("Boiler 1-W");
		Thread.sleep(2000);
		
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
		Thread.sleep(2000);
		
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
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\GAURAV\\workspace\\GMR_Automation\\Images\\Electric panel room.jpg");
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\GAURAV\\workspace\\GMR_Automation\\Images\\unsafe.jpg");

		//click on single upload 
		driver.findElement(By.xpath("//tr[1]//td[6]//button[1]//i[1]")).click();
		Thread.sleep(1000);
		
		//click on upload all 
		driver.findElement(By.xpath("//button[@name='btnUploadAll']")).click();
		Thread.sleep(5000);
		
		//Submit
		//driver.findElement(By.xpath("//button[@class='btn btn-success waves-effect w-md waves-light m-b-5']")).click();
		Thread.sleep(10000);
				
	
	
	
	
	
	}
	
	@AfterMethod
	public void AMTest() throws InterruptedException
	{
			driver.close();
		System.out.println("Close browser successfully");
	}
	
}
