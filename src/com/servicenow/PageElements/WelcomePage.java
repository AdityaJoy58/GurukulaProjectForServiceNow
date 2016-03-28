package com.servicenow.PageElements;

import org.openqa.selenium.By;

public class WelcomePage {

  //Welcome page elements
  public static By gurukulaLogo = (By.xpath("//span[@class='hipster img-responsive img-rounded']"));
  public static By gurukulaTitle = (By.xpath("//h1[@class='ng-scope' or @translate='main.title']"));
  public static By loginLink = (By.linkText("login"));
  public static By registerANewAccount = (By.linkText("Register a new account"));
  public static By navbarGurukulaLogo = (By.xpath("//a[@class='navbar-brand']/img"));
  public static By navbarHome = (By.xpath("//span[@class='glyphicon glyphicon-home']"));
  public static By navbarAccount = (By.xpath("//span[@class='glyphicon glyphicon-user']"));
  public static By navbarAccountAuthenticate = (By.xpath("//span[@class='glyphicon glyphicon-log-in']"));
  public static By navbarAccountRegister = (By.xpath("//span[@class='glyphicon glyphicon-plus-sign']"));

}
