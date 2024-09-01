package demo;
import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class screen {
	@Test
	public void m1() throws Exception
	{
			System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
			WebDriver driver=new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();		
			driver.get("https://www.amazon.in/");
			TakesScreenshot screenshot=(TakesScreenshot) driver;
			File src=screenshot.getScreenshotAs(OutputType.FILE);
			File trg =new File("D:\\Gowri SS\\Personal\\photos\\screenshot.png");
			FileUtils.copyFile(src, trg);
			Thread.sleep(3000);		
			driver.quit();			
	}			
	}

