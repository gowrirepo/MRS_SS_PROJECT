package properties_sample;

public class prop_sample {
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.util.Properties;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.safari.SafariDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class TestBase {
		
		static WebDriver driver;
		static Properties prop;
		
		public TestBase()
		{
			// Read properties file
			
			prop=new Properties(); //step :1 - create object of properties class which is already in util package in java mean inbuilt class properties
			FileInputStream fis =new FileInputStream("D:\\Gowri SS\\Personal\\Eclipse Workspace\\CRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties"); //step 2: create object of fileinputstream class//inside doublequote config.properties file path should mention 
			prop.load(fis); //make connection between config property file and java util and loadconfig file in java util 
			
			System.out.println(prop.getProperty("browser"));// to give the values of browser from property 
			
			String browsername=prop.getProperty("browser");
			
			if(browsername.equalsIgnoreCase("Chrome"))
			{
//				System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
//				driver = new ChromeDriver();
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			
			else if(browsername.equalsIgnoreCase("IE"))
			{
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
//				System.setProperty("webdriver.ie.driver","C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
//				driver = new InternetExplorerDriver();
			}
			else if(browsername.equalsIgnoreCase("msedge"))
			{
				System.setProperty("webdriver.msedge.driver","C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
				driver=new EdgeDriver();
//				WebDriverManager.edgedriver().setup();
//				driver = new EdgeDriver();		
			}		
			
			else if(browsername.equalsIgnoreCase("Firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				WebDriver driver = new FirefoxDriver();	
//				System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
//				WebDriver driver = new FirefoxDriver();			
			}
			
			else if(browsername.equalsIgnoreCase("safari"))
			{
				WebDriverManager.safaridriver().setup();
				WebDriver driver = new SafariDriver();
//				System.setProperty("webdriver.safari.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
//				WebDriver driver = new FirefoxDriver();	
			}
			
			else
			{
				System.out.println("no browser found");
			}
			
			driver.get(prop.getProperty("url"));
			
			driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
			driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
			driver.findElement(By.xpath("//button[@class='login']")).click();
		}

}
