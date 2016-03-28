package com.servicenow.Helpers;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.servicenow.PageElements.StaffPage;

//Helper Class where related Functions for Staff Page are available
public class StaffPageHelper {

  private WebDriver driver;
  private WebDriverWait wait;

  public StaffPageHelper(WebDriver d){
    this.driver = d;
    Assert.assertNotNull(driver, "Driver Failed in getDriver()");
    wait = new WebDriverWait(driver, 10);
  }

  public void verifyStaffPageElements() throws InterruptedException{
    System.out.println("Verify Staff Page Elements Started");
    Assert.assertTrue(driver.findElement(StaffPage.staffTitle).isDisplayed(), "Staff Page Staff Title Element Not Found");
    Assert.assertTrue(driver.findElement(StaffPage.createANewStaffButton).isDisplayed(), "Staff Page Create a New Staff button Element Not Found");
    Assert.assertTrue(driver.findElement(StaffPage.searchQueryTextBox).isDisplayed(), "Staff Page Search a Query text box Element Not Found");
    Assert.assertTrue(driver.findElement(StaffPage.searchAStaffButton).isDisplayed(), "Staff Page Search a Staff button Element Not Found");
    Assert.assertTrue(driver.findElement(StaffPage.staffTable).isDisplayed(), "Staff Page Staff table Element Not Found");
    System.out.println("Verify Staff Page Elements Completed");
  }

  public void clickCreateANewStaffButton() throws InterruptedException{
    Assert.assertTrue(driver.findElement(StaffPage.createANewStaffButton).isDisplayed(), "Staff Page Create a New Staff button Element Not Found");
    driver.findElement(StaffPage.createANewStaffButton).click();
  }

  public void verifyCreateOrEditAStaffElements() throws InterruptedException{
    System.out.println("Verify Create or Edit a Staff section Elements Started");
    wait.until(ExpectedConditions.visibilityOfElementLocated(StaffPage.createOrEditAStaffLabel));
    Assert.assertTrue(driver.findElement(StaffPage.createOrEditAStaffLabel).isDisplayed(), "Staff Page Create or Edit a Staff Label Element Not Found");
    Assert.assertTrue(driver.findElement(StaffPage.createOrEditAStaffIDReadOnlyField).isDisplayed(), "Staff Page Staff Readonly ID Element Not Found");
    Assert.assertTrue(driver.findElement(StaffPage.createOrEditAStaffNameTextBox).isDisplayed(), "Staff Page Staff Name text box Element Not Found");
    Assert.assertTrue(driver.findElement(StaffPage.createOrEditAStaffRelatedBranchNameDropdownList).isDisplayed(), "Staff Page Staff Related Branch Name Dropdown list Element Not Found");
    Assert.assertTrue(driver.findElement(StaffPage.createOrEditAStaffCancelButton).isDisplayed(), "Staff Page Cancel button Element Not Found");
    Assert.assertTrue(driver.findElement(StaffPage.createOrEditAStaffSaveButton).isDisplayed(), "Staff Page Save button Element Not Found");
    System.out.println("Verify Create or Edit a Staff section Elements Completed");
  }

  public String setCreateOrEditAStaffData(String name) throws InterruptedException{
    System.out.println("Verify Set Create a New Staff Data Started");
    Assert.assertNotNull(driver.findElement(StaffPage.createOrEditAStaffIDReadOnlyField).getAttribute("readonly"),"Staff Page Staff ID Element is Editable which is not as expected");
    driver.findElement(StaffPage.createOrEditAStaffNameTextBox).clear();
    driver.findElement(StaffPage.createOrEditAStaffNameTextBox).sendKeys(name);
    Select dropdown = new Select(driver.findElement(StaffPage.createOrEditAStaffRelatedBranchNameDropdownList));
    System.out.println("Sizeeeeee##########" +dropdown.getOptions().size());
    dropdown.selectByIndex(dropdown.getOptions().size()-1);
    System.out.println("Verify Set Create a New Staff Data Completed");
    return dropdown.getFirstSelectedOption().getText();
  }

  public void clickCancelButtonInCreateOrEditAStaff() throws InterruptedException{
    System.out.println("Click Cancel in Create Or Edit a New Staff button Started");
    Assert.assertTrue(driver.findElement(StaffPage.createOrEditAStaffCancelButton).isDisplayed(), "Staff Page Create a New Staff popup Cancel button Element Not Found");
    driver.findElement(StaffPage.createOrEditAStaffCancelButton).click();
    wait.until(ExpectedConditions.invisibilityOfElementLocated(StaffPage.createOrEditAStaffLabel));
    System.out.println("Click Cancel in Create Or Edit a New Staff button Completed");
  }

