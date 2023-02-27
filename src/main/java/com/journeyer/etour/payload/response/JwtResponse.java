package com.journeyer.etour.payload.response;

import java.util.List;

public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private int  cust_id;	
  private String email;
  private List<String> roles;

  public JwtResponse(String accessToken,int cust_id, String email, List<String> roles) {
    this.token = accessToken;
    this.cust_id = cust_id;
    this.email = email;
    this.roles = roles;
  }

  public String getAccessToken() {
    return token;
  }

  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }

  public int getCust_Id() {
    return cust_id;
  }

  public void setCust_Id(int cust_id) {
    this.cust_id = cust_id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

public List<String> getRoles() {
    return roles;
  }
}
