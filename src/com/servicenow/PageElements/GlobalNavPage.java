package com.servicenow.PageElements;

import org.openqa.selenium.By;

public class GlobalNavPage {

  public static By navbarGurukulaLogo = (By.xpath("//a[@class='navbar-brand']/img"));
  public static By navbarHome = (By.xpath("//span[@class='glyphicon glyphicon-home']"));

  //Elements under Global Nav Account before Login
  public static By navbarAccount = (By.xpath("//span[@class='glyphicon glyphicon-user']"));
  public static By navbarAccountAuthenticate = (By.xpath("//span[@class='glyphicon glyphicon-log-in']"));
  public static By navbarAccountRegister = (By.xpath("//span[@class='glyphicon glyphicon-plus-sign']"));

  //Elements under Global Nav Entities
  public static By navbarEntities = (By.xpath("//span[@translate='global.menu.entities.main']"));
  public static By navbarEntitiesBranch = (By.xpath("//a[@href='#/branch']/span[@translate='global.menu.entities.branch']"));
  public static By navbarEntitiesStaff = (By.xpath("//a[@href='#/staff']/span[@translate='global.menu.entities.staff']"));

  // Elements under Global Nav Account after Login
  public static By navbarAccountSettings = (By.xpath("//a[@href='#/settings']/span[@translate='global.menu.account.settings']"));
  public static By navbarAccountPassword = (By.xpath("//a[@href='#/password']/span[@translate='global.menu.account.password']"));
  public static By navbarAccountSessions = (By.xpath("//a[@href='#/sessions']/span[@translate='global.menu.account.sessions']"));
  public static By navbarAccountLogout = (By.xpath("//a[@href='']/span[@translate='global.menu.account.logout']"));

}
