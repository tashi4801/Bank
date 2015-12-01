package common;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.example.domain.MailForm;

/**
 * メール送信を実行するクラス。
 * →送信元:sample.miya@gmail.com
 * @author miyaharashuusaku
 *
 */
public class MailSend {
	public  void sendMail(MailForm mailForm) {

		
	//認証情報作成
    Authenticator auth = new MailAuthenticator();
    
    //セッション情報の作成
    Properties properties = new Properties();
    
    //送信元（Gmail)のホスト設定
    properties.setProperty("mail.smtp.host", "smtp.gmail.com");
    properties.setProperty("mail.smtp.port", "465");//（SSL が必須）
    
    //ssl関連の設定
    properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    properties.setProperty("mail.smtp.socketFactory.fallback", "false");
    properties.setProperty("mail.smtp.socketFactory.port", "465");
    
    //タイムアウトの設定
    properties.setProperty("mail.smtp.connectiontimeout", "50000");
    properties.setProperty("mail.smtp.timeout", "50000");
 
    //メール送信ログを出力
    properties.setProperty("mail.debug", "true");
 
    //認証を有効にする
    properties.setProperty("mail.smtp.auth", "true");
    
    //セッションの作成
    //認証情報がいらない場合はpropertiesのみの引数でgetinstanceできる
    Session session = Session.getInstance(properties, auth);
    
    //メッセージ作成
    MimeMessage mimeMessage = new MimeMessage(session);

    
    try {
        //宛先の設定
        InternetAddress[] toAddress = new InternetAddress[1];
        toAddress[0] = new InternetAddress(mailForm.getTo());
        mimeMessage.setRecipients(MimeMessage.RecipientType.TO, toAddress);
   
        //送信元の設定
        InternetAddress fromAddress = new InternetAddress("tashi480@gmail.com");
        mimeMessage.setFrom(fromAddress);
   
        //題名、本文の設定
        mimeMessage.setSubject(mailForm.getSubject());
        mimeMessage.setText(mailForm.getMessage());
        System.out.println("チェック");
//        // マルチパートオブジェクトを生成
//        Multipart mp = new MimeMultipart();
        
//        //本文設定
//        MimeBodyPart mbp1 = new MimeBodyPart();
//        mbp1.setText("送ったぞー", "ISO-2022-JP");
//        mbp1.setHeader("Content-Type","text/plain");
//        mp.addBodyPart(mbp1);
//        File file = new File(".");
//        System.out.println(file.getAbsolutePath() + "チェック２");
//        //添付ファイルのデータソースを取得する。
//        DataHandler imgdh = null;
//    	FileDataSource fds = new FileDataSource("WebContent/img/スキルアップ支援制度利用マニュアル.pptx");
//    	imgdh = new DataHandler(fds);
//
//    	//画像添付
//        // 添付するファイルデータソースを指定
//    	MimeBodyPart mbp2 = new MimeBodyPart();            
//        mbp2.setDataHandler(imgdh);
//        try {
//			mbp2.setFileName(MimeUtility.encodeText(fds.getName(),"iso-2022-jp","B"));
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}//ファイル名は多分ディレクトリの中に、画像を置いてのパス名
//        mp.addBodyPart(mbp2);
        
        
        // マルチパートオブジェクトをメッセージに設定
//        mimeMessage.setContent(mp);
        mimeMessage.setSentDate(new java.util.Date());
        // 送信します
        Transport.send(mimeMessage);
        
//        //変更を保存
//        mimeMessage.saveChanges();
//        Transport.send(mimeMessage);
        
      } catch(MessagingException e) {
        e.printStackTrace();
      }
    
	}     
}
