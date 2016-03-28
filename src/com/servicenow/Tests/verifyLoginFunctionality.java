package com.servicenow.Tests;

import org.testng.annotations.Test;
import com.servicenow.BaseFramework;
import com.servicenow.Helpers.HomePageHelper;
import com.servicenow.Helpers.LoginHelper;
import com.servicenow.Helpers.RegistrationPageHelper;

public class verifyLoginFunctionality extends BaseFramework{

  @Test(priority=0, groups = {"ServiceNow_FunctionalTests"})
  public void testInValidCredentials() throws Exception {
    LoginHelper lh = new LoginHelper(driver);
    System.out.println("Verify InValid Credentials works as Expected");
    lh.clickLoginLinkOnWelcomePage();
    lh.verifyGlobalNavLoginElements();
    lh.setValidLoginCredentials("notadmin","notadmin");
    lh.clickLoginAuthenticate();
    lh.verifyGlobalNavLoginElements();
  }

  @Test(priority=1, groups = {"ServiceNow_FunctionalTests"})
  public void testValidCredentials() throws Exception {
    LoginHelper lh = new LoginHelper(driver);
    HomePageHelper hph = new HomePageHelper(driver);
    System.out.println("Verify Valid Credentials works as Expected");
    lh.clickGlobalNavBarHome();
    lh.clickLoginLinkOnWelcomePage();
    lh.setValidLoginCredentials("admin","admin");
    lh.clickLoginAuthenticate();
    Thread.sleep(10);
    hph.verifyUserLoggedInSuccessfully("admin");
    hph.verifyGlobalNavHomePageElements();
    hph.clickLogout();
  }

  //Register a New User is not working as expected
  @Test(priority=2, groups = {"ServiceNow_FunctionalTests"})
  public void testRegisterNewUser() throws Exception {
    String[] registerUserDetails = {"testaditya", "testaditya@localhost", "password", "password"};
    LoginHelper lh = new LoginHelper(driver);
    RegistrationPageHelper rph = new RegistrationPageHelper(driver);
    System.out.println("Verify Register a User works as Expected");
    lh.clickRegisterANewAccountOnWelcomePage();
    rph.verifyRegistrationPageElements();
    rph.setRegisterUserDetails(registerUserDetails);
    rph.clickRegisterButton();
    lh.clickGlobalNavBarHome();
    //Write Code for Verification after User is Registered. Presently, the application doesn't work for registration.
  }

}
