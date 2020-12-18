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

    public void sendMail(String subject,String description){

        List<Student> students=dao.getStudentList();
        ArrayList<String> list=getEmailList(students);

        Email email = EmailBuilder.startingBlank()
                // yha pr jha jha Name here h wha apna name and emal here h wha email and  password here ki jagah apna paaword daalna tbi mail wala work krega
                //ok bro thanks and problem aaye to puch lena  ok bye bye

                .from("Yash Yadav","yadavyash115@gmail.com")

                .to("", list)
                .withSubject(subject)
                .withReplyTo("Yash Yadav", "yadavyash115@gmail.com")
                .withPlainText(description)
                .buildEmail();

        Mailer mailer = MailerBuilder
                .withSMTPServer("smtp.gmail.com", 587, "yadavyash115@gmail.com", "Honesty@123")
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
       list.add("yadayyash115@gmail.com");
       list.add("amany8194@gmail.com");
        return list;
    }

}
