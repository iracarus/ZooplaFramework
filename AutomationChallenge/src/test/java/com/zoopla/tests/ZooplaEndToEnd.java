package com.zoopla.tests;

import com.zoopla.base.BaseClass;
import com.zoopla.base.ExcelUtils;
import com.zoopla.base.TestUtil;
import com.zoopla.pages.AgentDetailsPage;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.PropertyDetailsPage;
import com.zoopla.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class ZooplaEndToEnd extends BaseClass {

    HomePage homePage;
    SearchResultsPage searchPage;
    PropertyDetailsPage propertyDetailsPage;
    AgentDetailsPage agentDetailsPage;

    String TestDataSheet = "Property";
    @BeforeMethod
    public void setup()
    {
        initialize();
        homePage  = new HomePage();
        searchPage = new SearchResultsPage();
        propertyDetailsPage = new PropertyDetailsPage();
        agentDetailsPage = new AgentDetailsPage();
    }

    @DataProvider
    public Object[][] getPropertyTestData(){
        Object[][] data = TestUtil.getTestData(TestDataSheet);
        return data;
    }
    @Test(priority=1, dataProvider = "getPropertyTestData")
    public void verifyAgentDetails(String City, String LocationPosition) throws InterruptedException {
        String expAgentLogo, expAgentName, expAgentPhone;
        String actualAgentLogo, actualAgentName, actualAgentPhone;

        homePage.performSearch(City);
        //searchPage.navigateToPropertyDetails(Integer.valueOf(ExcelUtils.getCellData(1,1)));
        searchPage.navigateToPropertyDetails((int)Double.parseDouble(LocationPosition));

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
