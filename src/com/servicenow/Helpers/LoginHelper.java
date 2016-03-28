package com.servicenow.Helpers;

import com.servicenow.PageElements.GlobalNavPage;
import com.servicenow.PageElements.LoginPage;
import com.servicenow.PageElements.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

//Helper Class where related Functions for Login Page are available
public class LoginHelper {

  private WebDriver driver;

  public LoginHelper(WebDriver d){
    this.driver = d;
    Assert.assertNotNull(driver, "Driver Failed in getDriver()");
  }

  public void clickGlobalNavBarHome() throws Exception{
    Assert.assertTrue(driver.findElement(GlobalNavPage.navbarHome).isDisplayed(), "Global Nav bar Home Element Not Found");
    driver.findElement(GlobalNavPage.navbarHome).click();
  }

  public void clickRegisterANewAccountOnWelcomePage() throws Exception{
    Assert.assertTrue(driver.findElement(WelcomePage.registerANewAccount).isDisplayed(), "Register a New Account link Element Not Found");
    driver.findElement(WelcomePage.registerANewAccount).click();
  }

  public void clickLoginLinkOnWelcomePage() throws Exception{
    Assert.assertTrue(driver.findElement(WelcomePage.loginLink).isDisplayed(), "Login link Element Not Found");
    driver.findElement(WelcomePage.loginLink).click();
  }

  public void verifyLoginPageElements() throws Exception{
    System.out.println("Verifying Login Page Elements Started");
    Assert.assertTrue(driver.findElement(LoginPage.loginTextBox).isDisplayed(), "Login Page Login textbox Element Not Found");
    Assert.assertTrue(driver.findElement(LoginPage.passwordTextBox).isDisplayed(), "Login Page Password textbox Element Not Found");
    Assert.assertTrue(driver.findElement(LoginPage.automaticLogin).isDisplayed(), "Login Page Automatic Login checkbox Element Not Found");
    Assert.assertTrue(driver.findElement(LoginPage.authenticateLogin).isDisplayed(), "Login Page Authenticate button Element Not Found");
    Assert.assertTrue(driver.findElement(LoginPage.didYouForgetYourPassword).isDisplayed(), "Login Page Did you Forget your password Element Not Found");
    Assert.assertTrue(driver.findElement(LoginPage.registerANewAccount).isDisplayed(), "Login Page Register a New Account Element Not Found");
    System.out.println("Verifying Login Page Elements Completed");

  }

  public void verifyGlobalNavLoginElements() throws Exception{
    System.out.println("Verify Global Nav Login Page Elements Started");
    Assert.assertFalse(driver.findElements(GlobalNavPage.navbarEntities).size() > 0, "In Login Page, Entities Section Found which is not Expected");
    driver.findElement(GlobalNavPage.navbarAccount).click();
    Assert.assertTrue(driver.findElement(GlobalNavPage.navbarAccountAuthenticate).isDisplayed(), "In Login Page, Authenticate option is not Found under Global Nav Account section which is not expected");
    Assert.assertTrue(driver.findElement(GlobalNavPage.navbarAccountRegister).isDisplayed(), "In Login Page, Register option is not Found under Global Nav Account section which is not expected");
    Assert.assertFalse(driver.findElements(GlobalNavPage.navbarAccountSettings).size() > 0, "In Login Page, Settings option is Found under Global Nav Account section which is not expected");
    Assert.assertFalse(driver.findElements(GlobalNavPage.navbarAccountPassword).size() > 0, "In Login Page, Password option is Found under Global Nav Account section which is not expected");
    Assert.assertFalse(driver.findElements(GlobalNavPage.navbarAccountSessions).size() > 0, "In Login Page, Sessions option is Found under Global Nav Account section which is not expected");
    Assert.assertFalse(driver.findElements(GlobalNavPage.navbarAccountLogout).size() > 0, "In Login Page, Logout option is Found under Global Nav Account section which is not expected");
    System.out.println("Verify Global Nav Login Page Elements Completed");
  }

  public void setValidLoginCredentials(String login, String password) throws Exception{
    System.out.println("Set Login Credentials Started");
    verifyLoginPageElements();
    driver.findElement(LoginPage.loginTextBox).clear();
    driver.findElement(LoginPage.loginTextBox).sendKeys(login);
    driver.findElement(LoginPage.passwordTextBox).clear();
    driver.findElement(LoginPage.passwordTextBox).sendKeys(password);
    System.out.println("Set Login Credentials Completed");
  }

  public void clickLoginAuthenticate() throws Exception{
    Assert.assertTrue(driver.findElement(LoginPage.authenticateLogin).isDisplayed(), "Login Page Authenticate button Element Not Found");
    driver.findElement(LoginPage.authenticateLogin).click();
  }

//Login Utility
  public void loginUtility() throws Exception{
    HomePageHelper hph = new HomePageHelper(driver);
    System.out.println("Verify Valid Credentials works as Expected");
    clickLoginLinkOnWelcomePage();
    setValidLoginCredentials("admin","admin");
    clickLoginAuthenticate();
    hph.verifyUserLoggedInSuccessfully("admin");
    hph.verifyGlobalNavHomePageElements();
  }

}
