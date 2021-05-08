package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configdataprovider {
	Properties po;
	public configdataprovider()
	{
		File src = new File("./Config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			po = new Properties();
			po.load(fis);
		} catch (Exception e) {
			System.out.println("config file is not available "+e.getMessage());
			
		} 
		
		
		
		
	}
	public String getBrowser() {
		// TODO Auto-generated method stub
		return po.getProperty("Browser");
	}
	public String getStagingURL() {
		// TODO Auto-generated method stub
		return po.getProperty("QaURL");
	}
	
}
