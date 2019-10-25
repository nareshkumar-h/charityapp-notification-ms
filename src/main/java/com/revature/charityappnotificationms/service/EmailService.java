package com.revature.charityappnotificationms.service;

import org.springframework.mail.SimpleMailMessage;

import com.revature.charityappnotificationms.domain.User;

public interface EmailService {
	void sendSimpleMessage(String to, String subject, String text);

	void sendSimpleMessageUsingTemplate(String to, String subject, SimpleMailMessage template, String... templateArgs);

	User sendMail(User user);

}
