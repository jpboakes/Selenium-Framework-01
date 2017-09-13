package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;



public class validateTitle extends base {
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest

	public void initialize() throws IOException{
		driver=initializeDriver();
		log.info("Driver initialised");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to " + prop.getProperty("url"));
		
		
	}
	
	@Test
		
	public void basepageNavigation() throws IOException {
		LandingPage l=new LandingPage(driver);
		//compare the text from the browser with actual text.-error..
		Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES123");
		log.info("Successfully validated Text");
		
		
	}
	@AfterTest
	
	public void teardown() {
		driver.close();
		driver=null;
	}
	
}
