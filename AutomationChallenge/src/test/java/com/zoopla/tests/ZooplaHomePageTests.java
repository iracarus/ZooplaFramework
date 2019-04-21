package com.zoopla.tests;

import com.zoopla.base.BaseClass;
import com.zoopla.pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;


public class ZooplaHomePageTests extends BaseClass {
    HomePage homePage;

    Logger logger = LogManager.getLogger(ZooplaHomePageTests.class);

    @BeforeClass
    public void setup()
    {
        initialize();
        homePage  = new HomePage();
    }

    @Test(priority=1)
    public void verifyHomePageTitle()
    {
        logger.info("test log4j");
        String title = homePage.getTitle();
        Assert.assertEquals(title, "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents");
    }

    @AfterClass
    public void end()
    {
        tearDown();
    }
}
