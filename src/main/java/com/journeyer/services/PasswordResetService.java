package com.journeyer.services;

import com.journeyer.modal.PasswordReset;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PasswordResetService {
    public String genarateOtp();
    public void save(PasswordReset passwordReset);

    public String getOtp(int cust_id);

    public boolean sendOpt(PasswordReset passwordReset);

    public List<PasswordReset> getAll();

    public void delete(int id);
}
