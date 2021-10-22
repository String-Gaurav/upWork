package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

//=======================Locators=========================================
	
	By TalentSearchImage = By.xpath("(//*[@icon-name=\"search\"])[1]");
	By Select_talent_dropdown = By.xpath("//*[@icon-name=\"dropdown-caret\"]");
	By Select_Talent = By.xpath("//*[@class=\"nav-dropdown-menu nav-dropdown-search\"]/li[1]/a");
	By Search = By.name("q");
	By Select_talent_From_List = By.xpath("//*[@id=\"nav-main\"]/div/div[1]/form/div/ul/li/a");

//=======================Locators=========================================

	public HomePage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement ClickOnSearchOptions() {

		return driver.findElement(TalentSearchImage);
	}

	public WebElement SelectTalentDropdown() {

		return driver.findElement(Select_talent_dropdown);
	}

	public WebElement SelectTalent() {

		return driver.findElement(Select_Talent);
	}
	
	public WebElement PerformSearch() {

		return driver.findElement(Search);
	}

	public WebElement SelectTalentFromList() {

		return driver.findElement(Select_talent_From_List);
	}
	
	 public void highLighterMethod(WebElement element){
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}
}