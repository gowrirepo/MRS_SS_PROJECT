package mrs;

import java.io.FileInputStream;
import java.util.Properties;

public class properties 
{
	public String read(String value) throws Exception {

		FileInputStream f = new FileInputStream
				("D:\\Gowri SS\\Personal\\Java_Workspace\\Maven_Projects\\src\\confiig.properties\\config.properties");
		Properties propety = new Properties();
		
		propety.load(f);
		String data = propety.getProperty(value);
		return data;

	}

}

