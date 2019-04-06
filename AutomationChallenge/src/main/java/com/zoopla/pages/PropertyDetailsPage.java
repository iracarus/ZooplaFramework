package com.zoopla.pages;

import com.zoopla.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertyDetailsPage extends BaseClass {
    // Page Objects - OR
    @FindBy(xpath = "//article[@class='dp-sidebar-wrapper__summary']//h1")
    WebElement propertySummaryObject;

    @FindBy(xpath = "//article[@class='dp-sidebar-wrapper__summary']//h2")
    WebElement propertyAddressObject;

    @FindBy( xpath = "//article[@class='dp-sidebar-wrapper__summary']/div[2]/p")
    WebElement propertyRentObject;

    @FindBy( xpath = "//a[@class='ui-agent__details']//img")
    WebElement agentLogo;

    @FindBy(xpath = "//a[@class='ui-agent__details']//h4[@class='ui-agent__name']")
    WebElement agentName;

    @FindBy(xpath = "//a[@class='ui-agent__details']/parent::div//a[@data-track-label='Agent phone number 1']")
    WebElement agentPhone;

    public PropertyDetailsPage()
    {
        PageFactory.initElements(driver, this);
    }
    public String getPropertySummary()
    {
        return propertySummaryObject.getText();
    }

    public String getPropertyAddress()
    {
        return propertyAddressObject.getText();
    }

    public String getPropertyRent()
    {
        return propertyRentObject.getText();
    }

    public String getAgentName()
    {
        return agentName.getText();
    }

    public String getAgentLogo()
    {
        return agentLogo.getAttribute("src");
    }

    public String getAgentPhone()
    {
        return agentPhone.getAttribute("href").replaceAll("tel:", "");
    }

    public AgentDetailsPage clickOnAgentLink() {
        agentLogo.click();
        return new AgentDetailsPage();
    }
}
