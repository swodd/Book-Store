package com.swodd.backend.utility;

import com.swodd.backend.domain.User;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class MailConstructor {
    @Autowired
    private Environment env;

    public SimpleMailMessage constructNewUserEmail(User user, String password){
        String message = "\nPlease use the following credentials to log in and edit your personal information"
                + "/nUsername:" + user.getUsername() + "\nPassword:" + password;
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("Le's Bookstore - New User");
        email.setText(message);
        email.setFrom(env.getProperty("support.email"));
        return email;
    }
}
