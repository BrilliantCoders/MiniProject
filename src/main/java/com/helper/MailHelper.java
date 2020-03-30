package com.helper;

import com.database.AttendanceDAO;
import com.model.Student;
import org.apache.commons.fileupload.util.LimitedInputStream;
import org.apache.pdfbox.cos.COSName;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;

import org.simplejavamail.mailer.config.TransportStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

public class MailHelper {

    @Autowired
    AttendanceDAO dao;

    public void send(String subject,String description){

        List<Student> students=dao.getStudentList();
        ArrayList<String> list=getEmailList(students);

        Email email = EmailBuilder.startingBlank()


                .from("Rajat Kathuriya","kathuriyarajat@gmail.com")

                .to("", list)
                .withSubject(subject)
                .withReplyTo("Rajat Kathuriya", "kathuriyarajat@gmail.com")
                .withPlainText(description)
                .buildEmail();

        Mailer mailer = MailerBuilder
                .withSMTPServer("smtp.gmail.com", 587, "kathuriyarajat@gmail.com", "Rajat@5692")
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                //.withProxy("172.31.100.29", 3128, "edcguest", "edcguest")
                .withSessionTimeout(10 * 1000)
                .withProperty("mail.smtp.auth", "true")
                .withProperty("mail.smtp.starttls.enable","true")
                //.withProperty( "enable_starttls_auto","true")
                .withDebugLogging(true)
                .buildMailer();

        mailer.sendMail(email);

        System.out.println("Message sent...");
    }


    public ArrayList<String> getEmailList(List<Student> students){

        ArrayList<String> list=new ArrayList<String>();
       /* for (Student s: students) {
            list.add(s.getEmail());
        }*/
       list.add("kathuriyarajat@gmail.com");
       list.add("rajurajat41@gmail.com");
        list.add("rajurajat37@gmail.com");
        list.add("rajurajat40@gmail.com");
        list.add("rajurajat38@gmail.com");
        list.add("hello1233232@gmail.com");
        return list;
    }

}