  public void clickSaveButtonInCreateOrEditAStaff() throws InterruptedException{
    System.out.println("Click Save in Create Or Edit a New Staff button Started");
    Assert.assertTrue(driver.findElement(StaffPage.createOrEditAStaffSaveButton).isDisplayed(), "Staff Page Create a New Staff popup Cancel button Element Not Found");
    driver.findElement(StaffPage.createOrEditAStaffSaveButton).click();
    wait.until(ExpectedConditions.invisibilityOfElementLocated(StaffPage.createOrEditAStaffLabel));
    System.out.println("Click Save in Create Or Edit a New Staff button Completed");
  }

  public void setQueryToSearchAStaff(String searchQuery) throws InterruptedException{
    System.out.println("Click Save in Create Or Edit a New Staff button Started");
    Assert.assertTrue(driver.findElement(StaffPage.searchQueryTextBox).isDisplayed(), "Staff Page Search Query Text box Element Not Found");
    driver.findElement(StaffPage.searchQueryTextBox).clear();
    driver.findElement(StaffPage.searchQueryTextBox).sendKeys(searchQuery);
    System.out.println("Click Save in Create Or Edit a New Staff button Completed");
  }

  public void clickSearchAStaffButton() throws InterruptedException{
    System.out.println("Click Search a Staff button Started");
    Assert.assertTrue(driver.findElement(StaffPage.searchAStaffButton).isDisplayed(), "Staff Page Search a Staff button Element Not Found");
    driver.findElement(StaffPage.searchAStaffButton).click();
    System.out.println("Click Search a Staff button Completed");
  }

  public void verifyStaffInTable(String searchStaffName, String searchStaffRelatedBranchName, boolean staffExistsorNot) throws InterruptedException{
    System.out.println("Verify Staff in Table Started");
    boolean foundStaff = false;
    if(driver.findElements(StaffPage.staffDetailsTable).size() > 0){
      WebElement Webtable=driver.findElement(StaffPage.staffDetailsTable);
      List<WebElement> TotalRowCount=Webtable.findElements(StaffPage.staffDetailsTable);
      System.out.println("Number of Rows in the Staff Table: "+TotalRowCount.size());
      // Now we will Iterate the Table and print the Values
      // for every line, store all columns
      for (WebElement row : TotalRowCount) {
        WebElement staffID = row.findElement(StaffPage.staffDetailsTableStaffIDColumn);
        WebElement staffName = row.findElement(StaffPage.staffDetailsTableStaffNameColumn);
        WebElement staffRelatedBranchName = row.findElement(StaffPage.staffDetailsTableStaffRelatedBranchNameColumn);
        if(searchStaffName!="" && searchStaffRelatedBranchName!="" && staffName.getText().equals(searchStaffName) && staffRelatedBranchName.getText().equals(searchStaffRelatedBranchName)){
          System.out.println("Staff ID: "+staffID.getText()+" |  Staff Name: "+staffName.getText()+" |  Staff Related Branch Name: "+staffRelatedBranchName.getText());
          System.out.println("Validated with Staff Name and Staff Related Branch Name");
          foundStaff = true;
          break;
        }else if(searchStaffName!="" && searchStaffRelatedBranchName=="" && staffName.getText().equals(searchStaffName)){
          System.out.println("Staff ID: "+staffID.getText()+" |  Staff Name: "+staffName.getText()+" |  Staff Related Branch Name: "+staffRelatedBranchName.getText());
          System.out.println("Validated with only Staff Name");
          foundStaff = true;
          break;
        }else if(searchStaffName=="" && searchStaffRelatedBranchName!="" && staffRelatedBranchName.getText().equals(searchStaffRelatedBranchName)){
          System.out.println("Staff ID: "+staffID.getText()+" |  Staff Name: "+staffName.getText()+" |  Staff Related Branch Name: "+staffRelatedBranchName.getText());
          System.out.println("Validated with only Staff Related Branch Name");
          foundStaff = true;
          break;
        }else
          System.out.println("Please Enter the Staff Name or Staff Related Branch Name to Search");
      }
    }
    if(staffExistsorNot){
      Assert.assertTrue(foundStaff,"Staff searched is not Found which is not expected");
      System.out.println("Validated, Staff Exists as Expected");
    }else{
      Assert.assertFalse(foundStaff,"Staff searched is Found which is not expected");
      System.out.println("Validated, Staff doesn't Exist as Expected");
    }
    System.out.println("Verify Staff in Table Completed");
  }

