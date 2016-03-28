package com.servicenow.PageElements;

import org.openqa.selenium.By;

public class LoginPage {

  public static By loginTextBox = (By.id("username"));
  public static By passwordTextBox = (By.id("password"));
  public static By automaticLogin = (By.id("rememberMe"));
  public static By authenticateLogin = (By.xpath("//button[@class='btn btn-primary ng-scope']"));
  public static By didYouForgetYourPassword = (By.linkText("Did you forget your password?"));
  public static By registerANewAccount = (By.linkText("Register a new account"));

}
