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

public class BBSObservation_Test {
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
	public void Report_BBS_Observation() throws InterruptedException, AWTException
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
		driver.findElement(By.xpath("//span[text()='BBS Observation']")).click();
		Thread.sleep(1000);
		
		//Report EHS Observation 
		driver.findElement(By.xpath("//ul[@class='site-menu-sub active-sub']//li[3]//a[1]//span[1]")).click();
		Thread.sleep(5000);
	
		//Location/SubLocation 
		driver.findElement(By.id("txtLocation_value")).sendKeys("Boiler 1-W");
		Thread.sleep(5000);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		//Exact Location
		driver.findElement(By.id("txtExactLocation")).sendKeys("Test");
		Thread.sleep(2000);

		//End time 
		driver.findElement(By.xpath("//div[@class='card-box']//div[3]//div[1]//timepicker-pop[1]//table[1]//tbody[1]//tr[2]//td[1]//input[1]")).click();
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_UP);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		
		//Responsible Function
		driver.findElement(By.id("txtFunction_value")).sendKeys("AHP");
		Thread.sleep(5000);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		//Activity Observed 
		driver.findElement(By.id("txtaActivityObserved")).sendKeys("Test Activity Observed ");
		Thread.sleep(2000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//scroll down
		jse.executeScript("scroll(0, 250);");

		//Eye/Face AT Risk
		driver.findElement(By.xpath("//body[@id='LayoutBody']//div[@class='col-md-12']//div[@class='col-md-12']//tr[1]//td[3]//div[1]")).click();
		Thread.sleep(2000);
		
		//Barrier for At-Risk Behaviour
		Select Behaviour = new Select(driver.findElement(By.xpath("//select[@name='ddlBarrierforAtRiskBehaviour01']")));
		Behaviour.selectByVisibleText("Accepted culture or Peer Pressure");
		Thread.sleep(2000);
		
		//Comments
		driver.findElement(By.xpath("//tr[1]//td[7]//textarea[1]")).sendKeys("Test Comments");
		Thread.sleep(2000);
		
		//save
		driver.findElement(By.xpath("//button[@class='btn btn-success waves-effect w-md waves-light m-b-5 ng-binding ng-scope']")).click();
		Thread.sleep(2000);
		
		
	}
	
	@AfterMethod
	public void AMTest() throws InterruptedException
	{
		//driver.close();
		System.out.println("Close browser successfully");
	}
	
}
