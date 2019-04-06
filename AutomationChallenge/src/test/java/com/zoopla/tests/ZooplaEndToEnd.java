package com.zoopla.tests;

import com.zoopla.base.BaseClass;
import com.zoopla.pages.AgentDetailsPage;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.PropertyDetailsPage;
import com.zoopla.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ZooplaEndToEnd extends BaseClass {

    HomePage homePage;
    SearchResultsPage searchPage;
    PropertyDetailsPage propertyDetailsPage;
    AgentDetailsPage agentDetailsPage;

    @BeforeMethod
    public void setup()
    {
        initialize();
        homePage  = new HomePage();
        searchPage = new SearchResultsPage();
        propertyDetailsPage = new PropertyDetailsPage();
        agentDetailsPage = new AgentDetailsPage();
    }


    @Test(priority=1)
    public void verifyAgentDetails()
    {
        String cityName = "London";
        String expAgentLogo, expAgentName, expAgentPhone;
        String actualAgentLogo, actualAgentName, actualAgentPhone;

        homePage.performSearch(cityName);
        searchPage.navigateToPropertyDetails(5);
        expAgentLogo = propertyDetailsPage.getAgentLogo();
        expAgentName = propertyDetailsPage.getAgentName();
        expAgentPhone = propertyDetailsPage.getAgentPhone();

        propertyDetailsPage.clickOnAgentLink();

        actualAgentLogo = agentDetailsPage.getAgentLogo();
        actualAgentName = agentDetailsPage.getAgentName();
        actualAgentPhone = agentDetailsPage.getAgentPhone();

        Assert.assertEquals(actualAgentLogo, expAgentLogo);
        Assert.assertEquals(actualAgentName, expAgentName);
        Assert.assertEquals(actualAgentPhone, expAgentPhone);
    }

    @AfterMethod
    public void end()
    {
        tearDown();
    }
}
