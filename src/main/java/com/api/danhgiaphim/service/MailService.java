package com.api.danhgiaphim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendResetEmail(String to, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Yêu cầu đặt lại mật khẩu");

        message.setText("Mã xác thực đặt lại mật khẩu của bạn là:\n\n👉 " + token
                + "\n\nMã có hiệu lực trong 15 phút. Vui lòng không chia sẻ mã này.");

        mailSender.send(message);
    }
}
