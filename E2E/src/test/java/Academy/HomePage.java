package Academy;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest

	public void initialize() throws IOException{
		
		
		driver=initializeDriver();
		log.info("Driver initialised");
	}
	
	@Test(dataProvider="getData")
	
	public void basepageNavigation(String userName, String password, String text) throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("Navigated to " + prop.getProperty("url"));
		LandingPage l=new LandingPage(driver);
		l.getLogin().click();
		log.info("Clicked on logon button");
		LoginPage lp=new LoginPage(driver);
		log.info("Selected login Name");
		lp.getEmail().sendKeys(userName);
		log.info("Following keys were sent " + userName);
		lp.getPassword().sendKeys(password);
		log.info("Following keys were sent " + password);
		lp.selectLogin().click();
		System.out.println(text);
				}
	@AfterTest
	
	public void teardown() {
		driver.close();
		driver=null;
	}

	@DataProvider
	public Object[][] getData() {
		//Row stands for how many different data types test should run,
		//coloumn stands for how many values per each test.
		Object[][] data=new Object[2][3];
		//0th row
		data[0][0]="nonrestricted@user.com";
		data[0][1]="123456";
		data[0][2]="restricted user";
		//1st row		
		data[1][0]="Restricteduser@user.com";
		data[1][1]="654321";
		data[1][2]="Nonrestricred user";
		
		return data;
		
	}


}
