package com.epam.travelrecommendation.service;

import com.epam.travelrecommendation.model.Otp;
import com.epam.travelrecommendation.repository.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;

import java.util.Random;

@Service
public class OtpGeneratorService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private OtpRepository otpRepository;
    @Autowired
    private Otp otp;

    void otpGgenerate(String email){
        otp.setOtp(String.valueOf(new Random().nextInt(999999)));
        otp.setEmail(email);
        otp.setExpiry(LocalDateTime.now().plusMinutes(5));
        //should implement otp sending to given mail

    }
    boolean otpValidate(String userOtp){
        return userOtp.equals(otp.getOtp());
    }

}
