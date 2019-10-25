package com.revature.charityappnotificationms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.revature.charityappnotificationms.domain.Email;

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
	public void sendSimpleMessageUsingTemplate(String to, String subject, SimpleMailMessage template,
			String... templateArgs) {
		String text = String.format(template.getText(), templateArgs);
		sendSimpleMessage(to, subject, text);
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

}
