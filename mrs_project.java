package mrs;

import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.target.model.SessionID;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mrs_project 
{

	WebDriver driver;
	SoftAssert Assert;
	Select s;
	Robot r;
	properties prop;
	
	@BeforeSuite
	public void setup1() throws Exception 
	{
		prop = new properties();
		String browser1 = prop.read("Browser");
		String url1 = prop.read("URL");

		if (browser1.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} 
		else if (browser1.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.get(url1);
		Assert = new SoftAssert();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority=1)
	public void loginpage() throws Exception
	{
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("Admin");
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("Admin123");

		//		List<WebElement>sessionlocation=driver.findElements(By.xpath("//ul[@id='sessionLocation']"));
		//		for(WebElement sl:sessionlocation)
		//		{
		//			if(sl.equals("Inpatient Ward"))
		//			{	
		//			sl.click();			
		//			}
		//			System.out.print(sl.getText());
		//		}
		WebElement sessionlocation=driver.findElement(By.id("Inpatient Ward"));
		sessionlocation.click();
		WebElement loginbutton=driver.findElement(By.id("loginButton"));
		loginbutton.click();
		//		Assert.assertTrue(driver.getPageSource().contains("openmrs"));
	}
	@Test(priority=2)
	public void registerpatient()
	{
		WebElement registerpatient=driver.findElement(By.xpath("//a[@type='button'and contains(@id,'registerPatient')]"));
		registerpatient.click();
		WebElement registerpatientnamegiven=driver.findElement(By.xpath("//input[@name='givenName']"));
		registerpatientnamegiven.sendKeys("Abi");
		WebElement familyname=driver.findElement(By.xpath("//input[@name='familyName']"));
		familyname.sendKeys("S");
		WebElement arrowbutton=driver.findElement(By.xpath("//button[@id='next-button']"));
		arrowbutton.click();

		//	    List<WebElement> gender=driver.findElements(By.xpath("//option[@value='F']"));
		//	    s=new Select(gender);
		WebElement gender=driver.findElement(By.xpath("//option[@value='F']"));
		gender.click();
		WebElement clickright=driver.findElement(By.xpath("//button[@class='confirm right']"));
		clickright.click();
	}
	@Test(priority=3)
	public void birthdate() throws Exception
	{
		WebElement day=driver.findElement(By.xpath("//input[@id='birthdateDay-field']"));
		day.sendKeys("12");	    
		WebElement drpdownmonth=driver.findElement(By.xpath("//select[@id='birthdateMonth-field']"));
		s=new Select(drpdownmonth);
		s.selectByIndex(5);	    
		WebElement year=driver.findElement(By.xpath("//input[@name='birthdateYear']"));
		year.sendKeys("2012");
		WebElement clickright1=driver.findElement(By.xpath("//button[@class='confirm right']"));
		clickright1.click();
	}
	@Test(priority=4)
	public void contactinfo() throws Exception
	{
		WebElement address1=driver.findElement(By.xpath("//input[@id='address1']"));
		address1.sendKeys("tikluk nagar");	    
		WebElement address2=driver.findElement(By.xpath("//input[@id='address2']"));
		address2.sendKeys("saravanampatti");
		WebElement city=driver.findElement(By.xpath("//input[@name='cityVillage']"));
		city.sendKeys("Coimbatore");
		WebElement state=driver.findElement(By.xpath("//input[@name='stateProvince']"));
		state.sendKeys("TamilNadu");
		WebElement country=driver.findElement(By.xpath("//input[@name='country']"));
		country.sendKeys("India");
		WebElement postal=driver.findElement(By.xpath("//input[@name='postalCode']"));
		postal.sendKeys("602601");
		WebElement clickright2=driver.findElement(By.xpath("//button[@class='confirm right']"));
		clickright2.click();
		WebElement phone=driver.findElement(By.xpath("//input[@name='phoneNumber']"));
		phone.sendKeys("987654321");
		WebElement clickright3=driver.findElement(By.xpath("//button[@class='confirm right']"));
		clickright3.click();

	}
	@Test(priority=5)
	public void relation() throws Exception
	{
		WebElement patientrelation=driver.findElement(By.id("relationship_type"));
		s=new Select(patientrelation);
		s.selectByVisibleText("Doctor");
		WebElement personname=driver.findElement(By.xpath("//input[@placeholder='Person Name']"));
		personname.sendKeys("abcd");	    
		WebElement clickright4=driver.findElement(By.xpath("//button[@class='confirm right']"));
		clickright4.click();
		WebElement confirm=driver.findElement(By.xpath("//input[@id='submit']"));
		confirm.click();
	}
	@Test(priority=6)
	public void generalactions() throws Exception
	{

		WebElement startvisit=driver.findElement(By.xpath("//div[contains(text(),'Start Visit')]"));
		startvisit.click();

		WebElement startVisitconfirmButton1 = driver.findElement(By.xpath("//button[@id='start-visit-with-visittype-confirm']"));
		startVisitconfirmButton1.click();
		Thread.sleep(2000);

		//   driver.findElement(By.xpath("//div[text()='Click or drop a file here.']")).sendKeys("C:\\Users\\GOWRI SS\\Desktop\\Knila Technologies\\Manual_Assessment-_test_case_and_bug_report (1).pdf");

		WebElement attachment= driver.findElement(By.xpath("//a[@id='attachments.attachments.visitActions.default']"));
		attachment.click();  
		Thread.sleep(2000);
		WebElement filedrop= driver.findElement(By.xpath("//form[@id='visit-documents-dropzone']"));
		Thread.sleep(1000);
		filedrop.click();
		Thread.sleep(1000);


		r=new Robot();
		r.delay(1000);     

		//   driver.findElement(By.xpath("//div[text()='Click or drop a file here.']")).click();

		//     JavascriptExecutor js=(JavascriptExecutor)driver;
		//     js.executeScript("arguments[0].click()",filedrop);


		StringSelection ss= new StringSelection("C:\\Users\\GOWRI SS\\Desktop\\Knila Technologies\\Manual_Assessment-_test_case_and_bug_report (1).pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
		Thread.sleep(3000);

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.delay(2000);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.delay(2000);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);      
		r.delay(2000);   

		WebElement caption= driver.findElement(By.xpath("//textarea[@placeholder='Enter a caption']"));
		caption.sendKeys("abcd");
		Thread.sleep(3000);
		WebElement upload= driver.findElement(By.xpath("//button[@class='confirm ng-binding']"));
		upload.click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);     
	}

	@Test(priority=7)
	public void deletepatient() throws Exception
	{

		WebElement deletepatient= driver.findElement(By.xpath("//div[contains(text(),'Delete Patient')]"));                 
		deletepatient.click();
		WebElement deletepatientconfirmbox= driver.findElement(By.xpath("//input[@id='delete-reason']"));
		Thread.sleep(2000);
		deletepatientconfirmbox.sendKeys("done");
		Thread.sleep(2000);
		WebElement clickrightok=driver.findElement(By.xpath("(//button[@class='confirm right' and text()='Confirm'])[3]"));
		clickrightok.click();
		Thread.sleep(5000);

	}  
	@Test(priority=8)
	public void screenshot() throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\Gowri SS\\Personal\\Java_Workspace\\Maven_Projects\\src\\screenshot\\sc1.jpeg");
		FileUtils.copyFile(src,dest);
	}

	@AfterSuite
	public void methodfinal() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.close();

	}	

}	















