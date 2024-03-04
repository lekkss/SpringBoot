package com.example.emailsmtp.service;

import com.example.emailsmtp.model.EmailDetails;

public interface EmailService {
    String sendSimpleMail(EmailDetails details);

    String sendMailWithAttachment(EmailDetails details);

}
