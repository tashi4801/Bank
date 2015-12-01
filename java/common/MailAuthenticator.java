package common;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class MailAuthenticator extends Authenticator {
 
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("sample.miya", "rakus2015");
    }
}