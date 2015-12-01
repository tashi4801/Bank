package to.msn.wings.codezine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MailTransfer extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		System.out.println("MailTransferにはいったよ！！！");
		request.setCharacterEncoding("Windows-31J");
		ServletConfig config=this.getServletConfig();
		ServletContext application=config.getServletContext();
		Properties objPrp=new Properties();
		objPrp.put("mail.smtp.host",config.getInitParameter("smtp"));
		objPrp.put("mail.host",config.getInitParameter("smtp"));
	    Session session=Session.getDefaultInstance(objPrp,null);
	    MimeMessage msg=new MimeMessage(session);
	    try {
			msg.setRecipients(Message.RecipientType.TO,request.getParameter("_to"));
			InternetAddress objFrm=new InternetAddress(
				request.getParameter("_from"),request.getParameter("_fromArias"));
			msg.setFrom(objFrm);
			msg.setSubject(request.getParameter("_subject"),"ISO-2022-JP");
			StringBuffer body=new StringBuffer();
			BufferedReader template=new BufferedReader(
				new FileReader(application.getRealPath("/WEB-INF/data/template.dat")));
			while(template.ready()){body.append(template.readLine() + "\r\n");}
			String bodyText=body.toString();
			Enumeration objEnm=request.getParameterNames();
			while(objEnm.hasMoreElements()){
				String name=(String)objEnm.nextElement();
				if(!name.startsWith("_")){
					bodyText=bodyText.replaceAll("__" + name + "__",request.getParameter(name));
				}
			}
			template.close();
			msg.setText(bodyText,"ISO-2022-JP");
			Transport.send(msg);
			response.sendRedirect(request.getParameter("_location"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	
	}
}
