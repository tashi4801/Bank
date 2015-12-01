package common;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;


public class MailSendMiyahara {
	public  void mail()  {
	    //認証情報作成
//	    Authenticator auth = new MailAuthenticator();
	 
	    //セッション情報の作成
	    Properties properties = new Properties();
	 
	    //ホスト設定
	    properties.setProperty("mail.smtp.host", "smtp.gmail.com");
	    properties.setProperty("mail.smtp.port", "465");
	 
	    //smtp関連の設定
	    properties.setProperty("mail.smtp.socketFactory.class", 
	                           "javax.net.ssl.SSLSocketFactory");
	    properties.setProperty("mail.smtp.socketFactory.fallback", "false");
	    properties.setProperty("mail.smtp.socketFactory.port", "465");
	 
	    //タイムアウトの設定
	    properties.setProperty("mail.smtp.connectiontimeout", "50000");
	    properties.setProperty("mail.smtp.timeout", "50000");
	 
	    //メール送信ログを出力
	    properties.setProperty("mail.debug", "true");
	 
	    //認証を有効にする
	    properties.setProperty("mail.smtp.auth", "true");
	 
//	    //セッションの作成
//	    //認証情報がいらない場合はpropertiesのみの引数でgetinstanceできる
//	    Session session = Session.getInstance(properties, new MailAuthenticator());
	    
	    Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
	          protected PasswordAuthentication getPasswordAuthentication(){
	              return new PasswordAuthentication("sample.miya", "rakus2015");
	          }
	      });
	    
	 
	    //メッセージ作成
	    MimeMessage mimeMessage = new MimeMessage(session);
	    //宛先の設定
	      InternetAddress[] toAddress = new InternetAddress[1];
	      try {
			toAddress[0] = new InternetAddress("tashi480@gmail.com");
		} catch (AddressException e) {
			System.out.println("宛先エラー");

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			mimeMessage.setRecipients(MimeMessage.RecipientType.TO, toAddress);
		} catch (javax.mail.MessagingException e) {
			// TODO Auto-generated catch block
			System.out.println("宛先エラー2");

			e.printStackTrace();
		}
	 
	      //送信元の設定
	      InternetAddress fromAddress = null;
		try {
			fromAddress = new InternetAddress("sample.miya@gmail.com");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			System.out.println("送信元エラー");

			e.printStackTrace();
		}
	      try {
			mimeMessage.setFrom(fromAddress);
		} catch (javax.mail.MessagingException e1) {
			System.out.println("fromAddressエラー");

			e1.printStackTrace();
		}
	 
	      //題名、本文の設定
	      try {
			mimeMessage.setSubject("my test mail");
		} catch (javax.mail.MessagingException e) {
			// TODO Auto-generated catch block
			System.out.println("題名エラー");

			e.printStackTrace();
		}
	      try {
			mimeMessage.setText("my test message");
		} catch (javax.mail.MessagingException e) {
			// TODO Auto-generated catch block
			System.out.println("本文エラー");

			e.printStackTrace();
		}
			System.out.println("ここまで順調");

	      //変更を保存
	      try {
			mimeMessage.saveChanges();
		} catch (javax.mail.MessagingException e) {
			System.out.println("mimeMessage");

			e.printStackTrace();
		}
	 
	    try {
			Transport.send(mimeMessage);
		} catch (javax.mail.MessagingException e) {
			System.out.println("送信");
			e.printStackTrace();
		}
		System.out.println("send mail succeed");
	}
}
