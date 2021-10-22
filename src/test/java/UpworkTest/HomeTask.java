package UpworkTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom.HomePage;
import pom.SearchOperation;
import resources.Base;



public class HomeTask extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());

	public WebDriver driver;
	public Properties prop;
	
	
	@BeforeTest
	public void getdriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		driver = initializedriver();
		log.info("driver is initialized");
		
		driver.manage().deleteAllCookies();
		log.info("Cookie cleared");

		driver.get(prop.getProperty("url"));
		log.info("url got opened");

	}

	@Test
	public void HomePageOperation()
			throws InterruptedException, IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		HomePage hp = new HomePage(driver);

		
		hp.highLighterMethod(hp.ClickOnSearchOptions());
		//Thread.sleep(5000);
		
		
		hp.SelectTalentDropdown().click();
		log.info("User click on the search talent dropdown list");
		//Thread.sleep(5000);
		
		hp.SelectTalent().click();
		log.info("User click on the search talent options from the list");
		//Thread.sleep(5000);
		
		hp.PerformSearch().sendKeys(prop.getProperty("searchstring"));
		log.info("User performed search operation provide from internal source");
		//Thread.sleep(5000);
		
		hp.SelectTalentFromList().click();
		log.info("User select search talent result from the search list");
		Thread.sleep(60000);

		log.info("Home page task is done");

	}
	
	@Test
	public void SearchResultOperation()
			throws InterruptedException {

		SearchOperation so = new SearchOperation(driver);
		
		so.StoreResultInTolist();
		log.info("User Store Result in list");
		
		//so.PrintResultInTolist();
		Thread.sleep(20000);
		log.info("wait for popup");
		
		so.SelectTalentFromList(2).click();
		Thread.sleep(5000);
		log.info("Click on the second result");
		
		so.CompareAfterClick();
		log.info("Compare the profile page with List data in list");
		
		log.info("Search, Click and Compare task is done");

	}


	@AfterTest
	public void tearDown() {

		driver.close();
		log.info("Browser got closed, Testcase_Tc_01 got passed");
	}

}
