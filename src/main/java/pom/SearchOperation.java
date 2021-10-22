package pom;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;

public class SearchOperation {

	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	List<SearchTalentList> list = new ArrayList<SearchTalentList>();
	List<WebElement> TotalTalent;
	

//=======================Locators=========================================
	By TalentList = By.xpath("//*[@class=\"up-card-section up-card-hover\"]");
	By TalentName = By.className("identity-name");
	By TalentSpeciality = By.cssSelector("div.identity-content > p > strong");
	By TalentCity = By.cssSelector("div.identity-content > div > span.d-inline-block.vertical-align-middle");
	By TalentDescription = By.cssSelector("div.up-line-clamp-v2-wrapper.mb-0");
	
	By ClickOnList = By.className("d-flex freelancer-tile");
	
	
	By TalentNameFromProfile = By.xpath("(//*[@itemprop=\"name\"])[1]");
	By TalentSpecialityFromProfile = By.xpath("//*[@class=\"row d-flex\"]/div/h2");
	By TalentCityFromProfile = By.xpath("(//*[@itemprop=\"locality\"])[1]/following-sibling::span[2]");
	By TalentDescriptionFromProfile = By.xpath("(//*[@class=\"text-pre-line break\"])[1]");

//=======================Locators=========================================

	
	
	public SearchOperation(WebDriver driver) {

		this.driver = driver;
	}
	
	public void StoreResultInTolist() {
		
		TotalTalent = driver.findElements(TalentList);
		for( WebElement talent : TotalTalent)
		{
			SearchTalentList sl = new SearchTalentList();
			sl.Name = talent.findElement(TalentName).getText();;
			sl.Special = talent.findElement(TalentSpeciality).getText();;
			sl.City = talent.findElement(TalentCity).getText();
			sl.Description = talent.findElement(TalentDescription).getText();
			list.add(sl);
		}
	}
	
	public void PrintResultInTolist() {
		
		List<WebElement> TotalTalent = driver.findElements(TalentList);
		for(int i=0;i<TotalTalent.size();i++)
		{
			System.out.println(list.get(i));
		}
		
	}
	
	public WebElement SelectTalentFromList(int index) {

		return TotalTalent.get(index).findElement(TalentName);
	}
	
	public void CompareAfterClick() {

		String Name = driver.findElement(TalentNameFromProfile).getText();
		String Special = driver.findElement(TalentSpecialityFromProfile).getText();
		String City = driver.findElement(TalentCityFromProfile).getText();
		String Description = driver.findElement(TalentDescriptionFromProfile).getText();
		for( SearchTalentList talent : list)
		{
			if (talent.Name.equals(Name)) {
				log.info("Assertion Passed");
				System.out.println (talent);
	        }
		}

	}
	

	
	 public void highLighterMethod(WebElement element){
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}
}