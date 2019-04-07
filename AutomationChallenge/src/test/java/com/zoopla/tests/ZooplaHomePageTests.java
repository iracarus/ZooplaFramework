package com.zoopla.tests;

import com.zoopla.base.BaseClass;
import com.zoopla.pages.AgentDetailsPage;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.PropertyDetailsPage;
import com.zoopla.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class ZooplaHomePageTests extends BaseClass {
    HomePage homePage;

    @BeforeClass
    public void setup()
    {
        initialize();
        homePage  = new HomePage();
    }

    @Test(priority=1)
    public void verifyHomePageTitle()
    {
        String title = homePage.getTitle();
        Assert.assertEquals(title, "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents");
    }

    @AfterClass
    public void end()
    {
        tearDown();
    }
}
