package com.servicenow.Helpers;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.servicenow.PageElements.HomePage;
import com.servicenow.PageElements.GlobalNavPage;

//Helper Class where related Functions for Home Page are available
public class HomePageHelper {

  private WebDriver driver;

  public HomePageHelper(WebDriver d){
    this.driver = d;
    Assert.assertNotNull(driver, "Driver Failed in getDriver()");
  }

  public void verifyUserLoggedInSuccessfully(String user) throws InterruptedException{
    System.out.println("Verify User Logged In Sucessfully Started");
    Assert.assertTrue(driver.findElement(HomePage.loggedInVerificationText).isDisplayed(), "Login Page LoggedIn Verification text Element Not Found");
    Assert.assertEquals(driver.findElement(HomePage.loggedInVerificationText).getText(),"You are logged in as user \""+user +"\".", "Login Page LoggedIn Verification text is not as expected");
    System.out.println("Verify User Logged In Sucessfully Completed");
  }

  public void verifyGlobalNavHomePageElements() throws InterruptedException{
    System.out.println("Verify Global Nav Home Page Elements Started");
    Assert.assertTrue(driver.findElement(GlobalNavPage.navbarEntities).isDisplayed(), "Global Nav bar Entities section Element Not Found which is not expected");
    driver.findElement(GlobalNavPage.navbarEntities).click();
    Assert.assertTrue(driver.findElement(GlobalNavPage.navbarEntitiesBranch).isDisplayed(), "Global Nav bar Entities section Branch Option Element Not Found which is not expected");
    Assert.assertTrue(driver.findElement(GlobalNavPage.navbarEntitiesStaff).isDisplayed(), "Global Nav bar Entities section Staff Option Element Not Found which is not expected");
    driver.findElement(GlobalNavPage.navbarAccount).click();
    Assert.assertTrue(driver.findElement(GlobalNavPage.navbarAccountSettings).isDisplayed(), "Global Nav bar Account section Settingss Option Element Not Found which is not expected");
    Assert.assertTrue(driver.findElement(GlobalNavPage.navbarAccountPassword).isDisplayed(), "Global Nav bar Account section Password Option Element Not Found which is not expected");
    Assert.assertTrue(driver.findElement(GlobalNavPage.navbarAccountSessions).isDisplayed(), "Global Nav bar Account section Sessions Option Element Not Found which is not expected");
    Assert.assertTrue(driver.findElement(GlobalNavPage.navbarAccountLogout).isDisplayed(), "Global Nav bar Account section Logout Option Element Not Found which is not expected");
    driver.findElement(GlobalNavPage.navbarAccount).click();
    Assert.assertFalse(driver.findElements(GlobalNavPage.navbarAccountAuthenticate).size() > 0, "Global Nav bar Account section Authenticate Option Element Found which is not expected");
    Assert.assertFalse(driver.findElements(GlobalNavPage.navbarAccountRegister).size() > 0, "Global Nav bar Account section Register Option Element Found which is not expected");
    System.out.println("Verify Global Nav Home Page Elements Completed");
  }

  public void clickEntitiesBranchButton() throws InterruptedException{
    System.out.println("Verify click for Global Nav Entities-> Branch Started");
    Assert.assertTrue(driver.findElement(GlobalNavPage.navbarEntities).isDisplayed(), "Global Nav bar Entities section Element Not Found which is not expected");
    driver.findElement(GlobalNavPage.navbarEntities).click();
    Assert.assertTrue(driver.findElement(GlobalNavPage.navbarEntitiesBranch).isDisplayed(), "Global Nav bar Entities section Branch Option Element Not Found which is not expected");
    driver.findElement(GlobalNavPage.navbarEntitiesBranch).click();
    System.out.println("Verify click for Global Nav Entities-> Branch Completed");
  }

  public void clickEntitiesStaffButton() throws InterruptedException{
    System.out.println("Verify click for Global Nav Entities-> Staff Started");
    Assert.assertTrue(driver.findElement(GlobalNavPage.navbarEntities).isDisplayed(), "Global Nav bar Entities section Element Not Found which is not expected");
    driver.findElement(GlobalNavPage.navbarEntities).click();
    Assert.assertTrue(driver.findElement(GlobalNavPage.navbarEntitiesStaff).isDisplayed(), "Global Nav bar Entities section Staff Option Element Not Found which is not expected");
    driver.findElement(GlobalNavPage.navbarEntitiesStaff).click();
    System.out.println("Verify click for Global Nav Entities-> Staff Completed");
  }

  public void clickLogout() throws InterruptedException{
    System.out.println("Verify User Logout Sucessfully Started");
    driver.findElement(GlobalNavPage.navbarAccount).click();
    Assert.assertTrue(driver.findElement(GlobalNavPage.navbarAccountLogout).isDisplayed(), "Global Nav bar Account section Logout Option Element Not Found which is not expected");
    driver.findElement(GlobalNavPage.navbarAccountLogout).click();
    System.out.println("Verify User Logout Sucessfully Completed");
  }

}
