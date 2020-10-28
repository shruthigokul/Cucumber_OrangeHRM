package setUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class driverSetUp 
{
    public static WebDriver driver;
    public static WebDriverWait wait;
    
    public static WebDriver settingUp() {
    	driver = new FirefoxDriver();
    	wait = new WebDriverWait(driver, 20);
    	return driver;
    }
}
