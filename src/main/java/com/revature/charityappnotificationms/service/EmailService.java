package com.revature.charityappnotificationms.service;

import org.springframework.mail.SimpleMailMessage;

import com.revature.charityappnotificationms.domain.Email;


public interface EmailService {
	void sendSimpleMessage(String to, String subject, String text);

	void sendSimpleMessageUsingTemplate(String to, String subject, SimpleMailMessage template, String... templateArgs);

	Email sendMail(Email email);

}
