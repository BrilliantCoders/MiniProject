/*package com.helper;
import com.chilkatsoft.*;

public class ChilkatExample {

    static {
        try {
            System.loadLibrary("chilkat");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Native code library failed to load.\n" + e);
            System.exit(1);
        }
    }

    public static void main(String argv[])
    {
        // This example requires the Chilkat API to have been previously unlocked.
        // See Global Unlock Sample for sample code.

        // The mailman object is used for sending and receiving email.
        CkMailMan mailman = new CkMailMan();

        // To connect through an HTTP proxy, set the HttpProxyHostname
        // and HttpProxyPort properties to the hostname (or IP address)
        // and port of the HTTP proxy.  Typical port numbers used by
        // HTTP proxy servers are 3128 and 8080.
        mailman.put_HttpProxyHostname("172.31.102.29");
        mailman.put_HttpProxyPort(3128);
        mailman.put_HttpProxyUsername("edcguest");
        mailman.put_HttpProxyPassword("edcguest");

        // Important:  Your HTTP proxy server must allow non-HTTP
        // traffic to pass.  Otherwise this does not work.

        // Set the SMTP server.
        mailman.put_SmtpHost("smtp.gmail.com");

        // Set the SMTP login/password (if required)
        mailman.put_SmtpUsername("rajurajat41@gmail.com");
        mailman.put_SmtpPassword("crcrrajat");

        // Create a new email object
        CkEmail email = new CkEmail();

        email.put_Subject("This is a test");
        email.put_Body("This is a test");
        email.put_From("Chilkat Support rajurajat41@gmail.com");
        boolean success = email.AddTo("Chilkat Admin","rajurajat41@gmail.com");

        // Call SendEmail to connect to the SMTP server via the HTTP proxy and send.
        // The connection (i.e. session) to the SMTP server remains
        // open so that subsequent SendEmail calls may use the
        // same connection.
        success = mailman.SendEmail(email);
        if (success != true) {
            System.out.println(mailman.lastErrorText());
            return;
        }

        // Some SMTP servers do not actually send the email until
        // the connection is closed.  In these cases, it is necessary to
        // call CloseSmtpConnection for the mail to be  sent.
        // Most SMTP servers send the email immediately, and it is
        // not required to close the connection.  We'll close it here
        // for the example:
        success = mailman.CloseSmtpConnection();
        if (success != true) {
            System.out.println("Connection to SMTP server not closed cleanly.");
        }

        System.out.println("Mail Sent!");
    }
}
*/