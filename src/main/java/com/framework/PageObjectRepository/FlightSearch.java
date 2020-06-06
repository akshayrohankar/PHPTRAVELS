package com.framework.PageObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.Resources.base;

public class FlightSearch extends base {

	public FlightSearch() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='nav row-reverse ']/li[2]")
	public WebElement flightTab;

	@FindBy(xpath = "//label[contains(text(),'Round Trip')]")
	public WebElement roundTripBtn;

	@FindBy(xpath = "//span[contains(text(),'Economy')]")
	public WebElement travelTypeDrodwn;

	@FindBy(xpath = "//div[contains(@id,'location_from')]")
	public WebElement sourceCity;

	@FindBy(xpath = "//div[contains(@id,'location_to')]")
	public WebElement destinationCity;

	@FindBy(xpath = "//input[@id='FlightsDateStart']")
	public WebElement departDate;

	@FindBy(css = "body.with-waypoint-sticky:nth-child(2) div.datepickers-container:nth-child(9) div.datepicker.-bottom-left-.-from-bottom-:nth-child(8) div.datepicker--content div.datepicker--days.datepicker--body.active div.datepicker--cells.datepicker--cells-days > div.datepicker--cell.datepicker--cell-day.-weekend-.-current-")
	public WebElement todaysDate;

	@FindBy(css = "body.with-waypoint-sticky:nth-child(2) div.datepickers-container:nth-child(9) div.datepicker.-bottom-left-.-from-bottom-:nth-child(9) div.datepicker--content div.datepicker--days.datepicker--body.active div.datepicker--cells.datepicker--cells-days > div.datepicker--cell.datepicker--cell-day.-weekend-.-current-+div")
	public WebElement tomorrowsDate;

	@FindBy(xpath = "//input[@id='FlightsDateEnd']")
	public WebElement returnDate;

	@FindBy(xpath = "//div[contains(@class,'row no-gutters mb-15 row-reverse')]//div[contains(@class,'row no-gutters')]//div[1]//div[1]//div[2]//div[1]//span[1]//button[1]")
	public WebElement addAdult;

	@FindBy(xpath = "//div[@id='flights']//div[2]//div[1]//div[2]//div[1]//span[1]//button[1]")
	public WebElement addChild;

	@FindBy(xpath = "//div[contains(@class,'col-md-4 col-xs-12')]//div[3]//div[1]//div[2]//div[1]//span[1]//button[1]")
	public WebElement addInfant;

	@FindBy(xpath = "//div[@class='col-xs-12 col-md-12']//button[contains(text(),'Search')]")
	public WebElement searchBtn;
	
	@FindBy(xpath = "//p[contains(text(),'0 Total listings found')]")
	public WebElement verifyFlightList;

	
	// Dropdown for travel type
	public void selectTravelType(String ElementName) throws InterruptedException {
		travelTypeDrodwn.click();
		Thread.sleep(2000);
		List<WebElement> DropdownList = driver.findElements(By.xpath("//ul[@class='chosen-results']//li"));
		//System.out.println(DropdownList.size());
		for (int i = 0; i < DropdownList.size(); i++) {
			//System.out.println(DropdownList.get(i).getText());
			if (DropdownList.get(i).getText().equals(ElementName)) {
				DropdownList.get(i).click();
				break;
			}
		}
	}

	public void selectSourceCity(String city) throws InterruptedException {
		sourceCity.click();
		Thread.sleep(2000);
		sourceCity.findElement(By.tagName("a")).sendKeys(city);
		Thread.sleep(2000);
		sourceCity.findElement(By.tagName("a")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	public void selectDestinationCity(String city) throws InterruptedException {
		destinationCity.click();
		Thread.sleep(2000);
		destinationCity.findElement(By.tagName("a")).sendKeys(city);
		Thread.sleep(2000);
		destinationCity.findElement(By.tagName("a")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	public void selectTraveldates() {
		// Select Departure Date
		departDate.click();
		todaysDate.click();
		// Select Return Date
		returnDate.click();
		tomorrowsDate.click();
	}

	public void selectPersonCategories() {
		// Select Adult,Child,Infant
		addAdult.click();
		addChild.click();
		addInfant.click();
	}

	public void searchFlightsAvailable() {
		searchBtn.click();
	}

	public void verifySearchResults() {
		if(verifyFlightList.isDisplayed()) {
			System.out.println("No flights available");
		}else {
			System.out.println("Available flights are displayed");
		}
		
	}
}
