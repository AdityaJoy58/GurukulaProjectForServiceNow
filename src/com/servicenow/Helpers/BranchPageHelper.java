package com.servicenow.Helpers;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.servicenow.PageElements.BranchPage;

//Helper Class where related Functions for Branch Page are available
public class BranchPageHelper {

  private WebDriver driver;
  private WebDriverWait wait;

  public BranchPageHelper(WebDriver d){
    this.driver = d;
    Assert.assertNotNull(driver, "Driver Failed in getDriver()");
    wait = new WebDriverWait(driver, 10);
  }

  public void verifyBranchPageElements() throws InterruptedException{
    System.out.println("Verify Branch Page Elements Started");
    Assert.assertTrue(driver.findElement(BranchPage.branchesTitle).isDisplayed(), "Branch Page Branches Title Element Not Found");
    Assert.assertTrue(driver.findElement(BranchPage.createANewBranchButton).isDisplayed(), "Branch Page Create a New Branch button Element Not Found");
    Assert.assertTrue(driver.findElement(BranchPage.searchQueryTextBox).isDisplayed(), "Branch Page Search Query Text box Element Not Found");
    Assert.assertTrue(driver.findElement(BranchPage.searchABranchButton).isDisplayed(), "Branch Page Search a Branch button Element Not Found");
    Assert.assertTrue(driver.findElement(BranchPage.branchTable).isDisplayed(), "Branch Page Branch Table HeadLine Element Not Found");
    System.out.println("Verify Branch Page Elements Completed");
  }

  public void clickCreateANewBranchButton() throws InterruptedException{
    System.out.println("Click Create a New Branch button Started");
    Assert.assertTrue(driver.findElement(BranchPage.createANewBranchButton).isDisplayed(), "Branch Page Create a New Branch button Element Not Found");
    driver.findElement(BranchPage.createANewBranchButton).click();
    System.out.println("Click Create a New Branch button Completed");
  }

  public void verifyCreateOrEditABranchElements() throws InterruptedException{
    System.out.println("Verify Create or Edit a Branch section Elements Started");
    wait.until(ExpectedConditions.visibilityOfElementLocated(BranchPage.createOrEditABranchLabel));
    Assert.assertTrue(driver.findElement(BranchPage.createOrEditABranchLabel).isDisplayed(), "Branch Page Create or Edit a Branch Label Element Not Found");
    Assert.assertTrue(driver.findElement(BranchPage.createOrEditABranchIDReadOnlyField).isDisplayed(), "Branch Page Branch Readonly ID Element Not Found");
    Assert.assertTrue(driver.findElement(BranchPage.createOrEditABranchNameTextBox).isDisplayed(), "Branch Page Branch Name text box Element Not Found");
    Assert.assertTrue(driver.findElement(BranchPage.createOrEditABranchCodeTextBox).isDisplayed(), "Branch Page Branch Code text box Element Not Found");
    Assert.assertTrue(driver.findElement(BranchPage.createOrEditABranchCancelButton).isDisplayed(), "Branch Page Cancel button Element Not Found");
    Assert.assertTrue(driver.findElement(BranchPage.createOrEditABranchSaveButton).isDisplayed(), "Branch Page Save button Element Not Found");
    System.out.println("Verify Create or Edit a Branch section Elements Completed");
  }

  public void setCreateOrEditABranchData(String name, String code) throws InterruptedException{
    System.out.println("Verify Set Create a New Branch Data Started");
    Assert.assertNotNull(driver.findElement(BranchPage.createOrEditABranchIDReadOnlyField).getAttribute("readonly"),"Branch Page Branch ID Element is Editable which is not as expected");
    driver.findElement(BranchPage.createOrEditABranchNameTextBox).clear();
    driver.findElement(BranchPage.createOrEditABranchNameTextBox).sendKeys(name);
    driver.findElement(BranchPage.createOrEditABranchCodeTextBox).clear();
    driver.findElement(BranchPage.createOrEditABranchCodeTextBox).sendKeys(code);
    System.out.println("Verify Set Create a New Branch Data Completed");
  }

  public void clickCancelButtonInCreateOrEditABranch() throws InterruptedException{
    System.out.println("Click Cancel in Create Or Edit a New Branch button Started");
    Assert.assertTrue(driver.findElement(BranchPage.createOrEditABranchCancelButton).isDisplayed(), "Branch Page Create a New Branch popup Cancel button Element Not Found");
    driver.findElement(BranchPage.createOrEditABranchCancelButton).click();
    wait.until(ExpectedConditions.invisibilityOfElementLocated(BranchPage.createOrEditABranchLabel));
    System.out.println("Click Cancel in Create Or Edit a New Branch button Completed");
  }

