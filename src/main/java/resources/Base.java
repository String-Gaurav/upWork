package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Base {
    public WebDriver driver;
    public Properties prop;
    public WebDriver initializedriver() throws IOException {

        prop = new Properties();

        FileInputStream fis = new FileInputStream(
                "src\\main\\java\\resources\\data.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
            ChromeOptions o = new ChromeOptions();
            // add Incognito parameter
//		      o.addArguments("--incognito");
            o.addArguments("--disable-web-security");
            o.addArguments("--allow-running-insecure-content");
            // DesiredCapabilities object
            DesiredCapabilities c = DesiredCapabilities.chrome();
            //set capability to browser
            c.setCapability(ChromeOptions.CAPABILITY, o);
            driver = new ChromeDriver(o);

        } else if (browserName.equals("firefox")) {

            System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        if (browserName.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "drivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;

    }
    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
        FileHandler.copy(source, new File(destinationFile));

        return destinationFile;
    }

}
