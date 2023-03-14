package com.journeyer.services.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Validator {
  
  // Regular expression for email validation
  private static final String EMAIL_PATTERN = 
      "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
      + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
  
  // Regular expression for name validation
  private static final String NAME_PATTERN = "[a-zA-Z]+";
  
//Regular expression for mobile number validation
 private static final String MOBILE_PATTERN = "\\d{10}";
  
  /**
   * Validate email address with regular expression
   * @param email the email address to validate
   * @return true if the email is valid, false otherwise
   */
  public boolean validateEmail(String email) {
    Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }
  
  /**
   * Validate name with regular expression
   * @param name the name to validate
   * @return true if the name is valid, false otherwise
   */
  public boolean validateName(String name) {
    Pattern pattern = Pattern.compile(NAME_PATTERN);
    Matcher matcher = pattern.matcher(name);
    return matcher.matches();
  }
  
  /**
   * Validate mobile number with regular expression
   * @param mobile the mobile number to validate
   * @return true if the mobile number is valid, false otherwise
   */
  public boolean validateMobile(String mobile) {
    Pattern pattern = Pattern.compile(MOBILE_PATTERN);
    Matcher matcher = pattern.matcher(mobile);
    return matcher.matches();
  }
  
}
