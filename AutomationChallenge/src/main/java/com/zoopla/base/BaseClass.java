package com.zoopla.base;

import com.zoopla.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static Properties props;
    public static WebDriver driver;

    public BaseClass() {
        FileInputStream inputFile;
        props = new Properties();
        try {
            inputFile = new FileInputStream("/Users/Kingslayer/Downloads/Selenium/NaveenHybridFramework/AutomationChallenge/src/main/resources/properties.config");
            props.load(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ExcelUtils excel = new ExcelUtils();
    }

    public static void initialize()
    {
        String browserName = props.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);

        driver.get(props.getProperty("url"));
    }

    public void tearDown()
    {
        driver.quit();
    }
}
