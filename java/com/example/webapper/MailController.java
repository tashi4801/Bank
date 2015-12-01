package com.example.webapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.MailForm;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import common.Mail;
import common.MailSend;
import common.MailSendMiyahara;


@Controller
public class MailController {
	
	@ModelAttribute("mailForm")
	public MailForm setUpMailForm(){
		return new MailForm();
	}
	
	@RequestMapping("/mail")
	public String send(){
		return "bank/mail";
	}
	@RequestMapping(value="/send", method = RequestMethod.POST)
	public String send(MailForm mailForm){
//		Mail mail = new Mail();
//		mail.mailSend(mailForm);
//		
		MailSend mailSend =new MailSend();
		mailSend.sendMail(mailForm);
		return "bank/mail";
	}
	@RequestMapping(value="/sendMiyahara", method = RequestMethod.POST)
	public String sendMiyahara(MailForm mailForm){
//		Mail mail = new Mail();
//		mail.mailSend(mailForm);
//		
		MailSendMiyahara mailSend = new MailSendMiyahara();
				mailSend.mail();
		return "bank/mail";
	}
	
}
