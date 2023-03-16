package com.journeyer.modal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class PasswordReset {

    @Id
    private  int cust_Id;
    private String email;
    private String otp;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    private String password;
    private int flag;

    @Override
    public String toString() {
        return "PasswordReset{" +
                "cust_Id=" + cust_Id +
                ", email='" + email + '\'' +
                ", otp='" + otp + '\'' +
                ", flag=" + flag +
                '}';
    }


    public int getCust_Id() {
        return cust_Id;
    }

    public void setCust_Id(int cust_Id) {
        this.cust_Id = cust_Id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

}
