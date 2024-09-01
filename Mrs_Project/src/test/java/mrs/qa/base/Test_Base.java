package mrs.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import mrs.qa.util.Testutil;

public class Test_Base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public Test_Base() throws IOException
	{	
		
		prop=new Properties(); 
		FileInputStream fis =new FileInputStream("D:\\Gowri SS\\Personal\\Eclipse Workspace\\CRMTest\\"
				+ "src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(fis); 
		
		
	}
	
	public static void initialization()
	{		
		String browsername=prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("Chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(browsername.equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			
		}
		else if(browsername.equalsIgnoreCase("msedge"))
		{
		
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();		
		}		
		
		else if(browsername.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();	
						
		}
		
		else if(browsername.equalsIgnoreCase("safari"))
		{
			WebDriverManager.safaridriver().setup();
			WebDriver driver = new SafariDriver();
			
		}
		
		else
		{
			System.out.println("no browser found");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Testutil.pageloadtimeout));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Testutil.implicitwait));
		
		driver.get(prop.getProperty("url"));
		
//		driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
//		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
//		driver.findElement(By.xpath("//button[@class='login']")).click();
	}
}

