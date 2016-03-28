package com.servicenow.PageElements;

import org.openqa.selenium.By;

  public class StaffPage {

  public static By staffTitle = (By.xpath("//h2[@translate='gurukulaApp.staff.home.title']"));
  public static By createANewStaffButton = (By.xpath("//span[@translate='gurukulaApp.staff.home.createLabel']"));

  //Search Elements
  public static By searchQueryTextBox = (By.id("searchQuery"));
  public static By searchAStaffButton = (By.xpath("//span[@class='glyphicon glyphicon-search']/../span[text()='Search a Staff']"));
  public static By staffTable = (By.xpath("//div[@class='table-responsive']//th[@translate='gurukulaApp.staff.name' or @translate='gurukulaApp.staff.related_branch']"));
  public static By staffDetailsTable = (By.xpath("//div[@class='table-responsive']/table[@class='table table-striped']/tbody/tr"));
  public static By staffDetailsTableStaffIDColumn = (By.xpath("./td[1]/a"));
  public static By staffDetailsTableStaffNameColumn = (By.xpath("./td[2]"));
  public static By staffDetailsTableStaffRelatedBranchNameColumn = (By.xpath("./td[3]"));
  public static By staffDetailsTableStaffViewColumn = (By.xpath("./td[4]/button/span[@translate='entity.action.view']"));
  public static By staffDetailsTableStaffEditColumn = (By.xpath("./td[4]/button/span[@translate='entity.action.edit']"));
  public static By staffDetailsTableStaffDeleteColumn = (By.xpath("./td[4]/button/span[@translate='entity.action.delete']"));


  //Create or Edit a Staff popup elements
  public static By createOrEditAStaffLabel = (By.id("myStaffLabel"));
  public static By createOrEditAStaffIDReadOnlyField = (By.xpath("//input[@ng-model='staff.id']"));
  public static By createOrEditAStaffNameTextBox= (By.xpath("//input[@ng-model='staff.name']"));
  public static By createOrEditAStaffRelatedBranchNameDropdownList = (By.xpath("//select[@ng-model='staff.related_branchId']"));
  public static By createOrEditAStaffCancelButton = (By.xpath("//span[@translate='entity.action.cancel']"));
  public static By createOrEditAStaffSaveButton = (By.xpath("//span[@translate='entity.action.save']"));

  //Delete Staff Popup Elements
  public static By deleteStaffPopupTitle = (By.xpath("//h4[@translate='entity.delete.title']"));
  public static By deleteStaffPopupConfirmationText = (By.xpath("//p[@translate='gurukulaApp.staff.delete.question']"));
  public static By deleteStaffPopupConfirmationCancelButton = (By.xpath("//div[@id='deleteStaffConfirmation']//span[@translate='entity.action.cancel']"));
  public static By deleteStaffPopupConfirmationDeleteButton = (By.xpath("//div[@id='deleteStaffConfirmation']//span[@translate='entity.action.delete']"));
  public static By deleteStaffPopupConfirmationCloseIcon = (By.xpath("//div[@id='deleteStaffConfirmation']//button[@class='close']"));



}
