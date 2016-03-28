package com.servicenow.Tests;

import org.testng.annotations.Test;

import com.servicenow.BaseFramework;
import com.servicenow.Helpers.CommonHelpers;
import com.servicenow.Helpers.HomePageHelper;
import com.servicenow.Helpers.LoginHelper;
import com.servicenow.Helpers.StaffPageHelper;

public class verifyCreateSearchEditDeleteStaffFuntionality extends BaseFramework {
  CommonHelpers ch = new CommonHelpers();
  String staffName = ch.generateRandomString(15);
  String staffRelatedBranchName;
  String editedStaffName = ch.generateRandomString(15);

  @Test(priority=0, groups = {"ServiceNow_FunctionalTests"})
  public void testCreateANewStaffAndVerify() throws Exception {
    LoginHelper lh = new LoginHelper(driver);
    HomePageHelper hph = new HomePageHelper(driver);
    StaffPageHelper sph = new StaffPageHelper(driver);
    System.out.println("Verify Create a New Staff works as Expected");
    lh.loginUtility();
    hph.clickEntitiesStaffButton();
    sph.verifyStaffPageElements();
    sph.clickCreateANewStaffButton();
    sph.verifyCreateOrEditAStaffElements();
    sph.setCreateOrEditAStaffData(staffName);
    // Verify Cancel Works
    sph.clickCancelButtonInCreateOrEditAStaff();

    sph.clickCreateANewStaffButton();
    sph.verifyCreateOrEditAStaffElements();
    staffRelatedBranchName = sph.setCreateOrEditAStaffData(staffName);
    // Verify Save Works
    sph.clickSaveButtonInCreateOrEditAStaff();
    sph.verifyStaffInTable(staffName,staffRelatedBranchName,true);

  }

  @Test(priority=1, groups = {"ServiceNow_FunctionalTests"})
  public void testSearchAStaffWithStaffName() throws Exception {
    LoginHelper lh = new LoginHelper(driver);
    HomePageHelper hph = new HomePageHelper(driver);
    StaffPageHelper sph = new StaffPageHelper(driver);
    System.out.println("Verify Search a Staff with Staff Name works as Expected");
    lh.loginUtility();
    hph.clickEntitiesStaffButton();
    sph.verifyStaffPageElements();
    sph.setQueryToSearchAStaff(staffName);
    sph.clickSearchAStaffButton();
    sph.verifyStaffInTable(staffName,"",true);
  }

  @Test(priority=2, groups = {"ServiceNow_FunctionalTests"})
  public void testSearchAStaffWithStaffRelatedBranchName() throws Exception {
    LoginHelper lh = new LoginHelper(driver);
    HomePageHelper hph = new HomePageHelper(driver);
    StaffPageHelper sph = new StaffPageHelper(driver);
    System.out.println("Verify Search a Staff Related Branch Name works as Expected");
    lh.loginUtility();
    hph.clickEntitiesBranchButton();
    hph.clickEntitiesStaffButton();
    sph.verifyStaffPageElements();
    sph.setQueryToSearchAStaff(staffRelatedBranchName);
    sph.clickSearchAStaffButton();
    sph.verifyStaffInTable("",staffRelatedBranchName, true); //This Test Will FAIL because Staff searched with Staff Related Branch Name is not working as expetced in Application. So commented the part
  }

  @Test(priority=3, groups = {"ServiceNow_FunctionalTests"})
  public void testEditAStaff() throws Exception {
    LoginHelper lh = new LoginHelper(driver);
    HomePageHelper hph = new HomePageHelper(driver);
    StaffPageHelper bph = new StaffPageHelper(driver);
    System.out.println("Verify Edit a Staff works as Expected");
    lh.loginUtility();
    hph.clickEntitiesBranchButton();
    hph.clickEntitiesStaffButton();
    bph.verifyStaffPageElements();
    bph.clickEditStaffButton(staffName);
    bph.verifyCreateOrEditAStaffElements();
    staffRelatedBranchName = bph.setCreateOrEditAStaffData(editedStaffName);
    bph.clickSaveButtonInCreateOrEditAStaff();
    bph.verifyStaffInTable(editedStaffName,staffRelatedBranchName,true);
  }

  @Test(priority=4, groups = {"ServiceNow_FunctionalTests"})
  public void testDeleteAStaff() throws Exception {
    LoginHelper lh = new LoginHelper(driver);
    HomePageHelper hph = new HomePageHelper(driver);
    StaffPageHelper bph = new StaffPageHelper(driver);
    System.out.println("Verify Delete a Staff works as Expected");
    lh.loginUtility();
    hph.clickEntitiesBranchButton();
    hph.clickEntitiesStaffButton();
    bph.verifyStaffPageElements();
    String staffID = bph.clickDeleteStaffButton(editedStaffName);
    bph.verifyDeletePopupElements(staffID);
    bph.clickDeleteButtonOnDeleteStaffPopup();
    bph.verifyStaffInTable(editedStaffName,staffRelatedBranchName,false);
  }

}
