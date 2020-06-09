package com.framework.FlightSearchTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.PageObjectRepository.FlightSearch;
import com.framework.Resources.base;

public class FlightSearchTest extends base {

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void searchFlightFunctionalityTest() throws InterruptedException {

		// Navigate to Flight Tab
		FlightSearch flight = new FlightSearch();
		flight.flightTab.click();

		// Click on RoundTrip button if not selected
		if (!flight.roundTripBtn.isSelected()) {
			flight.roundTripBtn.click();
		}

		// Select "Business" from dropdown
		flight.selectTravelType(prop.getProperty("travelClass"));
		// Select source city
		flight.selectSourceCity(prop.getProperty("sourceCity"));
		// select destination city
		flight.selectDestinationCity(prop.getProperty("destinationCity"));
		// select travel dates (source-Today destination-Tomorrow selected for demo)
		flight.selectTraveldates();
		// select persons categories
		flight.selectPersonCategories();
		// click on search button and begin searching for flights available
		flight.searchFlightsAvailable();
		// verify if flight list is displayed or not
		flight.verifySearchResults();
	}

	@AfterTest
	public void teardown() throws IOException {
		driver.quit();
	}
}
