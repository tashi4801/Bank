package common;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.example.domain.MailForm;

public class Mail {

	  // メール送信テスト
	 public void mailSend(MailForm mailForm) {
	    try {
	      // メール送信準備
	      Properties props = new Properties();
	      props.put("mail.smtp.host", "smtp.gmail.com" );
//	      Session session = Session.getDefaultInstance( props );
//	      session.setDebug( true );  // デバッグモードにする  ←①
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", "smtp.gmail.com");
	      props.put("mail.smtp.port", "587");
	      props.put("mail.smtp.debug", "true");

	      Session session = Session.getInstance(props, new javax.mail.Authenticator(){
	          protected PasswordAuthentication getPasswordAuthentication(){
	              return new PasswordAuthentication("tashi480", "e0906612");
	          }
	      });

	      // メール作成
	      MimeMessage mime = new MimeMessage( session );
	      mime.addFrom( InternetAddress.parse("tashi480@gmail.com") );
	      mime.setRecipients( Message.RecipientType.TO, InternetAddress.parse(mailForm.getTo()));
	      mime.setSubject(mailForm.getSubject(), "iso-2022-jp" );
	      mime.setText(mailForm.getMessage());
	      mime.setSentDate( new Date() );

	      // 送信
	      Transport.send( mime );
	    } catch( Exception ex ){
	      ex.printStackTrace();
	    }
	  }
}
  
   