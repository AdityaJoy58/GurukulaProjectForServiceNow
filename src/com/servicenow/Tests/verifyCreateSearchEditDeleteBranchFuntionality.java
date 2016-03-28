package com.servicenow.Tests;

import org.testng.annotations.Test;

import com.servicenow.BaseFramework;
import com.servicenow.Helpers.BranchPageHelper;
import com.servicenow.Helpers.CommonHelpers;
import com.servicenow.Helpers.HomePageHelper;
import com.servicenow.Helpers.LoginHelper;

public class verifyCreateSearchEditDeleteBranchFuntionality extends BaseFramework {

  CommonHelpers ch = new CommonHelpers();
  String branchName = ch.generateRandomString(15);
  String branchCode = ch.generateAlphanumericRandomString(8);
  String editedBranchName = ch.generateRandomString(15);
  String editedBranchCode = ch.generateAlphanumericRandomString(8);

  @Test(priority=0, groups = {"ServiceNow_FunctionalTests"})
  public void testCreateANewBranchAndVerify() throws Exception {
    LoginHelper lh = new LoginHelper(driver);
    HomePageHelper hph = new HomePageHelper(driver);
    BranchPageHelper bph = new BranchPageHelper(driver);
    System.out.println("Verify Create a New Branch works as Expected");
    lh.loginUtility();
    hph.clickEntitiesBranchButton();
    bph.verifyBranchPageElements();
    bph.clickCreateANewBranchButton();
    bph.verifyCreateOrEditABranchElements();
    bph.setCreateOrEditABranchData(branchName,branchCode);
    // Verify Cancel Works
    bph.clickCancelButtonInCreateOrEditABranch();

    bph.clickCreateANewBranchButton();
    bph.verifyCreateOrEditABranchElements();
    bph.setCreateOrEditABranchData(branchName,branchCode);
    // Verify Save Works
    bph.clickSaveButtonInCreateOrEditABranch();
    bph.verifyBranchInTable(branchName,branchCode,true);
  }

  @Test(priority=1, groups = {"ServiceNow_FunctionalTests"})
  public void testSearchABranchWithBranchName() throws Exception {
    LoginHelper lh = new LoginHelper(driver);
    HomePageHelper hph = new HomePageHelper(driver);
    BranchPageHelper bph = new BranchPageHelper(driver);
    System.out.println("Verify Search a Branch With Branch Name works as Expected");
    lh.loginUtility();
    hph.clickEntitiesBranchButton();
    bph.verifyBranchPageElements();
    bph.setQueryToSearchABranch(branchName);
    bph.clickSearchABranchButton();
    bph.verifyBranchInTable(branchName,"",true);
  }

  @Test(priority=2, groups = {"ServiceNow_FunctionalTests"})
  public void testSearchABranchWithBranchCode() throws Exception {
    LoginHelper lh = new LoginHelper(driver);
    HomePageHelper hph = new HomePageHelper(driver);
    BranchPageHelper bph = new BranchPageHelper(driver);
    System.out.println("Verify Search a Branch With Branch Code works as Expected");
    lh.loginUtility();
    hph.clickEntitiesStaffButton();
    hph.clickEntitiesBranchButton();
    bph.verifyBranchPageElements();
    bph.setQueryToSearchABranch(branchCode);
    bph.clickSearchABranchButton();
    bph.verifyBranchInTable("", branchCode,true);
  }

  @Test(priority=3, groups = {"ServiceNow_FunctionalTests"})
  public void testEditABranch() throws Exception {
    LoginHelper lh = new LoginHelper(driver);
    HomePageHelper hph = new HomePageHelper(driver);
    BranchPageHelper bph = new BranchPageHelper(driver);
    System.out.println("Verify Edit a Branch works as Expected");
    lh.loginUtility();
    hph.clickEntitiesStaffButton();
    hph.clickEntitiesBranchButton();
    bph.verifyBranchPageElements();
    bph.clickEditBranchButton(branchName);
    bph.verifyCreateOrEditABranchElements();
    bph.setCreateOrEditABranchData(editedBranchName,editedBranchCode);
    bph.clickSaveButtonInCreateOrEditABranch();
    bph.verifyBranchInTable(editedBranchName,editedBranchCode,true);
  }

  @Test(priority=4, groups = {"ServiceNow_FunctionalTests"})
  public void testDeleteABranch() throws Exception {
    LoginHelper lh = new LoginHelper(driver);
    HomePageHelper hph = new HomePageHelper(driver);
    BranchPageHelper bph = new BranchPageHelper(driver);
    System.out.println("Verify Delete a Branch works as Expected");
    lh.loginUtility();
    hph.clickEntitiesStaffButton();
    hph.clickEntitiesBranchButton();
    bph.verifyBranchPageElements();
    String branchID = bph.clickDeleteBranchButton(editedBranchName);
    bph.verifyDeletePopupElements(branchID);
    bph.clickDeleteButtonOnDeleteBranchPopup();
    bph.verifyBranchInTable(editedBranchName,editedBranchCode,false);
  }
}
