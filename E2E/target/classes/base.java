package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		
		prop= new Properties();
		FileInputStream fis=new FileInputStream("G:\\MavenProject\\E2E\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "G://chromedriver.exe");
			driver = new ChromeDriver();		
		}
		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "G://geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "G://IEDriverServer32.exe");
			driver = new InternetExplorerDriver();
		}
		else{
			System.out.println("browserName not found or identified. Please check data properties");			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
//	public void getScreenshot(String result) throws IOException {
//		
//		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyDirectory(src, new File("G://MavenProject//E2E//logs//screenshot//" + result + "_sceenshot.png"));
//		
//	}
	
}