  public void clickSaveButtonInCreateOrEditABranch() throws InterruptedException{
    System.out.println("Click Save in Create Or Edit a New Branch button Started");
    Assert.assertTrue(driver.findElement(BranchPage.createOrEditABranchSaveButton).isDisplayed(), "Branch Page Create a New Branch popup Cancel button Element Not Found");
    driver.findElement(BranchPage.createOrEditABranchSaveButton).click();
    wait.until(ExpectedConditions.invisibilityOfElementLocated(BranchPage.createOrEditABranchLabel));
    System.out.println("Click Save in Create Or Edit a New Branch button Completed");
  }

  public void setQueryToSearchABranch(String searchQuery) throws InterruptedException{
    System.out.println("Click Save in Create Or Edit a New Branch button Started");
    Assert.assertTrue(driver.findElement(BranchPage.searchQueryTextBox).isDisplayed(), "Branch Page Search Query Text box Element Not Found");
    driver.findElement(BranchPage.searchQueryTextBox).clear();
    driver.findElement(BranchPage.searchQueryTextBox).sendKeys(searchQuery);
    System.out.println("Click Save in Create Or Edit a New Branch button Completed");
  }

  public void clickSearchABranchButton() throws InterruptedException{
    System.out.println("Click Search a Branch button Started");
    Assert.assertTrue(driver.findElement(BranchPage.searchABranchButton).isDisplayed(), "Branch Page Search a Branch button Element Not Found");
    driver.findElement(BranchPage.searchABranchButton).click();
    System.out.println("Click Search a Branch button Completed");
  }

  public void verifyBranchInTable(String searchBranchName, String searchBranchCode, boolean branchExistsorNot) throws InterruptedException{
    System.out.println("Verify Branch in Table Started");
    boolean foundBranch = false;
    if(driver.findElements(BranchPage.branchDetailsTable).size() > 0){
      WebElement Webtable=driver.findElement(BranchPage.branchDetailsTable);
      List<WebElement> TotalRowCount=Webtable.findElements(BranchPage.branchDetailsTable);
      System.out.println("Number of Rows in the Branch Table: "+TotalRowCount.size());
      // Now we will Iterate the Table and print the Values
      // for every line, store all columns
      for (WebElement row : TotalRowCount) {
        WebElement branchID = row.findElement(BranchPage.branchDetailsTableBranchIDColumn);
        WebElement branchName = row.findElement(BranchPage.branchDetailsTableBranchNameColumn);
        WebElement branchCode = row.findElement(BranchPage.branchDetailsTableBranchCodeColumn);
        if(searchBranchName!="" && searchBranchCode!="" && branchName.getText().equals(searchBranchName) && branchCode.getText().equals(searchBranchCode)){
          System.out.println("Branch ID: "+branchID.getText()+" |  Branch Name: "+branchName.getText()+" |  Branch Code: "+branchCode.getText());
          System.out.println("Validated with Branch Name and Branch Code");
          foundBranch = true;
          break;
        }else if(searchBranchName!="" && searchBranchCode=="" && branchName.getText().equals(searchBranchName)){
          System.out.println("Branch ID: "+branchID.getText()+" |  Branch Name: "+branchName.getText()+" |  Branch Code: "+branchCode.getText());
          System.out.println("Validated with only Branch Name");
          foundBranch = true;
          break;
        }else if(searchBranchName=="" && searchBranchCode!="" && branchCode.getText().equals(searchBranchCode)){
          System.out.println("Branch ID: "+branchID.getText()+" |  Branch Name: "+branchName.getText()+" |  Branch Code: "+branchCode.getText());
          System.out.println("Validated with only Branch Code");
          foundBranch = true;
          break;
        }else
          System.out.println("Please Enter the Branch Name or Branch Code to Search");
      }
    }
    if(branchExistsorNot){
      Assert.assertTrue(foundBranch,"Branch searched is not Found which is not expected");
      System.out.println("Validated, Branch Exists as Expected");
    }else{
      Assert.assertFalse(foundBranch,"Branch searched is Found which is not expected");
      System.out.println("Validated, Branch doesn't Exist as Expected");
    }
    System.out.println("Verify Branch in Table Completed");
  }

