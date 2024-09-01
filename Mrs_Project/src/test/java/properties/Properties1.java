package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Properties1 
{
@Test
	public void readconfig() throws Exception
	{
	    Properties prop=new Properties();
	    String read=System.getProperty("user.dir");
		FileInputStream file =new FileInputStream(read+"/src/test/java/properties/Properties1.java");
		prop.load(file);
		String browser=prop.getProperty("browser");
		String url=prop.getProperty("url");
		
        System.out.println(browser);
        System.out.println(url);
        
	}

}
