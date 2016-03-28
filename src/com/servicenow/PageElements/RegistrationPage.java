package com.servicenow.PageElements;

import org.openqa.selenium.By;

public class RegistrationPage {

  public static By registrationLoginTextBox = (By.xpath("//input[@ng-model='registerAccount.login']"));
  public static By registrationEmailTextBox = (By.xpath("//input[@ng-model='registerAccount.email']"));
  public static By registrationNewPasswordTextBox = (By.xpath("//input[@ng-model='registerAccount.password']"));
  public static By registrationNewPasswordConfirmationTextBox = (By.xpath("//input[@ng-model='confirmPassword']"));
  public static By registrationRegisterButton = (By.xpath("//button[@translate='register.form.button']"));
  public static By registrationLoginLink = (By.xpath("//div[@translate='global.messages.info.authenticated']/a[@href='#/login']"));

}
