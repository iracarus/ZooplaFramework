package com.zoopla.pages;

import com.zoopla.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    //Page Factory - OR
    @FindBy(xpath = "//div[contains(@class, 'search search-home wrap search-section-for-sale search-type-search overseas-hero-')]")
    WebElement mainSearch;

    @FindBy(name="q")
    WebElement searchBox;

    @FindBy(id="search-submit")
    WebElement searchBtn;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isAt()
    {
        return mainSearch.isDisplayed();
    }

    public  void goTo()
    {

    }

    public String getTitle()
    {
        return driver.getTitle();
    }

    public SearchResultsPage performSearch(String searchString)
    {
        searchBox.sendKeys(searchString);
        searchBtn.click();
        return new SearchResultsPage();
    }
}
