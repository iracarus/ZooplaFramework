package com.zoopla.tests;

import com.zoopla.base.BaseClass;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.SearchResultsPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class ZooplaSearchResultsTests extends BaseClass {
    HomePage homePage;
    SearchResultsPage searchPage;

    @BeforeMethod
    public void setup()
    {
        initialize();
        homePage  = new HomePage();
        searchPage = new SearchResultsPage();
    }

    @Test(priority=1)
    public void printPricesDescending()
    {
        String cityName = "London";
        homePage.performSearch(cityName);
        List<WebElement> listings = searchPage.getPropertyListingObjects();
        List<Integer> prices = searchPage.getPrices(listings);
        Collections.sort(prices);

        for( int i = prices.size()-1; i >= 0; i--)
            System.out.println(prices.get(i));
    }

}
