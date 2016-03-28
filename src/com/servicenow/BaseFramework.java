package com.servicenow;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BaseFramework {
  public WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException{
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String baseUrl = "http://localhost:8080";
        // Launch Firefox and direct it to the Base URL
        driver.get(baseUrl);
    }

    public WebDriver getDriver(){
      Assert.assertNotNull(driver, "Driver Failed in getDriver()");
      return driver;
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
      //Close the Application after all TESTS have completed Execution
      driver.quit();
    }
}
