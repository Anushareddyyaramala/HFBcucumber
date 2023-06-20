package hooks;

import java.io.IOException;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import com.GenericUtils.JavaUtility;
import com.GenericUtils.LogUtility;
import com.GenericUtils.PropertyFile;
import com.GenericUtils.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver ;
//	public static WebDriver sdriver;
	WebdriverUtility wLib=new WebdriverUtility();
	LogUtility log=new LogUtility();
	JavaUtility jlib=new JavaUtility();
	PropertyFile plib=new PropertyFile();
	

	@Before
	public void launchbrowser() throws IOException {

		String BROWSER=plib.readDataFromPropertyFile("Browser");
		if(BROWSER.equalsIgnoreCase("CHROME"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Reporter.log("--Browser "+BROWSER+" launched successfully--",true);
//			driver.get(URL);
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			Reporter.log("--Browser "+BROWSER+" launched successfully--",true);
			
		}
		else if(BROWSER.equalsIgnoreCase("EDGE"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			Reporter.log("--Browser "+BROWSER+" launched successfully--",true);
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		
		wLib.maximiseWindow(driver);
		wLib.waitForElementsToLoadInDOM(driver);
	}
         public void appbrowser() throws IOException {
        	 
		String URL = plib.readDataFromPropertyFile("Url");
		driver.get(URL);
        log.Info("url launched");
        WebElement signin=driver.findElement(By.xpath("//div[@class='nav-line-1-container']"));
        wLib.mouseHoverOn(driver, signin);
        driver.findElement(By.xpath("//span[text()='Sign in']")).click();
	}
	
	public void closebrowser() {
		
		driver.close();
		Reporter.log("--browser closed successfull--", true);
		log.Info("Browser closed ");
	}
		
	}

