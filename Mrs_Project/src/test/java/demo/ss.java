package demo;

import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

public class ss {

	
		    @Test

		    public void testGuru99TakeScreenShot() throws Exception{

				WebDriver driver ;
		    	System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
		    	driver = new ChromeDriver();

		        //goto url

		        driver.get("https://demo.guru99.com/V4/");

		        //Call take screenshot function

		        this.takeSnapShot(driver, "c://test.png") ;     

		    }

		    /**

		     * This function will take screenshot

		     * @param webdriver

		     * @param fileWithPath

		     * @throws Exception

		     */

		    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

		        //Convert web driver object to TakeScreenshot

		        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

		        //Call getScreenshotAs method to create image file

		                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		            //Move image file to new destination

		                File DestFile=new File(fileWithPath);

		                //Copy file at destination

		                FileUtils.copyFile(SrcFile, DestFile);

		    }

		}
		// TODO Auto-generated constructor stub
	}

}
