package com.journeyer.services;

import com.journeyer.modal.PasswordReset;
import com.journeyer.repository.PasswordResetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordResetServiceImpl implements   PasswordResetService{

    @Autowired
    PasswordResetRepo passwordResetRepo;

    @Autowired
    Emailservice emailservice;
    @Override
    public String genarateOtp() {
        int otpLength = 6;
        StringBuilder otp = new StringBuilder();
        for(int i = 0; i < otpLength; i++) {
            int digit = (int) (Math.random() * 10);
            otp.append(digit);
        }
        return otp.toString();
    }

    @Override
    public void save(PasswordReset passwordReset) {
        passwordResetRepo.save(passwordReset);
    }

    @Override
    public String getOtp(int cust_id) {
        PasswordReset passwordReset=passwordResetRepo.getById(cust_id);
        return passwordReset.getOtp();
    }

    @Override
    public boolean sendOpt(PasswordReset passwordReset) {
        boolean flag=false;
        try{
            flag= emailservice.sendEmail(passwordReset.getEmail(),"OTP:"+passwordReset.getOtp(),"OTP:"+passwordReset.getOtp()+". Dont share with any one");
        }catch (Exception e){
            System.out.println("otp sending failed");
            return false;
        }
       return flag;
    }

    @Override
    public List<PasswordReset> getAll() {

        return passwordResetRepo.findAll();
    }

    @Override
    public void delete(int id) {
        passwordResetRepo.getById(id);
    }
}
