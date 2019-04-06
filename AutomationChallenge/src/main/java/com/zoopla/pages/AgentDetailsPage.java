package com.zoopla.pages;

import com.zoopla.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentDetailsPage extends BaseClass {
    @FindBy(xpath = "//div[@class='sidebar sbt']/img")
    WebElement agentLogo;

    @FindBy(xpath = "//div[@class='sidebar sbt']/p/strong")
    WebElement agentName;

    @FindBy(xpath="//div[@class='sidebar sbt']//span[@class='agent_phone']/a")
    WebElement agentPhone;

    public AgentDetailsPage()
    {
        PageFactory.initElements(driver, this);
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
        return agentPhone.getAttribute("href").replaceAll("tel:", "0").replace("+44", "0").replaceFirst("0", "");
    }
}
