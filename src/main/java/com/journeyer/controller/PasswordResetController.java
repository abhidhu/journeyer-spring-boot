package com.journeyer.controller;

import com.journeyer.modal.Customer;
import com.journeyer.modal.PasswordReset;
import com.journeyer.repository.Customerrepo;
import com.journeyer.services.PasswordResetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class PasswordResetController {

    @Autowired
    PasswordResetService passwordResetService;

    @Autowired
    Customerrepo customerrepo;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping(value = "/sendotp")
    public String genarateOtp(@RequestBody PasswordReset passwordReset){

        System.out.println("Request come to send email");

        if(passwordReset.getEmail()==null)  return "envalid email id";
        Optional<Customer> customerOptional=customerrepo.findByEmail(passwordReset.getEmail());
        Customer customer=customerOptional.get();

        if(customer==null)      return "envalid email id 2";

        String email=passwordReset.getEmail();
        passwordReset.setCust_Id(customer.getCust_Id());

        String otp= passwordResetService.genarateOtp();
        passwordReset.setOtp(otp);
        boolean isSend=passwordResetService.sendOpt(passwordReset);

        if(!isSend)     return "Otp not send due to technical isssue";

        passwordResetService.save(passwordReset);

        return "OTP genareted succefully! Check your email to reset a password!!";

    }

    @PostMapping(value = "setpassword")
    public String setOtp(@RequestBody PasswordReset passwordReset){
        System.out.println(passwordReset.getOtp());
        System.out.println(passwordReset.getEmail());
        if(passwordReset.getOtp()==null)        return "invalide otp";

        List<PasswordReset> allPasswordReset=passwordResetService.getAll();

        for(PasswordReset p: allPasswordReset){
            if(p.getOtp().equals(passwordReset.getOtp()) && passwordReset.getEmail().equals(p.getEmail())){
                Optional<Customer> customerOptional=customerrepo.findByEmail(passwordReset.getEmail());
                Customer customer=customerOptional.get();
                String password=encoder.encode(passwordReset.getPassword());

                customer.setPassword(password);

                customerrepo.save(customer);

                passwordResetService.delete(customer.getCust_Id());


                return "Password updated successfully!!!";
            }
        }


        return "invalide otp";


    }
}
