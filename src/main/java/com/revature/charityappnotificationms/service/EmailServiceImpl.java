package com.revature.charityappnotificationms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.revature.charityappnotificationms.domain.Email;
import com.revature.charityappnotificationms.domain.User;

@Component
public class EmailServiceImpl implements EmailService {

	@Autowired
	public JavaMailSender emailSender;

	public void sendSimpleMessage(String to, String subject, String text) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(to);
			message.setSubject(subject);
			message.setText(text);

			emailSender.send(message);
			System.out.println("Mail Sent");
		} catch (MailException exception) {
			System.out.println("Mail Message:" + exception.getMessage());
			exception.printStackTrace();
		}
	}

	@Override
	public Email sendMail(Email email) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email.getTo());
			message.setSubject(email.getSubject());
			message.setText(email.getText());
	
			emailSender.send(message);
			System.out.println("Mail Sent");
		} catch (MailException exception) {
			System.out.println("Mail Message:" + exception.getMessage());
			exception.printStackTrace();
		}
		return email;

	}
	
	public void sendRegistrationMail(User user) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(user.getEmail());
			message.setSubject("Registration Mail -" +user.getApplicationName());
			StringBuilder content = new StringBuilder();
			content.append("Welcome "+ user.getName() + ", \n");
			content.append("Thank you for registering through our " +user.getApplicationName() + "." ).append("\n");
			content.append("\n");
			content.append("\n");
			content.append("Regards,").append("\n");
			content.append("JayaKrishna.").append("\n");
			content.append("Contact: 8148179875." );
			
			
			message.setText(content.toString());
	
			emailSender.send(message);
			System.out.println("Mail Sent");
		} catch (MailException exception) {
			System.out.println("Mail Message:" + exception.getMessage());
			exception.printStackTrace();
		}
	}


}
