package base;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utility.AppiumServer;
import utility.CommonUtils;
import utility.ExcelReader;

public class TestBase {
	
	
	public static AppiumDriver<MobileElement> driver;
	public static String loadPropertyFile = "IOS_careapp.properties";
	//public static String loadPropertyFile = "ios_careapp.properties";
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"/src/test/resources/testdata//testdata.xlsx");
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	@BeforeSuite
	public void setUp() throws IOException{
		
		if(driver==null){
			
			
		
			
			
			if(loadPropertyFile.startsWith("Android")){
				
			//	AppiumServer.start();
				log.debug("Appium server started");
				CommonUtils.loadAndroidConfProp(loadPropertyFile);
				CommonUtils.setAndroidCapabilities();
				driver = CommonUtils.getAndroidDriver();
				
			}else if(loadPropertyFile.startsWith("IOS")){
				
				
				CommonUtils.loadIOSConfProp(loadPropertyFile);
				CommonUtils.setIOSCapabilities();
				driver = CommonUtils.getIOSDriver();
				
			}
			
			
			
			
			
		}
		
		
	}
	
	@AfterSuite
	public void tearDown() throws InterruptedException{
		
		Thread.sleep(3000);
		if(loadPropertyFile.startsWith("Android")){
		driver.quit();
	//	AppiumServer.stop();
		log.debug("Appium server stopped");
		}else{
			
			driver.quit();
		}
		
		
	}
	
}
