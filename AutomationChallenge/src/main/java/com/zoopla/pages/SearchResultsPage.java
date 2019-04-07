package com.zoopla.pages;

import com.zoopla.base.BaseClass;
import com.zoopla.base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchResultsPage extends BaseClass {
    public String selectedPropertySummary, selectedPropertyAddress, selectedPropertyRent;
    String TestDataSheet = "Property";

    public List<WebElement> getPropertyListingObjects()
    {
        List<WebElement> listings = driver.findElements(By.xpath("//ul[@class='listing-results clearfix js-gtm-list']/li[@data-listing-id]"));
        return listings;
    }

    public List<Integer> getPrices(List<WebElement> priceListing)
    {
        List<Integer> prices = new ArrayList<>();
        for(WebElement elem : priceListing)
        {
            WebElement currentPrice = elem.findElement(By.xpath(".//a[@class='listing-results-price text-price']"));
            prices.add(TestUtil.getNumeric(currentPrice.getText()));
        }

        return prices;
    }

    public String getExpectedListingSummary(int propertyNumber)
    {
        String listingSummary;
        List<WebElement> listings = getPropertyListingObjects();
        listingSummary = listings.get(propertyNumber-1).findElement(By.xpath(".//div[@class='listing-results-right clearfix']/h2/a")).getText();
        selectedPropertySummary = listingSummary;
        return listingSummary;
    }

    public String getExpectedListingAddress(int propertyNumber)
    {
        String listingAddress;
        List<WebElement> listings = getPropertyListingObjects();
        listingAddress = listings.get(propertyNumber-1).findElement(By.xpath(".//div[@class='listing-results-right clearfix']/span/a")).getText();
        selectedPropertyAddress = listingAddress;
        return listingAddress;
    }

    public PropertyDetailsPage navigateToPropertyDetails(int propertyNumber)
    {
        List<WebElement> listings = getPropertyListingObjects();
        selectedPropertyRent = listings.get(propertyNumber-1).findElement(By.xpath(".//a[@class='listing-results-price text-price']")).getText();
        listings.get(propertyNumber-1).findElement(By.xpath(".//a[@class='listing-results-price text-price']")).click();
        return new PropertyDetailsPage();
    }

    public void verifySearchPageTitle(String cityName) {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains(cityName));
    }


}