  public void clickEditBranchButton(String presentBranchName) throws InterruptedException{
    System.out.println("Click Edit a Branch button Started");
    Assert.assertTrue(driver.findElements(BranchPage.branchDetailsTable).size() > 0,"Branch Table is Empty");
    WebElement Webtable=driver.findElement(BranchPage.branchDetailsTable);
    List<WebElement> TotalRowCount=Webtable.findElements(BranchPage.branchDetailsTable);
    System.out.println("Number of Rows in the Branch Table: "+TotalRowCount.size());
    // Now we will Iterate the Table and print the Values
    // for every line, store all columns
    for (WebElement row : TotalRowCount) {
      WebElement branchID = row.findElement(BranchPage.branchDetailsTableBranchIDColumn);
      WebElement branchName = row.findElement(BranchPage.branchDetailsTableBranchNameColumn);
      WebElement branchCode = row.findElement(BranchPage.branchDetailsTableBranchCodeColumn);
      if(presentBranchName!="" && branchName.getText().equals(presentBranchName)){
        System.out.println("Branch ID: "+branchID.getText()+" |  Branch Name: "+branchName.getText()+" |  Branch Code: "+branchCode.getText());
        WebElement branchEdit = row.findElement(BranchPage.branchDetailsTableBranchEditColumn);
        branchEdit.click();
        break;
      }
    }
    System.out.println("Click Edit a Branch Button Completed");
  }

  public String clickDeleteBranchButton(String presentBranchName) throws InterruptedException{
    System.out.println("Click Delete a Branch Started");
    Assert.assertTrue(driver.findElements(BranchPage.branchDetailsTable).size() > 0,"Branch Table is Empty");
    WebElement Webtable=driver.findElement(BranchPage.branchDetailsTable);
    List<WebElement> TotalRowCount=Webtable.findElements(BranchPage.branchDetailsTable);
    System.out.println("Number of Rows in the Branch Table: "+TotalRowCount.size());
    // Now we will Iterate the Table and print the Values
    // for every line, store both columns
    WebElement branchID = null;
    for (WebElement row : TotalRowCount) {
      branchID = row.findElement(BranchPage.branchDetailsTableBranchIDColumn);
      WebElement branchName = row.findElement(BranchPage.branchDetailsTableBranchNameColumn);
      WebElement branchCode = row.findElement(BranchPage.branchDetailsTableBranchCodeColumn);
      if(presentBranchName!="" && branchName.getText().equals(presentBranchName)){
        System.out.println("Branch ID: "+branchID.getText()+" |  Branch Name: "+branchName.getText()+" |  Branch Code: "+branchCode.getText());
        WebElement branchDelete = row.findElement(BranchPage.branchDetailsTableBranchDeleteColumn);
        branchDelete.click();
        break;
      }
    }
    System.out.println("Click Delete a Branch Completed");
    return branchID.getText();
  }

  public void verifyDeletePopupElements(String branchID) throws InterruptedException{
    System.out.println("Verify Delete Branch Confirmation Popup Elements Started");
    wait.until(ExpectedConditions.visibilityOfElementLocated(BranchPage.deleteBranchPopupConfirmationDeleteButton));
    Assert.assertTrue(driver.findElement(BranchPage.deleteBranchPopupTitle).isDisplayed(), "Branch Page Delete Branch Confirmation popup title Element Not Found");
    Assert.assertTrue(driver.findElement(BranchPage.deleteBranchPopupConfirmationText).isDisplayed(), "Branch Page Delete Branch Confirmation popup Confirmation text Element Not Found");
    Assert.assertEquals("Are you sure you want to delete Branch "+branchID +"?",driver.findElement(BranchPage.deleteBranchPopupConfirmationText).getText(), "Branch Page Delete Branch Confirmation popup Confirmation text is not as expected");
    Assert.assertTrue(driver.findElement(BranchPage.deleteBranchPopupConfirmationCancelButton).isDisplayed(), "Branch Page Delete Branch Confirmation popup Cancel Element Not Found");
    Assert.assertTrue(driver.findElement(BranchPage.deleteBranchPopupConfirmationDeleteButton).isDisplayed(), "Branch Page Delete Branch Confirmation popup Button Element Not Found");
    Assert.assertTrue(driver.findElement(BranchPage.deleteBranchPopupConfirmationCloseIcon).isDisplayed(), "Branch Page Delete Branch Confirmation popup Close icon Element Not Found");
    System.out.println("Verify Delete Branch Confirmation Popup Elements Completed");
  }

  public void clickDeleteButtonOnDeleteBranchPopup() throws InterruptedException{
    System.out.println("Click Delete button on Delete Branch Confirmation Popup Started");
    Assert.assertTrue(driver.findElement(BranchPage.deleteBranchPopupConfirmationDeleteButton).isDisplayed(), "Branch Page Delete Branch Confirmation popup Button Element Not Found");
    driver.findElement(BranchPage.deleteBranchPopupConfirmationDeleteButton).click();
    System.out.println("Click Delete button on Delete Branch Confirmation Popup Completed");
  }
}
