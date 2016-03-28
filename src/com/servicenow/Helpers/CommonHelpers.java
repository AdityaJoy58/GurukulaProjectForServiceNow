package com.servicenow.Helpers;

import java.util.Random;

// Helper Class where all the common methods helpful for full application are available here
public class CommonHelpers {

  // To Generate Random String [a-zA-Z] of required length
  public String generateRandomString(int length) {
    String data = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random RANDOM = new Random();
    StringBuilder sb = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      sb.append(data.charAt(RANDOM.nextInt(data.length())));
    }
    return sb.toString();
  }

  //To Generate Random Alphanumeric String [0-9A-Z] of required length
  public String generateAlphanumericRandomString(int length) {
    String data = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random RANDOM = new Random();
    StringBuilder sb = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      sb.append(data.charAt(RANDOM.nextInt(data.length())));
    }
    return sb.toString();
  }

}
