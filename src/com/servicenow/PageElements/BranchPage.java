package com.servicenow.PageElements;

import org.openqa.selenium.By;

public class BranchPage {

  //Branch page Elements
  public static By branchesTitle = (By.xpath("//h2[@translate='gurukulaApp.branch.home.title']"));
  public static By createANewBranchButton = (By.xpath("//span[@translate='gurukulaApp.branch.home.createLabel']"));

  //Search Elements
  public static By searchQueryTextBox = (By.id("searchQuery"));
  public static By searchABranchButton = (By.xpath("//span[@class='glyphicon glyphicon-search']/../span[text()='Search a Branch']"));
  public static By branchTable = (By.xpath("//div[@class='table-responsive']//th[@translate='gurukulaApp.branch.name' or @translate='gurukulaApp.branch.code']"));
  public static By branchDetailsTable = (By.xpath("//div[@class='table-responsive']/table[@class='table table-striped']/tbody/tr"));
  public static By branchDetailsTableBranchIDColumn = (By.xpath("./td[1]/a"));
  public static By branchDetailsTableBranchNameColumn = (By.xpath("./td[2]"));
  public static By branchDetailsTableBranchCodeColumn = (By.xpath("./td[3]"));
  public static By branchDetailsTableBranchViewColumn = (By.xpath("./td[4]/button/span[@translate='entity.action.view']"));
  public static By branchDetailsTableBranchEditColumn = (By.xpath("./td[4]/button/span[@translate='entity.action.edit']"));
  public static By branchDetailsTableBranchDeleteColumn = (By.xpath("./td[4]/button/span[@translate='entity.action.delete']"));

  //Create or Edit a Branch pop up elements
  public static By createOrEditABranchLabel = (By.id("myBranchLabel"));
  public static By createOrEditABranchIDReadOnlyField = (By.xpath("//input[@ng-model='branch.id']"));
  public static By createOrEditABranchNameTextBox= (By.xpath("//input[@ng-model='branch.name']"));
  public static By createOrEditABranchCodeTextBox = (By.xpath("//input[@ng-model='branch.code']"));
  public static By createOrEditABranchCancelButton = (By.xpath("//span[@translate='entity.action.cancel']"));
  public static By createOrEditABranchSaveButton = (By.xpath("//span[@translate='entity.action.save']"));

  //Delete Branch Pop up Elements
  public static By deleteBranchPopupTitle = (By.xpath("//h4[@translate='entity.delete.title']"));
  public static By deleteBranchPopupConfirmationText = (By.xpath("//p[@translate='gurukulaApp.branch.delete.question']"));
  public static By deleteBranchPopupConfirmationCancelButton = (By.xpath("//div[@id='deleteBranchConfirmation']//span[@translate='entity.action.cancel']"));
  public static By deleteBranchPopupConfirmationDeleteButton = (By.xpath("//div[@id='deleteBranchConfirmation']//span[@translate='entity.action.delete']"));
  public static By deleteBranchPopupConfirmationCloseIcon = (By.xpath("//div[@id='deleteBranchConfirmation']//button[@class='close']"));


}
