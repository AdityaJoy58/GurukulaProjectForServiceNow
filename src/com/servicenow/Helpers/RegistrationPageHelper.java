package com.servicenow.Helpers;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.servicenow.PageElements.RegistrationPage;

//Helper Class where related Functions for Registration Page are available
public class RegistrationPageHelper {

  private WebDriver driver;

  public RegistrationPageHelper(WebDriver d){
    this.driver = d;
    Assert.assertNotNull(driver, "Driver Failed in getDriver()");
  }

  public void verifyRegistrationPageElements() throws InterruptedException{
    System.out.println("Verify Registration Page Elements Started");
    Assert.assertTrue(driver.findElement(RegistrationPage.registrationLoginTextBox).isDisplayed(), "Registration Page Login text box Element Not Found");
    Assert.assertTrue(driver.findElement(RegistrationPage.registrationEmailTextBox).isDisplayed(), "Registration Page Email text box Element Not Found");
    Assert.assertTrue(driver.findElement(RegistrationPage.registrationNewPasswordTextBox).isDisplayed(), "Registration Page New Password text box Element Not Found");
    Assert.assertTrue(driver.findElement(RegistrationPage.registrationNewPasswordConfirmationTextBox).isDisplayed(), "Registration Page Password Confirmation text box Element Not Found");
    Assert.assertTrue(driver.findElement(RegistrationPage.registrationRegisterButton).isDisplayed(), "Registration Page Register Button Element Not Found");
    Assert.assertFalse(driver.findElement(RegistrationPage.registrationRegisterButton).isEnabled(), "Registration Page Register Button is Enabled which is not as Expected");
    Assert.assertTrue(driver.findElement(RegistrationPage.registrationLoginLink).isDisplayed(), "Registration Page Login Link Element Not Found");
    System.out.println("Verify Registration Page Elements Completed");
  }

  public void setRegisterUserDetails(String[] userDetails) throws InterruptedException{
    System.out.println("Verify Register a User Started");
    driver.findElement(RegistrationPage.registrationLoginTextBox).clear();
    driver.findElement(RegistrationPage.registrationLoginTextBox).sendKeys(userDetails[0]);
    driver.findElement(RegistrationPage.registrationEmailTextBox).clear();
    driver.findElement(RegistrationPage.registrationEmailTextBox).sendKeys(userDetails[1]);
    driver.findElement(RegistrationPage.registrationNewPasswordTextBox).clear();
    driver.findElement(RegistrationPage.registrationNewPasswordTextBox).sendKeys(userDetails[2]);
    driver.findElement(RegistrationPage.registrationNewPasswordConfirmationTextBox).clear();
    driver.findElement(RegistrationPage.registrationNewPasswordConfirmationTextBox).sendKeys(userDetails[3]);
    Assert.assertTrue(driver.findElement(RegistrationPage.registrationRegisterButton).isEnabled(), "Registration Page Register Button is not Enabled which is not as Expected");
    driver.findElement(RegistrationPage.registrationRegisterButton).click();
    System.out.println("Verify Register a User Completed");
  }

  public void clickRegisterButton() throws InterruptedException{
    System.out.println("Click Register button Started");
    Assert.assertTrue(driver.findElement(RegistrationPage.registrationRegisterButton).isEnabled(), "Registration Page Register Button is not Enabled which is not as Expected");
    driver.findElement(RegistrationPage.registrationRegisterButton).click();
    System.out.println("Click Register button Completed");
  }
}