  public void clickEditStaffButton(String presentStaffName) throws InterruptedException{
    System.out.println("Click Edit a Staff button Started");
    Assert.assertTrue(driver.findElements(StaffPage.staffDetailsTable).size() > 0,"Staff Table is Empty");
    WebElement Webtable=driver.findElement(StaffPage.staffDetailsTable);
    List<WebElement> TotalRowCount=Webtable.findElements(StaffPage.staffDetailsTable);
    System.out.println("Number of Rows in the  Staff Table: "+TotalRowCount.size());
    // Now we will Iterate the Table and print the Values
    // for every line, store all columns
    for (WebElement row : TotalRowCount) {
      WebElement staffID = row.findElement(StaffPage.staffDetailsTableStaffIDColumn);
      WebElement staffName = row.findElement(StaffPage.staffDetailsTableStaffNameColumn);
      WebElement staffRelatedBranchName = row.findElement(StaffPage.staffDetailsTableStaffRelatedBranchNameColumn);
      if(presentStaffName!="" && staffName.getText().equals(presentStaffName)){
        System.out.println("Staff ID: "+staffID.getText()+" |  Staff Name: "+staffName.getText()+" |  Staff Related Branch Name: "+staffRelatedBranchName.getText());
        WebElement staffEdit = row.findElement(StaffPage.staffDetailsTableStaffEditColumn);
        staffEdit.click();
        break;
      }
    }
    System.out.println("Click Edit a Staff Button Completed");
  }

  public String clickDeleteStaffButton(String presentStaffName) throws InterruptedException{
    System.out.println("Click Delete a Staff Started");
    Assert.assertTrue(driver.findElements(StaffPage.staffDetailsTable).size() > 0,"Staff Table is Empty");
    WebElement Webtable=driver.findElement(StaffPage.staffDetailsTable);
    List<WebElement> TotalRowCount=Webtable.findElements(StaffPage.staffDetailsTable);
    System.out.println("Number of Rows in the Staff Table: "+TotalRowCount.size());
    // Now we will Iterate the Table and print the Values
    // for every line, store both columns
    WebElement staffID = null;
    for (WebElement row : TotalRowCount) {
      staffID = row.findElement(StaffPage.staffDetailsTableStaffIDColumn);
      WebElement staffName = row.findElement(StaffPage.staffDetailsTableStaffNameColumn);
      WebElement staffRelatedBranchName = row.findElement(StaffPage.createOrEditAStaffRelatedBranchNameDropdownList);
      if(presentStaffName!="" && staffName.getText().equals(presentStaffName)){
        System.out.println("Staff ID: "+staffID.getText()+" |  Staff Name: "+staffName.getText()+" |  Staff Related Branch Name: "+staffRelatedBranchName.getText());
        WebElement staffDelete = row.findElement(StaffPage.staffDetailsTableStaffDeleteColumn);
        staffDelete.click();
        break;
      }
    }
    System.out.println("Click Delete a Staff Completed");
    return staffID.getText();
  }

  public void verifyDeletePopupElements(String staffID) throws InterruptedException{
    System.out.println("Verify Delete Staff Confirmation Popup Elements Started");
    wait.until(ExpectedConditions.visibilityOfElementLocated(StaffPage.deleteStaffPopupConfirmationDeleteButton));
    Assert.assertTrue(driver.findElement(StaffPage.deleteStaffPopupTitle).isDisplayed(), "Staff Page Delete Staff Confirmation popup title Element Not Found");
    Assert.assertTrue(driver.findElement(StaffPage.deleteStaffPopupConfirmationText).isDisplayed(), "Staff Page Delete Staff Confirmation popup Confirmation text Element Not Found");
    Assert.assertEquals("Are you sure you want to delete Staff "+staffID +"?",driver.findElement(StaffPage.deleteStaffPopupConfirmationText).getText(), "Staff Page Delete Staff Confirmation popup Confirmation text is not as expected");
    Assert.assertTrue(driver.findElement(StaffPage.deleteStaffPopupConfirmationCancelButton).isDisplayed(), "Staff Page Delete Staff Confirmation popup Cancel Element Not Found");
    Assert.assertTrue(driver.findElement(StaffPage.deleteStaffPopupConfirmationDeleteButton).isDisplayed(), "Staff Page Delete Staff Confirmation popup Button Element Not Found");
    Assert.assertTrue(driver.findElement(StaffPage.deleteStaffPopupConfirmationCloseIcon).isDisplayed(), "Staff Page Delete Staff Confirmation popup Close icon Element Not Found");
    System.out.println("Verify Delete Staff Confirmation Popup Elements Completed");
  }

  public void clickDeleteButtonOnDeleteStaffPopup() throws InterruptedException{
    System.out.println("Click Delete button on Delete Staff Confirmation Popup Started");
    Assert.assertTrue(driver.findElement(StaffPage.deleteStaffPopupConfirmationDeleteButton).isDisplayed(), "Staff Page Delete Staff Confirmation popup Button Element Not Found");
    driver.findElement(StaffPage.deleteStaffPopupConfirmationDeleteButton).click();
    System.out.println("Click Delete button on Delete Staff Confirmation Popup Completed");
  }
}
