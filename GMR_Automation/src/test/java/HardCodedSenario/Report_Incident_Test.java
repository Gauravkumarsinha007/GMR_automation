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

import com.thoughtworks.selenium.webdriven.commands.Click;

public class Report_Incident_Test {
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
	public void Report_Incident_Employee() throws InterruptedException, AWTException
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
		driver.findElement(By.xpath("//span[@class='site-menu-title'][text()='Incident']")).click();
		Thread.sleep(1000);
		
		//Report Incident
		driver.findElement(By.xpath("//span[text()='Report Incident']")).click();
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

		//Shift 
		Select Shift = new Select(driver.findElement(By.id("ddlShift")));
		Shift.selectByVisibleText("B Shift- 14:00 to 22:00");
		Thread.sleep(2000);
		
		//Incident At 
		driver.findElement(By.xpath("//label[contains(text(),'Off Site')]")).click();
		Thread.sleep(2000);
		
		//Exact Location
		driver.findElement(By.xpath("//input[@placeholder='Exact Location']")).sendKeys("Test Location");
		Thread.sleep(2000);
		
		//Nature of Injury 
		driver.findElement(By.xpath("//label[contains(text(),'First Aid Case')]")).click();
		Thread.sleep(2000);
		
		//Incident Classification
		driver.findElement(By.xpath("//label[contains(text(),'Occupational Dieses')]")).click();
		Thread.sleep(2000);

		//Description of what happened
		driver.findElement(By.id("txtWhatHappenedDesc")).sendKeys("Test Desc for AT ");
		Thread.sleep(1000);
		
		//Immediate/Containment Action Taken (Also mention who visited site first and what action was proposed by him? if applicable)
		driver.findElement(By.xpath("//textarea[@ng-model='incidentFIRDetail.ImmediateAction']")).sendKeys("Tets Action Now");
		Thread.sleep(1000);
		
		//add injured person 
		driver.findElement(By.id("btnAddVictim")).click();
		Thread.sleep(2000);
		
				//Employee(s) / Other
				Select emp = new Select(driver.findElement(By.xpath("//select[@name='ddlVictimType']")));
				emp.selectByVisibleText("Visitor");
				Thread.sleep(1000);
				
				//Name
				driver.findElement(By.xpath("//input[@placeholder='Employee Name']")).sendKeys("Rahul Singh");
				Thread.sleep(1000);
				
				//Age 
				driver.findElement(By.xpath("//input[@placeholder='Age']")).sendKeys("35");
				Thread.sleep(10000);
		
				//Department
				driver.findElement(By.xpath("//input[@placeholder='Function']")).sendKeys("Audit Team");
				Thread.sleep(1000);
				
				//Gender 
				Select Gender = new Select(driver.findElement(By.xpath("//select[@name='ddlVictimGender']")));
				Gender.selectByVisibleText("Female");
				Thread.sleep(1000);
				
				//Save 
				driver.findElement(By.xpath("//button[@class='btn btn-icon btn-success btn-xs waves-effect waves-light m-r-5']")).click();
				Thread.sleep(2000);
		
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
//		driver.findElement(By.xpath("//button[@class='btn btn-warning m-b-5 ng-scope']")).click();
//		Thread.sleep(1000);
		
		//Submit
		driver.findElement(By.xpath("//button[@class='btn btn-success waves-effect w-md waves-light m-b-5']")).click();
		Thread.sleep(10000);
	}
	
	@AfterMethod
	public void AMTest() throws InterruptedException
	{
			driver.close();
		System.out.println("Close browser successfully");
	}
	
}
