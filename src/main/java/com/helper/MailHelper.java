package com.helper;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;

import org.simplejavamail.mailer.config.TransportStrategy;

public class MailHelper {

    public void send(){
        Email email = EmailBuilder.startingBlank()
                .from("Silver Geeker","silvergeeker@gmail.com")
                .to("Silver Geeker", "silvergeeker@gmail.com")
                .withReplyTo("Silver Geeker", "silvergeeker@gmail.com")
                .withSubject("hey")
                .withPlainText("Please view this email in a modern email client!")
                .buildEmail();

        Mailer mailer = MailerBuilder
                .withSMTPServer("smtp.gmail.com", 587, "silvergeeker@gmail.com", "silver96")
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .withProxy("172.31.100.29", 3128, "edcguest", "edcguest")
                .withSessionTimeout(10 * 1000)
                .withProperty("mail.smtp.auth", "true")
                .withProperty("mail.smtp.starttls.enable","true")
                //.withProperty( "enable_starttls_auto","true")
                .withDebugLogging(true)
                .buildMailer();

        mailer.sendMail(email);

        System.out.println("Message sent...");
    }

}
