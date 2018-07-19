package com.frame.service;

import javax.annotation.PostConstruct;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.annotation.SysLogColumn;
/**
 * 邮件发送
 * @author bobo
 *
 */
@Component
public class EmailSenderService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	private static EmailSenderService emailSender;
	
	@PostConstruct
	public void init(){
		emailSender = this;
	    emailSender.javaMailSender= this.javaMailSender;
	}
	
	  @SysLogColumn(operationName="发送简单的文本邮件")
	  public void sendSimpleMessage(String sendFrom, String[] sendTo, String subject, String textcontent) {
	    SimpleMailMessage mail = new SimpleMailMessage();
	    mail.setFrom(sendFrom);
	    mail.setTo(sendTo);
	    mail.setSubject(subject);
	    mail.setText(textcontent);
	    //发送
	    emailSender.javaMailSender.send(mail);
	  }
	  
	  
	  @SysLogColumn(operationName="发送HTML内容格式的邮件")
	  public void sendHtmlMessage(String sendFrom, String[] sendTo, String subject, String htmlContent) throws Exception {
	    MimeMessage mimeMessage = emailSender.javaMailSender.createMimeMessage(); 
	     
	    MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
	    mimeMessageHelper.setFrom(sendFrom);
	    mimeMessageHelper.setTo(sendTo);
	    mimeMessageHelper.setSubject(subject);
	    // true 表示启动HTML格式的邮件 
	    mimeMessageHelper.setText(htmlContent, true); 
	 
	    // 发送邮件
	    emailSender.javaMailSender.send(mimeMessage);
	  }
}
